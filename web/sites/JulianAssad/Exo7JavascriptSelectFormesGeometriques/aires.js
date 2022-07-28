/**
 * 
 */
let myTab = ['carrex', 'rectanglex', 'trapezex', 'trianglex', 'parallelogramex', 'cerclex'];
let index;

function monClickGeometrique() {
	let input = document.querySelector('#forme');
	x = input.value + '.gif'; //document.querySelector('#forme').value + '.gif'
	document.querySelector('#image').src = 'images/' + x;

	console.log(input.value)

	switch (input.value) {
		case 'carre':
			index = 0;
			break;
			
		case 'rectangle':
			index = 1;
			break;
			
		case 'trapeze':
			index = 2;
			break;
			
		case 'triangle':
			index = 3;
			break;
			
		case 'parallelo':
			index = 4;
			break;
			
		case 'cercle':
			index = 5;
			break;
			
		default:
			index = 0;
			break;
	}

	document.querySelector('#titulo').innerHTML = `Aire du ${myTab[index]}`

}