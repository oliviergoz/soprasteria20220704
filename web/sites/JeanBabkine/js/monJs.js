// JavaScript



let nombre = Math.floor(Math.random() * 100) + 1;



alert(`welcome to the game of jeanChien, le nombre est ${nombre}`)

let reste = 2

function proposition() {
	let input = document.querySelector('#nombre'); //Choix du nombre
	reste--;
	if (input.value == nombre) {
		fin('Tu as gagné mon brave',input);
	} else if (reste == 0) {
		fin(`tu as perdu immonde déchet, le nombre était ${nombre}`,input);
	} else if (input.value < nombre) {
		//c'est plus grand'
		alert(`Plus grand, il te reste ${reste} essais`)
		input.value = ''
	} else {
		//c'est plus petit'
		alert(`Plus petit, il te reste ${reste} essais`)
		input.value = ''
	}
}

function fin(texte,input) {
	alert(texte);
	input.disabled = "disabled";
	document.querySelector('#bouton').disabled = "disabled";
}

function rejouer(){
	window.location.reload();
}

