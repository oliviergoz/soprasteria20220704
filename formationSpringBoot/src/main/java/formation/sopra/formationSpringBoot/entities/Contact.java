package formation.sopra.formationSpringBoot.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Contact extends Personne {

	public Contact() {
	}

	public Contact(String prenom, String nom, String mail) {
		super(prenom, nom, mail);
	}

}
