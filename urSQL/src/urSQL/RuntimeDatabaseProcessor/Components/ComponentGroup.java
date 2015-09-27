package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;

import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

/**
 * 
 * @author ArturoMora™
 *
 */
public class ComponentGroup implements Component 
{
	String _Column;
	
	public ComponentGroup(String pColumna) 
	{
		this._Column = pColumna;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// TableData.
		TableData tableData = new TableData();
		
		// TableMetadata.
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
				
		// Iterator for the registers of the table
		Iterator< TableRegister > tableIterator = 
				pResultSet.getTableData().getData().iterator();
		
		Iterator< TableRegister > newtableIterator = null;
		
		// Temporal Register
		TableRegister tmp = null;
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
				{
					newTmp = newtableIterator.next();
					if(TableRegister.comparate(tmp.getRegister().get(indexTemp), 
							                   ">", 
							                   newTmp.getRegister().get(indexTemp), 
							                   tableType))
					{
						tableData.getData().add(x, tmp);
					}
				}
			}
		}
		return (new ResultSet(tableData, tableMetadata));
	}
}
