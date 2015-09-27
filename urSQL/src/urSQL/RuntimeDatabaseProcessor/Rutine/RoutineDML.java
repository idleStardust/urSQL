package urSQL.RuntimeDatabaseProcessor.Rutine;
import java.util.Iterator;
import java.util.LinkedList;

import urSQL.RuntimeDatabaseProcessor.DataIntegrityManager;
import urSQL.RuntimeDatabaseProcessor.Components.Component;
import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.System.TableMetadata;
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
		// Plan Execution - Relational Algebra
		ResultSet resultPartial = this.runPlan();
	
		// Final response to the queried
		ResultSet resultFinalExtreme = null;
		
		// Instruction for a Delete Routine
		// Deletes from a TableData 
		if(this._Command.equalsIgnoreCase(CONSTANT_DELETE))
		{
			// Data Review
			DataIntegrityManager referencialIM = new DataIntegrityManager();
						
			// Data Execution
			this.deleteRows(resultPartial);
			//referencialIM.makeReview(resultPartial);
			
		}
		
		// Instruction for a Delete Routine
		// Deletes from a TableData 
		if(this._Command.equalsIgnoreCase(CONSTANT_INSERT))
		{
			// Data Review
			DataIntegrityManager referencialIM = new DataIntegrityManager();
			//referencialIM.makeReview(resultPartial);

			// Data Execution
			this.insertRows(resultPartial);			
		}
		
		// Instruction for a Delete Routine
		// Deletes from a TableData 
		if(this._Command.equalsIgnoreCase(CONSTANT_SET))
		{
			// Data Review
			DataIntegrityManager referencialIM = new DataIntegrityManager();
			//referencialIM.makeReview(resultPartial);

			// Data Execution
			this.updateRows(resultPartial);			
		}
		
		// Instruction for a Delete Routine
		// Deletes from a TableData 
		if(this._Command.equalsIgnoreCase(CONSTANT_SELECT))
		{
			resultFinalExtreme = resultPartial;
		}
		
		else
		{
			resultFinalExtreme = null;
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
		//	sDm.insertRow(SystemCatalog.getInstance().getCurrentDatabase(), 
		//			pResultSet.getTableMetadata(), pResultSet.getTableData().getData().toArray((new String[tmp.getRegister().size()])));
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
			sDm.deleteRow(SystemCatalog.getInstance().getCurrentDatabase(), 
				          tableName, it.next().getRegister().get(pkIndex));
		}
		return null;
	}
	
	private ResultSet updateRows(ResultSet pResultSet)
	{
		// Table Name
		String tableName = pResultSet.getTableMetadata().getTableName();
		
		// Primary Key Index
		int pkIndex = pResultSet.getTableMetadata().indexByName(pResultSet
				                .getTableMetadata().getPrimaryKey().getName());
		
		// Disk Data Manager
		StoreDataManager sDm = new StoreDataManager();
		
		// Iterator for the Registers
		Iterator< TableRegister > it = pResultSet.getTableData().getData().iterator();
		
		// Temporal TableRegister
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
