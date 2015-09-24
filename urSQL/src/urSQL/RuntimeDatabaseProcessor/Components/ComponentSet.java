package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

public class ComponentSet implements Component
{
	protected String _ColumnName;
	protected String _NewValue;
	
	public ComponentSet(String pColumn, String pNewVaule)
	{
		this._NewValue = pNewVaule;
		this._ColumnName = pColumn;
	}
	
	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		return null;
	}
	
}
