package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

public class ComponentFor implements Component
{
	protected ResultSet _ApplicableTable;
	
	public ComponentFor(ResultSet pTable)
	{
		this._ApplicableTable = pTable;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// Convierte la tabla a un XML o Json
		// Retorna la tabla donde el registro es la tabla convertida
		return null;
	}
}
