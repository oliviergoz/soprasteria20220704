/**
 * 
 */
 
				var motSecret;
				
				var now=new Date();			
				var tableauMot=new Array();	 
				var mots=new Array();		 
				
				var tailleMot;				 
				var coupsManques=0;			 
				var lettresTrouvees=0;		 
				var fini=false;				 
				
				mots[0]="NOUHAILA";
				mots[1]="MONSIEUR";
				mots[2]="POMPIER";
				mots[3]="ORACLE";
				mots[4]="PLACARD";
				mots[5]="RADIATEUR";
				mots[6]="DEODORANT";
				mots[7]="CAMION";
				mots[8]="HORLOGE";
				mots[9]="MARGUERITE";
				mots[10]="ELEPHANT";
				mots[11]="IGLOO";
				mots[12]="NAVIRE";
				
		
				motSecret=mots[now.getSeconds() % mots.length];
				tailleMot=motSecret.length;
				
				
				function changeCouleur(element,couleur){
					element.style.backgroundColor=couleur;
				}
				
				
				function proposer(element){
					if(element.style.backgroundColor=="pink" ||fini) return;
					
					 
					var lettre=element.innerHTML;
					changeCouleur(element,"pink");
					
					
					var trouve=false;
					
					 
					for(var i=0; i<tailleMot; i++) {
						
						
						if(tableauMot[i].innerHTML==lettre) {
							tableauMot[i].style.visibility='visible';	
							trouve=true;
							lettresTrouvees++;
						}
						
					}
					
					if(!trouve){
						coupsManques++;
						document.img_pendu[pend].src="img_pendu/pend_"+coupsManques+".gif"; 
						
						if(coupsManques==3){
							alert("Vous avez perdu !");
							for(var i=0; i<tailleMot; i++) tableauMot[i].style.visibility='visible';
							fini=true;
							
						}
					}
					if(lettresTrouvees==tailleMot){
						alert("Bravo ! Vous avez decouvert le mot secret !");
						fini=true;
					}
				}