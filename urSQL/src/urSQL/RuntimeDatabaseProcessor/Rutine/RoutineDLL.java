package urSQL.RuntimeDatabaseProcessor.Rutine;
import urSQL.System.ResultSet;

public class RoutineDLL extends Routine
{
	
	/**
	 * 
	 */
	public static String CONSTANT_CD = "CREATE_DATABASE";
	
	/**
	 * 
	 */
	public static String CONSTANT_RD= "DROP_DATABASE";
	
	/**
	 * 
	 */
	public static String CONSTANT_DD = "DISPLAY_DATABASE";
	
	/**
	 * 
	 */
	public static String CONSTANT_SD = "SET_DATABASE";
	
	/**
	 * 
	 */
	public static String CONSTANT_CT = "CREATE_TABLE";
	
	/**
	 * 
	 */
	public static String CONSTANT_AT =  "ALTER_TABLE";
	
	/**
	 * 
	 */
	public static String CONSTANT_DP =  "DROP_TABLE";
	
	/**
	 * 
	 */
	public static String CONSTANT_CI =  "CREATE_INDEX";
	
	
	public RoutineDLL(String pCommand) 
	{
		super(pCommand);
	}

	@Override
	public ResultSet execute() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
