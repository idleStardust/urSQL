package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

public class ComponentWhere implements Component
{
	protected String _ColumnName;
	protected char   _ComparisonOperator;
	protected String _Value;
	protected ResultSet _ApplicableTable;
	
	public ComponentWhere(String pColumnName, char pComparisonOperator, 
			              String pValue, ResultSet pTable)
	{
		this._ColumnName = pColumnName;
		this._ComparisonOperator = pComparisonOperator;
		this._Value = pValue;
		this._ApplicableTable = pTable;
	}

	@Override
	public ResultSet apply() 
	{
		// Filtra las columnas en la tabla que cumplan con la sentencia
		return null;
	}
	
	
	
}
