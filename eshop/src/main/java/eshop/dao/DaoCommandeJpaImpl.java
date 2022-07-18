package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import eshop.entities.Client;
import eshop.entities.Commande;
import eshop.util.Context;

class DaoCommandeJpaImpl implements DaoCommande {

	@Override
	public void insert(Commande obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Commande update(Commande obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Commande obj) {
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
		em.remove(em.find(Commande.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Commande findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Commande obj = em.find(Commande.class, key);
		em.close();
		return obj;
	}

	@Override
	public List<Commande> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Commande> query = em.createQuery("from Commande o", Commande.class);
		List<Commande> list = query.getResultList();
		em.close();
		return list;
	}

	public Commande findByIdWithLignes(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Commande> query = em.createNamedQuery("Commande.findByIdWithLignes", Commande.class);
		query.setParameter("id", key);
		Commande commande = null;
		try {
			commande = query.getSingleResult();
		} catch (Exception e) {
		}
		em.close();
		return commande;
	}

}
