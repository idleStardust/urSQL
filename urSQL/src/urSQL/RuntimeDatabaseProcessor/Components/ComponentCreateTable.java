package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Vector;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.SystemCatalog.SystemCatalog;

public class ComponentCreateTable implements Component {

	private String table_name;
	private Vector<Vector<String>> vec;
	private String pk;
	
	@Override
	public ResultSet apply(ResultSet pResultSet) {
		// TODO Auto-generated method stub
		
		SystemCatalog sc = SystemCatalog.getInstance();
		sc.addTable(table_name, pk, vec);
		
		StoreDataManager sdm = new StoreDataManager();
		sdm.createTable(sc.getMetadata(table_name));
		
		return null;
	}
	
	/**
	 * Crea una tabla 
	 * 
	 * @param table_name nombre de la tabla
	 * 
	 * @param vec valores de las columnas, tipos, contraints,
	 * y presicion
	 * 
	 * @param pk valor de la llave primaria
	 */
	public ComponentCreateTable(String table_name, Vector<Vector<String>> vec, String pk){
		this.table_name = table_name;
		this.vec = vec;
		this.pk = pk;
	}

}
