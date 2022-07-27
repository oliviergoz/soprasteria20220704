/**
 * 
 */
let variable=10;
console.debug('debug');
console.log('log');
console.warn('warn');
console.error('error');
let deuxFoisDeux = function() {
	return 2 * 2;
}

console.log(deuxFoisDeux());
console.log(deuxFoisDeux);

function foisDeux(arg, afficher) {
	afficher(arg * 2);
}
foisDeux(8,console.log);

foisDeux(3, function(arg) {
	console.log('texte'+arg);
});

foisDeux(2,(arg)=>{
	console.log(`la meme avec une lambda ${arg}`);
});

console.log(2=='2');
console.log(2==='2');

function monClick(){
	let input=document.querySelector('#input');
	//console.log(document.querySelector('#input').value);
	//console.log(variable);
	input.value=variable;
}