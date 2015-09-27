package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.SystemCatalog.SystemCatalog;

public class ComponentDropTable implements Component {

	private String table_name;
	
	@Override
	public ResultSet apply(ResultSet pResultSet) {
		// TODO Auto-generated method stub
		
		SystemCatalog sc = SystemCatalog.getInstance();
		sc.dropTable(table_name);
		
		StoreDataManager sdm = new StoreDataManager();
		sdm.dropTable(table_name);
		
		return null;
	}
	
	public ComponentDropTable(String table_name){
		this.table_name = table_name;
	}

}
