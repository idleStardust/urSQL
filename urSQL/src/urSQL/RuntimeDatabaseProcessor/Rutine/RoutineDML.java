package urSQL.RuntimeDatabaseProcessor.Rutine;
import java.util.LinkedList;

import urSQL.RuntimeDatabaseProcessor.Components.Component;
import urSQL.System.ResultSet;

public class RoutineDML extends Routine
{
	/**
	 * 
	 */
	public static String CONSTANT_SELECT = "SELECT";
	
	/**
	 * 
	 */
	public static String CONSTANT_INSERT = "INSERT";
	
	
	/**
	 * 
	 */
	public static String CONSTANT_DELETE = "DELETE";
	
	
	/**
	 * 
	 */
	public static String CONSTANT_SET = "SET";
	
	
	/**
	 * 
	 */
	public RoutineDML(String pCommand, LinkedList<Component> pComponents) 
	{
		super(pCommand, pComponents);
	}

	@Override
	public ResultSet execute() 
	{
		return null;
	}

}
