package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;
import urSQL.SystemCatalog.SystemCatalog;

public class ComponentForeignKeyTable implements Component {

	
	String table1;
	String table2;
	
	String column1;
	String column2;
	
	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		
		SystemCatalog sc = SystemCatalog.getInstance();
		
		sc.addReference(table1, column1, table2, column2);
		
		return null;
		
	}
	
	
	public ComponentForeignKeyTable(String pTable1, String pColumn1, String pColumn2, String pTable2){
		table1 = pTable1;
		table2 = pTable2;
		
		column1 = pColumn1;
		column2 = pColumn2;
	}

}
