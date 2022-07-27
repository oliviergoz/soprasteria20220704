/**
 * 
 */
 

let sec = 0;
let min = 0;
let hrs = 0;
let t;

function chron(){
    sec++;
    if (sec >= 60) {
        sec = 0;
        min++;
        if (min >= 60) {
            min = 0;
            hrs++;
        }
    }
}
function add() {
    chron();
    document.getElementById("timing").innerHTML = (hrs > 9 ? hrs : "0" + hrs) 
        	 + ":" + (min > 9 ? min : "0" + min)
       		 + ":" + (sec > 9 ? sec : "0" + sec);
    timer();
}
function timer() {
    t = setTimeout(add, 1000);
}

function Play(){
	timer();
}
function Stop(){
	clearTimeout(t);
}
function Reset(){
	document.getElementById("timing").innerHTML="00:00:00";
	sec=0; min=0; hrs=0;
}