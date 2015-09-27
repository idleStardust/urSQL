package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;

public class ComponentSetDatabase implements Component {

	
	String database_name;
	
	@Override
	public ResultSet apply(ResultSet pResultSet) {
		// TODO Auto-generated method stub
		
		StoreDataManager sdm = new StoreDataManager();
		sdm.setDatabase(database_name);
		
		return null;
	}

	
	public ComponentSetDatabase(String database_name){
		this.database_name = database_name;
	}
}
