package formationJpa.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
@SequenceGenerator(name = "seqFormation", sequenceName = "seq_formation", allocationSize = 1, initialValue = 100)
@NamedQueries({ @NamedQuery(name = "Formation.findAll", query = "select f from Formation f"),
		@NamedQuery(name = "Formation.setReferentToNull", query = "update Formation f set f.referent=null where f.referent=:referent"),
		@NamedQuery(name = "Formation.deleteByReferent", query = "delete from Formation f where f.referent=:referent") })
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormation")
	private Long id;
	// @Column(name="nom",columnDefinition = "text")
	@Column(name = "nom")
	// @Lob
	private String nom;
	@Column(name = "date_formation")
	private LocalDate date;
	// @OneToOne @OneToOne
	// @ManyToOne @OneToMany
	// @ManyToMany @ManyToMany
	@ManyToOne
	@JoinColumn(name = "referent_id", foreignKey = @ForeignKey(name = "formation_referent_id_fk"))
	private Formateur referent;
	@ManyToOne
	@JoinColumn(name = "salle_id", foreignKey = @ForeignKey(name = "formation_salle_id_fk"))
	private Salle salle;
	@OneToMany(mappedBy = "id.formation")
	private Set<ModuleFormation> modulesformation;

	public Formation() {

	}

	public Formation(String nom, LocalDate date) {
		this.nom = nom;
		this.date = date;
	}

	public Formation(String nom) {
		this(nom, LocalDate.now());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Set<ModuleFormation> getModulesformation() {
		return modulesformation;
	}

	public void setModulesformation(Set<ModuleFormation> modulesformation) {
		this.modulesformation = modulesformation;
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
		Formation other = (Formation) obj;
		return Objects.equals(id, other.id);
	}

}
