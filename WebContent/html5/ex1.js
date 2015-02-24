function add() {
		var a,b,_a,_b;
		var sumBtn = document.getElementById("sum-btn");
		a=prompt("a값을 입력하라", 0);		
		b=prompt("b값을 입력하라", 0);
		_a = parseInt(a);
		_b = parseInt(b);
		sumBtn.value =_a+_b;
	}
	
	function init(){
		var sumBtn = document.getElementById("sum-btn");
		sumBtn.onclick = add;
	}
	
	window.onload = init;