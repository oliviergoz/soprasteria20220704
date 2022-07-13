package formationJpa.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_student", allocationSize = 1, initialValue = 100)
//@DiscriminatorValue("S")
public class Stagiaire extends Personne {
	private String entreprise;

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

}
