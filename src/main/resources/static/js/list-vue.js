Vue
	.createApp({

		data() {
			return {
				id: 1,//임시
				list: "",
				//				list: [
				//					{
				//						id: 0, 
				//						companyId: 0,
				//						name: "",
				//						image: "",
				//						department: "",
				//						position: "",
				//						date: "",
				//						breakTimeStart: "",
				//						breakTimeEnd: "",
				//						workHours: "",
				//						restHours: "",
				//						clockIn: "",
				//						clockOut: "",
				//						ex_id:""
				//					}
				//				],

				dateUnit: "",
				showDate: "",
				initDate: "",
				page: 0,
				fromDate: "",
				toDate: "",
				workHours: "",
				restHours: "",
				clockIn: "",
				clockOut: "",
				progress: 0,
			};
		},

		methods: {
			dateUnitHandler(dateUnit) {
				console.log(dateUnit);
				this.initDate = dayjs();
				this.toDate = "",
					console.log(this.initDate);
				switch (dateUnit) {
					case 'day':
						this.dateUnit = dateUnit;

						if (this.page != 0) {
							this.initDate = this.initDate.add(this.page, "d");
						}

						let dayOfWeek = this.getDayOfWeek(this.initDate.format("d"));
						this.showDate = this.initDate.format("YYYY.M.D") + dayOfWeek;

						this.fromDate = this.initDate.format("YYYY-MM-DD");

						this.getList();
						//                        this.findByDateUnit(this.date);

						break;

					case 'week':
						this.dateUnit = dateUnit;

						if (this.page != 0) {
							this.initDate = this.initDate.add(this.page, "w");
						}

						let startOfWeek = this.initDate.startOf('w').format("M.DD");
						let endOfWeek = this.initDate.endOf('w').format("M.DD");
						this.showDate = startOfWeek + "-" + endOfWeek;

						this.fromDate = this.initDate.startOf('w').format("YYYY-MM-DD");
						this.toDate = this.initDate.endOf('w').format("YYYY-MM-DD");

						this.getLists();

						break;

					case 'month':
						this.dateUnit = dateUnit;

						if (this.page != 0) {
							this.initDate = this.initDate.add(this.page, "M");
						}

						this.showDate = this.initDate.format("M") + "월";

						this.fromDate = this.initDate.startOf('M').format("YYYY-MM-DD");
						this.toDate = this.initDate.endOf('M').format("YYYY-MM-DD");

						this.getLists();

						break;
				}
			},

			datepagingHandler(p) {
				switch (p) {
					case 'plus': this.page++;
						this.dateUnitHandler(this.dateUnit);
						break;
					case 'minus': this.page--;
						this.dateUnitHandler(this.dateUnit);
						break;
				}
			},

			async getList() {
//				let response = await fetch(`http://localhost:80/api/officehours/daylist?id=${this.id}&fromDate=${this.fromDate}`);
//				let list = await response.json();
//				this.list = list;

				let requestOptions = {
					method: 'GET',
					redirect: 'follow'
				};

				fetch(`http://localhost:80/api/officehours/daylist?id=${this.id}&fromDate=${this.fromDate}`, requestOptions)
					.then(response => this.list = response.json())
					.then(list => 
					{
						this.workHours = this.progressHoursFormat(list[0].workHours);
						this.restHours = this.progressHoursFormat(list[0].restHours);}
						)
					.catch(error => {
						this.workHours = "근무 내역이 없습니다.";
						this.restHours = "근무 내역이 없습니다.";
						});
				

				console.log(this.workHours);



			},
			async getLists() {
//				let response = await fetch(`http://localhost:80/api/officehours/wmlist?id=${this.id}&fromDate=${this.fromDate}&toDate=${this.toDate}`);
//				let list = await response.json();
//				this.list = list;
				let requestOptions = {
					method: 'GET',
					redirect: 'follow'
				};

				fetch(`http://localhost:80/api/officehours/wmlist?id=${this.id}&fromDate=${this.fromDate}&toDate=${this.toDate}`, requestOptions)
					.then(response => this.list = response.json())
					.then(list => {
						this.workHours = this.progressHoursFormat(list[0].workHours);
						this.restHours = this.progressHoursFormat(list[0].restHours);}
						)
					.catch(error => {
						this.workHours = "근무 내역이 없습니다.";
						this.restHours = "근무 내역이 없습니다.";
						});
						
				
//				this.progress = progressPercentage(list[0].workHours)

				console.log(this.workHours);



//				console.log(list);

			},

			getDayOfWeek(number) {
				switch (number) {
					case '0':
						return "(일)";
					case '1':
						return "(월)";
					case '2':
						return "(화)";
					case '3':
						return "(수)";
					case '4':
						return "(목)";
					case '5':
						return "(금)";
					case '6':
						return "(토)";
				}
			},

			progressHoursFormat(hours) {

				let str = hours.split(":");
				let totalHours = "";

				if (str[0] !== "00") {
					if (str[0].indexOf("0") <= 0) {
						totalHours = str[0].replace("0", '') + "시간";
					} else {
						totalHours = str[0] + "시간";
					}
				}

				if (str[1] !== "00") {
					if (str[1].indexOf("0") <= 0) {
						totalHours = totalHours + " " + str[1].replace("0", '') + "분";
					} else {
						totalHours = totalHours + " " + str[1] + "분";
					}
				}

				return totalHours;
			},
			
			progressPercentage(hours) {
				//list[0].workHours
				let str = hours.split(":");
				let hourToSec = parseInt(str[0])*3600;
				let minToSec = parseInt(str[1])*60;
				let totalSec = hourToSec+minToSec;
				let workHoursSec = 0;
				let progress = 0;
				switch (this.dateUnit) {
					case 'day':
							workHoursSec= 50400;
						break;
					case 'week':
							workHoursSec= 0;
						break;
					case 'month':
							workHoursSec= 0;
						break;
				}
				progress = math.floor(((totalSec / workHoursSec) * 100));
				
				console.log(progress);
				
				return progress;
			}

		},
		
		
		mounted() {
			this.dateUnitHandler("day");

		}
	})
	.mount(".main-wrap");
