



console.debug('debug');
console.log('log');
console.warn('warn');
console.error('error');

var seconds=0;
var minutes=0;
var sec=0;
var min=0;
let a=0;
	

function time(){
	if(seconds==59){
		seconds=0;
		minutes+=1
	}
	else{
		seconds+=1;
	}
	if(seconds<10){
		sec='0'+seconds;
	}
	else{
		sec=seconds;
	}
	if(minutes<10){
		min='0'+minutes;
	}
	else{
		min=minutes;
	}
	
	
	timer();
	document.getElementById("titre").innerHTML = min+':'+sec;
}
function timer() {
    a = setTimeout(time, 1000);
}
function monPlay(){
	clearTimeout(a);
	timer();

}
function monPause(){
	clearTimeout(a);
	
}
function monReset(){
	clearTimeout(a);
	seconds=0;
	minutes=0;
	document.getElementById("titre").innerHTML = '00:00';
	
}