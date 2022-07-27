let x = document.querySelector('#game_result');
let y = document.querySelector('#game_input');
let z = document.querySelector('#game_number');
let a = document.querySelector('#mysteryNbrBtn');
let remain = 10;
let number = 0;
loadingFunction();

function loadingFunction() {
	x.value = '';
	y.focus();
	number = Math.floor(Math.random() * 100);
	mysteryNumber('hide');
}

function lauchGame() {
	let value = y.value;
	
	if (value == number) {
		x.value = 'Félicitation ! Vous avey trouvé le bon nombre !';
		y.value = '';
		remain = 10;
		let reset = setTimeout(loadingFunction, 3000);
		/* loadingFunction(); */
	} else {
		remain--;
		x.value = 'Perdu, vous n\'avez pas réussi à trouver le bon nombre. Il vous reste ' + remain + ' essais.';
		y.value = ''
		y.focus();
	}
}

function mysteryNumber(p) {
	if (p == 'hide') {
		z.value = '***';
		a.setAttribute('onclick','mysteryNumber("display")');
	} else if (p == 'display') {
		z.value = number;
		a.setAttribute('onclick','mysteryNumber("hide")');
	}
}