package formationJpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formationJpaSpring.entities.Formateur;
import formationJpaSpring.entities.Formation;

@Repository
class DaoFormationJpaImpl implements DaoFormation {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void insert(Formation obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Formation update(Formation obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional
	public void delete(Formation obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Formation.class, key));
	}

	@Override
	public Formation findByKey(Long key) {
		return em.find(Formation.class, key);

	}

	@Override
	public List<Formation> findAll() {
		return em.createNamedQuery("Formation.findAll", Formation.class).getResultList();
	}

	@Transactional
	public void setReferentToNull(Formateur formateur) {
		Query query = em.createNamedQuery("Formation.setReferentToNull");
		query.setParameter("referent", formateur);
		query.executeUpdate();
	}

	@Transactional
	public void deleteByReferent(Formateur formateur) {
		Query query = em.createNamedQuery("Formation.deleteByReferent");
		query.setParameter("referent", formateur);
		query.executeUpdate();
	}
}
