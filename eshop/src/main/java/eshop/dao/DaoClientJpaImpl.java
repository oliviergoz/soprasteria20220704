package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import eshop.entities.Client;
import eshop.util.Context;

class DaoClientJpaImpl implements DaoClient {

	@Override
	public void insert(Client obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Client update(Client obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Client.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Client findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Client obj = em.find(Client.class, key);
		em.close();
		return obj;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("from Client o", Client.class);
		List<Client> list = query.getResultList();
		em.close();
		return list;
	}

}
