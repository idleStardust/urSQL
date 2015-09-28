package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;
import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;
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
	
	private ResultSet getTableData(String pName)
	{
		StoreDataManager storedDataManager = new StoreDataManager();
		
		// Table Crude Data To Insert One-To-One The Registers.
		TableData tableData = new TableData();
		
		// Charge The Crude Data From The Hard Disk
		LinkedList< LinkedList <String> > crudeData = storedDataManager.getTable(
				SystemCatalog.getInstance().getCurrentDatabase(), pName);
		
		// Iterator For The Charged Crude Data.
		Iterator< LinkedList <String> > it = crudeData.iterator();
		
		while(it.hasNext())
		{
			tableData.getData().add(new TableRegister(it.next()));
		}
		
		TableMetadata newTableMetadat = SystemCatalog.getInstance().getMetadata(pName);
		return (new ResultSet(tableData, newTableMetadat));
	}
	
	/**
	 *
	 */
	public ResultSet apply(ResultSet pResultSet)
	{
		
		ResultSet resultSetFinal = this.getTableData(this._TableName);
		ResultSet resultSetTemp = null;
		
		Iterator< String > joinTableNames = this._JoinTables.iterator();
		
		while(joinTableNames.hasNext())
		{
			resultSetTemp = this.getTableData(joinTableNames.next());
			resultSetFinal = crossTable(resultSetFinal, resultSetTemp);
		}
		
		return resultSetFinal;
	}
	
	/**
	 *
	 */
	public ResultSet crossTable(ResultSet pTable, ResultSet pAnotherTable)
	{
		String PKName1 = pTable.getTableMetadata().getPrimaryKey().getName();
		String PKName2 = pAnotherTable.getTableMetadata().getPrimaryKey().getName();
		
		// Position of PK in the data structure.
		int indexOfPrimaryKey1 = pTable.getTableMetadata().indexByName(PKName1);
		int indexOfPrimaryKey2 = pAnotherTable.getTableMetadata().indexByName(PKName2);
		
		Iterator< TableRegister > iteratorFromTable = 
				pTable.getTableData().getData().iterator();
		Iterator< TableRegister > iteratorToTable = 
				pAnotherTable.getTableData().getData().iterator();
		
		Iterator< String > stringIterator;
		
		TableRegister tmpRegisterFrom = null;
		TableRegister tmpRegisterTo = null;
		
		TableData newData = new TableData();
		TableMetadata newMetadata = this.crossMetadata(pTable.getTableMetadata(), 
				                                       pAnotherTable.getTableMetadata());
		while(iteratorFromTable.hasNext())
		{
			tmpRegisterFrom = iteratorFromTable.next();
			while(iteratorToTable.hasNext())
			{
				tmpRegisterTo = iteratorToTable.next();
				
				// If Primary Key Is Equal
				if(tmpRegisterFrom.getRegister().get(indexOfPrimaryKey1).
				   equalsIgnoreCase(
				   tmpRegisterTo.getRegister().get(indexOfPrimaryKey2)))
				{
					stringIterator = tmpRegisterTo.getRegister().iterator();
					while(stringIterator.hasNext())
					{
						tmpRegisterFrom.getRegister().add(stringIterator.next());
					}
					newData.getData().add(tmpRegisterFrom);
				}
			}
		}
		return (new ResultSet(newData, newMetadata));
	}
	
	public TableMetadata crossMetadata(TableMetadata pMetadata, TableMetadata pAnotherMetadata)
	{
		// New Primary Key Is The Primary Key Of The First Metadata
		TableAttribute newPK = new TableAttribute(
				pMetadata.getTableName() + "." + pMetadata.getPrimaryKey().getName(),
				pMetadata.getPrimaryKey().getType());
		
		// Create Simple Info About The New METADATA Created
		TableMetadata newMetadata = new TableMetadata(pMetadata.getTableName() + "." 
		              + pAnotherMetadata.getTableName(), newPK);
		
		// Iterators for TableMetadata's
		Iterator< TableAttribute > iteratorMeta =
				pMetadata.getTableColumns().iterator();
		
		// Temporal for adding from the used METADATA's
		TableAttribute tmpViewAttribute = null;
		
		// Get The METADATA complete information of each attribute
		// TableName.AttributeName
		while(iteratorMeta.hasNext())
		{
			tmpViewAttribute = iteratorMeta.next();
			newMetadata.getTableColumns().add(new TableAttribute(
					pMetadata.getTableName() + "." + tmpViewAttribute.getName(),
					tmpViewAttribute.getType()));			
		}
		Iterator< TableAttribute > iteratorAnotherMeta = 
				pAnotherMetadata.getTableColumns().iterator();
		
		while(iteratorAnotherMeta.hasNext())
		{
			tmpViewAttribute = iteratorAnotherMeta.next();
			newMetadata.getTableColumns().add(new TableAttribute(
					pAnotherMetadata.getTableName() + "." + tmpViewAttribute.getName(),
					tmpViewAttribute.getType()));
		}
		System.out.print("La puta madre... llegue aquí");
		return (newMetadata);
	}
}