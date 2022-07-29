timer = document.getElementById('timer')
play = document.getElementById('play')
pause = document.getElementById('pause')
reset = document.getElementById('reset')

min = 0;
sec = 0;
paused = true;

myInterval = setInterval(function(){
	if(!paused){
		if(sec==60){
			min++
			sec=0
		}
		sec++
		if(sec<10){
			if(min<10){
				timer.innerHTML ='0'+min+':'+'0'+sec
			}
			else if(min>=10){
				timer.innerHTML = min+':'+'0'+sec
			}
		}else if (min<10){
			if(sec<10)
				timer.innerHTML ='0'+min+':'+'0'+sec
			else if(sec>=10){
				timer.innerHTML ='0'+min+':'+sec
			}
		}else{
			timer.innerHTML =min+':'+sec
		}
	}
}, 1000);


function bPlay(){

	paused = false;
	play.setAttribute('disabled','');

}
function bPause(){
	paused = true
	play.removeAttribute('disabled','');
}
function bReset(){
	bPause();
	sec=0;
	min=0;
	timer.innerHTML ='00:00'

}