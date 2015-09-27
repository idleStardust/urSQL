package urSQL.System;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This object has all the information of a table.
 * @author ArturoMora™
 */
public class TableData 
{
	/**
	 *  Data Structure for all the registers of the table.
	 */
	protected LinkedList < TableRegister > _Data;
	
	public TableData(LinkedList < TableRegister > pData)
	{
		this._Data = pData;
	}
	
	public TableData()
	{
		this(new LinkedList<>());
	}

	public LinkedList< TableRegister > addTableData(TableData pTData)
	{
		// Iterator Of TableRegister
		Iterator< TableRegister > regIterator = pTData.getData().iterator();
		
		LinkedList<TableRegister> newData = _Data;
		
		// Add the data of the register
		while(regIterator.hasNext())
		{
			newData.add(regIterator.next());
		}
		return newData;
	}
	/**
	 * Get for the _Data (LinkedList < LinkedList < String > > ).
	 */
	public LinkedList< TableRegister > getData() 
	{
		return this._Data;
	}

	/**
	 * Set for the _Data (LinkedList < LinkedList < String > > ).
	 */
	public void setData(LinkedList< TableRegister > pData) 
	{
		this._Data = pData;
	}

	/**
	 * Print the entire information of the table.
	 */
	public void print()
	{
		// Iterator
		Iterator< TableRegister > dataIterator = null;
		Iterator< String > tempIterator = null;
		dataIterator = this._Data.iterator();
		
		// It's print the data of the table
		while( dataIterator.hasNext() )
		{
			tempIterator = dataIterator.next().getRegister().iterator();
			while( tempIterator.hasNext() )
			{
				System.out.print(tempIterator.next() + '\t');
			}
			System.out.println();
		}
	}
}