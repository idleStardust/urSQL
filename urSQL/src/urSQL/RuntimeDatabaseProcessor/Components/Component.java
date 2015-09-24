package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

public interface Component 
{
	public ResultSet apply(ResultSet pResultSet);
}
