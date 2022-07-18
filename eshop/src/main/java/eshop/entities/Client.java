package eshop.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 100, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "prenom", column = @Column(name = "client_prenom", length = 255)),
		@AttributeOverride(name = "nom", column = @Column(name = "client_nom", length = 255)),
		@AttributeOverride(name = "mail", column = @Column(name = "client_mail", length = 255)) })

@NamedQueries({
		@NamedQuery(name = "Client.findByKeyWithCommandes", query = "select c from Client c left join fetch c.commandes where c.id=:id"),
		@NamedQuery(name = "Client.findByIdWithCommandesDetails", query = "select c from Client c left join fetch c.commandes as commande left join fetch commande.lignes where c.id=:id"),
		@NamedQuery(name = "Client.findByNomContaining", query = "select c from Client c where c.nom like :texte "),
		@NamedQuery(name = "Client.findByNomContainingWithCommandes", query = "select c from Client c left join fetch c.commandes where c.nom like :texte ") })
public class Client extends Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "client_id")
	private Long id;
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "client_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "client_rue", length = 255)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "client_cp", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "client_ville", length = 255)) })
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;

	public Client() {

	}

	public Client(String prenom, String nom, String mail, Adresse adresse) {
		super(prenom, nom, mail);
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

}
