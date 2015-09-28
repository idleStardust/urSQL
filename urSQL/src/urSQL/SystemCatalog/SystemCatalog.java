package urSQL.SystemCatalog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Vector;

import urSQL.StoredDataManager.Pair;
import urSQL.StoredDataManager.BplusJ.xBplusTreeBytes;
import urSQL.System.TableAttribute;
import urSQL.System.TableMetadata;

public class SystemCatalog 
{
/*-*-*-*-*-*-*-*-*-*-*Banderas*-*-*-*-*-*-*-*-*-*-*-*/
	
	/**
	 * Byte que representa booleano true
	 */
	private static byte BYTE_TRUE = 0X1;
	/*
	 * byte que representa booleano false
	 */
	private static byte BYTE_FALSE = 0X0;
	
	
	/*-*-*-*-*-*-*-*-*-*-*-*-*Tipos de datos*-*-*-*-*-*-*-*-*-*-*-*-*/

	/**
	 * Byte de tipo entero
	 */
	private static final byte BY_TYPE_INTEGER = (byte)0x00;
	/**
	 * Byte de tipo char
	 */
	private static final byte BY_TYPE_CHAR = (byte)0x02;
	/**
	 * Byte de tipo varchar
	 */
	private static final byte BY_TYPE_VARCHAR = (byte)0x03;
	/**
	 * Byte de tipo decimal, como el float
	 */
	private static final byte BY_TYPE_DECIMAL = (byte)0x01;
	/**
	 * Byte de tipo fecha
	 */
	private static final byte BY_TYPE_DATETIME = (byte)0x04;
	
	/*******************Strings para archivos**********************/
	
	/**
	 * Separador de en las direcciones de archivos
	 */
	private static final String FILE_SEPARATOR = File.separator;
	/**
	 * Este es la direcciï¿½n donde se van a almacenar las bases de datos.
	 */
	private static final String SYSTEM_CATALOG_PATH = System.getProperty("user.dir") + FILE_SEPARATOR +"SYSTEM_CATALOG";
	/**
	 * Sufijo del nombre de los archivos de arbol
	 */
	private static final String TREE_SUFIX = "_TREE";
	/**
	 * Sufijo del nombre de los archivos de bloques de informacion
	 */
	private static final String BLOCKS_SUFFIX = "_BLOCKS";
	/**
	 * Sufijo que identifica los archivos de informaciï¿½n de tabla
	 */
	private static final String INFORMATION = "_INFORMATION";
	/**
	 * Sufijo que identifica los archivos de referencias
	 */
	private static final String REFERENCES = "_REFERENCES";
	/**
	 * Key para determinar el tipo de arbol
	 */
	private static final String TREE_TYPE = " TYPE";
	
	/*-*-*-*-*-*-*-*-*-*-*-*-*Keys imporantes para la tabla de informacion*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
	
	/**
	 * contiene nombre de la llavae primaria
	 */
	private static final String PK_KEY = " PRIMARY_KEY";
	/**
	 * nombre de la tabla
	 */
	private static final String TABLE_NAME = " TABLE_NAME";
	/**
+	 * cantidad de columnas 
	 */
	private static final String QUANT_COL = " QU_CL";
	
	
	/*-*-*-*-*-*-*-*-*-*-*-*-*Keys imporantes para la tabla de referencias*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
	
	private static final String QUANT_REF = " REF";
	
	/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*String types*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
	/**
	 *
	 */
	private static final String INTEGER = "0";
	/**
	 * 
	 */
	private static final String DECIMAL = "1";
	/**
	 * 
	 */
	private static final String CHAR = "2";
	/**
	 * 
	 */
	private static final String VARCHAR = "3";
	/**
	 * 
	 */
	private static final String DATETIME = "4";
	
	private String database_name;
	
	/**
	 * Crea la estructura de archivos y carpetas del
	 * System Catalog
	 */
	private SystemCatalog(){
		//verifica que exista la carpeta del System Catalog
		File system_catalog = new File(SYSTEM_CATALOG_PATH);
		//verifica que exista la carpeta 
		if(system_catalog.exists()){
			//bandera de verificacion
			boolean result = false;
			result = system_catalog.mkdirs();
			if(!result){
				System.err.format("No se pudo crear la carpeta %s\n", SYSTEM_CATALOG_PATH);
			}else{
				System.out.format("La carpeta a sido creada exitosamente\n");
			}
		}else{
			System.out.format("La carpeta ya ha sido creada\n");
		}
	}
	
	/**
	 * Crea la carpeta donde se guardan los archivos de las 
	 * tabas para una base de datos
	 * 
	 * @param database_name nombre de la base de datos
	 */
	public void addDatabase(String database_name){
		//crea el file de la ubicaciï¿½n de bases de datos 
		File database = new File(SYSTEM_CATALOG_PATH + FILE_SEPARATOR + database_name);
		//si el archivo ya existe
		if(database.exists()){
			System.err.format("La base de datos con el nombre %s ya existe\n", database_name);
		}
		//si no existe
		else{
			boolean result = database.mkdirs();
			if(!result){
				System.err.format("La base de datos con el nombre %s no pudo ser creada\n", database_name);
			}else{
				System.out.format("La base de datos con el nombre %s fue creada exitosamente\n", database_name);
			}
		}
	}
	
	/**
	 * Se elige una base de datos para trabajar
	 * 
	 * @param database_name nombre de la base de 
	 * datos
	 */

	public void setDatabase(String database_name){
		File database = new File(SYSTEM_CATALOG_PATH + FILE_SEPARATOR +database_name);
		
		if(database.exists()){
			this.database_name = database_name;
		}
		else{
			System.err.format("La base de datos %s no existe\n", database_name);
		}
	}
	
	
	/**
	 * Agrega una tabla a la carpeta de la base de 
	 * datos 
	 * 
	 * @param database_name nombre de la base de datos
	 * 
	 * @param table_name nombre de la tabla
	 */
	public void addTable(String table_name, String pk, Vector<Vector<String>> vec){
		//verifica que exista
		File database = new File(SYSTEM_CATALOG_PATH + FILE_SEPARATOR + database_name);
		
		if(!database.exists()){
			System.err.format("La base de datos %s no ha sido creada\n", database_name);
		}
		else{
			//se crea un file de una carpeta donde van a almacenarse todos los archivos de una tabla
			File table = new File(database, table_name);
			//verifica si existe la tabla
			if(table.exists()){
				System.err.format("La tabla %s ya fue creada en la base %s\n", table_name, database_name);
			}
			//crea las tablas si no existe
			else{
				//crea la nueva carpeta
				boolean is_made = table.mkdirs();
				//si la carpeta no fue creada
				if(!is_made){
					System.err.format("No pudo crearse la carpeta para la tabla %s\n", table_name);
				}
				//si el archivo si se creo
				else{
					//nombres de los archivos para cada tabla 
					String inf_file = table_name + INFORMATION;
					String ref_file = table_name + REFERENCES;
					
					//crea los files
					//files de informacion
					File inf_file_tree = new File(table, inf_file + TREE_SUFIX);
					File inf_file_blocks = new File(table, inf_file + BLOCKS_SUFFIX);
					//files de referencias
					File ref_file_tree = new File(table, ref_file + TREE_SUFIX);
					File ref_file_blocks = new File(table, ref_file + BLOCKS_SUFFIX);
					//se crean los arboles
					try {
						xBplusTreeBytes tree_inf = xBplusTreeBytes.Initialize(new RandomAccessFile(inf_file_tree, "rw"), 
								new RandomAccessFile(inf_file_blocks, "rw"), 10);
						
						xBplusTreeBytes tree_ref = xBplusTreeBytes.Initialize(new RandomAccessFile(ref_file_tree, "rw"), 
								new RandomAccessFile(ref_file_blocks, "rw"), 10);
						
						tree_inf.set(TREE_TYPE, INFORMATION.getBytes());
						tree_ref.set(TREE_TYPE, REFERENCES.getBytes());
						
						tree_inf.set(TABLE_NAME, table_name.getBytes());
						
						tree_ref.set(QUANT_REF, short2bytes((short)0));
						
						tree_inf.set(PK_KEY, pk.getBytes());
						
						byte[] quantity = ByteBuffer.allocate(2).putShort((short)vec.size()).array();
						
						tree_inf.set(QUANT_COL, quantity);
						
						Vector<byte[]>  registers = convertStr2Byte(vec);
						
						for(int i = 0; i  < registers.size(); i++){
							tree_inf.set(vec.get(i).get(0), registers.get(i));
						}
						
						tree_inf.Commit();
						tree_ref.Commit();
						
						tree_inf.Shutdown();
						tree_ref.Shutdown();
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}
		}
	}	
	
	/**
	 * Convierte el vector de vectores de strings a 
	 * un vector de registros de bytes
	 * 
	 * @param vec vector de vectores con la metadata
	 * 
	 * @return vector con los registros en bytes
	 */
	private Vector<byte[]> convertStr2Byte(Vector<Vector<String>> vec){
		
		Vector<byte[]> registers = new Vector<byte[]>();
		
		for (int i = 0; i < vec.size(); i++) {
			byte[] register = convertStr2ByteAux(vec.get(i));
			registers.addElement(register);
		}
		
		return registers;
	}
	
	/**
	 * Convierte un vector de string en un registro 
	 * de bytes
	 * 
	 * @param vec vector de string con la metadata
	 * 
	 * @return arreglo de bytes con la informaciï¿½n
	 */
	private byte[] convertStr2ByteAux(Vector<String> vec){
		//nombre
		byte[] b_name = vec.get(0).getBytes();
		byte[] b_name_size = short2bytes((short)b_name.length);
		
		byte[] reg_name = byteArrayConcatenate(b_name_size, b_name);
		//tipo y constraint
		byte[] inf = new byte[2];
		
		switch(vec.get(4)){
		case INTEGER:
			inf[0] = BY_TYPE_INTEGER;
			break;
		case DECIMAL:
			inf[0] = BY_TYPE_DECIMAL;
			break;
		case CHAR:
			inf[0] = BY_TYPE_CHAR;
			break;
		case VARCHAR:
			inf[0] = BY_TYPE_VARCHAR;
			break;
		case DATETIME:
			inf[0] = BY_TYPE_DATETIME;
			break;
		}
		
		switch(vec.get(1)){
		case "0":
			inf[1] = BYTE_FALSE;
			break;
		case "1":
			inf[1] = BYTE_TRUE;
			break;
		}
		//presicion
		byte[] pres1 = short2bytes((short) Integer.parseInt(vec.get(2)));
		byte[] pres2 = short2bytes((short) Integer.parseInt(vec.get(3)));
		
		byte[] pres = byteArrayConcatenate(pres1, pres2);
		
		byte[] result = byteArrayConcatenate(reg_name, inf);
		
		result = byteArrayConcatenate(result, pres);
		//registro total
		return result;
	}
	
	/**
	 * Se crea una nueva referencia
	 * 
	 * @param database_name nombre de la base de datos
	 * 
	 * @param table1 tabla uno
	 *  
	 * @param column1 columna de la tabla1
	 * 
	 * @param table2 tabla 2
	 * 
	 * @param column2 columna de la tabla 2
	 */
	public void addReference(String table1, String column1, String table2, String column2){
		//verifica que exista
		File database = new File(SYSTEM_CATALOG_PATH + FILE_SEPARATOR + database_name);
				
		if(!database.exists()){
			System.err.format("La base de datos %s no ha sido creada\n", database_name);
		}
		else{
			//se crea un file de una carpeta donde van a almacenarse todos los archivos de una tabla
			File table = new File(database, table1);
			//verifica si existe la tabla
			if(!table.exists()){
				System.err.format("La tabla %s no se encuentra en la base %s\n", table1, database_name);
			}
			//si existe 
			else{
				//se crean archivos para referencias
				String ref_file = table1 + REFERENCES;
				
				File ref_file_tree = new File(table, ref_file + TREE_SUFIX);
				File ref_file_blocks = new File(table, ref_file + BLOCKS_SUFFIX);
				//se crea el arbol
				try {
					xBplusTreeBytes tree_ref = xBplusTreeBytes.Initialize(new RandomAccessFile(ref_file_tree, "rw"), 
							new RandomAccessFile(ref_file_blocks, "rw"), 10);
					
					byte[] register = addReferenceAux(column1, table2, column2);
					
					tree_ref.set(column1, register);
					
					tree_ref.Commit();
					tree_ref.Shutdown();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Crea un registro a partir de estos parï¿½metros
	 * 
	 * @param column1 columna 1
	 * 
	 * @param table2 tabla 2
	 * 
	 * @param column2 columna 2
	 * 
	 * @return arreglo de bytes que representan los valores anteriores
	 */
	private byte[] addReferenceAux(String column1, String table2, String column2){
		//registros de bytes
		byte[] b_column1 = column1.getBytes();
		byte[] b_table2 = table2.getBytes();
		byte[] b_column2 = column2.getBytes();
		//regisros de bytes con el tamaño
		b_column1 = byteArrayConcatenate(short2bytes((short)b_column1.length), b_column1);
		b_table2 = byteArrayConcatenate(short2bytes((short)b_table2.length), b_table2);
		b_column2 = byteArrayConcatenate(short2bytes((short)b_column2.length), b_column2);
		//re hace le registro final
		byte[] result = byteArrayConcatenate(b_column1, b_table2);
		result = byteArrayConcatenate(result, b_column2);
		
		return result;
	}
	
	/**
	 * Concatena dos arreglos de bytes creando un nuevo arreglo
	 * 
	 * @param by_array1 primer arreglo a concatenar que va al
	 * inicio del nuevo arreglo
	 * 
	 * @param by_array2 segundo arreglo a concatenar que va al
	 * final del nuevo arreglo
	 * 
	 * @return un nuevo arreglo con los dos arreglos concatenados
	 */
	private byte[] byteArrayConcatenate(byte[] by_array1, byte[] by_array2){
		byte[] res = new byte[by_array1.length + by_array2.length];
		
		for (int i = 0; i < by_array1.length; i++) {
			res[i] = by_array1[i];
		}
		
		for (int i = 0; i < by_array2.length; i++) {
			res[by_array1.length+i] = by_array2[i];
		}
		
		return res;
	}
	
	/**
	 * Convierte un short a un arreglo de bytes
	 * 
	 * @param num short que se va a convertir
	 * 
	 * @return arreglo de bytes que representa el short 
	 */
	private byte[] short2bytes(short num){
		return ByteBuffer.allocate(2).putShort(num).array();
	}
	
	/**
	 * Elimina la carpeta, elimimna los archivos dentro
	 * si es necesario o si hay en el directorio.
	 * 
	 * @param database Nombre de la base de datos a 
	 * eliminar.
	 */
	private void recursiveFileDelete(File database){
		//Esta pila es utilizada para eliminar los archivos 
		//dentro de los directorios
		java.util.Stack<File> stack = new java.util.Stack<File>();
		//Se agrega el directorio inicial
		stack.push(database);
		
		while(!stack.isEmpty()){
			File tmp = stack.pop();
			//si es un archivo se borra inmediatamente
			if(tmp.isFile()){
				tmp.delete();
			}
			//si es un directorio
			else if(tmp.isDirectory()){
				File[] tmp_array = tmp.listFiles();
				//si no es directorio o un error de I/O
				if(tmp_array == null){
					System.err.format("El archivo de nombre %s, no es un directorio o hubo un error de I/O"
							+ "\nla direccion abosulta es %s\n", 
							tmp.getName(), tmp.getAbsolutePath());
					break;
				}
				//si el directorio esta vacio se elimina inmediatamente
				else if(tmp_array.length == 0){
					tmp.delete();
				}
				//si el directorio esta lleno
				else if(tmp_array.length > 0){
					stack.push(tmp);
					
					for (int i = 0; i < tmp_array.length; i++) {
						//si es un archivo se elimina directamente
						if(tmp_array[i].isFile()){
							tmp_array[i].delete();
						}
						//si es un directorio se agrega a la pila
						else if(tmp_array[i].isDirectory()){
							stack.push(tmp_array[i]);
						}
					}
				}
			}
		}
	}

	/**
	 * Get the Name Of the Actual Database
	 * @return
	 */
	public String getCurrentDatabase()
	{
		return this.database_name;
	}
	

    private static SystemCatalog INSTANCE = new SystemCatalog();
    
    public static SystemCatalog getInstance() 
    {
        return INSTANCE;
    }
	/**
	 * Elimina una base de datos
	 * 
	 * @param database_name elimina una base de datos
	 */
    public void dropDatabase(String database_name){
    	//archivo 
    	File database = new File(SYSTEM_CATALOG_PATH + FILE_SEPARATOR + database_name);
    	
    	if(!database.exists()){
    		System.err.format("La base de datos %s no existe\n", database_name);
    	}
    	else{
    		recursiveFileDelete(database);
    	}
    }

    /**
     * Se elimina la tabla de la base de datos
     * 
     * @param table_name nombre de la tabla
     */
    public void dropTable(String table_name){
    	File database = new File(SYSTEM_CATALOG_PATH + FILE_SEPARATOR + database_name);
    	if(!database.exists()){
    		System.err.format("La base de datos %s no existe\n", database_name);
    	}
    	else{
    		File table = new File(database, table_name);
    		if(!table.exists()){
    			System.err.format("La tabla %s no existe en la base de datos\n" , table_name);
    		}
    		else{
    			recursiveFileDelete(table);
    		}
    	}
    }

    /**
     * Retorna la metadata de una tabla
     * 
     * @param table_name nombre de la tabla 
     * 
     * @return metadata de una tabla
     */
    public TableMetadata getMetadata(String table_name){
    	
    	LinkedList<TableAttribute> list = new LinkedList<TableAttribute>();
    	
    	File database = new File(SYSTEM_CATALOG_PATH + FILE_SEPARATOR + database_name);
    	
    	if(!database.exists()){
    		System.err.format("No existe la carpeta de las bases de datos");
    	}
    	else{
    		//crea la tabla de la base 
    		File table = new File(database, table_name);
    		
    		if(!table.exists()){
    			System.err.format("No hay tabla %s en la base", table_name);
    		}
    		else{
    			//se crea el arbol
    			String inf_file = table_name + INFORMATION;
    			
    			File inf_file_tree = new File(table, inf_file + TREE_SUFIX);
				File inf_file_blocks = new File(table, inf_file + BLOCKS_SUFFIX);
				
				if(!inf_file_tree.exists() || !inf_file_blocks.exists()){
					System.err.format("Los archivos de la tabla %s estan corrompidos\n", table_name);
				}
				
				else{
					try {
						xBplusTreeBytes tree_inf = xBplusTreeBytes.ReOpen(new RandomAccessFile(inf_file_tree, "rw"), 
								new RandomAccessFile(inf_file_blocks, "rw"));
						//se obtiene la primera llave del arbol
						String key = tree_inf.NextKey(TREE_TYPE);
						//se consigue lista de atributos
						while(key != null){
							TableAttribute ta = getMetadataAux(tree_inf.get(key));
							list.add(ta);
							key = tree_inf.NextKey(key);
						}
						//nombre de la columna que es llave primaria
						String pk = new String(tree_inf.get(PK_KEY));
						
						int pk_index = -1;
						
						for(int i =0; i< list.size(); i++){
							if(pk.compareTo(list.get(i).getName()) == 0){
								pk_index = i;
								break;
							}
						}
						
						TableMetadata tm = new TableMetadata(table_name, list, list.get(pk_index));
						
						return tm;
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
    		}
    	}
    	
    	
    	return null;
    }

    /**
     * Convierte un registro en un TableAttribute 
     * 
     * @param register registro de bytes 
     * @return
     */
    private TableAttribute getMetadataAux(byte[] register){
    	int size = ByteBuffer.wrap(register).getShort();
    	
    	String name = new String(register,2,size);
    	
    	byte type = register[size+2];
    	
    	String str_type = "";
    	
    	switch(type){
    		case BY_TYPE_INTEGER:
    			str_type = TableAttribute.TYPE_INT;
    			break;
    		case BY_TYPE_DECIMAL:
    			str_type = TableAttribute.TYPE_DECIMAL;
    			break;
    		case BY_TYPE_CHAR:
    			str_type = TableAttribute.TYPE_CHAR;
    			break;
    		case BY_TYPE_VARCHAR:
    			str_type = TableAttribute.TYPE_VARCHAR;
    			break;
    		case BY_TYPE_DATETIME:
    			str_type = TableAttribute.TYPE_DATETIME;
    			break;
    	}
    	
    	return new TableAttribute(name, str_type);
    }
    
    /**
     * Verifica si una columna tiene referencias
     * 
     * @param table_name nombre de la tabla
     * 
     * @param column_name nombre de la columna
     * 
     * @return true si esta dentro del árbol y false
     * en cualquier otro caso
     */
    public boolean isHaveReferences(String table_name, String column_name){
    	boolean result = false;
    	
    	File database = new File(database_name);
    	//si el archivo no existe
    	if(!database.exists()){
    		System.err.format("La base de datos %s no existe\n", database_name);
    	}
    	//si la base existe
    	else{
    		File table = new File(database, table_name);
    		//Si la tabla no existe
    		if(!table.exists()){
    			System.err.format("La tabla no existe en la base de datos\n");
    		}
    		//si la tabla existe
    		else{
    			String ref_file = table_name + REFERENCES;
    			//files de referencias
				File ref_file_tree = new File(table, ref_file + TREE_SUFIX);
				File ref_file_blocks = new File(table, ref_file + BLOCKS_SUFFIX);
				//se crea el arbol
				try {
					xBplusTreeBytes tree_ref = xBplusTreeBytes.ReOpen(new RandomAccessFile(ref_file_tree, "rw"), 
							new RandomAccessFile(ref_file_blocks, "rw"));
					//verfiica si la columna tiene alguna referencia
					result = tree_ref.ContainsKey(column_name);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	
    	return result;
    }
    
    /**
     * Retorna la referencia de otra tabla
     * 
     * @param table_name nombre de la tabla
     * 
     * @param column_name nombre de la columna
     * 
     * @return par con el nombre de la columna y 
     * la tabla a la cual se le hace la referencia
     */
    public Pair<String, String> getReference(String table_name, String column_name){
    	File database = new File(database_name);
    	//si el archivo no existe
    	if(!database.exists()){
    		System.err.format("La base de datos %s no existe\n", database_name);
    	}
    	
    	else{
    		File table = new File(database, table_name);
    		//Si la tabla no existe
    		if(!table.exists()){
    			System.err.format("La tabla no existe en la base de datos\n");
    		}
    		//si la tabla existe
    		else{
    			String ref_file = table_name + REFERENCES;
    			//files de referencias
				File ref_file_tree = new File(table, ref_file + TREE_SUFIX);
				File ref_file_blocks = new File(table, ref_file + BLOCKS_SUFFIX);
				//se crea el arbol
				try {
					xBplusTreeBytes tree_ref = xBplusTreeBytes.ReOpen(new RandomAccessFile(ref_file_tree, "rw"), 
							new RandomAccessFile(ref_file_blocks, "rw"));
					
					byte[] reference = tree_ref.get(column_name);
					
					Pair<String, String> ref = getReferenceAux(reference);
					
					return ref;
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	
    	
    	return null;
    }
    
    /**
     * Crea un pair a partir del byte
     * 
     * @param reference array de bytes 
     * 
     * @return retorna un par de string
     * con el nombre de la tabla y el
     * nombre de la columna
     */
    private Pair<String,String> getReferenceAux(byte[] reference){
    	int sizeCn1 = (int) ByteBuffer.wrap(reference).getShort();
    	String column1_name = new String(reference, 2, sizeCn1);
    	
    	int sizeT2 = (int) ByteBuffer.wrap(reference).getShort(2+sizeCn1);
    	String table2_name = new String(reference, 2+sizeCn1+2, sizeT2);
    	
    	int sizeCn2 = (int) ByteBuffer.wrap(reference).getShort(2+sizeCn1+2+sizeT2);
    	String column2_name = new String(reference, 2+sizeCn1+2+sizeT2+2, sizeCn2);
    	
    	Pair<String, String> ref = new Pair<String, String>(table2_name, column2_name);
    	
    	return ref;
    }
    
}