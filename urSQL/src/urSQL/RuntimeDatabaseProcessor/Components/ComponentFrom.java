package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

public class ComponentFrom implements Component
{
	protected String _TableName;
	
	public ComponentFrom(String pTableName)
	{
		this._TableName = pTableName;
	}

	@Override
	public ResultSet apply() 
	{
		// Recuperar la tabla del SystemCatalog.
		
		// Aplicar el Join, si se requiere.
		
		// Retornar Tabla.
		return null;
	}
}
