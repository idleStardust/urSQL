package urSQL.RuntimeDatabaseProcessor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import urSQL.StoredDataManager.Pair;
import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;
import urSQL.SystemCatalog.SystemCatalog;

public class DataIntegrityManager 
{
	
	public DataIntegrityManager(){
		
	}
	
	public boolean examineRS(ResultSet rs){
		boolean result = false;
	
		//manejo de archivos
		SystemCatalog sc = SystemCatalog.getInstance();
		StoreDataManager sdm = new StoreDataManager();
		//metadata
		TableMetadata  metadata = rs.getTableMetadata();
		//nombre de la tabla
		String table_name = metadata.getTableName();
		//se guardan las columnas con referencias
		Queue<String> queue_columns = new LinkedList<String>();
		//verifica si tienen referencias las 
		LinkedList<TableAttribute> list = metadata.getTableColumns();
		for(int i =0; i < list.size(); i++){
			String tmp = list.get(i).getName();
			if(sc.isHaveReferences(table_name, tmp)){
				queue_columns.add(tmp);
			}
		}
		
		
		LinkedList<Pair<Pair<String,String>,String>> list_2 = new LinkedList<Pair<Pair<String,String>,String>>();
		
		while(!queue_columns.isEmpty()){
			String column = queue_columns.poll();
			Pair<Pair<String,String>,String> tmp = sc.getReference(table_name, column);
			list_2.add(tmp);
		}
		
		LinkedList<TableRegister> rows = rs.getTableData().getData();
		
		for (int i = 0; i < rows.size(); i++) {
			for (int j = 0; j < list_2.size(); j++) {
				
			}
		}
		
		
		return result;
	}
	
	private int indexOf(LinkedList<String> list, String column){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).compareTo(column) == 0){
				return i;
			}
		}
		return -1;
	}
}
