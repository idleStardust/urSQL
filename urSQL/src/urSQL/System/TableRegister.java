package urSQL.System;

import java.util.LinkedList;

/**
 * TableRegister is a object that represent a register from
 * a relational database.
 * @author ArturoMora™
 *
 */
public class TableRegister 
{
	/*
	 * 
	 */
	public static final String MORE_THAN = ">";
	
	/**
	 * 
	 */
	public static final String CONSTANT_LESS_THAN = "<";
	
	/**
	 * 
	 */
	public static final String CONSTANT_MORE_THAN = ">";
	
	/**
	 * 
	 */
	public static final String CONSTANT_EQUAL_THAN = "=";
	
	/**
	 * Constant LIKE
	 */
	public static final String CONSTANT_LIKE = "LIKE";
	
	/**
	 * Constant NOT
	 */
	public static final String CONSTANT_NOT = "NOT";
	
	/**
	 * Constant IS_NULL
	 */
	public static final String CONSTANT_IS_NULL = "IS NULL";
	
	/**
	 * Constant NOT_NULL
	 */
	public static final String CONSTANT_NOT_NULL = "IS NOT NULL";
	
	/**
	 * Constant NULL
	 */
	public static final String CONSTANT_NULL = "NULL";
	
	/**
	 * 
	 */
	public static final String TYPE_INTEGER = "INTEGER";
	
	/**
	 * 
	 */
	public static final String TYPE_DECIMAL = "DECIMAL";
	
	/**
	 * 
	 */
	public static final String TYPE_CHAR =    "CHAR";
	
	/**
	 * 
	 */
	public static final String TYPE_VARCHAR = "VARCHAR";

	/**
	 * 
	 */
	public static final String TYPE_DATETIME= "DATETIME";
	
	/**
	 * Structure with string that represent the register of the
	 * Database.
	 */
	protected LinkedList< String > _Register;
	
	/**
	 * 
	 * @param pRegister
	 */
	public TableRegister(LinkedList< String > pRegister)
	{
		this._Register = pRegister;
	}
	
	/**
	 * 
	 */
	public TableRegister()
	{
		this(new LinkedList<>());
	}
	
	/**
	 *  Get for _Register
	 * @return
	 */
	public LinkedList< String > getRegister() 
	{
		return this._Register;
	}

	/**
	 * Set for _Register
	 * @param pRegister
	 */
	public void setRegister(LinkedList < String > pRegister)
	{
		this._Register = pRegister;
	}
	
	public static boolean comparate(String pValue, String pComparator, 
			                        String pAnotherValue, String pType)
	{
		boolean value = false;
		if(pComparator.equalsIgnoreCase(CONSTANT_EQUAL_THAN)    || 
				pComparator.equalsIgnoreCase(CONSTANT_LESS_THAN)||
			    pComparator.equalsIgnoreCase(CONSTANT_MORE_THAN)||
				pComparator.equalsIgnoreCase(CONSTANT_NOT))
		{
			TableRegister.valorate(pValue, pComparator, pAnotherValue, pType);
		}
		if(pComparator.equalsIgnoreCase(CONSTANT_LIKE))
		{
			value = pComparator.equalsIgnoreCase(CONSTANT_NULL);
		}
		if(pComparator.equalsIgnoreCase(CONSTANT_NOT_NULL))
		{
			value = pValue.equalsIgnoreCase(CONSTANT_NULL);
		}
		if(pComparator.equalsIgnoreCase(CONSTANT_IS_NULL))
		{
			value = !pValue.equalsIgnoreCase(CONSTANT_NULL);
		}
		return value;
	}
	
	public static boolean valorate(String pValue, String pComparator, 
			                       String pAnotherValue, String pType)
	{
		boolean returnValue = false;
		if(pType.equalsIgnoreCase(TYPE_CHAR))
		{
			
		}
		if(pType.equalsIgnoreCase(TYPE_VARCHAR))
		{
			
		}
		if(pType.equalsIgnoreCase(TYPE_DATETIME))
		{
			
		}
		if(pType.equalsIgnoreCase(TYPE_DECIMAL))
		{
			double value = Double.parseDouble(pValue);
			double anotherValue = Double.parseDouble(pAnotherValue);
			if(pComparator.equalsIgnoreCase(CONSTANT_MORE_THAN))
			{
				returnValue = value > anotherValue;
			}
			if(pComparator.equalsIgnoreCase(CONSTANT_LESS_THAN))
			{
				returnValue = value < anotherValue;
			}
			if(pComparator.equalsIgnoreCase(CONSTANT_EQUAL_THAN))
			{
				returnValue = value == anotherValue;
			}
			if(pComparator.equalsIgnoreCase(CONSTANT_NOT))
			{
				returnValue = value != anotherValue;
			}
		}
		if(pType.equalsIgnoreCase(TYPE_INTEGER))
		{
			int value = Integer.parseInt(pValue);
			int anotherValue = Integer.parseInt(pAnotherValue);
			if(pComparator.equalsIgnoreCase(CONSTANT_MORE_THAN))
			{
				returnValue = value > anotherValue;
			}
			if(pComparator.equalsIgnoreCase(CONSTANT_LESS_THAN))
			{
				returnValue = value < anotherValue;
			}
			if(pComparator.equalsIgnoreCase(CONSTANT_EQUAL_THAN))
			{
				returnValue = value == anotherValue;
			}
			if(pComparator.equalsIgnoreCase(CONSTANT_NOT))
			{
				returnValue = value != anotherValue;
			}
		}
		return (returnValue);
	}
}