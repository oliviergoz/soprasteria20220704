package formationJpaSpring.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "module_formation")
public class ModuleFormation {
	@EmbeddedId
	private ModuleFormationKey id;
	@ManyToOne
	@JoinColumn(name = "formateur_id", foreignKey = @ForeignKey(name = "module_formation_formateur_id_fk"))
	private Formateur formateur;
	@Column(name = "debut")
	private LocalDate dateDebut;
	@Column(name = "fin")
	private LocalDate dateFin;

	public ModuleFormation() {

	}

	public ModuleFormation(ModuleFormationKey id, Formateur formateur, LocalDate dateDebut, LocalDate dateFin) {
		this.id = id;
		this.formateur = formateur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public ModuleFormationKey getId() {
		return id;
	}

	public void setId(ModuleFormationKey id) {
		this.id = id;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleFormation other = (ModuleFormation) obj;
		return Objects.equals(id, other.id);
	}

}
