package urSQL.RuntimeDatabaseProcessor.Routines;

import java.util.ArrayList;

import urSQL.RuntimeDatabaseProcessor.Components.Component;
import urSQL.System.ResultSet;

public abstract class Routine 
{
	protected ArrayList< Component > _AccessRoutine;
	
	public abstract ResultSet execute();
	
	public Routine()
	{
		this._AccessRoutine = new ArrayList<>();
	}
	
	public Routine(ArrayList< Component > pComponents)
	{
		this._AccessRoutine = pComponents;
	}
	
	public void addComponent(Component pComponent)
	{
		this._AccessRoutine.add(pComponent);
	}
}