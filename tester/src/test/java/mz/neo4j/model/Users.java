package mz.neo4j.model;

import java.util.Date;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public class Users extends Entity{
	
	private String username;
	
	private String email;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private String aboutme;
	
	private String gender;
	
	private Long gold;
	
	private String job;
	
	private String cellphonenumber;
	
	private String confirmation_code;
	
	private String confirmed;
	
	private Long country_id;
	
	@DateLong
	private Date birthday;
	
	@DateLong
	private Date last_login;

	@DateLong
	private Date remember_token;

	@DateLong
	private Date created_at;
	
	@DateLong
	private Date updated_at;
	
	//active course
	//lesson_acl
	//roles

}
