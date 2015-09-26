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
		@SuppressWarnings("unused")
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
		// Primary Keys most be equal
		TableData propertyData = pTable.getTableData();
		TableData anotherData = pAnotherTable.getTableData();
		return null;
	}
}
