
const random = Math.floor(Math.random() * 100) + 1;
tries = 10;
console.log(random);
document.getElementById('tries').innerHTML = 'Essais Restant : '+tries+''



function guessNumber(){

	tries --;
    guess = document.getElementById('guess')
    result = document.getElementById('result')
    secret = document.getElementById('secret')
    if(guess.value == random){
    	result.innerHTML = 'VOUS AVEZ GAGNE'
    	document.getElementById('bguess').setAttribute("hidden","");
    	document.getElementById('replay').removeAttribute("hidden","");
    }
    if(tries == 0){
    	result.innerHTML = 'VOUS AVEZ PERDU'
    	secret.value = 'Le nombre secret etait : '+random+'';
    	document.getElementById('bguess').setAttribute("hidden","");
    	document.getElementById('replay').removeAttribute("hidden","");
    }

    else{
    	document.getElementById('tries').innerHTML = 'Essais Restant : '+tries+''
    }

}
