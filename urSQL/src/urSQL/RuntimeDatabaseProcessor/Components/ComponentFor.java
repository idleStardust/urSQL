package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;

public class ComponentFor implements Component
{
	/**
	 *  Constant for XML type
	 */
	public static String TYPE_XML = "XML";
	
	/**
	 *  Constant for JSON type
	 */
	public static String TYPE_JSON = "JSON";
	
	/**
	 *  Type Requested for output
	 */
	protected String _FormatType;
	
	public ComponentFor(String pType)
	{
		this._FormatType = pType;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		// Converts the table data to XML or JSON
		@SuppressWarnings("unused")
		String dataInFormat;
		//------- Type: XML -------
		if (this._FormatType.equals(ComponentFor.TYPE_XML))
		{
			dataInFormat = this.convertToJson(pResultSet);
		}
		//------- Type: JSON-------
		if (this._FormatType.equals(ComponentFor.TYPE_JSON))
		{
			dataInFormat = this.convertToJson(pResultSet);
		}
		return null;
	}
	
	/**
	 *  This converts a @ResultSet to a XML file.
	 */
	public String convertToXML(ResultSet pResultSet)
	{
		return "helloBitchImXML";
	}
	
	/**
	 *  This converts a @ResultSet to a JSON file.
	 */
	public String convertToJson(ResultSet pResultSet)
	{
		return "helloBitchImJson";
	}
}