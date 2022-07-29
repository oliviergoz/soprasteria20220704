console.debug('debug');
console.log('log');
console.warn('warn');
console.error('error');


var alphabet= ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
var mots=['chaussures','pendu','chat','bureau','formation','cahier','manger','ordinateur']
var m=Math.floor(Math.random()*mots.length);
let n=alphabet.length;
lettres();
lettresAffichage();
var index='a';


function rejouer(){
	
}

function lettresAffichage(){
	let div=document.createElement('div');
	div.id='maDiv2';
	let i=0;
	for( i=0;i<mots[m].length;i++){
		let input=document.createElement('input');
		input.type="button";
		input.disabled;		
		input.id='a'+i;
		input.value='';
		div.append(input);
	}
	
	document.querySelector('#div').append(div);
}

function lettres() {
	let div=document.createElement('div');
	div.id='maDiv';
	let i=0;
	for( i=0;i<n;i++){
		let input=document.createElement('input');
		input.type="button";
		input.style="width:35px; height:35px; border: dashed 2px black;";
		//input.style="height:60px";
		input.id=alphabet[i];
		input.value=alphabet[i];		
		input.addEventListener('click', (event) => {
		console.log(event.target.id);
		index=event.target.id
		});		
		input.onclick=ajouterLettre;
		div.append(input);
	}
	
	
	document.querySelector('#div').append(div);

}

function ajouterLettre(){
	let exist=false;
	for( i=0;i<mots[m].length;i++){
		if(index==mots[m].charAt(i)){
			document.getElementById("a"+i).value=index;
			console.log(index+'--> une lettre trouvée');
			document.getElementById('a'+i).style.backgroundColor="yellow";
			document.getElementById(index).style.backgroundColor="green";
			exist=true;
		}
	}
	if( !exist){document.getElementById(index).style.backgroundColor="red";}
	
}

