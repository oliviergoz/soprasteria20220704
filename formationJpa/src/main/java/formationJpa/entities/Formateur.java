package formationJpa.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_trainer", allocationSize = 1, initialValue = 100)
//@DiscriminatorValue("T")
public class Formateur extends Personne {
	private Integer experience;
	@OneToMany(mappedBy = "referent")
	private Set<Formation> formations;
	@ManyToMany
	@JoinTable(
			name = "competences", 
			joinColumns = @JoinColumn(name = "formateur_id", foreignKey = @ForeignKey(name = "comptences_formateur_id_fk")), 
			inverseJoinColumns = @JoinColumn(name = "module_id", foreignKey = @ForeignKey(name = "comptences_module_id_fk")))
	private Set<Module> modules;

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

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

}
