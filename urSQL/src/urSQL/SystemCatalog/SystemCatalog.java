package urSQL.SystemCatalog;

public class SystemCatalog 
{
    private static SystemCatalog INSTANCE = new SystemCatalog();

    private SystemCatalog() {}

    public static SystemCatalog getInstance() 
    {
        return INSTANCE;
    }
    

}
