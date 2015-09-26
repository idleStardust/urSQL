package urSQL.RuntimeDatabaseProcessor.Routines;

import urSQL.System.ResultSet;

public class RoutineUpdate extends Routine
{
	@Override
	public ResultSet execute() 
	{
		// Create the respective table
		ResultSet table = this.runPlan();
		// Verify Refential Integrity
		return null;
	}
}
