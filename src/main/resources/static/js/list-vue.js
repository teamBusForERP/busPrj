Vue
	.createApp({

		data() {
			return {
				employeeId: "1", //임시
				dateUnit: "",
				showDate: "",
				initDate: "",
				page: 0,
				fromDate: "",
				toDate: "",


				totalWorkTime: "",
				totalRestTime: "",

				clockIn: "",
				clockOut: "",




			};
		},

		methods: {
			dateUnitHandler(dateUnit) {
				console.log(dateUnit);
				this.initDate = dayjs();
				this.toDate= "",
				console.log(this.initDate);
				switch (dateUnit) {
					case 'day':
						this.dateUnit = dateUnit;

						if (this.page != 0) {
							this.initDate = this.initDate.add(this.page, "d");
						}
						console.log(this.page);
						console.log(this.page + 1);
						let dayOfWeek = this.getDayOfWeek(this.initDate.format("d"));
						console.log(dayOfWeek);
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
						
						this.getList();
						
						break;

					case 'month':
						this.dateUnit = dateUnit;

						if (this.page != 0) {
							this.initDate = this.initDate.add(this.page, "M");
						}

						this.showDate = this.initDate.format("M") + "월";

						this.fromDate = this.initDate.startOf('M').format("YYYY-MM-DD");
						this.toDate = this.initDate.endOf('M').format("YYYY-MM-DD");

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
				let response = await fetch(`http://localhost:80/api/officehours?employeeId=${this.employeeId}&fromDate=${this.fromDate}&toDate=${this.toDate}`);
				let list = await response.json();
				this.clockIn = list.clockIn;
				this.clockOut= list.clockOut;
				this.totalWorkTime = list.totalWorkTime;
				this.totalRestTime = list.totalRestTime;
				console.log(list);

				
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
			}
		},

		mounted() {
			this.dateUnitHandler("day");
		}
	})
	.mount(".main-wrap");
