package formationJpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.util.Context;
import formationJpaSpring.entities.ModuleFormation;
import formationJpaSpring.entities.ModuleFormationKey;

public class DaoModuleFormationJpaImpl implements DaoModuleFormation {

	@Override
	public void insert(ModuleFormation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public ModuleFormation update(ModuleFormation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(ModuleFormation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(ModuleFormationKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(ModuleFormation.class, key));
		;
		tx.commit();
		em.close();

	}

	@Override
	public ModuleFormation findByKey(ModuleFormationKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		ModuleFormation obj = em.find(ModuleFormation.class, key);
		em.close();
		return obj;
	}

	@Override
	public List<ModuleFormation> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<ModuleFormation> query = em.createQuery("from ModuleFormation mf", ModuleFormation.class);
		List<ModuleFormation> list = query.getResultList();
		em.close();
		return list;
	}

}
