Vue
	.createApp({
		data() {
			return {
				id: 1,//임시
				companyId: 1,
				list: "",
				dateUnit: "",
				showDate: "",
				initDate: "",
				fromDate: "",
				toDate: "",
			};
		},
		methods: {
			dateFormater(dateUnit) {
				switch (dateUnit) {
					case 'day':
						this.dateUnit = dateUnit;
						let dayOfWeek = this.getDayOfWeek(this.initDate.format("d"));
						this.showDate = this.initDate.format("YYYY.M.D") + dayOfWeek;
						this.fromDate = this.initDate.format("YYYY-MM-DD");
						this.getDayList();
						break;

					case 'week':
						this.dateUnit = dateUnit;

						let startOfWeek = this.initDate.startOf('w').format("M.DD");
						let endOfWeek = this.initDate.endOf('w').format("M.DD");
						this.showDate = startOfWeek + " ~ " + endOfWeek;
						this.fromDate = this.initDate.startOf('w').format("YYYY-MM-DD");
						this.toDate = this.initDate.endOf('w').format("YYYY-MM-DD");
						this.getWMList();
						break;

					case 'month':
						this.dateUnit = dateUnit;
						this.showDate = this.initDate.format("M") + "월";
						this.fromDate = this.initDate.startOf('M').format("YYYY-MM-DD");
						this.toDate = this.initDate.endOf('M').format("YYYY-MM-DD");
						this.getWMList();

						break;
				}
			},
			dateUnitHandler(dateUnit) {
				this.initDate = dayjs();
				this.dateFormater(dateUnit);
			},

			datepagingHandler(p) {
				const now = dayjs().format('YYYY-MM-DD');
				switch (p) {
					case 'plus':
						if (this.initDate.format('YYYY-MM-DD') == now)
							return;

						if (this.dateUnit == 'day')
							this.initDate = this.initDate.add(1, "d");
						else if (this.dateUnit == 'week')
							this.initDate = this.initDate.add(1, "w");
						else if (this.dateUnit == 'month')
							this.initDate = this.initDate.add(1, "M");

						this.dateFormater(this.dateUnit);
						break;
					case 'minus':
						if (this.dateUnit == 'day')
							this.initDate = this.initDate.add(-1, "d");
						else if (this.dateUnit == 'week')
							this.initDate = this.initDate.add(-1, "w");
						else if (this.dateUnit == 'month')
							this.initDate = this.initDate.add(-1, "M");

						this.dateFormater(this.dateUnit);
						break;
				}
			},

			async getDayList() {
				let response = await fetch(`http://localhost/api/officehours/daylist?companyId=${this.companyId}&fromDate=${this.fromDate}`);
				let list = await response.json();
				this.list = this.listFormatter(list, 'day');
			},
			async getWMList() {
				let response = await fetch(`http://localhost/api/officehours/wmlist?companyId=${this.companyId}&fromDate=${this.fromDate}&toDate=${this.toDate}`);
				let list = await response.json();
				this.list = list;
				this.listFormatter(list, 'WM');

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
			listFormatter(list, dateUnit) {
				// restHours
				// workHours

				let resultList = []
				for (item of list) {
					console.log(item);
					let workHH = parseInt(item.workHours.substr(0, 2));
					let workMM = parseInt(item.workHours.substr(3, 5));
					// item.workHours = `${workHH}시간 ${workMM}분`
					item.workHours = (workHH != 0)? `${workHH}시간 ${workMM}분` : `${workMM}분`
					let restHH = parseInt(item.restHours.substr(0, 2));
					let restMM = parseInt(item.restHours.substr(3, 5));
					item.restHours = (restHH != 0)? `${restHH}시간 ${restMM}분` : `${restMM}분` 
					if (dateUnit == 'day') {
						item.clockIn = item.clockIn.split('T')[1].substr(0, 5);
						item.clockOut = item.clockOut.split('T')[1].substr(0, 5);
					}
					resultList.push(item);
				}
				// else{

				// }
				return resultList;
			}
		},
		mounted() {
			this.dateUnit = 'day';
			this.initDate = dayjs();
			this.dateUnitHandler('day');
		}
	})
	.mount("#wrap");