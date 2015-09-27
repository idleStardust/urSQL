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
	protected LinkedList< Component > _Components;
	
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
		this._Components = pComponents;
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
		Iterator< Component > componentIterator = this._Components.iterator();
		while ( componentIterator.hasNext() )
		{
			resultTable = componentIterator.next().apply(resultTable);
		}
		return (resultTable);
	}
	
	/**
	 * 
	 * @param pComponents
	 */
	public void setComponents(LinkedList< Component > pComponents)
	{
		this._Components = pComponents;
	}
	
	/**
	 * 
	 * @return
	 */
	public LinkedList< Component > getComponents()
	{
		return (this._Components);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCommand()
	{
		return this._Command;
	}
	
	/**
	 * 
	 * @param pCommand
	 */
	public void setCommand(String pCommand)
	{
		this._Command = pCommand;
	}
	
	/**
	 * 
	 * @param pComponent
	 */
	public void add(Component pComponent)
	{
		this._Components.add(pComponent);
	}
}