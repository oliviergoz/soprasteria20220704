/**
 * 
 */

console.log(setChoice());
console.log('machin');
let random = Math.floor(Math.random() * 101);
let attempt_rest_value = 10;
let hint;

function attempt() {
	let choice = document.querySelector('#choice');
	let result_test = document.querySelector('#result_test');
	
	if (attempt_rest_value > 0){
		if (input.value < nombre){
			hint='Trop petit';
		}
		else if (input.value > nombre){
			hint='Trop grand';
		} else {
			hint='Bravo';
		}
	} else {
		hint='Perdu';
	}
	result_test = hint;
	attempt_rest_value --;
}
