
console.debug('debug');
console.log('log');
console.warn('warn');
console.error('error');


var images=['carre.gif','img1.jpg','cercle.gif','parallelo.gif','img1.png','rectangle.gif','img2.png','trapeze.gif','img3.png','triangle.gif'];
let n=-1;


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
	clearTimeout(a);
	timer();
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'
	
}
function endImage(){
	n=images.length-1;
	clearTimeout(a);
	timer();
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'

}
function lastImage(){
	clearTimeout(a);
	timer();
	if(n<=1){
		n=0;
	}
	else{
		n-=1;;
	}
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'

}
function nextImage(){
	clearTimeout(a);
	timer();
	if(n==images.length-1){
		n=0;
	}
	else{
		n+=1;;
	}
	document.getElementById("image").innerHTML = '<img height="400PX" src=img/'+images[n]+'>'

}