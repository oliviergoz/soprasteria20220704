      

let ALPHABET = 'abcdefghijklmnopqrstuvwxyz';


function clavier() {
	let tab=document.createElement('table');
	let lig = document.createElement('tr');
	for (let i in ALPHABET) {
		let col = document.createElement('td');
		let touche = document.createElement('input');
		touche.type="button";

		touche.value=ALPHABET[i];
		col.append(touche);
		lig.append(col);
	}
	tab.append(lig);
	document.querySelector('#div').append(tab);
	
}   
   
   
   
 
