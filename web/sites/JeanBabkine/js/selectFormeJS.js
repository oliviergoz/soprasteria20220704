
 
function change(){
	
	document.querySelector('#image').src=`image/${forme}.gif`;	
	document.querySelector('#titre').innerHTML=`Aire du ${forme}`
	
}



function calcul() {
	let input = document.querySelector('#calcul1');
	let forme=document.querySelector('#select').value;
	
	if (forme == "carre") { 
		let x = input*input
		alert(`Aire : ${x}`)
	}
	
	
	if (forme == "cercle") { 
		let x = 3.14*input*input
		alert(`Aire : ${x}`)
	}

}
