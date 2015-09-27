package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.SystemCatalog.SystemCatalog;

public class ComponentDropDatabase implements Component {

	String database_name;
	
	@Override
	public ResultSet apply(ResultSet pResultSet) {
		// TODO Auto-generated method stub
		
		StoreDataManager sdm = new StoreDataManager();
		sdm.deleteDatabaseScheme(database_name);
		
		SystemCatalog sc = SystemCatalog.getInstance();
		sc.dropDatabase(database_name);
		
		return null;
	}
	
	public void ComponentDropDatabase(String pDatabase_name){
		database_name = pDatabase_name;
	}

}
