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
		ResultSet resultSetTemp = null;
		Iterator< String > tablesToJoinIterator = this._TablesToJoin.iterator();
		
		while( tablesToJoinIterator.hasNext() )
		{
			//resultSetTemp = new ResultSet(tablesToJoinIterator.next());
			resultSetFinal = this.crossResultSet(resultSetTemp, resultSetFinal);
		} 
		return pResultSet;
	}
	
	protected ResultSet crossResultSet(ResultSet pResultSet, ResultSet pAnotherResultSet)
	{
		TableMetadata newMetadata = this.crossMetadata(pResultSet.getTableMetadata(), 
				pAnotherResultSet.getTableMetadata());
		
		TableData newData = this.crossTable(pResultSet, pAnotherResultSet);
		
		return(new ResultSet(newData, newMetadata));
	}
	
	/**
	 *
	 */
	protected TableData crossTable(ResultSet pTable, ResultSet pAnotherTable)
	{
		// Name of PK.
		String PKName1 = pTable.getTableMetadata().getPrimaryKey().getName();
		String PKName2 = pAnotherTable.getTableMetadata().getPrimaryKey().getName();
		
		// Position of PK in the data structure.
		int indexOfPrimaryKey1 = pTable.getTableMetadata().indexByName(PKName1);
		int indexOfPrimaryKey2 = pTable.getTableMetadata().indexByName(PKName2);
		
		// Merge the METADATA of the table's.
		TableMetadata newMetadata = this.crossMetadata(pTable.getTableMetadata(),
				                                       pTable.getTableMetadata());
		TableData newTable1;
		TableData newTable2;
		TableData newData = null;// = addTable(newTable1, newTable2);
		
		return (newData);
	}
	
	protected TableData conjuntionTableData(TableData pTable, TableData pAnotherTable,
			                                int pViewIndex, int pViewerIndex)
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
