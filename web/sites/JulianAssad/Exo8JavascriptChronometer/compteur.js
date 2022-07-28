/**
 * 
 */
//querySelector puede llamar por .clase, #id o '[name="box1"]' y tal vez más


console.log('Salut :p');

let botones=['playButton','pauseButton'];

let segundero = 0;
let minutero = 0;
let hora = 0;

let reloj; //esto lo hago para darle nombre a la secuencia y poder borrarla

function start() {
	reloj = setInterval(() => { //todo lo que esta en estos {} es una funcion que pude haber hecho aparte y llamar el setInterval(funcion,1000);


		//sec ticks toujours
		segundero++;

		//min ticks tous les 60 secs
		if (segundero == 60) {
			segundero = 0;
			minutero++;
		}

		//hr ticks tous les 60 min
		if (minutero == 60) {
			minutero = 0;
			hora++;
		}

		//retrieving info vers mon html
		//use ternario, pude haber hecho ifs para leer más facil.
		document.querySelector('#chronometer').innerHTML = ((hora < 10) ? '0' + hora : hora) + ':' + ((minutero < 10) ? '0' + minutero : minutero) + ':' + ((segundero < 10) ? '0' + segundero : segundero);

	}, 1000); //1000ms

	//desactivo el boton correspondiente (ejemplo con tableau/variables y ejemplo introduciendo el nombre enterp)
	document.querySelector(`[name="${botones[0]}"]`).disabled = true;
	document.querySelector('[name="pauseButton"]').disabled = false; //`[name="${botones[1]}"]` pude haber puesto
	
	//ça sert a rien, je le fais comme exemple xD
	document.querySelector('[name="playButton"]').value = 'off';
	document.querySelector('[name="pauseButton"]').value = 'on';
	
}

function pause() { //no pasa nada si se borra el intervalo porque las variables hr, min, sec se quedan guardadas
	clearInterval(reloj);
	
	//disabling and reset buttons
	document.querySelector('[name="playButton"]').disabled = false;
	document.querySelector(`[name="${botones[1]}"]`).disabled = true;
	
	document.querySelector('[name="playButton"]').value = 'on';
	document.querySelector('[name="pauseButton"]').value = 'off';

}


function reset() {
	clearInterval(reloj); //pausa + resetear valores y affichage
	segundero = 0;
	minutero = 0;
	hora = 0;
	//au lieu de copier ligne 32, vaut mieux mettre du texte xD?
	document.querySelector('#chronometer').innerHTML = '00:00:00';
	
	//reset de los botonos como en las otras dos funciones
	document.querySelector('[name="playButton"]').disabled = false;
	document.querySelector('[name="pauseButton"]').disabled = false;

	document.querySelector('[name="playButton"]').value = 'on';
	document.querySelector('[name="pauseButton"]').value = 'on';


}



