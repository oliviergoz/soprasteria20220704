
 
function changeForme(){
	let forme=document.querySelector('#select').value;
	document.querySelector('#image').src=`image/${forme}.gif`;	
	document.querySelector('#titre').innerHTML=`Aire du ${forme}`
	
}



function calcul() {
	let input = document.querySelector('#nombre');
	let forme=document.querySelector('#select').value;
	
	if (forme == "carre") { 
	document.querySelector('#Calcul1').innerHTML='c:'
	document.querySelector('#Calcul2').innerHTML=' '
	}
	
	
	if (forme == "cercle") { 
	document.querySelector('#Calcul1').innerHTML='r:'
	document.querySelector('#Calcul2').innerHTML=' '
	}

}
