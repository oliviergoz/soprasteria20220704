console.debug('debug');
console.log('log');
console.warn('warn');
console.error('error');



var produit=[{nom:'Tshirt',prix:15},{nom:'chaussures',prix:35}]


create();

function create() {
	let div=document.createElement('div');
	div.innerHTML="List des produits";
	div.id='maDiv';
	let table=document.createElement('table');
	table.id='table';
	table.b
	let tr=document.createElement('tr');
	let nom=document.createElement('td');
	let prix=document.createElement('td');
	nom.innerHTML="nom";prix.innerHTML="prix";
	tr.append(nom);tr.append(prix);
	table.append(tr);
	let i=0;
	for( i=0;i<produit.length;i++){
		
		let tr=document.createElement('tr');
		let nom=document.createElement('td');
		let prix=document.createElement('td');
		nom.innerHTML=produit[i].nom;prix.innerHTML=produit[i].prix+'$';
		tr.append(nom);tr.append(prix);
		table.append(tr);
	}
	div.append(table);
	document.querySelector('#div').append(div);

}

function add(){
	let inputNom=document.querySelector('#inputNom');
	let inputPrix=document.querySelector('#inputPrix');
	if(inputNom.value=='' || inputPrix.value==''){
		alert('Veuilliez remplir tous les champs');
	}
	else{
		if(typeof inputPrix.value!=='string'){
			alert('le prix doit être un nombre')
		}
		else{
			let tr=document.createElement('tr');
			let nom=document.createElement('td');
			let prix=document.createElement('td');
			nom.innerHTML=inputNom.value;prix.innerHTML=inputPrix.value+'$';
			tr.append(nom);tr.append(prix);
			table.append(tr);
			div.append(table);
		}
	}
	inputPrix.value='';
	inputNom.value='';
}

