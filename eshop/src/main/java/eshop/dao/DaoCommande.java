package eshop.dao;

import eshop.entities.Commande;

public interface DaoCommande extends DaoGeneric<Commande, Long> {
	public Commande findByIdWithLignes(Long key);
}