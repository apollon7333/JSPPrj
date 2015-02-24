function init() {
	var btnCountdown = document.getElementById("btn-countdown");
	btnCountdown.onclick = countDownClick; 
}

var count=60;
var timer=null;

function countDown() {
	var lblCcount = document.getElementById("lbl-count");

	lblCcount.innerText = --count;

	if (count > 0)
		setTimeout(countDown, 1000);
}

function countDownClick(){
	if(timer==null) //여러번 누를 수 있으니까 조건 검사
		timer = setTimeout(countDown,1000);
	/*setInterval(countDown,1000);*/	
}

window.onload = init;