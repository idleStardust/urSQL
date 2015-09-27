package urSQL.SystemCatalog;

import urSQL.System.TableData;
import urSQL.System.TableMetadata;

public class SystemCatalog 
{
    private static SystemCatalog INSTANCE = new SystemCatalog();
    
    public String _CurrentDatabase;
    
    public void setCurrentDatabase(String pCurrentDatabase)
    {

    	this._CurrentDatabase = pCurrentDatabase;
    }
    
    public String getCurrentDatabase()
    {
    	return (this._CurrentDatabase);
    }
    
    private SystemCatalog() 
    {
    }

    public static SystemCatalog getInstance() 
    {
        return INSTANCE;
    }
    
    /** 
     *  Verifica que la tabla exista en la base de datos actual.
     *  @param  String  tableName
     *  @return boolean tableExist?
     */ 
    public boolean tableExists(String pTableName)
    {
    	// Busca en el esquema la existencia de la tabla.
    	return true;
    }
    
    /**  
     *  Verifica que la columna exista en la base de datos actual.
     *  @param  String  tableName, String columnName
     *  @return boolean columnExist?
     */  
    public boolean columExists(String pTableName, String pColumnName)
    {
    	// Busca en la tabla la columna deseada.
    	return true;
    }
    
    
    public TableMetadata recoveryTableMetadata(String pTabla)
    {
    	return null;
    }
}