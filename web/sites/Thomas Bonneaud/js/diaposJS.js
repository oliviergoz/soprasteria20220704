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

function click_start() {
	turn = true;
}

function click_stop() {
	turn = false;
	
}

running = setInterval(function(){
	if (turn == true){
		index++;
		document.querySelector('#images').src=images_sources[index];
		if (index == 3){
			index = -1;
			}
		}
},1000);

function click_next(){
	index ++;
	if (index != 4){
		document.querySelector('#images').src=images_sources[index];
	} else if (index == 4) {
		index = 0;
		document.querySelector('#images').src=images_sources[index];
	}
}

function click_back(){
	index --;
	if (index != -1){
		document.querySelector('#images').src=images_sources[index];
	} else if (index == -1) {
		index = 3;
		document.querySelector('#images').src=images_sources[index];
	}
}

function click_first() {
	index = 0;
	document.querySelector('#images').src=images_sources[index];
}

function click_last() {
	index = 3;
	document.querySelector('#images').src=images_sources[index];
}