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
	 * 
	 */
	private int current_index;
	
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
	
	public ResultSet(LinkedList<String> pColumnNames, TableRegister pValues, String pType)
	{
		Iterator<String> attIterator = pColumnNames.iterator();
		while(attIterator.hasNext())
		{
			this._TableMetadata.getTableColumns().
			add(new TableAttribute(attIterator.next(), pType));
			this._TableData.getData().add(pValues);
		}		
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
	
	public boolean first()
	{
		this.current_index = 0;
		this._TableData._Data.get(0);
		return true;
	}

	public boolean last()
	{
		this.current_index = this._TableMetadata.getTableColumns().size() - 1;
		return true;
	}

	public boolean absolute(int row)
	{
		this.current_index = row;
		return true;
	}
	
	public boolean relative(int row)
	{
		int size = this._TableData._Data.size();
		if (this.current_index + row >= size)
		{
			return false;
		} 
		else 
		{
			this.current_index += row;
			return true;
		}
	}

	public boolean previous()
	{
		if (this.current_index == 0) 
		{
			return false;
		} 
		else 
		{
			this.current_index--;
			return true;
		}
	}

	public boolean next()
	{
		int size = this._TableData._Data.size() - 1;
		if (this.current_index == size) 
		{
			return false;
		} 
		else
		{
			this.current_index++;
			return true;
		}
	}

	public int getRow() 
	{
		return this.current_index;
	}

	public String getColumn(String colName) 
	{
		Iterator<TableAttribute> i = this._TableMetadata._TableColumns.iterator();
		TableAttribute tmp = null;
		int x = 0;
		for (x = 0; i.hasNext(); x++)
		{
			tmp = i.next();
			if (tmp.getName().equals(colName))
			{
				break;
			}
		}
		return (this._TableData._Data.get(current_index).getRegister().get(x));
	}

	public String getColumn(int colIndex)
	{
		return (this._TableData._Data.get(current_index)
				.getRegister().get(colIndex));
	}
}