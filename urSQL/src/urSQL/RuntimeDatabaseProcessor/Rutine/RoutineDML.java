package urSQL.RuntimeDatabaseProcessor.Rutine;
import java.util.Iterator;
import java.util.LinkedList;

import urSQL.RuntimeDatabaseProcessor.ReferencialIntegrityManager;
import urSQL.RuntimeDatabaseProcessor.Components.Component;
import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.System.TableRegister;
import urSQL.SystemCatalog.SystemCatalog;

public class RoutineDML extends Routine
{
	/**
	 * Constant for the SQL Word SELECT
	 */
	public static String CONSTANT_SELECT = "SELECT";
	
	/**
	 * Constant for the SQL Word Insert
	 */
	public static String CONSTANT_INSERT = "INSERT";
	
	
	/**
	 * Constant for the SQL Word DELETE
	 */
	public static String CONSTANT_DELETE = "DELETE";
	
	
	/**
	 * Constant for the SQL Word SET
	 */
	public static String CONSTANT_SET = "SET";
	
	
	/**
	 * 
	 */
	public RoutineDML(String pCommand, LinkedList<Component> pComponents) 
	{
		super(pCommand, pComponents);
	}

	/**
	 * 
	 */
	public RoutineDML(String pCommand) 
	{
		super(pCommand, new LinkedList<>());
	}
	
	@Override
	public ResultSet execute() 
	{
		// Final response to the queried
		ResultSet resultPartial = null;
		
		// Plan Execution - Relational Algebra
		ResultSet resultFinalExtreme = this.runPlan();
		
		// Data Review
		ReferencialIntegrityManager referencialIM = new ReferencialIntegrityManager();
		//referencialIM.makeReview(resultPartial);
		
		if(this._Command.equalsIgnoreCase(CONSTANT_DELETE))
		{
			// Data Execution
			this.deleteRows(resultPartial);
		}
		
		if(this._Command.equalsIgnoreCase(CONSTANT_INSERT))
		{
			// Data Execution
			this.insertRows(resultPartial);
		}
		
		if(this._Command.equalsIgnoreCase(CONSTANT_SET))
		{
			// Data Execution
			this.updateRows(resultPartial);
		}
		
		if(this._Command.equalsIgnoreCase(CONSTANT_SELECT))
		{
			resultFinalExtreme = resultPartial;
		}
		return (resultFinalExtreme);
	}
	
	private ResultSet insertRows(ResultSet pResultSet)
	{
		// Disk Data Manager
		StoreDataManager sDm = new StoreDataManager();
		// Iterator for the Registers
		Iterator< TableRegister > it = pResultSet.getTableData().getData().iterator();
		while(it.hasNext())
		{
			//sDm.insertRow(SystemCatalog.getInstance().getCurrentDatabase(), metadata, data);
		}
		return null;
	}
	
	private ResultSet deleteRows(ResultSet pResultSet)
	{
		// Table Name
		String tableName = pResultSet.getTableMetadata().getTableName();
		
		// Primary Key Index
		int pkIndex = pResultSet.getTableMetadata().indexByName(pResultSet.getTableMetadata().getPrimaryKey().getName());
		
		// Disk Data Manager
		StoreDataManager sDm = new StoreDataManager();
		
		// Iterator for the Registers
		Iterator< TableRegister > it = pResultSet.getTableData().getData().iterator();
		while(it.hasNext())
		{
			sDm.deleteRow(SystemCatalog.getInstance().getCurrentDatabase(), tableName, it.next().getRegister().get(pkIndex));
		}
		return null;
	}
	
	private ResultSet updateRows(ResultSet pResultSet)
	{
		// Table Name
		String tableName = pResultSet.getTableMetadata().getTableName();
		
		// Primary Key Index
		int pkIndex = pResultSet.getTableMetadata().indexByName(pResultSet.getTableMetadata().getPrimaryKey().getName());
		
		// Disk Data Manager
		StoreDataManager sDm = new StoreDataManager();
		
		// Iterator for the Registers
		Iterator< TableRegister > it = pResultSet.getTableData().getData().iterator();
		
		// Temp
		TableRegister tmp = null;
		while(it.hasNext())
		{
			tmp = it.next();
			sDm.updateRegister(SystemCatalog.getInstance().getCurrentDatabase(), 
					tableName, tmp.getRegister().get(pkIndex), tmp.getRegister().toArray(new String[tmp.getRegister().size()]));
		}
		return null;
	}
	
}
