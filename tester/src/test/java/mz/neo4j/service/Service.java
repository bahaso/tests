package mz.neo4j.service;

public interface Service<T> {
	Iterable<T> findAll();
	
	T find(Long _id);
	
	void delete(Long _id);
	
	T createOrUpdate(T entity);
}
