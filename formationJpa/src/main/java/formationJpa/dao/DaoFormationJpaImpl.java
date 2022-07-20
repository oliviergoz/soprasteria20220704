package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

	/*	manipulation d'objet au lieu de lignes/tables en SQL
	 * 	en gros : select * from ENTITE alias (correspond à une instance)
	 * donc pour une fomation = "select f from Formation f"
	 */
	public List<Formation> demoJpql() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		String requete="select f from Formation f where f.nom like '%a%' ";
//		String requete="select f from Formation f where f.nom like :nom ";
		String requete="select f from Formation f where f.referent=:formateur ";
		TypedQuery<Formation> query = em.createQuery(requete, Formation.class);
//		query.setParameter("nom", "%a%");
		Formateur f = new Formateur();
		f.setId(100L);
		query.setParameter("formateur", f);
		List<Formation> list = query.getResultList();
		em.close();
		return list;
	}
	
	public void setReferentNoNull(Formateur formateur) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		javax.persistence.Query query = em.createNamedQuery("Formation.setReferentNoNull");
		query.setParameter("referent", formateur);
		query.executeUpdate();
		tx.commit();
		em.close();
	}

	public void deleteByReferent (Formateur formateur) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		javax.persistence.Query query = em.createNamedQuery("Formation.deleteByReferent");
		query.setParameter("referent", formateur);
		query.executeUpdate();
		tx.commit();
		em.close();
	}
}
