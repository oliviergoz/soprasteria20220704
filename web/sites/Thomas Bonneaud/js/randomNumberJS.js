/**
 * 
 */

console.log('machin');
let random = Math.floor(Math.random() * 101);
let attempt_rest_value = 10;
let hint;

function attempt() {
	let choice = document.querySelector('#choice');
	let result_test = document.querySelector('#result_test');
	
	if (attempt_rest_value > 0){
		if (choice.value < random){
			hint='Trop petit';
		}
		else if (choice.value > random){
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
