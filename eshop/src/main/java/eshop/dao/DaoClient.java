package eshop.dao;

import java.util.List;

import eshop.entities.Client;

public interface DaoClient extends DaoGeneric<Client, Long> {
	public Client findByKeyWithCommandes(Long key);

	public Client findByIdWithCommandesDetails(Long key);

	public List<Client> findByNomContaining(String nom);

	public List<Client> findByNomContainingWithCommandes(String nom);
}
