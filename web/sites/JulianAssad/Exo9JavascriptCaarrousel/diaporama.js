/**
 * 
 */
//querySelector puede llamar por .clase, #id o '[name="box1"]' y tag <div>,<p>,<h1>,etc
// si se usan variables, usar `${miVariable}`


console.log('Salut :p');

let imageTab=['ensenada.jpg','bladerunner.jpg','totoro.jpeg','Picture1.png','triangle.gif','zoom.png'];
let imageNumber = 0;


function photoSource(){

	document.querySelector('#diaporamax').src=`images/${imageTab[imageNumber]}`;
}

function next(){
	
	if(imageNumber<imageTab.length-1){
	imageNumber++;
	}else{
	imageNumber=0;
	}
	photoSource();
	//document.querySelector('#diaporamax').style.width='500px';
	//document.querySelector('#diaporamax').style.height='500px';
}

function back(){
	
	if(imageNumber>0){
	imageNumber--;
	}else{
	imageNumber=imageTab.length-1;
	}
	photoSource();	
}

function last(){
	
	imageNumber=imageTab.length-1;
	photoSource();	
}

function first(){
	
	imageNumber=0;
	photoSource();	
}

