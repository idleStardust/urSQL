package urSQL.RuntimeDatabaseProcessor.Routines;

import java.util.Iterator;
import java.util.LinkedList;

import urSQL.RuntimeDatabaseProcessor.Components.Component;
import urSQL.System.ResultSet;

public abstract class Routine 
{
	/**
	 * 
	 */
	protected LinkedList< Component > _AccessRoutine;
	
	/**
	 * 
	 * @return
	 */
	public abstract ResultSet execute();
	
	/**
	 * 
	 * @return
	 */
	public ResultSet runPlan()
	{
		ResultSet resultTable = null;
		Iterator< Component > componentIterator = this._AccessRoutine.iterator();
		while ( componentIterator.hasNext() )
		{
			resultTable = componentIterator.next().apply(resultTable);
		}
		return (resultTable);
	}
	
	/**
	 * 
	 */
	public Routine()
	{
		this(new LinkedList<>());
	}
	
	/**
	 * 
	 * @param pComponents
	 */
	public Routine(LinkedList< Component > pComponents)
	{
		this._AccessRoutine = pComponents;
	}
}