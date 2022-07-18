package eshop.dao;

import java.util.List;

import eshop.entities.Fournisseur;
import eshop.entities.Produit;

public interface DaoProduit extends DaoGeneric<Produit, Long> {
	public List<Produit> findByFournisseur(Fournisseur fournisseur);

}
