package eshop.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "fournisseur")
@SequenceGenerator(sequenceName = "seq_fournisseur", name = "seqFournisseur", initialValue = 1, allocationSize = 100)
public class Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFournisseur")
	@Column(name = "fournisseur_id")
	private Long id;
	@Column(name = "fournisseur_nom")
	private String nom;
	@AttributeOverrides({
			@AttributeOverride(name = "prenom", column = @Column(name = "fournisseur_contact_prenom", length = 255)),
			@AttributeOverride(name = "nom", column = @Column(name = "fournisseur_contact_nom", length = 255)),
			@AttributeOverride(name = "mail", column = @Column(name = "fournisseur_contact_mail", length = 255)) })
	@Embedded
	private Contact contact;
	@AttributeOverrides({
			@AttributeOverride(name = "numero", column = @Column(name = "fournisseur_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "fournisseur_rue", length = 255)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "fournisseur_cp", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "fournisseur_ville", length = 255)) })
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> produits;

	public Fournisseur() {

	}

	public Fournisseur(String nom, Contact contact, Adresse adresse) {
		this.nom = nom;
		this.contact = contact;
		this.adresse = adresse;
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
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
		Fournisseur other = (Fournisseur) obj;
		return Objects.equals(id, other.id);
	}

}
