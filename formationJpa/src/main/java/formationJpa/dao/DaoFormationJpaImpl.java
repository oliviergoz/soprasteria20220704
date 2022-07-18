package formationJpa.dao;

import java.text.Normalizer.Form;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import formationJpa.entities.Formateur;
import formationJpa.entities.Formation;
import formationJpa.util.Context;

class DaoFormationJpaImpl implements DaoFormation {

	@Override
	public void insert(Formation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Formation update(Formation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Formation obj) {
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
		em.remove(em.find(Formation.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Formation findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Formation formation = em.find(Formation.class, key);
		em.close();
		return formation;
	}

	@Override
	public List<Formation> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em.createNamedQuery("Formation.findAll", Formation.class);
		List<Formation> list = query.getResultList();
		em.close();
		return list;
	}

	public List<Formation> demoJpql() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		// String requete = "select f from Formation f where f.referent=:formateur";
		String requete = "select f from Formation f where f.referent.prenom='olivier'";
		TypedQuery<Formation> query = em.createQuery(requete, Formation.class);
//		Formateur f = new Formateur();
//		f.setId(100L);
		// query.setParameter("formateur", f);
		List<Formation> list = query.getResultList();
		em.close();
		return list;
	}

	public void setReferentToNull(Formateur formateur) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createNamedQuery("Formation.setReferentToNull");
		query.setParameter("referent", formateur);
		query.executeUpdate();
		tx.commit();
		em.close();
	}

	public void deleteByReferent(Formateur formateur) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createNamedQuery("Formation.deleteByReferent");
		query.setParameter("referent", formateur);
		query.executeUpdate();
		tx.commit();
		em.close();
	}
}
