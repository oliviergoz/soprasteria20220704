const countries = ['France','Italy'];
const animals = ['Chien', 'Chat'];
const vegetables = ['Tomate', 'Carote'];
const capitals = ['Paris', 'Luxembourg'];

const randomWordList = [animals,vegetables,countries,capitals];
const randomWordListTitle = ['Animaux','Fruits é Légumes','Pays','Capitales'];

let randomWord = '', score = '', timeout;
let error = 0;

document.addEventListener('keydown', (event) => {console.log(game(event.key));});

loadingFunction();

function loadingFunction() {
	randomWordFunction();
}


function randomWordFunction(p) {
	let x = document.querySelector('#pendu_img');
	let y = document.querySelector('#prop').getElementsByTagName('button');
	let z = document.querySelector('#indice');
	let a = document.querySelector('#mysteryword').getElementsByTagName('input');
	let b = document.querySelector('#list').getElementsByTagName('button');
	
	// REMOVE
	for (let i = 0; i < y.length; i++) {
		y[i].classList.remove('used');
		y[i].removeAttribute('disabled');
	}
	
	z.innerHTML = '';
	
	for (let i = 0; i < a.length; i) {
		a[i].remove();
	}
	
	error = 0;
	score = '';
	clearTimeout(timeout);
	
	// INITIALIZE	
	let index = '';
	if (typeof p == 'undefined') {
		index = Math.floor(Math.random() * randomWordList.length)
		temp = randomWordList[index];
	} else {
		index = p;
		temp = randomWordList[index];
	}
	for (let i = 0; i < b.length; i++) {
		if (i == index) {
			b[i].classList.add('active');
		} else {
			b[i].classList.remove('active');
		}
	}
	randomWord = temp[Math.floor(Math.random() * temp.length)];
	// console.log(randomWord);
	
	
	x.src = 'imgs/pendu_0.png';
	
	let anchor = document.querySelector('#mysteryword');
	
	for (let i = 0; i < randomWord.length; i++) {
		let input = document.createElement('input');
		input.type= 'text';
		input.setAttribute('readonly','readonly');
		if (randomWord[i] == ' ' || randomWord[i] == '-') {
			input.className = 'space';
		}
		input.value = ' ';
		anchor.append(input);
		score = randomWord.length;
	}
	
	// enlever class tous les bouttons + disabled
}

function game(p) {
	let x = document.querySelector('#btn_' + p);
	let x2 = document.querySelector('#prop').getElementsByTagName('button');
	let y = document.querySelector('#pendu_img');
	let z = document.querySelector('#mysteryword').getElementsByTagName('input');
	let a = document.querySelector('#indice');
	
	x.classList.add('used');
	x.setAttribute('disabled','true');
	
	if (randomWord.toLowerCase().indexOf(p.toLowerCase()) >= 0) {
		// button
		x.classList.add('used');
		x.setAttribute('disabled','true');
		
		// bottom word
		for (let i = 0; i < randomWord.length; i++) {
			if (p.toLowerCase() == randomWord[i].toLowerCase()) {
				z[i].classList.add('validate');
				z[i].value = randomWord[i].toUpperCase();
				score--;
			}
		}
	} else {
		error++;
		y.src = 'imgs/pendu_' + error + '.png';
	}
	if (error == 9) { // PERDRE
		a.innerHTML = 'Vous avez perdu !';
		for (let i = 0; i < 26; i++) {
			x2[i].classList.add('used');
			x2[i].setAttribute('disabled','true');
		}
		
		for (let i = 0; i < randomWord.length; i++) {
			if (!z[i].classList.contains('validate')) {
				z[i].classList.add('invalidate');
				z[i].value = randomWord[i].toUpperCase();
			}
		}
		
		timeout = setTimeout(loadingFunction,3000);
	} if (score == 0) { // GAGNER
		a.innerHTML = 'Félicitations ! Vous avez gagné !';
		for (let i = 0; i < 26; i++) {
			x2[i].classList.add('used');
			x2[i].setAttribute('disabled','true');
		}
		timeout = setTimeout(loadingFunction,3000);
	}
}