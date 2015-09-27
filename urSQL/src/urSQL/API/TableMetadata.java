package urSQL.API;
import java.util.Iterator;
import java.util.LinkedList;

public class TableMetadata
{
	protected String _TableName;
	protected LinkedList<TableAttribute> _TableColumns;
	protected TableAttribute _PrimaryKey;
	
	public TableMetadata(String pTableName, 
			LinkedList< TableAttribute > pTableColumns, TableAttribute pPrimaryKey)
	{
		this._TableName = pTableName;
		this._TableColumns = pTableColumns;
		this._PrimaryKey = pPrimaryKey;
	}

	public String getTableName() 
	{
		return _TableName;
	}

	public void setTableName(String pTableName) 
	{
		this._TableName = pTableName;
	}

	public LinkedList<TableAttribute> getTableColumns() 
	{
		return _TableColumns;
	}

	public void setTableColumns(LinkedList<TableAttribute> pTableColumns) 
	{
		this._TableColumns = pTableColumns;
	}

	public TableAttribute getPrimaryKey() 
	{
		return _PrimaryKey;
	}

	public void setPrimaryKey(TableAttribute pPrimaryKey) 
	{
		this._PrimaryKey = pPrimaryKey;
	}
	

	/**
	 * Print the name of the attributes.
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