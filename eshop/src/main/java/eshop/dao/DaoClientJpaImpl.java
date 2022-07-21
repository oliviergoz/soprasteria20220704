package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshop.entities.Client;

@Repository
class DaoClientJpaImpl implements DaoClient {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Client obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Client update(Client obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Client obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Client.class, key));
	}

	@Override
	public Client findByKey(Long key) {
		Client obj = em.find(Client.class, key);
		return obj;
	}

	@Override
	public List<Client> findAll() {
		TypedQuery<Client> query = em.createQuery("from Client o", Client.class);
		List<Client> list = query.getResultList();
		return list;
	}

	public Client findByKeyWithCommandes(Long key) {
		TypedQuery<Client> query = em.createNamedQuery("Client.findByKeyWithCommandes", Client.class);
		query.setParameter("id", key);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (Exception e) {
		}
		return client;
	}

	public Client findByIdWithCommandesDetails(Long key) {
		TypedQuery<Client> query = em.createNamedQuery("Client.findByIdWithCommandesDetails", Client.class);
		query.setParameter("id", key);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (Exception e) {
		}
		return client;
	}

	public List<Client> findByNomContaining(String nom) {
		TypedQuery<Client> query = em.createNamedQuery("Client.findByNomContaining", Client.class);
		query.setParameter("texte", "%" + nom + "%");
		List<Client> list = query.getResultList();
		return list;
	}

	public List<Client> findByNomContainingWithCommandes(String nom) {
		TypedQuery<Client> query = em.createNamedQuery("Client.findByNomContainingWithCommandes", Client.class);
		query.setParameter("texte", "%" + nom + "%");
		List<Client> list = query.getResultList();
		return list;
	}

}
