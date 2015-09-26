package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.LinkedList;

import urSQL.System.ResultSet;

/**
 * 
 * @author ArturoMora™
 *
 */
public class ComponentGroup implements Component 
{
	LinkedList< String > _Columns;
	public ComponentGroup(LinkedList< String > pComponentes) 
	{
		this._Columns = pComponentes;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
