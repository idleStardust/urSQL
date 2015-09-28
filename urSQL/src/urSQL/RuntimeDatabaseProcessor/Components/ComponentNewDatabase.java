package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.SystemCatalog.SystemCatalog;

public class ComponentNewDatabase implements Component {

	
	String _database_name;
	
	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// TODO Auto-generated method stub
		
		SystemCatalog sc = SystemCatalog.getInstance();
		sc.addDatabase(_database_name);
		
		StoreDataManager sdm  = new StoreDataManager();
		sdm.createDatabase(_database_name);
		
		return null;
	}
	
	public ComponentNewDatabase(String pName){
		_database_name = pName;
	}

}
