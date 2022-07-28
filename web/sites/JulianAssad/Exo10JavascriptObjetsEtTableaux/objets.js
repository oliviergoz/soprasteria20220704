/**
 * 
 */
//querySelector puede llamar por .clase, #id o '[name="box1"]' y tal vez más

console.log('Salut :p');

let produits = [{ nom: 'voiture', prix: '9000' }, { nom: 'kkhuat', prix: '20' }];

console.log(produits);
console.log(produits[1].prix);
console.log(produits.length)


function create() {

	document.querySelector('[name="playButton"]').disabled = true;

	let div = document.querySelector('#myDiv');

	let tb = document.createElement('table'); //esto nos crea la valisa que queramos mientras exista en html
	tb.id = "table1";
	div.append(tb);

	let tr1 = document.createElement('tr');
	tr1.innerHTML = 'produit';
	tb.append(tr1);

	let tr2 = document.createElement('tr');
	tb.append(tr2);

	let td1 = document.createElement('td');
	td1.innerHTML = produits[0].nom;
	tr2.append(td1);

	let td2 = document.createElement('td');
	td2.innerHTML = produits[1].prix;
	tr2.append(td2);




	let div2 = document.createElement('div');
	div2 = document.querySelector('#myDiv2');
	div2.id = 'myDiv2'

	let inputNom = document.createElement('input');
	inputNom.id = 'nom'
	div2.append(inputNom);

	let inputPrix = document.createElement('input');
	inputPrix.id = 'prix'
	div2.append(inputPrix);


	let b1 = document.createElement('button');
	b1.innerHTML = "ajout de produit";
	b1.id = "botonx";
	b1.setAttribute("onclick", "addNewProducts()"); //esto crea un onclick en el boton
	//b1.setAttribute("type", "submit");
	div2.append(b1);




	//	b1.addEventListener('click', (event) => {
	//		console.log(event);
	//	});

}

function addNewProducts() {

	let input1 = document.querySelector('#nom');
	let input2 = document.querySelector('#prix');
	
	let tab = document.querySelector('#table1');
	let tr2 = document.createElement('tr');
	tab.append(tr2);

	let td1 = document.createElement('td');
	td1.innerHTML = input1.value;
	tr2.append(td1);

	let td2 = document.createElement('td');
	td2.innerHTML = input2.value;
	tr2.append(td2);
	
	console.log(input1.value);

}


