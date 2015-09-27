package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;

public class ComponentNewDatabase implements Component {

	
	String _database_name;
	
	@Override
	public ResultSet apply(ResultSet pResultSet) {
		// TODO Auto-generated method stub
		
		StoreDataManager sdm  = new StoreDataManager();
		
		sdm.createDatabase(_database_name);
		
		return null;
	}
	
	public ComponentNewDatabase(String pName){
		_database_name = pName;
	}

}
