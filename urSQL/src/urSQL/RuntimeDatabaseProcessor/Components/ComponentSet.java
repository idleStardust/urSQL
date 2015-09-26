package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

/**
 * Clase que representa a la instrucción [SET ColumnName = NewValue]
 * @author ArturoMora™
 */
public class ComponentSet implements Component
{
	/**
	 * The column that contains values for replace.
	 */
	protected String _ColumnName;
	
	/**
	 *  The value to replace. 
	 */
	protected String _NewValue;
	
	/**
	 * 
	 * @param pColumn
	 * @param pNewVaule
	 */
	public ComponentSet(String pColumn, String pNewVaule)
	{
		this._NewValue = pNewVaule;
		this._ColumnName = pColumn;
	}

	@Override
	/**
	 * 
	 */
	public ResultSet apply(ResultSet pResultSet) 
	{
		// 
		return null;
	}
	
}
