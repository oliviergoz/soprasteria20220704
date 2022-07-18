package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import eshop.entities.Fournisseur;
import eshop.util.Context;

class DaoFournisseurJpaImpl implements DaoFournisseur {

	@Override
	public void insert(Fournisseur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Fournisseur update(Fournisseur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Fournisseur obj) {
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
		em.remove(em.find(Fournisseur.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Fournisseur findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Fournisseur obj = em.find(Fournisseur.class, key);
		em.close();
		return obj;
	}

	@Override
	public List<Fournisseur> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Fournisseur> query = em.createQuery("from Fournisseur o", Fournisseur.class);
		List<Fournisseur> list = query.getResultList();
		em.close();
		return list;
	}

}
