package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;

public class ComponentSet implements Component
{
	protected TableAttribute _ColumnName;
	protected String _NewValue;
	
	public ComponentSet(String pNewVaule)
	{
		// Búsqueda de MetadaData de la Columna
		this._NewValue = pNewVaule;
	}
	
	@Override
	public ResultSet apply() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
