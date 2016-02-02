package mz.neo4j.service;

import org.neo4j.ogm.session.Session;

import mz.neo4j.model.Entity;
import mz.neo4j.session.Neo4JSessionFactory;

public abstract class GenericService<T> implements Service<T> {

	private static final int DEPTH_LIST = 0;
	private static final int DEPTH_ENTITY = 1;
	private Session session = Neo4JSessionFactory.getInstance().getNeo4jSession();
	
	public Iterable<T> findAll()
	{
		return session.loadAll(getEntityType(),DEPTH_LIST);
	}
	
	public T find(Long _id)
	{
		return session.load(getEntityType(), _id, DEPTH_ENTITY);
	}
	
	public void delete(Long _id)
	{
		session.delete(session.load(getEntityType(), _id));
	}
	
	public T createOrUpdate(T entity)
	{
		session.save(entity, DEPTH_ENTITY);
		return find(((Entity) entity).getID());
	}
	
	public abstract Class<T> getEntityType();
}
