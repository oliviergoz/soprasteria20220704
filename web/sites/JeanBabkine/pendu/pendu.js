      

let ALPHABET = 'abcdefghijklmnopqrstuvwxyz';


function clavier() {
	let tab=document.createElement('table');
	let lig = document.createElement('tr');
	for (let i in ALPHABET) {
		let col = document.createElement('td');
		let b1 = document.createElement('button');
		b1.innerHTML = ALPHABET[i];
		b1.id = i;
		b1.addEventListener('click', (event) => {
		alert(event);
		});
		col.append(b1);
		lig.append(col);
	}
	tab.append(lig);
	document.querySelector('#div').append(tab);
	
}   
   

   
 
