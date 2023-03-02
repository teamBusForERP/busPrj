window.onload = function () {

	// ----------------- 프로그레스 바 

	let progressBarList = document.querySelectorAll(".progress-bar");
	let progressRate = 0.5;
	for (let i = 0; i < progressBarList.length; i++) {
		progressBarList[i].style.width =  progressRate * 100 + '%';
	}
	// ----------------- 프로그레스 바


	

	// ----------------- 시간 선택 버튼 
	let showDate = document.querySelector('#showDate');
  let showWeek = document.querySelector('#showWeek');
  let showMonth = document.querySelector('#showMonth');

  let date = dayjs();

  let btnPlus = document.querySelector('#date-btn-plus');
  let btnMinus = document.querySelector('#date-btn-minus');

  //기본 출력
  displayDate();
  // displayWeek();
  // displayMonth();

  function datePlusHandler() {
    date = date.add(1,"day");
    displayDate();
  }


  function dateMinusHandler() {
    date =  date.add(-1,"day");
    displayDate();
  }


  function displayDate() {
    formatDate = date.format("YYYY.MM.DD");
    showDate.innerText = formatDate;
  }

  function  displayMonth() {
    formatMonth = date.format("YYYY.MM");
    showMonth.innerText = formatMonth ;
  }

  function displayWeek() {
    formatStardaytWeek = dayjs("2023-02-27").format("MM.DD");
    formatEnddayWeek = dayjs("2023-02-27").add(6,"day").format("MM.DD");
    showWeek.innerText = formatStardaytWeek +' ~ '+ formatEnddayWeek;
  }

  btnPlus.addEventListener("click", datePlusHandler)
  btnMinus.addEventListener("click", dateMinusHandler)
	// ----------------- 시간 선택 버튼 


}
