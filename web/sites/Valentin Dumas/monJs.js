/**
 * 
 */
 
 let deuxFoisDeux=function(){
	return 2*2
}

console.log(deuxFoisDeux());
const random=Math.round(Math.random()*100);
console.log(random);
	let essais= 15;
    texter=null;
function monclick(){
	console.log(random);
	let input  = document.querySelector('#input');
    let input2 = document.querySelector('#input2');
    let input3 = document.querySelector('#input3');
	if (input.value > random) {texter = 'Plut petit gro nul';} else { 
		texter = 'plus ariana grande'; 
	}	
		while (essais>0) {
		input2.value = (input.value == random) ? 'uwin' : texter ;	
		essais = essais - 1;
		input3.value = essais + ' essais restants';
		break;
	}
	    if (essais == 0) {
		input2.value = ' uloose cétait : ' + random;

	}


}



