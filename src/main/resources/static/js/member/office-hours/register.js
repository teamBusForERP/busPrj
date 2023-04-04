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

				clockIn:"",
				clockOut:"",
				breakTimeStart:"",
				breakTimeEnd:"",

			};
		},
		methods: {
			formatDate(){
				console.log(this.worktime.clockIn);
				console.log(this.worktime.clockOut);
				console.log(this.worktime.breakTimeStart);
				console.log(this.worktime.breakTimeEnd);
			},
			menuBHandler() {
				this.menuBOn = false;
				this.sideBarOn = false;
				this.restEditerOn = false;
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
						console.log("근무 중 상태");
					} else {
						this.workStatus = 2;
						console.log("퇴근 등록 완료 상태");
					}
				} else { // 최근근무정보가 오늘이 아닌 경우
					if (recentWorktime.clockOut != null) {
						// 최근근무정보가 정상적으로 완료되었고, 오늘 날짜 기준 새로운 근무를 생성하기 전 상태
						this.workStatus = 0;
						this.worktime="";
						console.log("출근 등록 전 상태");
					} else if (recentWorktime.date == yesterday && defaultTime.diff(curTime) > 0) {
						// 최근근무정보가 어제이고, 퇴근 등록이 되지 않은 상태에서 야간근로 기준시간인 오전 06시가 지나지 않은 경우
						this.workStatus = 3;
						console.log("근무 중 자정이 지난 상태");
					} else {
						// 퇴근 등록 누락
						this.workStatus = 4;
						console.log("퇴근 등록 누락")
					}
				}

			},
			load(employeeId) {
				requestUrl = `/api/officehours`
				requestUrl += `?id=${employeeId}`

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
			}
		},
		mounted() {
			let employeeId = 1;
			console.log("mounted")
			this.today = dayjs().format('MM월DD일');
			this.load(employeeId);
		}
	})
	.mount(".wrap");