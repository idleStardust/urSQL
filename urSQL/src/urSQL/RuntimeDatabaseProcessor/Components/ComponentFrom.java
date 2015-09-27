package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;
import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableRegister;
import urSQL.SystemCatalog.SystemCatalog;

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
	protected LinkedList<String> _JoinTables;
	
	/**
	 * 
	 * @param pTableName
	 * @param pJoinTables
	 */
	public ComponentFrom(String pTableName, LinkedList< String > pJoinTables)
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
		
		// Carga de la la tabla	
		return null;
	}
	
	private ResultSet loadTable(String pTableName)
	{
		// Recuperar la tabla del StoreDataManager.
		StoreDataManager sdm = new StoreDataManager();
		LinkedList<LinkedList<String>> tableInfo =  sdm.getTable(SystemCatalog.getInstance().getCurrentDatabase(), pTableName);
		TableData tableData = new TableData();
		return null;
	}
}
