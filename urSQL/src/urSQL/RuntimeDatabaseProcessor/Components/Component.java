package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

/**
 * 
 * @author ArturoMora™
 *
 */
public interface Component 
{
	public ResultSet apply(ResultSet pResultSet);
}
