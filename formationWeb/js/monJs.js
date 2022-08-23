/**
 * 
 */

//produits
let produits = [{ nom: 'tele', prix: 500 }, { nom: 'telephone', prix: 300 }];

function initProduits() {
	for (let produit of produits) {
		document.querySelector('#tbody').append(createTr(produit));
	}
}

function createTr(produit) {
	let tr = document.createElement('tr');
	let tdNom = document.createElement('td');
	tdNom.innerHTML = produit.nom;
	let tdPrix = document.createElement('td');
	tdPrix.innerHTML = produit.prix;
	tr.append(tdNom);
	tr.append(tdPrix);
	return tr;
}

function ajouter() {
	let newTr = createTr(
		{
			nom: document.querySelector('#nom').value,
			prix: document.querySelector('#prix').value
		});
	newTr.classList.add('table-secondary');
	setTimeout(() => {
		newTr.classList.remove('table-secondary');
	}, 2000);
	document.querySelector('#tbody')
		.append(newTr);
	resetProduit();
}

function resetProduit() {
	document.querySelector('#nom').value = '';
	document.querySelector('#prix').value = '0';
}


function create() {
	//document.querySelector('#div').innerHTML =document.querySelector('#div').innerHTML+ '<h1>hello world</h1><div><h2>titre h2</h2><button onclick="alert(\'click\')">bouton</button></div>';
	let div = document.createElement('div');
	div.innerHTML = "une div creee par le js";
	div.id = 'maDiv';
	let b1 = document.createElement('button');
	b1.innerHTML = 'bouton';
	b1.id = 'b1';
	b1.addEventListener('click', (event) => {
		console.log(event);
	});
	div.append(b1);
	document.querySelector('#div').append(div);
}


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
	sec = 0;
	min = 0;
	document.querySelector('#h1').innerHTML = ((min < 10) ? '0' + min : min) + ':' + ((sec < 10) ? '0' + sec : sec);
	clearInterval(intervalCompteur);
	intervalCompteur = startInterval();
}

let images = ['carre', 'cercle', 'triangle', 'parallelo', 'trapeze', 'rectangle'];
let textes = ['carré', 'cercle', 'triangle', 'parallélogramme', 'trapèze', 'rectangle'];

//exercice diapo
let currentIndex = 0;
let interval;
function startDiapo() {
	interval = setInterval(() => {
		next();
	}, 1000);
}

function stopDiapo() {
	clearInterval(interval);
}

function next() {
	stopDiapo();
	if (currentIndex == images.length - 1) {
		first();
	} else {
		currentIndex++;
		loadImage();
	}
	startDiapo();
}

function previous() {
	stopDiapo();
	if (currentIndex = 0)  {
		last();
	} else {
		currentIndex--;
		loadImage();
	}
	startDiapo();
}

function first() {
	stopDiapo();
	currentIndex = 0;
	loadImage();
	startDiapo();
}

function last() {
	stopDiapo();
	currentIndex = images.length - 1;
	loadImage();
	startDiapo();
}

function loadImage() {
	document.querySelector('#image').src = `images/${images[currentIndex]}.gif`;
}


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
