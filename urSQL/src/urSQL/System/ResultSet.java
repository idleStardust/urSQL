package urSQL.System;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * ResultSet is a object that contains the data of the table 
 * and the information of attributes of the table.
 * @author ArturoMora™
 *
 */
public class ResultSet
{
	/**
	 *  The matrix of strings of chars that represent the information.
	 */
	protected LinkedList < LinkedList < String > > _TableData;
	
	/**
	 * The information about the attributes of the table.
	 */
	protected TableMetadata _TableMetadata;
	
	/**
	 *  Default constructor for ResultSet.
	 */
	public ResultSet(LinkedList< LinkedList < String > > pTableData, TableMetadata pTableMetadata)
	{
		this._TableData = pTableData;
		this._TableMetadata = pTableMetadata; 
	}

	/**
	 * Get of _TableData
	 */
	public LinkedList< LinkedList < String > > getTableData() 
	{
		return this._TableData;
	}

	/**
	 * Set of _TableData
	 */
	public void setTableData(LinkedList < LinkedList < String > > pTableData) 
	{
		this._TableData = pTableData;
	}

	/**
	 * Get of _TableMetadata
	 */
	public TableMetadata getTableMetadata()
	{
		return this._TableMetadata;
	}

	/**
	 * Set of _TableMetadata
	 */
	public void setTableMetadata(TableMetadata pMetadata)
	{
		this._TableMetadata = pMetadata;
	}
	
	
	/**
	 *  Print the MetaData And Data Information.
	 */
	public void print()
	{
		this.printMetadata();
		// Empty Line
		System.out.println("");
		this.printTableData();
	}
		
	
	/**
	 * Print the name of the attributes.
	 */
	public void printMetadata()
	{
		// Iterator
		Iterator< TableAttribute > metaIterator = null;
		// METADATA Iterator
		metaIterator = this._TableMetadata._TableColumns.iterator();
		// Print the METADATA
		while( metaIterator.hasNext() )
		{
			System.out.print(metaIterator.next().getName() + '\t');
		}
	}
		
	/**
	 * Print the entire information of the table.
	 */
	public void printTableData()
	{
		// Iterator
		Iterator< LinkedList< String > > dataIterator = null;
		Iterator< String > tempIterator = null;
		dataIterator = this._TableData.iterator();
		
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