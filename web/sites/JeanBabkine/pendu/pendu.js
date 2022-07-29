      

let ALPHABET = 'abcdefghijklmnopqrstuvwxyz';
let mots = ['pompes', 'reggeaton', 'aperol', 'plage'];
let randomWord = mots[Math.random()*mots.length|0];
let chance=4;



function start() {
	clavier();
	zonedejeu();



}
function clavier() {
	let tab=document.createElement('table');
	let lig = document.createElement('tr');
	for (let i in ALPHABET) {
		let col = document.createElement('td');
		let b1 = document.createElement('button');
		b1.innerHTML = ALPHABET[i];
		b1.id = i;
		b1.style.width = '30px';
		b1.style.height = '30px';
		
		b1.addEventListener('click', function() {
		b1.setAttribute('disabled', ' ');
		jeu(b1.innerHTML);
		
		});
		col.append(b1);
		lig.append(col);
	}
	tab.append(lig);
	document.querySelector('#div').append(tab);
	
}   

function zonedejeu() {
	for (let i in randomWord) { 
		word = document.createElement('input');
		word.style.width = '30px';
		word.style.height = '30px';
		word.id = `letter${i}`;
		word.setAttribute('disabled', '');
		
		document.querySelector('#wordzone').append(word);

	}
	
}


function jeu(lettre) {
	let wordrep;
	for (let i in randomWord) { 
		wordrep = document.getElementById(`letter${i}`);
		if (lettre == randomWord[i]) {
			wordrep.removeAttribute('disabled');
			wordrep.value = randomWord[i];
		}

		
	}

	if (!randomWord.includes(lettre)) {
		chance--;
	}

	else if (chance == 0) {
		alert('perdu');
	
	}
	
	


}

