/**
 * 
 */

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


let retourSetTimout=setTimeout(() => {
	console.log('hello world');
}, 2000);
let stopInterval=0;
let retourSetInterval=setInterval(()=>{
	console.log('hello');
	stopInterval++;
	if(stopInterval==5){
		clearInterval(retourSetInterval);
	}
},3000);

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
