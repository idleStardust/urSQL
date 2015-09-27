package urSQL.RuntimeDatabaseProcessor;

import urSQL.RuntimeDatabaseProcessor.Rutine.Routine;
import urSQL.System.ResultSet;

public class RuntimeDatabaseProcessor 
{
	Routine _LastRutine;
	
	public RuntimeDatabaseProcessor()
	{
		this._LastRutine = null;
	}
	
	public ResultSet playRoutine(Routine pRoutine)
	{
		this._LastRutine = pRoutine;
		return pRoutine.execute();
	}
}