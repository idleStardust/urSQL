package urSQL.QueryProcessor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.SystemCatalog.SystemCatalog;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoreDataManager sdm = new StoreDataManager();
		SystemCatalog sc = SystemCatalog.getInstance();
		
		//sc.addDatabase("Basesita");
		//sdm.createDatabase("Basesita");
		
		sc.setDatabase("Basesita");
		sdm.setDatabase("Basesita");
		
		LinkedList<LinkedList<String>> list = sdm.getTable("Basesita", "Tablita");
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				String tmp = list.get(i).get(j);
				System.out.print("/"+ tmp + "/");
			}
			System.out.println();
		}
		
		
		Vector<String> vec1 = new Vector<String>();
		vec1.add("Nombre");
		vec1.add("0");
		vec1.add("-1");
		vec1.add("-1");
		vec1.add("3");
		
		Vector<String> vec2 = new Vector<String>();
		vec2.add("Apellido");
		vec2.add("0");
		vec2.add("-1");
		vec2.add("-1");
		vec2.add("3");
		
		Vector<String> vec3 = new Vector<String>();
		vec3.add("Cedula");
		vec3.add("0");
		vec3.add("-1");
		vec3.add("-1");
		vec3.add("0");
		
		Vector<Vector<String>> vec = new Vector<Vector<String>>();
		vec.addElement(vec1);
		vec.addElement(vec2);
		vec.addElement(vec3);
		
		sc.addTable("Tablita", "Cedula", vec);
		
		sdm.createTable(sc.getMetadata("Tablita"));
		
		QueryProcessor q = new QueryProcessor();
		try {
			q.start_cli();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}