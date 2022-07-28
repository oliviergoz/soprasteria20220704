/**
 * 
 */


let spa = document.getElementsByTagName("span");
let start = document.getElementById('start');
let stop = document.getElementById('stop');
let reset = document.getElementById('reset');
let ms  = 0;
let sec = 0;
let min = 0;
let hrs = 0;
let t;

  function clickstart(){
   t =setInterval(update,10);
   start.disabled=true;
}
 function update(){
    ms+=1;
       if(ms==100){ ms=1;sec+=1;}
       if(sec==60){sec=0;min+=1; }
       if(min==60){min=0;hrs+=1;}
       spa[0].innerHTML=hrs+" hrs";
       spa[1].innerHTML=min+" min";
       spa[2].innerHTML=sec+" sec";
       spa[3].innerHTML=ms+" ms";
  }

function clickstop(){
    clearInterval(t);
    start.disabled=false;
    }
    
function clickreset(){
   clearInterval(t);
    start.disabled=false;
    ms=0,s=0,mn=0,h=0;
    spa[0].innerHTML=hrs+" hrs";
    spa[1].innerHTML=min+" min";
    spa[2].innerHTML=sec+" sec";
    spa[3].innerHTML=ms+" ms";
    }

    
