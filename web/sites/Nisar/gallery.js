img = document.getElementById('img');

const imageArray = ['carre.gif','cercle.gif','parallelo.gif','rectangle.gif','trapeze.gif','triangle.gif'];

index = 0;
paused=true;

function bLeft(){
	if(index-1 < 0){
		index = imageArray.length -1;
	}else{index--}
	
	img.setAttribute('src',''+imageArray[index]+'')
}

function bRight(){
	if(index+1 >= imageArray.length){
		index = 0;
	}else{index++}
	img.setAttribute('src',''+imageArray[index]+'')
}

function bFirst(){
	index=0;
	img.setAttribute('src',''+imageArray[index]+'')
}
function bLast(){
	index= imageArray.length -1 ;
	img.setAttribute('src',''+imageArray[index]+'')
}

function bAuto(){
	if(paused== false){
		paused = true;
		document.getElementById('auto').innerHTML= 'Auto Slide'
	}else{
		paused = false;
	}
	
	document.getElementById('auto').innerHTML= 'Stop'
}


myInterval = setInterval(function(){
	if(!paused){
		bRight();
	}
}, 1000);