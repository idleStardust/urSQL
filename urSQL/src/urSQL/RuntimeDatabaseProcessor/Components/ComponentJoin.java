package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;
import urSQL.System.ResultSet;
import urSQL.System.TableData;

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
		String PKName1 = pTable.getTableMetadata().getPrimaryKey().getName();
		String PKName2 = pAnotherTable.getTableMetadata().getPrimaryKey().getName();
		int indexOfPrimaryKey1 = pTable.getTableMetadata().indexByName(PKName1);
		int indexOfPrimaryKey2 = pTable.getTableMetadata().indexByName(PKName2);
		
		ResultSet combinedTables = pTable.addResultSet(pAnotherTable);
		
		
		return null;
	}
}
