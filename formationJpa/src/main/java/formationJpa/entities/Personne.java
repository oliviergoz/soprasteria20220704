package formationJpa.entities;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

//@Entity
//@Table(name = "person")
//@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_person", allocationSize = 1, initialValue = 100)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 1)
@MappedSuperclass
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonne")
	private Long id;
	@Column(name = "first_name", nullable = false)
	private String prenom;
	@Column(name = "last_name")
	private String nom;
//	@Column(name="civility",length = 4)
//	@Enumerated(EnumType.STRING)
	@Column(name = "civility")
	@Enumerated(EnumType.ORDINAL)
	private Civilte civilite;
	// @Transient
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "person_number", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "person_street", length = 255)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "person_zip_code", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "person_city", length = 255)) })
	private Adresse adresse;
	@Version
	private int version;
	
	public Personne() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Civilte getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilte civilite) {
		this.civilite = civilite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id);
	}

}
