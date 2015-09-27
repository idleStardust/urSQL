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
		// TableData is the new table of the updates registers.
		TableData tableData = new TableData();
		
		// TableMetadata is the same of the table that be updated.
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
		
		// Temporal to save TableRegisters in use.
		TableRegister tmp = null;
				
		// Search Index Of Column To Update In The Registers.
		int indexOfColumn = 
				pResultSet.getTableMetadata().indexByName(this._ColumnName);
		
		// Iterator for the the all registers.
		Iterator< TableRegister > regIterator = 
				pResultSet.getTableData().getData().iterator();
		
		// Iterate all the registers, and change the value of the
		// value by the columnIndex in the Linked List.
		while (regIterator.hasNext())
		{
			// Next item on the operator.
			tmp = regIterator.next();
			
			// Modify the Column Of the list.
			tmp.getRegister().set(indexOfColumn, this._NewValue);
			
			// Add to the new TableData.
			tableData.getData().add(tmp);
		}
		
		return (new ResultSet(tableData, tableMetadata));
	}
	
}
