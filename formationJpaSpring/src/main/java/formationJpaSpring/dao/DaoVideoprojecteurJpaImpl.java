package formationJpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.util.Context;
import formationJpaSpring.entities.Videoprojecteur;

class DaoVideoprojecteurJpaImpl implements DaoVideoprojecteur {

	@Override
	public void insert(Videoprojecteur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Videoprojecteur update(Videoprojecteur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Videoprojecteur obj) {
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
		em.remove(em.find(Videoprojecteur.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Videoprojecteur findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Videoprojecteur videoprojecteur = em.find(Videoprojecteur.class, key);
		em.close();
		return videoprojecteur;
	}

	@Override
	public List<Videoprojecteur> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Videoprojecteur> query = em.createQuery("from Videoprojecteur o", Videoprojecteur.class);
		List<Videoprojecteur> list = query.getResultList();
		em.close();
		return list;
	}

}
