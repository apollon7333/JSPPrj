function init() {
	var changeImg = document.getElementById("change-img");
	changeImg.onclick = changeImage; 
}

function changeImage(){
	var text = document.getElementById("text");
	var text2 = document.getElementById("text2");
	var img =document.getElementById("img");
	img.src = text.value;
	img.style.borderWidth = text2.value;
}

window.onload = init;