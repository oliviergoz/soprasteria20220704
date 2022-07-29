let alphabet =['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
let mots = ['oignon', 'rouge', 'laurier', 'thym', 'daube', 'olive', 'paleron'];
let randomWord = mots[Math.random()*mots.length|0];
let juste = 0;		//permet de savoir combien de lettre placé
let inc = 0;		//valeur qui incremente à chaque erreur
let pipou = 0; 		//valeur poubelle

//fonctions au lancement
function creation() {
	creationButton();
	hiddenWord();
}

//fonction de creation de l'alphabet
function creationButton() {
	for (letter of alphabet){
		let button = document.createElement('button');
		button.id = letter;
		button.className = 'truc2'
		button.innerHTML = letter;
		button.disabled = false;
		button.onclick = function(){
			button.disabled = true;
			propal = button.innerHTML;
			recherche();
			console.log('but+'+button.innerHTML);			//console retour valeur de l'id correct
			if (inc == 11){
				alert('Vous avez perdu. Le mot etait : '+randomWord);
				neutralization();
			}
		};
		let div = document.getElementById('bouton');
		div.append(button);
	};
}

//fonction de creation du mot caché
function hiddenWord() {
	let decoupe = randomWord.slice(0);
	for(letterWord of decoupe) 	{
		let caseLetterWord = document.createElement('input');
		caseLetterWord.className = 'truc';
		caseLetterWord.readOnly = true;
		caseLetterWord.name = letterWord;						//on récupérera le nom comme valeur et ça fera le taff
		caseLetterWord.value = '-';								//on cache à la main
		caseLetterWord.setAttribute('size','1');
		let div = document.getElementById('word');
		div.append(caseLetterWord);
		juste++;
		console.log(caseLetterWord.name);
		console.log(juste);
	};
}

function recherche() {
	let objs = document.getElementsByClassName('truc');
	for (obj of objs){
		if (obj.name == propal){
			obj.value = propal;
			pipou++;
			juste--;
			if (juste == 0) {
				alert('Vous avez GAGNE!. Le mot etait : '+randomWord);
				neutralization();
			}
		}
	}
	if (pipou == 0){
		mauvaiseLettre();
	}
	pipou = 0;
}

function mauvaiseLettre() {
	let imgID = 'image'+inc;
	let img = document.getElementById(imgID).hidden=false;
	inc++;
}

function neutralization(){		//desactive tout les boutons et affiche le mot
	let objs = document.getElementsByClassName('truc2');
	for (obj of objs){
		obj.disabled = true;
	}
}