package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;
import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
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
		return (new ResultSet(this.getTableData(), this.getTableMetadata()));
	}
	
	private TableData getTableData()
	{
		StoreDataManager storedDataManager = new StoreDataManager();
		
		// Table Crude Data To Insert One-To-One The Registers.
		TableData tableData = new TableData();
		
		// Charge The Crude Data From The Hard Disk
		LinkedList< LinkedList <String> > crudeData = storedDataManager.getTable("CURRENT_SCHEMA", this._TableName);
		
		// Iterator For The Charged Crude Data.
		Iterator< LinkedList <String> > it = crudeData.iterator();
		
		while(it.hasNext())
		{
			tableData.getData().add(new TableRegister(it.next()));
		}
		
		return (tableData);
	}
	
	private TableMetadata getTableMetadata()
	{
		return null;
	}
}
