package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;

public class ComponentWhere implements Component
{
	public static final String MORE_THAN = ">";
	public static final String LESS_THAN = "<";
	public static final String EQUAL_THAN = "=";
	public static final String LIKE = "LIKE";
	public static final String NOT = "NOT";
	public static final String IS_NULL = "IS NULL";
	public static final String NOT_NULL = "IS NOT NULL";
	public static final String NULL = "NULL";
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
	
	public boolean comparator(String pValue)
	{
		boolean returnValue = false;
		if(this._ComparisonOperator == EQUAL_THAN)
		{
			returnValue = (this._Value.equalsIgnoreCase(this._Value));
		}
		if(this._ComparisonOperator == LIKE)
		{
			returnValue = (!this._Value.endsWith(NULL));
		}
		if(this._ComparisonOperator == IS_NULL)
		{
			returnValue = (this._Value.equalsIgnoreCase(NULL));
		}
		if(this._ComparisonOperator == NOT_NULL)
		{
			returnValue = (!this._Value.equalsIgnoreCase(NULL));
		}
		return true;
	}
	
}
