package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.SystemCatalog.SystemCatalog;

public class ComponentSetDatabase implements Component {

	
	String database_name;
	
	@Override
	public ResultSet apply(ResultSet pResultSet) {
		// TODO Auto-generated method stub
		
		SystemCatalog sc = SystemCatalog.getInstance();
		sc.setDatabase(database_name);
		
		StoreDataManager sdm = new StoreDataManager();
		sdm.setDatabase(database_name);
		
		return null;
	}

	
	public ComponentSetDatabase(String database_name){
		this.database_name = database_name;
	}
}
