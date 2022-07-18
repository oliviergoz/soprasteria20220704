package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import eshop.entities.LigneCommande;
import eshop.entities.LigneCommandeKey;
import eshop.util.Context;

class DaoLigneCommandeJpaImpl implements DaoLigneCommande {

	@Override
	public void insert(LigneCommande obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public LigneCommande update(LigneCommande obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(LigneCommande obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(LigneCommandeKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(LigneCommande.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public LigneCommande findByKey(LigneCommandeKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		LigneCommande obj = em.find(LigneCommande.class, key);
		em.close();
		return obj;
	}

	@Override
	public List<LigneCommande> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<LigneCommande> query = em.createQuery("from LigneCommande o", LigneCommande.class);
		List<LigneCommande> list = query.getResultList();
		em.close();
		return list;
	}

}
