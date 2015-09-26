package urSQL.System;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This object has all the information of the name and type
 * of the attributes of a entity.
 * @author ArturoMora™
 */
public class TableMetadata
{
	/**
	 * Name of the entity associated to the METADATA.
	 */
	protected String _TableName;
	
	/**
	 * Pair attribute name and attribute type.
	 */
	protected LinkedList<TableAttribute> _TableColumns;
	
	/**
	 * Unique data of the entity.
	 */
	protected TableAttribute _PrimaryKey;
	
	/**
	 * 
	 */
	public TableMetadata(String pTableName, 
			LinkedList< TableAttribute > pTableColumns, TableAttribute pPrimaryKey)
	{
		this._TableName = pTableName;
		this._TableColumns = pTableColumns;
		this._PrimaryKey = pPrimaryKey;
	}

	/**
	 * 
	 */
	public TableMetadata(String pTableName, TableAttribute pPrimaryKey)
	{
		this(pTableName, new LinkedList<>(), pPrimaryKey);
	}
	
	/**
	 * Get for _TableName.
	 */
	public String getTableName() 
	{
		return _TableName;
	}

	/**
	 * Set for _TableName.
	 */
	public void setTableName(String pTableName) 
	{
		this._TableName = pTableName;
	}

	/**
	 * Get for _TableColumns.
	 */
	public LinkedList<TableAttribute> getTableColumns() 
	{
		return _TableColumns;
	}

	/**
	 * Set for _TableColumns.
	 */
	public void setTableColumns(LinkedList<TableAttribute> pTableColumns) 
	{
		this._TableColumns = pTableColumns;
	}

	/**
	 * Get for _PrimaryKey.
	 */
	public TableAttribute getPrimaryKey() 
	{
		return _PrimaryKey;
	}

	/**
	 *  Set for _PrimaryKey.
	 */
	public void setPrimaryKey(TableAttribute pPrimaryKey) 
	{
		this._PrimaryKey = pPrimaryKey;
	}
	
	/**
	 *  Search the index of a attribute according to a attribute name.
	 */
	public int indexByName(String pColumnName)
	{
		Iterator< TableAttribute > attributeIterator = this._TableColumns.iterator();
		int i = 0;
		for(i = 0; attributeIterator.hasNext(); i++)
		{
			// Attribute Name = Searched Column Name
			if (attributeIterator.next()._Name.equals(pColumnName))
				break;
		}
		return (i);
	}
	
	/**
	 *  Print the name of the attributes.
	 */
	public void print()
	{
		// Iterator
		Iterator< TableAttribute > metaIterator = null;
		// METADATA Iterator
		metaIterator = this._TableColumns.iterator();
		// Print the METADATA
		while( metaIterator.hasNext() )
		{
			System.out.print(metaIterator.next().getName() + '\t');
		}
	}
}