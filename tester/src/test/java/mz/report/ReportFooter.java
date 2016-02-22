package mz.report;

import java.util.ArrayList;
import java.util.List;

public class ReportFooter {

	List<Field> fields = new ArrayList<Field>();
	
	public ReportFooter(ReportHeader header){
		for(Column column : header.getAllColumns())
		{
			fields.add(new Field(column.getName(), (column.isCountable()?0:"")));
		}
	}
	
	public ReportFooter generateTotal(List<ReportRow> rows)
	{
		for(ReportRow row : rows)
		{
			for(int i=0; i<row.getAllFields().size(); i++)
			{
				if(row.getField(i).isCountable())
					this.fields.get(i).setValue( (Integer)row.getField(i).getValue() + (Integer)this.fields.get(i).getValue() );
			}
		}
		return this;
	}
	
}
