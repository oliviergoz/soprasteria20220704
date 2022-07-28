

let json = [
	{'nom':'café','prix':1},
	{'nom':'PQ','prix':2},
	{'nom':'3monts','prix':2.5}];




 


function createTableau() {
	
	let tab=document.createElement('table');
	tab.id='course';
	let head=document.createElement('thead');
	head.innerHTML="Mes courses";
	tab.append(head);
	
	let body=document.createElement('tbody');
	
	
	
	for (let key in json) {
		if (json.hasOwnProperty(key)) {
		let lig = document.createElement('tr');
		let col = document.createElement('td');
		let col1 = document.createElement('td');
		col.innerHTML=json[key].nom;
		col1.innerHTML=json[key].prix;
		lig.append(col);
		lig.append(col1);
		body.append(lig);
		}
	}
	tab.append(body);
	document.querySelector('#div').append(tab);
}

/*


let =document.createElement('button');
	b1.innerHTML='bouton';
	b1.id='b1';
	b1.addEventListener('click',(event)=>{
		console.log(event);
	});




*/
