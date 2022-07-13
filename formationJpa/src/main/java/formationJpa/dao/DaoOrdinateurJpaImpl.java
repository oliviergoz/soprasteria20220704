package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Ordinateur;
import formationJpa.util.Context;

class DaoOrdinateurJpaImpl implements DaoOrdinateur {

	@Override
	public void insert(Ordinateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Ordinateur update(Ordinateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Ordinateur obj) {
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
		em.remove(em.find(Ordinateur.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Ordinateur findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Ordinateur ordinateur = em.find(Ordinateur.class, key);
		em.close();
		return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Ordinateur> query = em.createQuery("from Ordinateur o", Ordinateur.class);
		List<Ordinateur> list = query.getResultList();
		em.close();
		return list;
	}

}
