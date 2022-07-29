

let images=['carre.gif','cercle.gif','parallelogramme.gif','rectangle.gif','trapeze.gif','triangle.gif'];
let n=0;
let t;


function next(){
	if(n==images.length-1){
		n=0;
	}
	else{
		n+=1;
	}
	document.getElementById("image").src = 'image/'+images[n];
}

function last(){
	if(n==0){
		n=images.length-1;
	}
	else{
		n-=1;
	}
	document.getElementById("image").src = 'image/'+images[n];
}	
	
function first(){
	n=0;
	document.getElementById("image").src = 'image/'+images[n];
	
}
function end(){
	n=images.length-1;
	document.getElementById("image").src = 'image/'+images[n];

}

	
function play(){
	
	timer();
}	

function stop(){
	clearInterval(t);

}

function timer() {
	t = setInterval(next,1000);
	
	//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
	//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
}



