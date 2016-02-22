package mz.report;

public class Field {

	private String identifier;
	private Boolean isCountable;
	private Object value;
	
	public Field(){}
	
	public Field (String identifier, Object value)
	{
		this.identifier = identifier;
		this.value = value;
		if(value.getClass() == Integer.class)
			this.isCountable = true;
		else this.isCountable = false;
	}
	
	public Field (String identifier, Boolean isCountable, Object value)
	{
		this.identifier = identifier;
		this.value = value;
		this.isCountable = isCountable;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Boolean isCountable() {
		return this.isCountable;
	}

	public void isCountable(Boolean isCountable) {
		this.isCountable = isCountable;
	}
	
}
