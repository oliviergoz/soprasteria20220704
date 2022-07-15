package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Module;
import formationJpa.util.Context;

class DaoModuleJpaImpl implements DaoModule {

	@Override
	public void insert(Module obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Module update(Module obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Module obj) {
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
		em.remove(em.find(Module.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Module findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Module module = em.find(Module.class, key);
		em.close();
		return module;
	}

	@Override
	public List<Module> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Module> query = em.createQuery("from Module o", Module.class);
		List<Module> list = query.getResultList();
		em.close();
		return list;
	}

}
