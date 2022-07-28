let start = document.getElementById('start_button');
let stop = document.getElementById('stop_button');
let next = document.getElementById('next_button');
let back = document.getElementById('back_button');
let first = document.getElementById('first_button');
let last = document.getElementById('last_button');
const images_sources = ['ressources/zac.jpg', 'ressources/ivern.jpg', 'ressources/evelynn.jpg', 'ressources/kayn.jpg'];
let index = 0;
let turn = false;
let seconde = -1;
let restart;

stop.disabled = true;

function click_start() {
	turn = true;
	clearInterval(running);
	restart = running();
	stop.disabled = false;
	start.disabled = true;
}

function click_stop() {
	turn = false;
	clearInterval(running);
	stop.disabled = true;
	start.disabled = false;
}

function running(){
	return setInterval(() => {
	if (turn == true){
		index++;
		document.querySelector('#images').src=images_sources[index];
		if (index == 3){
			index = -1;
			}
		}
	},1000);
}

function click_next(){
	index ++;
	if (index >= 4 || index <= - 1){
		index = 0;
		document.querySelector('#images').src=images_sources[index];
	} else if (index <= 4 || index >= - 1) {
		document.querySelector('#images').src=images_sources[index];
	}
	clearInterval(running);
}

function click_back(){
	index --;
	if (index >= 4 || index <= - 1){
		index = 3;
		document.querySelector('#images').src=images_sources[index];
	} else if (index <= 4 || index >= - 1) {
		document.querySelector('#images').src=images_sources[index];
	}
	clearInterval(running);
}

function click_first() {
	index = 0;
	document.querySelector('#images').src=images_sources[index];
	clearInterval(running);
}

function click_last() {
	index = 3;
	document.querySelector('#images').src=images_sources[index];
	clearInterval(running);
}