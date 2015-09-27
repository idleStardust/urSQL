package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;

import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;
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
	LinkedList< String > _Columns;
	
	public ComponentGroup(LinkedList< String > pColumnas) 
	{
		this._Columns = pColumnas;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// TableData.
		TableData tableData = new TableData();
		
		// TableMetadata.
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
		
		// Iterator for the registers of the table
		Iterator< String > columnIterator = this._Columns.iterator();
				
		// Iterator for the registers of the table
		Iterator< TableRegister > tableIterator = 
				pResultSet.getTableData().getData().iterator();
		
		Iterator< TableRegister > newtableIterator = null;
		
		// Temporal Index
		int indexTemp = 0;
		
		// Temporal Register
		TableRegister tmp = null;
		TableRegister newTmp = null;
		
		indexTemp = pResultSet.getTableMetadata().indexByName(columnIterator.next());

		// Iterate for all the table
		while( tableIterator.hasNext() )
		{
			tmp = tableIterator.next();
			newTmp = newtableIterator.next();
			if(true)
			{
				tableData.getData().add(tmp);
			}
			else
			{				
				newtableIterator = tableData.getData().iterator();
				while( newtableIterator.hasNext() )
				{
					break;
				}
			}
		}
		return (new ResultSet(tableData, tableMetadata));
	}
}
