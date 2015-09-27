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
		// Name of PK
		String PKName1 = pTable.getTableMetadata().getPrimaryKey().getName();
		String PKName2 = pAnotherTable.getTableMetadata().getPrimaryKey().getName();
		
		// Index of PK
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
		LinkedList< TableAttribute > newMeta = pTable.getTableMetadata().addMetadata(pAnotherTable.getTableMetadata());
		return (new ResultSet(new TableData(newData), new TableMetadata(newMeta) ));
	}
}
