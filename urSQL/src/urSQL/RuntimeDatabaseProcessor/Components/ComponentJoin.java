package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;
import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

/**
 * 
 * @author ArturoMora™
 *
 */
public class ComponentJoin 
{
	
	/**
	 *
	 */
	protected LinkedList< String > _TablesToJoin;
	
	/**
	 *
	 */
	public ComponentJoin(LinkedList< String > pTablesToJoin)
	{
		this._TablesToJoin = pTablesToJoin;
	}
	
	/**
	 *
	 */
	public ResultSet apply(ResultSet pResultSet)
	{
		
		ResultSet resultSetFinal = pResultSet;
		ResultSet resultSetTemp;
		Iterator< String > tablesToJoinIterator = this._TablesToJoin.iterator();
		
		while( tablesToJoinIterator.hasNext() )
		{
			//resultSetTemp = new ResultSet(tablesToJoinIterator.next());
			resultSetFinal = this.crossTable(resultSetFinal, resultSetFinal);
		}
		return pResultSet;
	}
	
	/**
	 *
	 */
	private ResultSet crossTable(ResultSet pTable, ResultSet pAnotherTable)
	{
		// Name of PK.
		String PKName1 = pTable.getTableMetadata().getPrimaryKey().getName();
		String PKName2 = pAnotherTable.getTableMetadata().getPrimaryKey().getName();
		
		// Position of PK in the data structure.
		int indexOfPrimaryKey1 = pTable.getTableMetadata().indexByName(PKName1);
		int indexOfPrimaryKey2 = pTable.getTableMetadata().indexByName(PKName2);
		
		// Temporal Values
		TableRegister regTemp = null;
		TableData dataTemp = new TableData();
		Iterator< TableRegister > regIterator = pAnotherTable.getTableData().getData().iterator();
		Iterator< TableRegister > viewIterator = pTable.getTableData().getData().iterator();
		while(regIterator.hasNext())
		{
			regTemp = regIterator.next();
			while(viewIterator.hasNext())
			{
				if(regTemp.getRegister().get(indexOfPrimaryKey2).equals
				(viewIterator.next().getRegister().get(indexOfPrimaryKey1)))
				{
					dataTemp.getData().add(regTemp);
					break;
				}
			}
		}
		
		// Aggregated TableData
		LinkedList< TableRegister > newData = dataTemp.addTableData(pTable.getTableData());
		
		return (new ResultSet(new TableData(newData), null ));
	}
	
	protected TableData conjuntionTableData()
	{
		return null;
	}
	
	protected TableMetadata crossMetadata(TableMetadata pMetadata, TableMetadata pAnotherMetadata)
	{
		// New Primary Key Is The Primary Key Of The First Metadata
		TableAttribute newPK = new TableAttribute(
				pMetadata.getTableName() + "." + pMetadata.getPrimaryKey().getName(),
				pMetadata.getPrimaryKey().getType());
		
		// Create Simple Info About The New Metadata Created
		TableMetadata newMetadata = new TableMetadata(pMetadata.getTableName() + "." 
		              + pAnotherMetadata.getTableName(), newPK);
		
		// Iterators for TableMetadata's
		Iterator< TableAttribute > iteratorMeta = pMetadata.getTableColumns().iterator();
		Iterator< TableAttribute > iteratorAnotherMeta = pAnotherMetadata.getTableColumns().iterator();
		
		// Temporal for adding from the used METADATA's
		TableAttribute tmpAddAttribute = new TableAttribute("", "");
		TableAttribute tmpViewAttribute = null;
		
		// Get The METADATA complete information of each attribute
		// TableName.AttributeName
		while(iteratorMeta.hasNext())
		{
			tmpViewAttribute = iteratorMeta.next();
			tmpAddAttribute.setName(pMetadata.getTableName() + "." + tmpViewAttribute.getName());
			tmpAddAttribute.setType(tmpViewAttribute.getType());
			newMetadata.getTableColumns().add(tmpAddAttribute);
			
		}
		while(iteratorAnotherMeta.hasNext())
		{
			tmpViewAttribute = iteratorAnotherMeta.next();
			tmpAddAttribute.setName(pAnotherMetadata.getTableName() + "." + tmpViewAttribute.getName());
			tmpAddAttribute.setType(tmpViewAttribute.getType());
			newMetadata.getTableColumns().add(tmpAddAttribute);
		}
		
		return (newMetadata);
	}
}
