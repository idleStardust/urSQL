package urSQL.System;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import com.google.gson.Gson;

public class Serializer 
{
	private ResultSet rs;

	public Serializer(ResultSet rs)
	{
		this.rs = rs;
	}

	public ResultSet getResultSet()
	{
		return this.rs;
	}
	
	public static void main(String[] args) 
	{
		String tableName = "estudiante";
		String nombre = "carne";
		String tipo = "INTEGER";
		String nombre2 = "nombre";
		String tipo2 = "VARCHAR";
		TableAttribute pk = new TableAttribute(nombre, tipo);
		TableAttribute col1 = new TableAttribute(nombre, tipo);
		TableAttribute col2 = new TableAttribute(nombre2, tipo2);
		LinkedList<TableAttribute> columnas = new LinkedList<TableAttribute>();
		columnas.add(col1);
		columnas.add(col2);
		LinkedList<String> reg1 = new LinkedList<String>();
		reg1.add("2012");
		reg1.add("hector");
		LinkedList<String> reg2 = new LinkedList<String>();
		reg2.add("2013");
		reg2.add("holandes");
		TableRegister treg1 = new TableRegister(reg1);
		TableRegister treg2 = new TableRegister(reg2);
		LinkedList<TableRegister> tdata = new LinkedList<TableRegister>();
		tdata.add(treg1);
		tdata.add(treg2);
		TableData tableData = new TableData(tdata);
		TableMetadata tMetaData = new TableMetadata(tableName, columnas, pk);
		ResultSet bulldozer = new ResultSet(tableData, tMetaData);
		Serializer culo = new Serializer(bulldozer);
		culo.serializeJson();
	}
	public String serialize()
	{
		String tableName = this.rs.getTableMetadata().getTableName();
		LinkedList<TableAttribute> columns = this.rs.getTableMetadata().getTableColumns();
		LinkedList<TableRegister> regs = this.rs.getTableData().getData();

		try 
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			Element rootElement = doc.createElement("table");
         		doc.appendChild(rootElement);

			Element table = doc.createElement(tableName);
         		rootElement.appendChild(table);

			for (int i = 0; i < regs.size(); i++) 
			{
				Element column = doc.createElement("row");
				for (int j = 0; j < regs.get(i).getRegister().size(); j++)
				{
					Attr colName = doc.createAttribute(columns.get(j).getName());
		 			colName.setValue(regs.get(i).getRegister().get(j));
		 			column.setAttributeNode(colName);
		 			table.appendChild(column);		
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("table.xml"));
			transformer.transform(source, result);

			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
			
			StringWriter outWriter = new StringWriter();
			StreamResult extremeResult = new StreamResult( outWriter );
			transformer.transform( source, extremeResult); 
			StringBuffer sb = outWriter.getBuffer(); 
			return sb.toString();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return ( "Error" );
		}
	}

	public String serializeJson() 
	{
		Gson gson = new Gson();
		String json = gson.toJson(this.rs);

		try {
			FileWriter writer = new FileWriter("table.json");
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return json;
	}
}