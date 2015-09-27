package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.LinkedList;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;

public class ComponentListDatabases implements Component {

	@Override
	public ResultSet apply(ResultSet pResultSet) {
		// TODO Auto-generated method stub
		
		StoreDataManager sdm = new StoreDataManager();
		
		LinkedList<String> listDatabases =  sdm.getDatabases();
		
		return null;
	}
	
	public ComponentListDatabases(){
		
	}

}
