package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.ArrayList;
import java.util.LinkedList;

import urSQL.System.ResultSet;

/**
 * 
 * @author ArturoMora™
 *
 */
public class ComponentFrom implements Component
{
	protected String _TableName;
	protected ArrayList<String> _JoinTables;
	
	public ComponentFrom(String pTableName, ArrayList<String> pJoinTables)
	{
		this._TableName = pTableName;
		this._JoinTables = pJoinTables;
	}
	
	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// Recuperar la tabla del SystemCatalog.
		
		// Aplicar el Join, si se requiere.
		if (this._JoinTables.isEmpty())
		{
			
		}
		
		// Retornar Tabla.
		return null;
	}
}
