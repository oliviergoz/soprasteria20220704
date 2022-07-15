package formationJpa.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "salle")
@SequenceGenerator(name = "seqSalle", sequenceName = "seq_salle", initialValue = 100, allocationSize = 1)
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSalle")
	private Long id;
	@Column(name = "nom", length = 150)
	private String nom;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "salle_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "salle_rue", length = 255)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "salle_cp", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "salle_ville", length = 255)) })
	private Adresse adresse;
	private int capacite;
	@OneToOne
	@JoinColumn(name = "video_id", foreignKey = @ForeignKey(name = "salle_video_id_fk"))
	private Videoprojecteur videoprojecteur;
	@OneToMany(mappedBy = "salle")
	private List<Formation> formations;

	public Salle() {

	}

	public Salle(String nom, Adresse adresse, int capacite, Videoprojecteur videoprojecteur) {
		this.nom = nom;
		this.adresse = adresse;
		this.capacite = capacite;
		this.videoprojecteur = videoprojecteur;
	}

	public Salle(String nom, Adresse adresse, int capacite) {
		this.nom = nom;
		this.adresse = adresse;
		this.capacite = capacite;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Videoprojecteur getVideoprojecteur() {
		return videoprojecteur;
	}

	public void setVideoprojecteur(Videoprojecteur videoprojecteur) {
		this.videoprojecteur = videoprojecteur;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
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
		Salle other = (Salle) obj;
		return Objects.equals(id, other.id);
	}

}
