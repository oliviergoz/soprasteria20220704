/**
 * 
 */
//penduGAME
//alert('Let the games begin');

let alphabet = 'abcçdefghijklmnopqrstuvwxyz';
let wordBank = ['anneaux', 'olivier'];

let intentosRestantes = 10;//el numero de imagenes



function startGame() {

	createLayout();
	createWordZone()
	//console.log(document.querySelector('#zonaDelMuerto'));
	document.querySelector('#zonaDelMuerto').removeAttribute('style')
	//document.querySelector('#zonaDelMuerto').style.display = "none";
	//createHangingSquare();

}

function createLayout() {

	document.querySelector('#startgame').parentElement.remove();//borra a su padre, o sea el div
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
		document.querySelector('#gameDiv').append(button);
		document.querySelector('#gameDiv').append(" ");
	}

}

function createWordZone() {

	let cell;

	for (let i = 0; i < wordBank[0].length; i++) { //cambiar la condicion limite cambiar el 0 por un generador de numero aleatorio
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
	document.querySelector('#wordZone').append(cell);


}


function monClick(letterReceived) {

//	console.log(letterReceived);
//	console.log(`#${intentosRestantes}`);
	let palabra=''; //darle la longitud o ver como hacer append o solo hacerlo string y poner +   mejor tabelau de la long
	let cell;
	let button = document.querySelector(`#${letterReceived}`);
	button.setAttribute('disabled', ''); //opuesto => .removeAttribute('disabled')

	for (let i = 0; i < wordBank[0].length; i++) { //AQUI TAMBIEN cambiar la condicion limite cambiar el 0 por un generador de numero aleatorio

		cell = document.querySelector(`#letter${i}`);

		if (letterReceived == wordBank[0][i]) {
			cell.setAttribute('value', letterReceived);
			//palabra=palabra+letterReceived; //a corregir
			//console.log(palabra);
		}
	}

	if (!wordBank[0].includes(letterReceived)) {
		document.querySelector(`#intento${intentosRestantes}`).setAttribute('style', 'visibility:visible');
		intentosRestantes--;//aqui esta el pedo
	}

	if (intentosRestantes == 0) {
		myTexte = 'Tu as perdu, reponse:' + wordBank[0];
		document.querySelector('#respuesta').value = myTexte;
	}

//tomar el imput de cada casilla y comparar con el string original, si coinciden, ganaste y llamas a reset
//puedo hacerlo con un tableau
}

function resetAll(){
	
	//borrar todo, reinicializar variables y llamar a start();
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

