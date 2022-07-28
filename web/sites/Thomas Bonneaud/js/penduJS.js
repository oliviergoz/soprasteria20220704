let alphabet =['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
let mots = ['oignon', 'rouge', 'laurier', 'thym', 'daube', 'olive', 'paleron'];
let randomWord = mots[Math.random()*mots.length|0];
let pos;

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
		button.innerHTML = letter;
		button.onclick = function(){
			console.log(button.innerHTML);			//console retour valeur de l'id correct
		};
		let div = document.getElementById('bouton');
		div.append(button);
	};
}

//fonction de creation du mot caché
function hiddenWord() {
	let decoupe = randomWord.slice(0);
	for(letterWord of decoupe) 	{
		pos++;
		let caseLetterWord = document.createElement('input');
		caseLetterWord.setAttribute('size','1');
		caseLetterWord.id = letterWord;						//on récupérera l'ID comme valeur et ça fera le taff
		caseLetterWord.value = '';							//on cache à la main
		let div = document.getElementById('word');
		div.append(caseLetterWord);
		console.log(caseLetterWord.id);
	};
}
