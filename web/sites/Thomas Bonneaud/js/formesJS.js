/**
 * 
 */

const images_sources = ['ressources/carre.gif', 'ressources/rectangle.gif', 'ressources/cercle.gif'];


function change() {
	let index = document.querySelector('#shape').value;
	document.querySelector('#images').src=images_sources[index];
}
