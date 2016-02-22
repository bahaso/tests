package mz.report;

import java.util.ArrayList;
import java.util.List;

public class ReportRow {

	private List<Field> fields = new ArrayList<Field>();
	
	public ReportRow(ReportHeader header)
	{
		for(Column column : header.getAllColumns())
		{
			this.fields.add(new Field(column.getName(),new Object()));
		}
	}
	
	public int count()
	{
		return this.fields.size();
	}
	
	public List<Field> getAllFields()
	{
		return this.fields;
	}
	
	public ReportRow setFieldValue(String fieldIdentifier, Object value)
	{
		for(Field field : this.fields)
		{
			if(field.getIdentifier() == fieldIdentifier)
			{
				field.setValue(value);
				break;
			}
		}
		return this;
	}
	
	public Field getField(int index)
	{
		return this.fields.get(index);
	}
	
	public Object getFieldValue(String fieldIdentifier)
	{
		for(Field field : this.fields)
		{
			if(field.getIdentifier() == fieldIdentifier)
			{
				return field.getValue();
			}
		}
		return null;
	}
	
	public static Object defaultFieldValue(Column column)
	{
		return (column.isCountable() ? 0 : column.getName());
	}
	
}