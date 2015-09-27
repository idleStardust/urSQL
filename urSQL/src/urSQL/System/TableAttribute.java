package urSQL.System;

/**
 * TableAttribute is a object that represents a attribute of a entity
 * of a relational database.
 * @author ArturoMora™
 *
 */
public class TableAttribute
{
	/**
	 * 
	 */
	public static final String TYPE_CHAR = "CHAR";
	
	/**
	 * 
	 */
	public static final String TYPE_VARCHAR = "VARCHAR";
	
	/**
	 * 
	 */
	public static final String TYPE_INT = "INT";
	
	/**
	 * 
	 */
	public static final String TYPE_DECIMAL = "DECIMAL";
	
	/**
	 * 
	 */
	public static final String TYPE_DATETIME = "DATETIME";
	
	/**
	 * 
	 */
	public static final String NULL_DATA = "NULL";
	/**
	 * Name of the attribute.
	 */
	protected String _Name;
	
	/**
	 * Name of the type of the attribute.
	 */
	protected String _Type;
	
	public TableAttribute(String pName, String pType)
	{
		this._Name = pName;
		this._Type = pType;
	}

	/**
	 * Get for _Name.
	 */
	public String getName() 
	{
		return this._Name;
	}

	/**
	 * Get for _Type.
	 */
	public String getType() 
	{
		return this._Type;
	}

	/**
	 * Set for _Type.
	 */
	public void setType(String pType) 
	{
		this._Type = pType;
	}	

	/**
	 * Set for _Name.
	 */
	public void setName(String pName) 
	{
		this._Name = pName;
	}
}
