package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;

import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

/**
 * 
 * @author ArturoMora™
 *
 */
public class ComponentInsert implements Component 
{
	LinkedList< String > _Columns;
	LinkedList< String > _Values;
	
	public ComponentInsert(LinkedList< String > pColumnas, LinkedList< String > pValores) 
	{
		this._Columns = pColumnas;
		this._Values = pValores;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		
		return null;
	}
}