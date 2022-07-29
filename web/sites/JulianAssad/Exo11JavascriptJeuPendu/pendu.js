/**
 * 
 */
//penduGAME
//alert('Let the games begin');

let alphabet = 'abcçdefghijklmnopqrstuvwxyz';
let wordBank = ['anneaux', 'olivier', 'diaporama'];



let intentosRestantes = 10;//el numero de imagenes
let palabraDelJugador = [];


function startGame() {

	nombreRNG = Math.floor(Math.random() * (wordBank.length));

	intentosRestantes = 10;//el numero de imagenes
	palabraDelJugador = [];

	createLayout();
	createWordZone()
	//console.log(document.querySelector('#zonaDelMuerto'));
	document.querySelector('#zonaDelMuerto').removeAttribute('style')
	//document.querySelector('#zonaDelMuerto').style.display = "none";
	//createHangingSquare();

}

function createLayout() {

	if (document.querySelector('#startgame')) {
		document.querySelector('#startgame').parentElement.remove();//borra a su padre, o sea el div
	}
	let button;

	for (let i = 0; i < alphabet.length; i++) {
		//console.log(alphabet[i]);

		button = document.createElement('button');
		button.innerHTML = `${alphabet[i]}`;
		button.style.width = '30px';
		button.style.height = '30px';
		button.id = `${alphabet[i]}`;
		button.setAttribute('value', `${alphabet[i]}`);
		button.setAttribute('onclick', `monClick('${alphabet[i]}')`); //preguntar a olivier si se puede poner una variable en html
		document.querySelector('#wordZone2').append(button);
		document.querySelector('#wordZone2').append(" ");
	}

}

function createWordZone() {

	let cell;

	for (let i = 0; i < wordBank[nombreRNG].length; i++) { //cambiar la condicion limite cambiar el 0 por un generador de numero aleatorio
		cell = document.createElement('input');
		cell.style.width = '30px';
		cell.style.height = '30px';
		cell.id = `letter${i}`;
		cell.setAttribute('disabled', '');
		document.querySelector('#wordZone').append(cell);
		document.querySelector('#wordZone').append(' ');
	}

	cell = document.createElement('input');
	cell.setAttribute('disabled', '');
	cell.id = `respuesta`;
	cell.style.height = '30px';
	cell.style.width = '300px';
	document.querySelector('#wordZone').append(cell);


}


function monClick(letterReceived) {

	//	console.log(letterReceived);
	//	console.log(`#${intentosRestantes}`);
	//darle la longitud o ver como hacer append o solo hacerlo string y poner +   mejor tabelau de la long

	let cell;
	let button = document.querySelector(`#${letterReceived}`);
	button.setAttribute('disabled', ''); //opuesto => .removeAttribute('disabled')

	palabraDelJugador.length = wordBank[nombreRNG].length; ///CAMBIAR


	for (let i = 0; i < wordBank[nombreRNG].length; i++) { //AQUI TAMBIEN cambiar la condicion limite cambiar el 0 por un generador de numero aleatorio

		cell = document.querySelector(`#letter${i}`);

		if (letterReceived == wordBank[nombreRNG][i]) { ///
			cell.setAttribute('value', letterReceived);
			palabraDelJugador[i] = letterReceived;
			console.log(palabraDelJugador);
			//palabra=palabra+letterReceived; //a corregir
		}
	}

	if (!wordBank[nombreRNG].includes(letterReceived)) {
		document.querySelector(`#intento${intentosRestantes}`).setAttribute('style', 'visibility:visible');
		intentosRestantes--;
	}

	if (intentosRestantes == -1) {
		myTexte = 'Tu as perdu, reponse:' + wordBank[nombreRNG]; //CAMBIAR
		document.querySelector('#respuesta').value = myTexte;

		resetAll();

		//funcion reset

	}

	let sommeDeLettres = '';

	for (let i = 0; i < palabraDelJugador.length; i++) {
		sommeDeLettres = sommeDeLettres + `${palabraDelJugador[i]}`;
	}

	if (sommeDeLettres == wordBank[nombreRNG]) {
		myTexte = 'Tu as GAGNE';
		document.querySelector('#respuesta').value = myTexte;

		resetAll();//funcionreset o mejor crear un boton

	}

	console.log(sommeDeLettres);


	//tomar el imput de cada casilla y comparar con el string original, si coinciden, ganaste y llamas a reset
	//puedo hacerlo con un tableau
}

function resetAll() {

	let botonNuevo;

	botonNuevo = document.createElement('button');
	botonNuevo.id = `jugarDeNuevo`;
	botonNuevo.innerHTML = `jugarDeNuevo`;
	document.querySelector('#wordZone').append(botonNuevo);
	botonNuevo.setAttribute('onclick', `reset()`);


	for (i = 0; i < alphabet.length; i++) { //CAMBIAR WORDBANK
		document.querySelector(`#${alphabet[i]}`).setAttribute('disabled', ''); //WORDBANK
	}




	//borrar todo, reinicializar variables y llamar a start();
}

function reset() {

	document.querySelector('#wordZone').remove();

	let div = document.createElement('div');
	div.id = ('wordZone');
	document.querySelector('#zonaDelMuerto').after(div);

	div = document.createElement('div');
	div.id = ('wordZone2');
	document.querySelector('#wordZone').append(div);


	for (i = 0; i <= 10; i++) {
		document.querySelector(`#intento${i}`).setAttribute('style', 'visibility:hidden');
	}
	startGame();
}



//function createHangingSquare() { //muy complicado, me fui directo al html
//
//	let div = document.createElement('div');
//	div.id = 'hangedZoneDiv'
//	document.querySelector('#gameDiv').after(div); //coloca mi nuevo dif despues del otro dif y no adentro
//
//
//	let table = document.createElement('table');
//	table.id = 'hangedZoneMainTable';
//
//	document.querySelector('#hangedZoneDiv').append(table);
//
////	let tr = document.createElement('tr');
////	table.append(tr);
////	let td = document.createElement('td');
////	tr.append(td);
//
//
//	let imagen;
//	for (let i = 0; i <= 10; i++) {
//		imagen = document.createElement('img');
//		imagen.id = `pend${i}`;
//
//				tr=document.createElement('tr');
//				table.append(tr);
//				tr.append(imagen);
//
//		document.querySelector(`#pend${i}`).src = `images/pend_${i}.gif`;
//		imagen.style.visibility = 'visible'; //hidden
//	}
//
//}

