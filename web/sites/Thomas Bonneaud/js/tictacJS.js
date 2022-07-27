let tictac = document.getElementById('tictac');
let start = document.getElementById('start_button');
let stop = document.getElementById('stop_button');
let abbort = document.getElementById('abbort_button');
let turn = false;
let seconde = 0;
let minute = 0;

stop.disabled = true;
abbort.disabled = true;

function click_abbort() {
    tictac.innerHTML = '00:00';
	seconde = 0; minute = 0;
	turn = false;
	stop.disabled = true;
	abbort.disabled = true;
}

function click_stop() {
	turn = false;
	stop.disabled = true;
	start.disabled = false;
}

function click_start() {
	turn = true;
	stop.disabled = false;
	abbort.disabled = false;
	start.disabled = true;
}

running = setInterval(function(){
	if (turn == true){
		seconde++;
		if (seconde == 60) {
			seconde = 0;
			minute++;
		}
		tictac.innerHTML = (minute > 9 ? minute : '0' + minute) + ':' + (seconde > 9 ? seconde : '0' + seconde);
	}
},1000);