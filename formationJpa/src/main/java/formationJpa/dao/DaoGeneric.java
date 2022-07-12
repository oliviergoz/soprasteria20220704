package formationJpa.dao;

import java.util.List;

interface DaoGeneric<T, K> {
	void insert(T obj);

	T update(T obj);

	void delete(T obj);

	void deleteByKey(K key);

	T findByKey(K key);

	List<T> findAll();
}
