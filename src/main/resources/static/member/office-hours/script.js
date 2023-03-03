window.onload = function () {
	let hamburgerBtn = document.querySelector(".hamburger");
	let restToggleOff = document.querySelector(".rest-toggle-off");
	let restToggleOn = document.querySelector(".rest-toggle-on");
	let restButton = document.querySelector(".commute-info .rest");
	// let xBtn = document.querySelector(".xbtn");
	let sideMenub = document.querySelector(".menu-b");
	let restEditorBox = document.querySelector(".rest-editor-box");
	let restEditSubmit = document.querySelector(".rest-edit-submit");


	let sideMenu = document.querySelector(".side-bar")
	hamburgerBtn.addEventListener("click", function () {
		sideMenu.classList.toggle("d-none");
		sideMenub.classList.toggle("d-none");
		// sideMenu.classList.toggle("menu-on");
		// if (sideMenu.classList.contains("menu-on")) {
		// 	sideMenu.style.transform = "translateX(0)";
		// 	sideMenu.style.transition = "transform 0.6s ease-in-out";
		// }
		// else {
		// 	sideMenu.style.transform = "translateX(100vw)";
		// }
	})
	restToggleOff.addEventListener("click", restToggleListener);
	restToggleOn.addEventListener("click", restToggleListener);

	function restToggleListener() {
		restToggleOff.classList.toggle("d-none");
		restToggleOn.classList.toggle("d-none");
		restButton.classList.toggle("d-none");
	}


	//휴게편집창
	restButton.addEventListener("click", restEditorOnListener);
	restEditSubmit.addEventListener("click", restEditorOffListener);

	function restEditorOnListener() {
		restEditorBox.classList.remove("d-none");
		sideMenub.classList.remove("d-none");
		// restEditorBox.style.transition = "all 0.6s ease-in-out";
		// restEditorBox.style.transform = "translateY(100vh)";
		// restPopupChk.checked = true;
	}

	function restEditorOffListener() {
		restEditorBox.classList.add("d-none");
		sideMenub.classList.add("d-none");
		// restEditorBox.style.transform = "translateY(0)";

		// restPopupChk.checked = false;
	}
	//휴게편집창↑↑↑↑


	// 팝업 외부 화면 클릭으로 창 닫기---------
	addEventListener("mouseup", (e) => {
		if (!restEditorBox.classList.contains("d-none")) {
			if (!restEditorBox.contains(e.target)) {
				restEditorOffListener();
			}
		}
	});


	let startRestTime = document.querySelector('#start-restTime');
	let endRestTime = document.querySelector('#end-restTime');


	let dateS = dayjs();
	dateS = dateS.set("hour", 13);
	dateS = dateS.set("minute", 00);
	//   let dateS = dayjs("12:00", "A hh:mm");
	console.log(dateS);

	let dateE = dateS.add(1, "hour");


	let btnPlusS = document.querySelector('#plus-s');
	let btnMinusS = document.querySelector('#minus-s');
	let btnPlusE = document.querySelector('#plus-e');
	let btnMinusE = document.querySelector('#minus-e');

	//기본 출력
	displayTime();


	function dateStartPlusHandler() {
		dateS = dateS.add(10, "minute");
		displayTime();
	}
	function dateStartMinusHandler() {
		dateS = dateS.add(-10, "minute");
		displayTime();
	}

	function dateEndPlusHandler() {
		dateE = dateE.add(10, "minute");
		displayTime();
	}
	function dateEndMinusHandler() {
		dateE = dateE.add(-10, "minute");
		displayTime();
	}

	function displayTime() {
		formatDateS = dateS.format("A hh:mm");

		formatDateS = formatDateS.replace("AM", "오전");
		formatDateS = formatDateS.replace("PM", "오후");
		startRestTime.innerText = formatDateS;

		formatDateE = dateE.format("A hh:mm");
		formatDateE = formatDateE.replace("AM", "오전");
		formatDateE = formatDateE.replace("PM", "오후");
		endRestTime.innerText = formatDateE;
	}

	btnPlusS.addEventListener("click", dateStartPlusHandler)
	btnMinusS.addEventListener("click", dateStartMinusHandler)
	btnPlusE.addEventListener("click", dateEndPlusHandler)
	btnMinusE.addEventListener("click", dateEndMinusHandler)
}