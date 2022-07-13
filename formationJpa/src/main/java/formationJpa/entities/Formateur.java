package formationJpa.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_trainer", allocationSize = 1, initialValue = 100)
//@DiscriminatorValue("T")
public class Formateur extends Personne {
	private Integer experience;

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

}
