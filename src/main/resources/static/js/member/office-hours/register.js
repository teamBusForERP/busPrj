Vue
	.createApp({
		data() {
			return {
				employee: "",
				companyName: "",
				workStatus: "",
				today: "",
				worktime: "",

				sideBarOn: false,
				restToggleOn: false,
				restEditerOn: false,
				menuBOn: false,

				clockInForm: "",
				clockOutForm: "",
				breakTimeStartForm1: "",
				breakTimeEndForm1: "",
				breakTimeStartForm2: "",
				breakTimeEndForm2: "",
				
				breakTimeStartObj: "",
				breakTimeEndObj: "",
				
				breakTimeErrMsg: ""

			};
		},
		methods: {
			restSubmitBtnHandler(){

				if (this.breakTimeEndObj.diff(this.breakTimeStartObj, "minute") < 0 ) // 휴게시작시간보다 휴게종료시간이 더 이른 경우
				{
					this.breakTimeErrMsg = "정확한 휴게시간을 입력하세요";
					return;
				}

				var requestOptions = {
					method: 'PUT',
					redirect: 'follow'
				};
				
				fetch(`http://localhost/api/officehours/rest?
				s=${this.workStatus}&
				id=${this.employee.id}&
				start=${this.breakTimeStartObj}&
				end=${this.breakTimeEndObj}`, requestOptions)
					.then(response => response.text())
					.then(result => {
						console.log(result)
						this.menuBHandler();
						this.reLoad();
					}
					)
					.catch(error => console.log('error', error));

			},
			submitBtnHandler() {
				requestUrl = `/api/officehours?id=${this.employee.id}&s=${this.workStatus}`
				var requestOptions = {
					method: 'POST',
					redirect: 'follow'
				};

				fetch(requestUrl, requestOptions)
					.then(response => response.text())
					.then(result => {
						console.log(result)
						this.reLoad(this.employee.id);
					})
					.catch(error => console.log('error', error));

			},
			formatDate() {
				// console.log(this.worktime.clockIn.split('T')[1].substr(0, 5));
				// console.log(this.worktime.clockOut.split('T')[1].substr(0, 5));
				this.clockInForm = this.worktime.clockIn.split('T')[1].substr(0, 5);
				if(this.worktime.clockOut != null)
					this.clockOutForm = this.worktime.clockOut.split('T')[1].substr(0, 5);
				const breakTimeStartString = `${this.worktime.date} ${this.worktime.breakTimeStart}`;
				const breakTimeEndString = `${this.worktime.date} ${this.worktime.breakTimeEnd}`;
				
				this.breakTimeStartObj = dayjs(Number(Date.parse(breakTimeStartString)));
				this.breakTimeEndObj = dayjs(Number(Date.parse(breakTimeEndString)));

				this.breakTimeStartForm1 = this.breakTimeStartObj.format('HH:mm');
				this.breakTimeEndForm1 = this.breakTimeEndObj.format('HH:mm');

				this.breakTimeStartForm2 = this.breakTimeStartObj.format('A hh:mm').replace('AM', '오전').replace('PM', '오후');
				this.breakTimeEndForm2 = this.breakTimeEndObj.format('A hh:mm').replace('AM', '오전').replace('PM', '오후');
			},
			menuBHandler() {
				this.menuBOn = false;
				this.sideBarOn = false;
				this.restEditerOn = false;
				this.breakTimeErrMsg = "";
			},
			sideBarHandler() {
				this.sideBarOn = !this.sideBarOn;
				this.menuBOn = true;
			},
			restToggleHandler() {
				this.restToggleOn = !this.restToggleOn;
			},
			restEditerHandler() {
				this.restEditerOn = !this.restEditerOn;
				this.menuBOn = true;
			},
			breakTimeStartUpHandler() {
				this.breakTimeStartObj = this.breakTimeStartObj.add(10, 'minutes');
				this.breakTimeStartForm2 = this.breakTimeStartObj.format('A hh:mm').replace('AM', '오전').replace('PM', '오후');
			},
			breakTimeStartDownHandler() {
				this.breakTimeStartObj = this.breakTimeStartObj.subtract(10, 'minutes');
				this.breakTimeStartForm2 = this.breakTimeStartObj.format('A hh:mm').replace('AM', '오전').replace('PM', '오후');
			},
			breakTimeEndUpHandler() {
				this.breakTimeEndObj = this.breakTimeEndObj.add(10, 'minutes');
				this.breakTimeEndForm2 = this.breakTimeEndObj.format('A hh:mm').replace('AM', '오전').replace('PM', '오후');
			},
			breakTimeEndDownHandler() {
				this.breakTimeEndObj = this.breakTimeEndObj.subtract(10, 'minutes');
				this.breakTimeEndForm2 = this.breakTimeEndObj.format('A hh:mm').replace('AM', '오전').replace('PM', '오후');
			},
			setWorkStatus(recentWorktime) {
				// 근무 상태 코드

				// 0: 출근등록 전 상태
				// 1: 근무 중 상태
				// 2: 퇴근등록 완료 상태
				// 3: 근무 중 자정이 지난 상태(퇴근시간이 등록되지 않은 최근근무정보가 오늘이 아닌 상태이지만 익일 06시 이전인 경우 - 야근)
				// 4: 예외처리(퇴근시간이 등록되지 않은 최근근무정보가 오늘이 아닌 상태 익일 06시 이후인 경우 - 퇴근 등록 누락)

				const today = dayjs().format('YYYY-MM-DD');
				const curTime = dayjs();

				let defaultTime = dayjs(); // 야간근로 기준시간 오전 6시
				defaultTime = defaultTime.set("hour", 6);
				defaultTime = defaultTime.set("minute", 0);
				defaultTime = defaultTime.set("second", 0);

				const yesterday = dayjs(this.today).subtract(1, 'day').format('YYYY-MM-DD');

				if (recentWorktime.date == today) { // 최근근무정보가 오늘인 경우
					if (recentWorktime.clockOut == null) {
						this.workStatus = 1;
						console.log("workStatus : 1 - 근무 중 상태");
					} else {
						this.workStatus = 2;
						console.log("workStatus : 2 - 퇴근 등록 완료 상태");
					}
				} else { // 최근근무정보가 오늘이 아닌 경우
					if (recentWorktime.clockOut != null) {
						// 최근근무정보가 정상적으로 완료되었고, 오늘 날짜 기준 새로운 근무를 생성하기 전 상태
						this.workStatus = 0;
						this.worktime = "";
						console.log("workStatus : 0 - 출근 등록 전 상태");
					} else if (recentWorktime.date == yesterday && defaultTime.diff(curTime) > 0) {
						// 최근근무정보가 어제이고, 퇴근 등록이 되지 않은 상태에서 야간근로 기준시간인 오전 06시가 지나지 않은 경우
						this.workStatus = 3;
						console.log("workStatus : 3 - 근무 중 자정이 지난 상태");
					} else {
						// 퇴근 등록 누락
						this.workStatus = 4;
						console.log("workStatus : 4 - 퇴근 등록 누락")
					}
				}

			},
			load(employeeId) {
				requestUrl = `/api/officehours?id=${employeeId}`

				fetch(requestUrl)
					.then((response) => response.text())
					.then((text) => {
						if (text.length == 0) {
							this.worktime = '';
							this.workStatus = 0;
						} else {
							this.worktime = JSON.parse(text);
							this.setWorkStatus(this.worktime);
							if(this.workStatus != 0) // 출근 등록 전 상태인 경우 렌더링을 위한 formatDate 생략
								this.formatDate();
						}
					})
					.catch(error => console.log('error', error));


				// Employee
				fetch("http://localhost/api/employee?id=1")
					.then(response => response.json())
					.then(result => {
						this.employee = result
					})
					.catch(error => console.log('error', error));

				//companyName
				fetch("http://localhost/api/employee/company?eid=1")
					.then(response => response.json())
					.then(result => {
						this.companyName = result.name;
					})
					.catch(error => console.log('error', error));
			},
			reLoad() {
				requestUrl = `/api/officehours?id=${this.employee.id}`

				fetch(requestUrl)
					.then((response) => response.text())
					.then((text) => {
						if (text.length == 0) {
							this.worktime = '';
							this.workStatus = 0;
						}
						else {
							this.worktime = JSON.parse(text);
							this.setWorkStatus(this.worktime);
							this.formatDate();
						}
					})
					.catch(error => console.log('error', error));
				}
		},
		mounted() {
			let employeeId = 1;
			this.today = dayjs().format('MM월DD일');
			this.load(employeeId);
		}
	})
	.mount(".wrap");