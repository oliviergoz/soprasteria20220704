/**
 * 
 */

let numeroimages= 0;
let tabimages=['forma.png','antman.png','julian.png','moch.png','gromoch.png']
let interval; 

function afficher(){
	document.querySelector('#diapodemoch').src=`imagediapo/${tabimages[numeroimages]}`;
}

function debutImage(){
	numeroimages=0;
	afficher();	
    }
    
function play(){
	interval= setInterval(() => {nextImage();}, 600)
}
function pause() {
	clearInterval(interval);
}

function nextImage(){
	if(numeroimages<tabimages.length-1){numeroimages++;
	}else{
	numeroimages=0;
	}
	afficher();
	}

function backImage(){
	if(numeroimages>0){numeroimages=numeroimages-1;
	}else{
	numeroimages=tabimages.length-1;
	}
	afficher();	
	}


function endImage(){	
	numeroimages=tabimages.length-1;
	
	afficher();	
	}
