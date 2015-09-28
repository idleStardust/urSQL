package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;	

import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

public class ComponentWhere implements Component
{
	/**
	 *  The name of the evaluated column.
	 */
	protected String _ColumnName;
	
	/**
	 *  The requested symbol operator.
	 */
	protected String _ComparisonOperator;
	
	/**
	 *  The value to compare.
	 */
	protected String _Value;
	
	public ComponentWhere(String pColumnName, String pComparisonOperator, 
			              String pValue)
	{
		this._ColumnName = pColumnName;
		this._ComparisonOperator = pComparisonOperator;
		this._Value = pValue;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// TableData.
		TableData tableData = new TableData();
		
		// TableMetadata.
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
		
		// Search Index Of Column.
		int indexOfColumn = 
				pResultSet.getTableMetadata().indexByName(this._ColumnName);
		
		// Current Info of the column to iterate.
		TableAttribute currentAttribute = tableMetadata.getTableColumns().get(indexOfColumn);
		
		// Register Of the database.
		TableRegister tmp = null;
		
		// Iterator for the the all registers.
		Iterator< TableRegister > regIterator = 
				pResultSet.getTableData().getData().iterator();
		
		// Iterate all the registers.
		while (regIterator.hasNext())
		{
			tmp = regIterator.next();
			
			if(TableRegister.comparate(
					tmp.getRegister().get(indexOfColumn), 
					this._ComparisonOperator, 
					this._Value, currentAttribute.getType()))
			{
				// Add the column that accomplish with the criteria.
				tableData.getData().add(tmp);	
			}
		}
		
		return (new ResultSet(tableData, tableMetadata));
	}
}
