package urSQL.RuntimeDatabaseProcessor;

import urSQL.RuntimeDatabaseProcessor.Routines.Routine;
import urSQL.System.ResultSet;

public class RuntimeDatabaseProcessor 
{
	public ResultSet playRoutine(Routine pRoutine)
	{
		return pRoutine.execute();
	}
}