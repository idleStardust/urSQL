package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

/**
 * 
 * @author ArturoMora™
 *
 */
public class ComponentAggregateFunction implements Component
{
	/**
	 * 
	 */
	protected String pFunction;
	
	/**
	 * 
	 */
	protected String pColumn;
	
	/**
	 * 
	 */
	public ComponentAggregateFunction(String pFunction, String pColumn) 
	{
		
	}
	
	@Override
	/**
	 * 
	 */
	public ResultSet apply(ResultSet pResultSet) 
	{
		return null;
	}

}
