
const random = Math.floor(Math.random() * 100) + 1;
tries = 10;
console.log(random);
document.getElementById('tries').innerHTML = 'Essais Restant : '+tries+''



function guessNumber(){

	tries --;
    guess = document.getElementById('guess').value;
    result = document.getElementById('result').value;
    secret = document.getElementById('secret').value;
    if(guess == random){
    	result = document.getElementById('result').innerHTML = 'VOUS AVEZ GAGNE'
    	document.getElementById('bguess').setAttribute("hidden","");
    	document.getElementById('replay').removeAttribute("hidden","");
    }
    if(tries == 0){
    	document.getElementById('result').innerHTML = 'VOUS AVEZ PERDU'
    	document.getElementById('secret').value = 'Le nombre secret etait : '+random+'';
    	document.getElementById('bguess').setAttribute("hidden","");
    	document.getElementById('replay').removeAttribute("hidden","");
    }

    else{
    	document.getElementById('tries').innerHTML = 'Essais Restant : '+tries+''
    }

}
