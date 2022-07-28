



console.debug('debug');
console.log('log');
console.warn('warn');
console.error('error');

var shapes=['carre','cercle','parallelo','rectangle','trapeze','triangle'];
var images=['carre','cercle','parallelo','ractangle','trapeze','triangle'];


	
	
function getForme(){
	let forme=document.querySelector('#forme').value;
	document.getElementById("titre").innerHTML = 'Aire de '+shapes[forme];
	document.getElementById("image").innerHTML = '<img src=imageExeAir/'+shapes[forme]+'.gif>'
	console.log(shapes[forme]);
	
	
}