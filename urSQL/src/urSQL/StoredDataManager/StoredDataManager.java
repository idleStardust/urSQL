package urSQL.StoredDataManager;


public class StoredDataManager 
{
	
    private static StoredDataManager INSTANCE = new StoredDataManager();

    private StoredDataManager() {}

    public static StoredDataManager getInstance() 
    {
        return INSTANCE;
    }
    
}
