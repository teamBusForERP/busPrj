Vue
	.createApp({

		data() {
			return {
			dateUnit : "",
			showDate : "",
			initDate : "",
			page : 0,
			fromDate : "",
			toDate : "",
			};
		},

		methods: {
			dateUnitHandler(dateUnit) {
				console.log(dateUnit);
				this.initDate = dayjs();
				console.log(this.initDate);
				switch (dateUnit) {
					case 'day':
						this.dateUnit = dateUnit;
						
						if (this.page != 0){
						this.initDate = this.initDate.add(this.page, "d");
						}
						console.log(this.page);
						console.log(this.page + 1);
						let dayOfWeek = this.getDayOfWeek(this.initDate.format("d"));
						console.log(dayOfWeek);
						this.showDate = this.initDate.format("YYYY.M.D")+dayOfWeek;
						
						this.fromDate = this.initDate.format("YYYY-MM-DD");
						
						
						//                        this.findByDateUnit(this.date);
						
						break;
 
					case 'week':
						this.dateUnit = dateUnit;
						
						if (this.page != 0){
						this.initDate = this.initDate.add(this.page, "w");
						}
						
						let startOfWeek = this.initDate.startOf('w').format("M.DD");
						let endOfWeek = this.initDate.endOf('w').format("M.DD");
						this.showDate = startOfWeek+"-"+endOfWeek;
						
						this.fromDate = this.initDate.startOf('w').format("YYYY-MM-DD");
						this.toDate = this.initDate.endOf('w').format("YYYY-MM-DD");

						break;

					case 'month':
						this.dateUnit = dateUnit;
						
						if (this.page != 0){
						this.initDate = this.initDate.add(this.page, "M");
						}
						
						this.showDate = this.initDate.format("M")+"월";
						
						this.fromDate = this.initDate.startOf('M').format("YYYY-MM-DD");
						this.toDate = this.initDate.endOf('M').format("YYYY-MM-DD");

						break;
				}
			},
			
			datepagingHandler(p){
				switch (p){
					case 'plus': this.page ++;
					this.dateUnitHandler(this.dateUnit);
						break;
					case 'minus': this.page --;
					this.dateUnitHandler(this.dateUnit);
						break;
				}
			},
			
			async findByDateUnit(unit) {
				let response = await fetch("/members/list?dateUnit=" + unit,);
				let list = await response.json();
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
		
		mounted(){
			this.dateUnitHandler("day");
		}
	})
	.mount(".main-wrap");
