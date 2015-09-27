package urSQL.API;

import java.util.Iterator;
import java.util.LinkedList;

public class TableData 
{
	protected LinkedList < LinkedList < String > > _Data;
	
	public TableData(LinkedList < LinkedList < String > > pData)
	{
		this._Data = pData;
	}
	

	/**
	 * Print the entire information of the table.
	 */
	public void print()
	{
		// Iterator
		Iterator< LinkedList< String > > dataIterator = null;
		Iterator< String > tempIterator = null;
		dataIterator = this._Data.iterator();
		
		// It's print the data of the table
		while( dataIterator.hasNext() )
		{
			tempIterator = dataIterator.next().iterator();
			while( tempIterator.hasNext() )
			{
				System.out.print(tempIterator.next() + '\t');
			}
			System.out.println();
		}
	}
}