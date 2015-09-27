package urSQL.RuntimeDatabaseProcessor.Rutine;

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
	 */
	public String _Command;
	
	/**
	 * 
	 * @param pComponents
	 */
	public Routine(String pCommand, LinkedList< Component > pComponents)
	{
		this._Command = pCommand;
		this._AccessRoutine = pComponents;
	}
	
	/**
	 * 
	 */
	public Routine(String pCommand)
	{
		this(pCommand, new LinkedList<>());
	}
	
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
}