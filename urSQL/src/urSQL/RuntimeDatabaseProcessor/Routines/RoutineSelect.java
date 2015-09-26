package urSQL.RuntimeDatabaseProcessor.Routines;

import urSQL.System.ResultSet;

public class RoutineSelect extends Routine
{
	@Override
	public ResultSet execute() 
	{
		return(this.runPlan());
	}
}