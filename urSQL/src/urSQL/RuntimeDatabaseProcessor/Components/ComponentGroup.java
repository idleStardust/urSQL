package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

/**
 * 
 * @author ArturoMora
 *
 */
public class ComponentGroup implements Component 
{
	String _Column;
	
	public ComponentGroup(LinkedList<String> cols) 
	{
		this._Column = cols.get(0);
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// TableMetadata.
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
		
		int index = tableMetadata.indexByName(this._Column);
				
		// Iterator for the registers of the table
		Iterator< TableRegister > tableIterator = 
				pResultSet.getTableData().getData().iterator();
		
		LinkedList<String> columns = new LinkedList<String>();
		
		TableRegister tmp = null;
		
		while (tableIterator.hasNext()) 
		{
			tmp = tableIterator.next();
			columns.add(tmp.getRegister().get(index));
		}
		
		Collections.sort(columns);
		LinkedList<Integer> indexes = new LinkedList<Integer>();
		
		for (int i = 0; i < columns.size(); i++)
		{
			for (int j = 0; j < pResultSet.getTableData().getData().size(); j++)
			{
				if (columns.get(i).equals(pResultSet.getTableData().getData().get(j).getRegister().get(index)))
				{
					if (!indexes.contains(j))
					{
						indexes.add(j);						
					}
				}
			}
		}
		
		LinkedList<TableRegister> new_regs = new LinkedList<TableRegister>();
		for (int k = 0; k < indexes.size(); k++)
		{
			new_regs.add(pResultSet.getTableData().getData().get(indexes.get(k)));
		}
		
		TableData td = new TableData(new_regs);
		ResultSet ready = new ResultSet(td, tableMetadata);
		return ready;
		
		/*Iterator< TableRegister > newtableIterator = null;
		
		// Temporal Register
		
		TableRegister newTmp = null;
		
		// Temporal Index
		int indexTemp = 
				pResultSet.getTableMetadata().indexByName(this._Column);
		
		// Type of the column
		String tableType = 
				pResultSet.getTableMetadata().getTableColumns().get(indexTemp).getType();
		
		// Iterate for all the table
		while( tableIterator.hasNext() )
		{
			tmp = tableIterator.next();
			if (tableData.getData().isEmpty())
			{
				tableData.getData().add(tmp);
			}
			else
			{
				newtableIterator = tableData.getData().iterator();
				for(int x = 0; newtableIterator.hasNext(); x++)
				{	System.out.println(newtableIterator.hasNext());
					newTmp = newtableIterator.next();
					if(TableRegister.comparate(tmp.getRegister().get(indexTemp), ">", newTmp.getRegister().get(indexTemp), 
					tableType))
					{	System.out.println("conchita");
						tableData.getData().add(x, tmp);
					}
				}
			}
		}
		return (new ResultSet(tableData, tableMetadata));*/
	}
}