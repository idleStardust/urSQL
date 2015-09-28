package urSQL.RuntimeDatabaseProcessor.Components;

import urSQL.System.ResultSet;
import urSQL.System.Serializer;
import urSQL.System.TableAttribute;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

/**
 * 
 * @author ArturoMora™
 *
 */
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
		// Converts the Result Set to a Standard Communicator File
		String dataInFormat = "";
		
		// Converts To A XML File
		if (this._FormatType.equals(ComponentFor.TYPE_XML))
		{
			dataInFormat = this.convertToXML(pResultSet);
		}
		
		// Converts To A JSON File
		if (this._FormatType.equals(ComponentFor.TYPE_JSON))
		{
			dataInFormat = this.convertToJson(pResultSet);
		}
		
		// Table Data of the ResultSet
		TableRegister tableRegister = new TableRegister();
		tableRegister.getRegister().add(dataInFormat);
		TableData tableData = new TableData();
		tableData.getData().add((tableRegister));
		
		// METADATA of the ResultSet
		TableAttribute tableAttribute = new TableAttribute(this._FormatType, TableAttribute.TYPE_CHAR);
		TableMetadata tableMetadata = new TableMetadata("ResultSet In Format", tableAttribute);
		tableMetadata.getTableColumns().add(tableAttribute);
		
		return (new ResultSet(tableData, tableMetadata));
	}
	
	/**
	 *  This converts a @ResultSet to a XML file.
	 */
	public String convertToXML(ResultSet pResultSet)
	{
		Serializer d = new Serializer(pResultSet);
		return d.serialize();
	}
	
	/**
	 *  This converts a @ResultSet to a JSON file.
	 */
	public String convertToJson(ResultSet pResultSet)
	{
		Serializer d = new Serializer(pResultSet);
		return d.serializeJson();
	}
}