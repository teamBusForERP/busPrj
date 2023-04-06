Vue
	.createApp({
		data() {
			return {
				employee: "",
				companyName: "",
			};
		},
		methods: {
			load(employeeId) {
				requestUrl = `/api/officehours?id=${employeeId}`

				// Employee
				fetch(`http://localhost/api/employee?id=${employeeId}`)
					.then(response => response.json())
					.then(result => {
						this.employee = result
						this.getCompanyName(result);
					})
					.catch(error => console.log('error', error));
				},
				getCompanyName(employee) {
					fetch(`http://localhost/api/company?id=${employee.companyId}`)
						.then(response => response.json())
						.then(result => {
							this.companyName = result.name;
						})
						.catch(error => console.log('error', error));
				}
		},
		mounted() {
			let employeeId = 1;
			this.load(employeeId);
		}
	})
	.mount(".template");