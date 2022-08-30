package formationSpringMvc.model;

import eshop.entities.Produit;

public class ElementPanierRestModel {
	private Produit produit;
	private Integer quantite;

	public ElementPanierRestModel() {

	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

}
