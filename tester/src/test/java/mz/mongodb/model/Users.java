package mz.mongodb.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("users")
public class Users {
	
	@Id
	private ObjectId _id;
	
}
