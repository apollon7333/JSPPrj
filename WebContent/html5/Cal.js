
	

function add() {
	var txtX = document.getElementById("txt-x");
	var txtY = document.getElementById("txt-y");
	var txtSum = document.getElementById("txt-sum");

	txtSum.value = parseInt(txtX.value) + parseInt(txtY.value);
}

function init() {
	var btnSum = document.getElementById("btn-sum");
	btnSum.onclick = add;
}

window.onload = init;