// Creation des variables

var lettre = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"];
var Btn = new Array();
var dico = new Array('provider','modem','adsl','connexion','transfert','adresse-ip','serveur de nom','nom de domaine','vercingetorix','napoleon','charlemagne','charles de gaulle','francois miterrand','terminator','shrek','nikita','titanic','le grand bleu','final fantasy','la grande evasion');
var lettre_deja_propose = new Array();

var mot = "";
var trouve = 0;
var existe = 0;
var fautes = 0;


function creationBtn(){
	for(var l=0; l<lettre.length; l++){
		Btn[l] = document.createElement('input');
		Btn[l].id = lettre[l];
		Btn[l].type = "button";
		Btn[l].value = lettre[l];
		Btn[l].className = "lettre_valid";
		Btn[l].onclick = propose;
		document.getElementById('navigation').appendChild(Btn[l]);
	}
	document.getElementById('lieu').appendChild(document.createElement('br'));
	select_mot();
}



// Selection alleatoire du mot dans le domaine et preparation de l'affichage des images (_)
function select_mot() {
	//var possibilites = dico.length;
	//var index = Math.floor(Math.random()*possibilites);

	mot = dico[Math.floor(Math.random()*dico.length)];

	
	var lettre_cache = new Array();
	for(var i=0; i<mot.length; i++){// Pour chaque lettre du mot
		lettre_cache[i] = document.createElement('input');
		lettre_cache[i].name = 'lettre_cache'+i;
		lettre_cache[i].className = 'lettre_cache';
		lettre_cache[i].id = 'lettre_cache'+i;
		lettre_cache[i].type = 'text';
		lettre_cache[i].readOnly= 'readOnly';
		
		document.getElementById('lieu').appendChild(lettre_cache[i]);
		
		/*
		// Si on rencontre un espace (" ") on affiche un espace
		if ( mot.substr(i,1) == " " ) {
			lettre_cache[i].value = "__";
			trouve++; // On marque l'espace comme deja trouve
			
		}else if ( mot.substr(i,1) == "-" ) {
			lettre_cache[i].value = "-";
			trouve++;// On marque l'espace comme deja trouve
			
		}*/
		
		// Si on rencontre un espace (" ") on affiche un espace
		if ( mot[i] == " " ) {
			lettre_cache[i].value = "__";
			trouve++; // On marque l'espace comme deja trouve
			
		}else if ( mot[i] == "-" ) {
			lettre_cache[i].value = "-";
			trouve++;// On marque l'espace comme deja trouve
			
		}

		
	}
	//affiche_mot_cache();// Lancement de l'affichage des images
	
}



// Controle de la lettre proposee (bon deroulement du jeu)
function propose(event) {
	var source = null;
	var lettre_propose = null;
	
	if(window.event){
		source = window.event.target;
	}else{
		source = event.target;
	}
	
	lettre_propose = source.value;
	
	
	// Test si la lettre a deja ete proposee
	for (var L=0; L<lettre_deja_propose.length; L++ ) {
		if ( lettre_propose == lettre_deja_propose[L] ) {
			alert('Vous avez deja propose cette lettre !');
			return;
		}
	}
	// Sinon modification de la lettre et lancement du test par rapport au mot caché
	change_style_lettre(lettre_propose);
	verif_lettre(lettre_propose);
	
}
	
	
	
	
// Changement des lettres bleues en rouge et enregistrement de la lettre proposee
function change_style_lettre(lettre_propose) {
	document.getElementById(lettre_propose).className =  'lettre_invalid';
	lettre_deja_propose[lettre_deja_propose.length] = lettre_propose;
}
	
	
	
	
	
// Verification de la lettre par rapport au mot cache
function verif_lettre(lettre_propose) {
	existe = 0; //initialisation de existe
	
	// Par rapport a chaque lettre du mot
	for ( i = 0; i < mot.length; i++ ) {
		// Si la lettre proposee existe dans le mot
		if ( lettre_propose == mot[i]/*.substr(i,1)*/ ) {
			document.getElementById('lettre_cache'+i).value = lettre_propose ;
			document.getElementById('lettre_cache'+i).className = "lettre_Touver";
			trouve++;
			existe = 1;
		}
	}

	// Si toutes les lettres ont ete trouvees (gagne)
	if ( trouve == mot.length) {
		alert('Bravo, vous avez trouve avant d\'etre pendu !!\nPour rejouer, cliquez sur le bouton \'Rejouer\'');
	}

	// Si la lettre proposee n'existe pas dans le mot, affichage du pendu
	if ( existe == 0 ) {
		eval("document.p" + fautes).src = "images/pend_"+fautes+".gif";
		fautes++;
	}

	// Si le pendu est complet (perdu)
	if ( fautes == 11 ) {
		alert('Perdu !\nLe mot a trouver etait : ' + mot + '\nPour rejouer, cliquez sur le bouton \'Rejouer\'');
	}
}