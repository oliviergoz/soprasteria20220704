package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import eshop.entities.Client;
import eshop.entities.Fournisseur;
import eshop.entities.Produit;
import eshop.util.Context;

class DaoProduitJpaImpl implements DaoProduit {

	@Override
	public void insert(Produit obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Produit update(Produit obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Produit obj) {
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
		em.remove(em.find(Produit.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Produit findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Produit obj = em.find(Produit.class, key);
		em.close();
		return obj;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Produit> query = em.createQuery("from Produit o", Produit.class);
		List<Produit> list = query.getResultList();
		em.close();
		return list;
	}

	public List<Produit> findByFournisseur(Fournisseur fournisseur) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Produit> query = em.createNamedQuery("Produit.findByFournisseur", Produit.class);
		query.setParameter("fournisseur", fournisseur);
		List<Produit> list = query.getResultList();
		em.close();
		return list;
	}

}
