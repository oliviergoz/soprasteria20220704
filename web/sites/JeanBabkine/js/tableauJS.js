

let json = [
	{'nom':'café','prix':1,'type':'alimentaire'},
	{'nom':'PQ','prix':2,'type':'hygiene'},
	{'nom':'salade','prix':0.5,'type':'alimentaire'},
	{'nom':'eau','prix':1.3,'type':'alimentaire'},
	{'nom':'3monts','prix':2.5,'type':'alcool'}];



 function add() {
	let name = document.querySelector('#nom');
 	let price = document.querySelector('#prix');
 	let type = document.querySelector('#type');
 	json.push({'nom':name.value,'prix':price.value,'type':type.value});
 }


function createTableau(tri) {
	
	let tab=document.createElement('table');
	tab.id='course';
	let head=document.createElement('thead');
	let hTr=document.createElement('tr');
	let hTh=document.createElement('th');
	hTh.colspan="2";
	hTh.innerHTML="Ma liste de course";
	hTr.append(hTh);
	head.append(hTr);
	tab.append(head);
	let body=document.createElement('tbody');
	for (let key in json) {
		if (json.hasOwnProperty(key)&&tri.includes(json[key].type)) {
		let lig = document.createElement('tr');
		let col = document.createElement('td');
		let col1 = document.createElement('td');
		col.innerHTML=json[key].nom;
		col1.innerHTML=json[key].prix+'$';
		lig.append(col);
		lig.append(col1);
		body.append(lig);
		}
	}
	tab.append(body);
	document.querySelector('#div').append(tab);
}

/*




*/
