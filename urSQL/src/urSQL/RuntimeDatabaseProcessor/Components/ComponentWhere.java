package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

public class ComponentWhere implements Component
{
	/**
	 *  The name of the evaluated column.
	 */
	protected String _ColumnName;
	
	/**
	 *  The requested symbol operator.
	 */
	protected char   _ComparisonOperator;
	
	/**
	 *  The value to compare.
	 */
	protected String _Value;
	
	public ComponentWhere(String pColumnName, char pComparisonOperator, 
			              String pValue)
	{
		this._ColumnName = pColumnName;
		this._ComparisonOperator = pComparisonOperator;
		this._Value = pValue;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// Filtra las columnas en la tabla que cumplan con la sentencia
		return null;
	}
	
	
	
}
