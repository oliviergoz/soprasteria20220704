package formation.sopra.formationSpringBoot.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "produit")
@SequenceGenerator(name = "seqProduit", sequenceName = "seq_produit", initialValue = 100, allocationSize = 1)
@NamedQueries({
		@NamedQuery(name = "Produit.findByFournisseur", query = "select p from Produit p where p.fournisseur=:fournisseur") })
public class Produit {
	@JsonView({ JsonViews.Base.class })
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	@Column(name = "produit_id")
	private Long id;
	@JsonView(JsonViews.Base.class)
	@Column(name = "produit_libelle", length = 150)
	@NotEmpty(message = "mon message empty")
	private String libelle;
	@JsonView({ JsonViews.Base.class })
	@Column(name = "produit_description", columnDefinition = "TEXT")
	private String description;
	@JsonView(JsonViews.Base.class)
	@Column(name = "produit_pu")
	@DecimalMin(value = "0.1")
	private double prixUnitaire;
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	@ManyToOne
	@JoinColumn(name = "produit_id_fournisseur", foreignKey = @ForeignKey(name = "produit_produit_id_fournisseur_fk"))
	private Fournisseur fournisseur;
	@OneToMany(mappedBy = "id.produit")
	private Set<LigneCommande> lignes;
	@Version
	private int version;

	public Produit() {

	}

	public Produit(String libelle, String description, double prixUnitaire, Fournisseur fournisseur) {
		this.libelle = libelle;
		this.description = description;
		this.prixUnitaire = prixUnitaire;
		this.fournisseur = fournisseur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Set<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(Set<LigneCommande> lignes) {
		this.lignes = lignes;
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
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}

}
