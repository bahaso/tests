package mz.report;

import java.util.ArrayList;
import java.util.List;

public class ReportHeader {
	
	private List<Column> columns = new ArrayList<Column>(); 
	
	public ReportHeader addColumn(Column column)
	{
		this.columns.add(column);
		return this;
	}
	
	public ReportHeader addColumn(String columnName, boolean isCountable)
	{
		this.columns.add(new Column(columnName,isCountable));
		return this;
	}
	
	public ReportHeader addColumns(List<Column> columns)
	{
		this.columns.addAll(columns.size(),columns);
		return this;
	}
	
	public Column getColumn(String columnName)
	{
		return this.columns.get(this.columns.indexOf(new Column(columnName)));
	}
	
	public Column getColumn(int index)
	{
		return this.columns.get(index);
	}
	
	public boolean isColumnCountable(String columnName)
	{
		return this.columns.get(this.columns.indexOf(new Column(columnName))).isCountable();
	}
	
	public List<Column> getAllColumns()
	{
		return this.columns;
	}
	
}