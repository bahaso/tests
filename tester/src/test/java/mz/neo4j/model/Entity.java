package mz.neo4j.model;

import org.neo4j.ogm.annotation.GraphId;

public abstract class Entity {
	
	@GraphId
	private Long _id;
	
	public Long getID()
	{
		return _id;
	}
	
	public void setID(Long _id)
	{
		this._id = _id;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || _id == null || getClass() != o.getClass())return false;
		Entity entity = (Entity)o;
		if(!_id.equals(entity._id))return false;
		return true;
	}
	
	@Override
	public int hashCode()
	{
		return (_id==null)?-1:_id.hashCode();
	}
	
}
