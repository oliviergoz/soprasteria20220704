
let val=Math.floor(Math.random()*100+1);
var essais=10;
var message='y a quoi la';

console.debug('debug');
console.log('log');
console.warn('warn');
console.error('error');


function monClick(){
	let input=document.querySelector('#input');
	let input2 = document.querySelector('#input2');
	let input3 = document.querySelector('#input3');
	essais-=1;
	if(essais==0){
		message=' c\'est perdu! La bonne réponse était : '+val
	}
	else if(input.value==val){
		message='bonne réponse';
	}
	else if(input.value>val){
		message='trop grand ! il vous reste '+essais+' tentatives';
	}
	else{
		message='trop petit ! il vous reste '+essais+' tentatives';
	}
	
	input2.value=message;
	input3.value='le dernier nombre essayé : '+input.value;
	
	
}