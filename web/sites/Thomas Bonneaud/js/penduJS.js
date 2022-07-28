let alphabet =['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];

function creationB(letter) {
	for (letter of alphabet){
		let button = document.createElement('button');
		button.type = 'button';
		button.id = letter;
		button.innerHTML = letter;
		let div = document.getElementById('bouton');
		div.append(button);
	};
}