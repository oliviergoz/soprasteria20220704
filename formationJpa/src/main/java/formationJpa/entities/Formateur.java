package formationJpa.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_trainer", allocationSize = 1, initialValue = 100)
//@DiscriminatorValue("T")
public class Formateur extends Personne {
	private Integer experience;
	@OneToMany(mappedBy = "referent")
	private Set<Formation> formations;

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}
