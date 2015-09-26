package urSQL.RuntimeDatabaseProcessor.Routines;

import urSQL.System.ResultSet;
import urSQL.System.TableMetadata;

public class RoutineInsert extends Routine
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
