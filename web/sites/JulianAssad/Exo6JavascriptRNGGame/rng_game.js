/**
 * 
 */
console.log('exo kk');
let intentos = 10;
nombreRNG = Math.floor(Math.random() * (100 + 1));
//nombreRNG = 6;
textePlusOuMoins=null;


function monClick() {
	let input = document.querySelector('#input');
	let input2 = document.querySelector('#input2');
	let input3valoresRestantes = document.querySelector('#input3valoresRestantes');

	console.log(input.value);
	console.log(nombreRNG);

	if (input.value > nombreRNG) {
		textePlusOuMoins = 'Essaie avec un nombre plus petit';
	} else { 
		textePlusOuMoins = 'Essaie avec un nombre plus grand'; 
	}

	while (intentos > 0) {

		let myTexte = (input.value == nombreRNG) ? 'Tu as gagné' : textePlusOuMoins ;

		input2.value = myTexte;
		intentos = intentos - 1;
		input3valoresRestantes.value = intentos + ' essais restans';//esto nos pone en el cuadrito el valor del nombre
		break;

	}

	if (intentos == 0) {
		myTexte = 'Tu as perdu';
		input2.value = myTexte;
	}


}