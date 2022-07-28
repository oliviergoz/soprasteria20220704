/**
 * 
 */


//exercice compteur
let sec = 0;
let min = 0;
let intervalCompteur;

function play() {
	changeButtonStatus();
	intervalCompteur = startInterval();
}

function startInterval() {
	return setInterval(() => {
		sec++;
		if (sec > 59) {
			sec = 0;
			min++;
		}
		document.querySelector('#h1').innerHTML = ((min < 10) ? '0' + min : min) + ':' + ((sec < 10) ? '0' + sec : sec);
	}, 1000);
}

function pause() {
	changeButtonStatus();
	clearInterval(intervalCompteur);
}

function changeButtonStatus() {
	document.querySelector('#play').disabled = !document.querySelector('#play').disabled;
	document.querySelector('#pause').disabled = !document.querySelector('#pause').disabled;
}

function reset() {
	sec =  0;
	min = 0;
	document.querySelector('#h1').innerHTML = ((min < 10) ? '0' + min : min) + ':' + ((sec < 10) ? '0' + sec : sec);
	clearInterval(intervalCompteur);
	intervalCompteur = startInterval();
}

let images = ['carre', 'cercle', 'triangle', 'parallelo', 'trapeze', 'rectangle'];
let textes = ['carré', 'cercle', 'triangle', 'parallélogramme', 'trapèze', 'rectangle'];

let obj = { prenom: 'olivier', nom: 'gozlan' };
console.log(obj);
console.log(obj.prenom);

let t = [obj, { prenom: 'toto', nom: 'tutu' }];
console.log(t);

//function somme(a, b) {
//	return a + b;
//}

//let somme = function(a, b) {
//	return a + b;
//}

//let somme = (a, b) => {
//	return a + b;
//}



function changeImage() {
	let index = document.querySelector('#forme').value;
	document.querySelector('#image').src = `images/${images[index]}.gif`;

	document.querySelector('#titre').innerHTML = `Aire du ${textes[index]}`;
	console.log('onchange');
}

function myClick() {
	console.log('onclick');
}


function monClick() {
	let input = document.querySelector('#input');
	//console.log(document.querySelector('#input').value);
	//console.log(variable);
	input.value = variable;
}
