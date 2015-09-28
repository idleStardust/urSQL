package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;

import urSQL.StoredDataManager.StoreDataManager;
import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;
import urSQL.SystemCatalog.SystemCatalog;

/**
 * 
 * @author ArturoMora™
 *
 */
public class ComponentJoin 
{
	
	/**
	 *
	 */
	protected LinkedList< String > _TablesToJoin;
	
	/**
	 *
	 */
	public ComponentJoin(LinkedList< String > pTablesToJoin)
	{
		this._TablesToJoin = pTablesToJoin;
	}
	
	/**
	 *
	 */
	public ResultSet apply(ResultSet pResultSet)
	{
		
		ResultSet resultSetFinal = pResultSet;
		ResultSet resultSetTemp = null;
		
		Iterator< String > joinTableNames = this._TablesToJoin.iterator();
		
		while(joinTableNames.hasNext())
		{
			resultSetTemp = this.getTableData(joinTableNames.next());
			resultSetFinal = crossTable(resultSetFinal, resultSetTemp);
		}
		
		return resultSetFinal;
	}
	
	private ResultSet getTableData(String pName)
	{
		StoreDataManager storedDataManager = new StoreDataManager();
		
		// Table Crude Data To Insert One-To-One The Registers.
		TableData tableData = new TableData();
		
		// Charge The Crude Data From The Hard Disk
		LinkedList< LinkedList <String> > crudeData = storedDataManager.getTable(
				SystemCatalog.getInstance().getCurrentDatabase(), pName);
		
		// Iterator For The Charged Crude Data.
		Iterator< LinkedList <String> > it = crudeData.iterator();
		
		while(it.hasNext())
		{
			tableData.getData().add(new TableRegister(it.next()));
		}
		
		TableMetadata newTableMetadat = SystemCatalog.getInstance().getMetadata(pName);
		return (new ResultSet(tableData, newTableMetadat));
	}
	
	public static void main(String[] args) 
	{
		String tableName1 = "culo";
		String nombre1 = "carne";
		String tipo1 = "INTEGER";
		String nombre21 = "culitos";
		String tipo21 = "VARCHAR";
		TableAttribute pk1 = new TableAttribute(nombre1, tipo1);
		TableAttribute col11 = new TableAttribute(nombre1, tipo1);
		TableAttribute col21 = new TableAttribute(nombre21, tipo21);
		LinkedList<TableAttribute> columnas1 = new LinkedList<TableAttribute>();
		columnas1.add(col11);
		columnas1.add(col21);
		LinkedList<String> reg11 = new LinkedList<String>();
		reg11.add("2012");
		reg11.add("hector");
		LinkedList<String> reg21 = new LinkedList<String>();
		reg21.add("2013");
		reg21.add("holandes");
		TableRegister treg11 = new TableRegister(reg11);
		TableRegister treg21 = new TableRegister(reg21);
		LinkedList<TableRegister> tdata1 = new LinkedList<TableRegister>();
		tdata1.add(treg11);
		tdata1.add(treg21);
		TableData tableData1 = new TableData(tdata1);
		TableMetadata tMetaData1 = new TableMetadata(tableName1, columnas1, pk1);
		ResultSet bulldozer1 = new ResultSet(tableData1, tMetaData1);
		
		String tableName = "estudiante";
		String nombre = "ojete";
		String tipo = "INTEGER";
		String nombre2 = "artal";
		String tipo2 = "VARCHAR";
		TableAttribute pk = new TableAttribute(nombre, tipo);
		TableAttribute col1 = new TableAttribute(nombre, tipo);
		TableAttribute col2 = new TableAttribute(nombre2, tipo2);
		LinkedList<TableAttribute> columnas = new LinkedList<TableAttribute>();
		columnas.add(col1);
		columnas.add(col2);
		LinkedList<String> reg1 = new LinkedList<String>();
		reg1.add("2013");
		reg1.add("hector");
		LinkedList<String> reg2 = new LinkedList<String>();
		reg2.add("2012");
		reg2.add("holandes");
		TableRegister treg1 = new TableRegister(reg1);
		TableRegister treg2 = new TableRegister(reg2);
		LinkedList<TableRegister> tdata = new LinkedList<TableRegister>();
		tdata.add(treg1);
		tdata.add(treg2);
		TableData tableData = new TableData(tdata);
		TableMetadata tMetaData = new TableMetadata(tableName, columnas, pk);
		ResultSet bulldozer = new ResultSet(tableData, tMetaData);
		
		ComponentJoin d = new ComponentJoin(null);
		d.crossTable(bulldozer, bulldozer1).print();
		
	}
	
	/**
	 *
	 */
	public ResultSet crossTable(ResultSet pTable, ResultSet pAnotherTable)
	{
		String PKName1 = pTable.getTableMetadata().getPrimaryKey().getName();
		String PKName2 = pAnotherTable.getTableMetadata().getPrimaryKey().getName();
		
		// Position of PK in the data structure.
		int indexOfPrimaryKey1 = pTable.getTableMetadata().indexByName(PKName1);
		int indexOfPrimaryKey2 = pAnotherTable.getTableMetadata().indexByName(PKName2);
		
		Iterator< TableRegister > iteratorFromTable = 
				pTable.getTableData().getData().iterator();
		Iterator< TableRegister > iteratorToTable = 
				pAnotherTable.getTableData().getData().iterator();
		
		Iterator< String > stringIterator;
		
		TableRegister tmpRegisterFrom = null;
		TableRegister tmpRegisterTo = null;
		
		TableData newData = new TableData();
		TableMetadata newMetadata = this.crossMetadata(pTable.getTableMetadata(), 
				                                       pAnotherTable.getTableMetadata());
		while(iteratorFromTable.hasNext())
		{
			tmpRegisterFrom = iteratorFromTable.next();
			while(iteratorToTable.hasNext())
			{
				tmpRegisterTo = iteratorToTable.next();
				
				// If Primary Key Is Equal
				if(tmpRegisterFrom.getRegister().get(indexOfPrimaryKey1).
				   equalsIgnoreCase(
				   tmpRegisterTo.getRegister().get(indexOfPrimaryKey2)))
				{
					stringIterator = tmpRegisterTo.getRegister().iterator();
					while(stringIterator.hasNext())
					{
						tmpRegisterFrom.getRegister().add(stringIterator.next());
					}
					newData.getData().add(tmpRegisterFrom);
				}
			}
		}
		return (new ResultSet(newData, newMetadata));
	}
	
	public TableMetadata crossMetadata(TableMetadata pMetadata, TableMetadata pAnotherMetadata)
	{
		// New Primary Key Is The Primary Key Of The First Metadata
		TableAttribute newPK = new TableAttribute(
				pMetadata.getTableName() + "." + pMetadata.getPrimaryKey().getName(),
				pMetadata.getPrimaryKey().getType());
		
		// Create Simple Info About The New METADATA Created
		TableMetadata newMetadata = new TableMetadata(pMetadata.getTableName() + "." 
		              + pAnotherMetadata.getTableName(), newPK);
		
		// Iterators for TableMetadata's
		Iterator< TableAttribute > iteratorMeta =
				pMetadata.getTableColumns().iterator();
		
		// Temporal for adding from the used METADATA's
		TableAttribute tmpViewAttribute = null;
		
		// Get The METADATA complete information of each attribute
		// TableName.AttributeName
		while(iteratorMeta.hasNext())
		{
			tmpViewAttribute = iteratorMeta.next();
			newMetadata.getTableColumns().add(new TableAttribute(
					pMetadata.getTableName() + "." + tmpViewAttribute.getName(),
					tmpViewAttribute.getType()));			
		}
		Iterator< TableAttribute > iteratorAnotherMeta = 
				pAnotherMetadata.getTableColumns().iterator();
		
		while(iteratorAnotherMeta.hasNext())
		{
			tmpViewAttribute = iteratorAnotherMeta.next();
			newMetadata.getTableColumns().add(new TableAttribute(
					pAnotherMetadata.getTableName() + "." + tmpViewAttribute.getName(),
					tmpViewAttribute.getType()));
		}
		return (newMetadata);
	}
}
