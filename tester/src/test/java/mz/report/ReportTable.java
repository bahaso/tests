package mz.report;

import java.util.ArrayList;
import java.util.List;

public class ReportTable {

	ReportHeader header = new ReportHeader();
	List<ReportRow> rows = new ArrayList<ReportRow>();
	ReportFooter footer = null;
	
	public ReportTable(){
		setDefaultHeaderColumnName();
		this.footer = new ReportFooter(header);
	}
	
	private void setDefaultHeaderColumnName(){
		this.header.addColumn("Class",false);
		this.header.addColumn("Method",false);
		this.header.addColumn("Success",true);
		this.header.addColumn("Failed",true);
		this.header.addColumn("Skipped",true);
	}
	
	public ReportTable addRow(Object...objects)
	{
		if(objects.length <= this.header.getAllColumns().size())
		{
			this.rows.add(this.rows.size(), new ReportRow(this.header));
			for(int i=0; i<objects.length; i++)
			{
				Object value = ( objects[i] != null ? objects[i] : ReportRow.defaultFieldValue(this.header.getColumn(i)));
				
				this.rows.get(this.rows.size()-1).setFieldValue(this.header.getColumn(i).getName(),value);
			}
		}
		return this;
	}
	
	public ReportHeader getHeader()
	{
		return this.header;
	}
	
	public List<ReportRow> getRows()
	{
		return this.rows;
	}
	
	public ReportFooter getFooter()
	{
		return this.footer;
	}
	
}
