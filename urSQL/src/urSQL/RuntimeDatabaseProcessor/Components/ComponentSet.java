package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;

import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

/**
 * This class represents the Set component. [SET ColumnName = NewValue]
 * @author ArturoMora™
 */
public class ComponentSet implements Component
{
	/**
	 * The column that contains values for replace.
	 */
	protected String _ColumnName;
	
	/**
	 *  The value to replace. 
	 */
	protected String _NewValue;
	
	/**
	 * 
	 * @param pColumn Name of the column.
	 * @param pNewVaule New value for the column.
	 */
	public ComponentSet(String pColumn, String pNewVaule)
	{
		this._NewValue = pNewVaule;
		this._ColumnName = pColumn;
	}

	
	@Override
	/**
	 * 
	 */
	public ResultSet apply(ResultSet pResultSet) 
	{
		// Search Index Of Column
		int indexOfColumn = 
				pResultSet.getTableMetadata().indexByName(this._ColumnName);
		
		// TableData
		TableData tableData = new TableData();
		
		// Modify Value
		Iterator< TableRegister > regIterator = 
				pResultSet.getTableData().getData().iterator();
		TableRegister tmp = null;
		while ( regIterator.hasNext() )
		{
			tmp = regIterator.next();
			tmp.getRegister().set(indexOfColumn, this._NewValue);
			tableData.getData().add(tmp);
		}
		
		// TableMetadata
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
		
		return (new ResultSet(tableData, tableMetadata));
	}
	
}
