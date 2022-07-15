package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Formateur;
import formationJpa.entities.Personne;
import formationJpa.entities.Stagiaire;
import formationJpa.util.Context;

class DaoPersonneJpaImpl implements DaoPersonne {

	@Override
	public void insert(Personne obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Personne update(Personne obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Personne obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		delete(findByKey(key));

	}

	@Override
	public Formateur findFormateurByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Formateur p = em.find(Formateur.class, key);
		//System.out.println(p.getFormations());
		em.close();
		return p;
	}

	@Override
	public Stagiaire findStagiaireByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Stagiaire p = em.find(Stagiaire.class, key);
		em.close();
		return p;
	}

	@Override
	public Personne findByKey(Long key) {
		return null;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		// Query query=em.createQuery("from Personne p");
		TypedQuery<Personne> query = em.createQuery("from Personne p", Personne.class);
		List<Personne> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Formateur> findAllFormateur() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		// Query query=em.createQuery("from Personne p");
		TypedQuery<Formateur> query = em.createQuery("from Formateur p", Formateur.class);
		List<Formateur> list = query.getResultList();
		em.close();
		return list;
	}

}
