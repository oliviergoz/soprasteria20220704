let start = document.getElementById('start_button');
let stop = document.getElementById('stop_button');
let next = document.getElementById('next_button');
let back = document.getElementById('back_button');
let first = document.getElementById('first_button');
let last = document.getElementById('last_button');
const images_sources = ['ressources/zac.jpg', 'ressources/ivern.jpg', 'ressources/evelynn.jpg', 'ressources/kayn.jpg'];
let index = 0;
let turn = false;
let restart;
let stopAuto
let maj;
let theInterval;

stop.disabled = true;

function maj_image() {
	document.querySelector('#images').src=images_sources[index];
}

function click_start() {
	turn = true;
	clearInterval(theInterval);
	restart = running();
	stop.disabled = false;
	start.disabled = true;
}

function click_stop() {
	turn = false;
	clearInterval(theInterval);
	stop.disabled = true;
	start.disabled = false;
}

function running(){
	return theInterval = setInterval(() => {
	if (turn == true){
		index++;
		maj = maj_image();
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
		maj = maj_image();;
	} else if (index <= 4 || index >= - 1) {
		maj = maj_image();;
	}
	clearInterval(theInterval);
}

function click_back(){
	index --;
	if (index >= 4 || index <= - 1){
		index = 3;
		maj = maj_image();;
	} else if (index <= 4 || index >= - 1) {
		maj = maj_image();;
	}
	clearInterval(theInterval);
}

function click_first() {
	index = 0;
	maj = maj_image();;
	clearInterval(theInterval);
}

function click_last() {
	index = 3;
	maj = maj_image();;
	clearInterval(theInterval);
}