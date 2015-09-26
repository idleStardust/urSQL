package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;

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
		int indexOfColumn = 
				pResultSet.getTableMetadata().indexByName(this._ColumnName);
		//
		TableData tableData = new TableData();
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
		return (new ResultSet(tableData, tableMetadata));
	}
	
}
