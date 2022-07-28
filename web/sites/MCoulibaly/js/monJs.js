/**
 * 
 */

let image = ['auba', 'dembele', 'araujo', 'pedri', 'raphinha'];
let imgAfficher=0;
let intervalDiapo;

function suivant(){
if (imgAfficher < image.length - 1) {
		imgAfficher++;
	} else {
		imgAfficher = 0;
	}
	dossierImage();
}

function precedent() {

	if (imgAfficher > 0) {
		imgAfficher--;
		
	} else {
		imgAfficher = image.length - 1;
	}
	dossierImage();
}
function dernierpage() {

	imgAfficher = image.length - 1;
	dossierImage();
}

function premierepage() {

	imgAfficher = 0;
	dossierImage();
}


function play(){
	intervalDiapo= setInterval(() => {
		next();
	}, 2000)
}
function changeStatut(){
	document.querySelector('#play').disabled=!document.querySelector('#play').disabled;
	document.querySelector('#pause').disabled=!document.querySelector('#pause').disabled;
}

function play() {
	changeStatut();
	intervalDiaporama = setInterval(() => {
		suivant();
	}, 3000)
}

function pause() {
	changeStatut();
	clearInterval(intervalDiapo);
	
}

function dossierImage() {
	document.querySelector('#diapo').src = `image/${image[imgAfficher]}.jpg`;
}


//var start = document.querySelector('play');
//var stop = document.querySelector('pause');
//var reset = document.querySelector('reset');
//var sec = 0;
//var min = 0;
//var t;

//function tick() {
//	sec++;
//	if (sec >= 60) {
//		sec = 0;
//		min++;
//	}
//}
//
//function add() {
//	tick();
//	document.querySelector('#chrono').innerHTML = (min > 9 ? min : "0" + min)
//		+ ":" + (sec > 9 ? sec : "0" + sec);
//	timer();
//}
//function timer() {
//	t = setTimeout(add, 1000);
//}
//
//
//function play(){
//	timer();
//	document.querySelector('#play').disabled=true;
//	document.querySelector('#pause').disabled=false;
//}
//function pause() {
//	document.querySelector('#play').disabled=false;
//	document.querySelector('#pause').disabled=true;
//	clearTimeout(t);
//}
//function reset() {
//	
//	document.querySelector('#chrono').innerHTML = "00:00";
//	sec = 0; min = 0;
//	clearTimeout(t);
//}
//
//
//let image = ['carre', 'rectangle', 'cercle', 'triangle', 'trapeze', 'parallelo'];
//let titre = ['carre', 'rectangle', 'cercle', 'triangle', 'trapeze', 'parallelo'];
//
//
//
//function monSelect() {
//	let index = document.querySelector('#forme').value;
//	document.querySelector('#image').src = `image/${image[index]}.jpg`;
//	document.querySelector('#titre').innerHTML = `Aire du ${image[index]}`;
//}
//
//
//
//
//
//
//let nbjuste = Math.floor(Math.random() * 10) + 1;
//
//var essai = 1;
//function f() {
//	let input = document.querySelector('#input').value;
//	if (essai < 2) {
//		if (input < nbjuste) {
//			alert("Plus")
//			essai++;
//		}
//		if (input > nbjuste) {
//			alert("Moins");
//			essai++;
//		}
//		if (input == nbjuste) {
//			alert("Bravo , le nombre était " + nbjuste + " Tu as gagné en " + essai + " essai");
//		}
//	}
//	else {
//		alert("Tu as n'as plus d'essai, le nombre exacte est " + nbjuste)
//	}
//
//}
