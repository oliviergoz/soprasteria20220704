package formationJpaSpring.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_student", allocationSize = 1, initialValue = 100)
//@DiscriminatorValue("S")
public class Stagiaire extends Personne {
	private String entreprise;
	@OneToOne
	@JoinColumn(name = "pc_id")
	private Ordinateur ordinateurPret;

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public Ordinateur getOrdinateurPret() {
		return ordinateurPret;
	}

	public void setOrdinateurPret(Ordinateur ordinateur) {
		this.ordinateurPret = ordinateur;
	}

}
