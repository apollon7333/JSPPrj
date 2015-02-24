
function init() {
	var btnResize = document.getElementById("btn-resize");
	var btnMove = document.getElementById("btn-move");
	var btnOpenerClose = document.getElementById("btn-opener-close");
	btnResize.onclick = btnNewTabClick; 
	btnMove.onclick = btnNewWinClick; 
	btnOpenerClose.onclick = btnCloseWinClick;
}

function btnResizeClick() {
	opener.resizeTo(100,100);
	opener.resizeTo(100,100);
}

function btnMoveClick() {
	opener.moveTo(100,100);
	opener.moveBy(100,100);
}

function btnOpenerCloseClick() {
	opener.close();	
}

window.onload = init;