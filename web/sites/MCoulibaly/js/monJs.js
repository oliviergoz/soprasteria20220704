/**
 * 
 */
let nbjuste = Math.floor(Math.random() * 10)+1;

var essai = 1;



function f() {
	let input= document.querySelector('#input').value;
	if(essai<2){
		if (input < nbjuste) {
			alert("Plus")
			essai++;
		}
	if (input > nbjuste) {
		alert("Moins");
		essai++;
	}
	if (input == nbjuste) { 
	alert("Bravo , le nombre était " + nbjuste + " Tu as gagné en " + essai + " essai");
	}
	}
	else {
		alert("Tu as n'as plus d'essai, le nombre exacte est " + nbjuste)
	}
	
}
