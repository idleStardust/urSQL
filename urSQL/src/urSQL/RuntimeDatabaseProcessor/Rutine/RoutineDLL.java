package urSQL.RuntimeDatabaseProcessor.Rutine;
import urSQL.System.ResultSet;

public class RoutineDLL extends Routine
{
	
	/**
	 * 
	 */
	public static final String CONSTANT_CD = "CREATE_DATABASE";
	
	/**
	 * 
	 */
	public static final String CONSTANT_RD= "DROP_DATABASE";
	
	/**
	 * 
	 */
	public static final String CONSTANT_DD = "DISPLAY_DATABASE";
	
	/**
	 * 
	 */
	public static final String CONSTANT_SD = "SET_DATABASE";
	
	/**
	 * 
	 */
	public static final  String CONSTANT_CT = "CREATE_TABLE";
	
	/**
	 * 
	 */
	public static final String CONSTANT_AT =  "ALTER_TABLE";
	
	/**
	 * 
	 */
	public static final String CONSTANT_DP =  "DROP_TABLE";
	
	/**
	 * 
	 */
	public static final String CONSTANT_CI =  "CREATE_INDEX";
	
	
	public RoutineDLL(String pCommand) 
	{
		super(pCommand);
	}

	@Override
	public ResultSet execute() 
	{
		return runPlan();
	}

}
