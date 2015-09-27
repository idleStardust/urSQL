package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.ArrayList;
import urSQL.System.ResultSet;

/**
 * 
 * @author ArturoMora™
 *
 */
public class ComponentFrom implements Component
{
	/**
	 * 
	 */
	protected String _TableName;
	
	/**
	 * 
	 */
	protected ArrayList<String> _JoinTables;
	
	/**
	 * 
	 * @param pTableName
	 * @param pJoinTables
	 */
	public ComponentFrom(String pTableName, ArrayList<String> pJoinTables)
	{
		this._TableName = pTableName;
		this._JoinTables = pJoinTables;
	}
	
	@Override
	/**
	 * @see urSQL.RuntimeDatabaseProcessor.Components.Component#apply(urSQL.System.ResultSet)
	 */
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
