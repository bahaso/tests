package mz.report;

public class Column {

	private boolean isCountable;
	private String name;
	
	public Column(){
		this.name = "Column";
		this.isCountable = false;
	}
	public Column(String columnName)
	{
		this.name = columnName;
		this.isCountable = false;
	}
	public Column(String columnName, boolean isCountable)
	{
		this.name = columnName;
		this.isCountable = isCountable;
	}
	
	public Column setColumnName(String columnName)
	{
		this.name = columnName;
		return this;
	}
	
	public Column setCountable(boolean isCountable)
	{
		this.isCountable = isCountable;
		return this;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean isCountable()
	{
		return this.isCountable;
	}
	
}
