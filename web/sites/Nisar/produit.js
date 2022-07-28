table = document.getElementById('tbody')

produits=[];

function fillTable(){
	table.innerHTML = "";
	produits.forEach(produit=>addRowProduit(produit))
}

function addRowProduit(produit){
	let ligne = table.insertRow(0);
	let nomCell = ligne.insertCell(0);
	let prixCell = ligne.insertCell(1);

	nomCell.innerHTML = produit.nom;
	prixCell.innerHTML = produit.prix+' €';

}

function addProduit(){
	name = document.getElementById('name').value
	price = document.getElementById('price').value
	let obj = new Object();
	obj.nom = name;
	obj.prix = price;
	produits.push(obj);
	fillTable();
}