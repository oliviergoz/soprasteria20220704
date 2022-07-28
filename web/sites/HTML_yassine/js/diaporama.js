
console.debug('debug');
console.log('log');
console.warn('warn');
console.error('error');


var images=['carre.gif','img1.jpg','cercle.gif','parallelo.gif','img1.png','rectangle.gif','img2.png','trapeze.gif','img3.png','triangle.gif'];
let n=0;


display();

function display(){
	if(n==images.length-1){
		n=0;
	}
	else{
		n+=1;;
	}
	timer();
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'
}
function timer() {
    a = setTimeout(display, 3000);
}


function firstImage(){
	n=0;
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'
	
}
function endImage(){
	n=images.length-1;
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'

}
function lastImage(){
	if(n==0){
		n=0;
	}
	else{
		n+=1;;
	}
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'

}
function nextImage(){
	if(n==images.length-1){
		n=0;
	}
	else{
		n+=1;;
	}
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'

}