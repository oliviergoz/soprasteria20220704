package eshop.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LigneCommandeKey implements Serializable{
	@ManyToOne
	@JoinColumn(name="ligne_commande_commande_id",foreignKey = @ForeignKey(name="ligne_commande_ligne_commande_commande_id_fk"))
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="ligne_commande_produit_id",foreignKey = @ForeignKey(name="ligne_commande_ligne_commande_produit_id_fk"))
	private Produit produit;
	
	public LigneCommandeKey() {
		
	}

	public LigneCommandeKey(Commande commande, Produit produit) {
		this.commande = commande;
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commande, produit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCommandeKey other = (LigneCommandeKey) obj;
		return Objects.equals(commande, other.commande) && Objects.equals(produit, other.produit);
	}
	
	
}
