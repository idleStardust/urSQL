package urSQL.System;

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
	protected TableData _TableData;
	
	/**
	 * The information about the attributes of the table.
	 */
	protected TableMetadata _TableMetadata;
	
	/**
	 *  Default constructor for ResultSet.
	 */
	public ResultSet(TableData pTableData, TableMetadata pTableMetadata)
	{
		this._TableData = pTableData;
		this._TableMetadata = pTableMetadata; 
	}

	/**
	 *  Constructor with default parameter TableData.
	 */
	public ResultSet(TableMetadata pTableMetadata)
	{
		this(new TableData() ,pTableMetadata);
	}
	
	/**
	 * Get of _TableData
	 */
	public TableData getTableData() 
	{
		return this._TableData;
	}

	/**
	 * Set of _TableData
	 */
	public void setTableData(TableData pTableData) 
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
		this._TableMetadata.print();
		System.out.println("");
		this._TableData.print();
	}	
	
}