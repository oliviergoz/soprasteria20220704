let alphabet =['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
let mots = ['oignon', 'rouge', 'laurier', 'thym', 'daube', 'olive', 'paleron'];
let randomWord = mots[Math.random()*mots.length|0];

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
		let caseLetterWord = document.createElement('input');
		caseLetterWord.setAttribute('size','1');
		caseLetterWord.id = letterWord;
		caseLetterWord.value = letterWord;
		let div = document.getElementById('word');
		caseLetterWord.readOnly = true;
		div.append(caseLetterWord);
		console.log(letterWord);
	};
}
