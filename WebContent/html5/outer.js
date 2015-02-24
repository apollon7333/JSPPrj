function init() {
	var openDoc = document.getElementById("open-doc");
	openDoc.onclick = openDocClick;
}

function openDocClick() {
	window.frames[0].location.href = "http://www.daum.net/";
}

window.onload = init;