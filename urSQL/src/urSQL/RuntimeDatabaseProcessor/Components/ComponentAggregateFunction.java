package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;

import urSQL.System.ResultSet;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

/**
 * 
 * @author Manuel Mora
 *
 */
public class ComponentAggregateFunction implements Component
{
	/**
	 * 
	 */
	protected String pFunction;
	
	
	/**
	 * 
	 */
	protected String pColumn;
	
	/**
	 * 
	 */
	
		
	public ComponentAggregateFunction(String pFunction, String pColumn) 
	{
		this.pColumn=pColumn;
		this.pFunction=pFunction;
		
	}
	
	
	@Override
	/**
	 * 
	 */
	public ResultSet apply(ResultSet pResultSet) 
	{	
		// TableData.
		switch(pFunction){
		case "AVR":
		TableData tableData = new TableData();
		
		// TableMetadata.
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
		
		// Register Of the database.
		TableRegister tmp = null;
		TableRegister count_result = new TableRegister();
		// Search Index Of Column.
		int indexOfColumn = pResultSet.getTableMetadata().indexByName(this.pColumn);
		
		// Iterator for the the all registers.
		Iterator< TableRegister > regIterator = 
				pResultSet.getTableData().getData().iterator();
		double count =0; 
		int i=0;
		// Iterate all the registers.
		while (regIterator.hasNext())
		{
			tmp = regIterator.next();
			// Modify the Column Of the list.
			count=count+Integer.parseInt(tmp.getRegister().get(indexOfColumn));
			i++;
		}
		double aver=(double)(count/(i));
		String resultado= Double.toString(aver);
		// Add to the new TableData.
		count_result.getRegister().addFirst(resultado);
		tableData.getData().add(count_result);	
		
		return (new ResultSet(tableData, tableMetadata));
		
		
		case "COUNT":
		TableData tableData1 = new TableData();
		
		// TableMetadata.
		TableMetadata tableMetadata1 = pResultSet.getTableMetadata();
		
		// Register Of the database.
		TableRegister tmp1 = null;
		TableRegister count_result1 = new TableRegister();
		// Search Index Of Column.
		int indexOfColumn1 = pResultSet.getTableMetadata().indexByName(this.pColumn);
		
		// Iterator for the the all registers.
		Iterator< TableRegister > regIterator1 = 
				pResultSet.getTableData().getData().iterator();
		int count1 =0; 
		int i1=0;
		// Iterate all the registers.
		while (regIterator1.hasNext())
		{
			tmp1 = regIterator1.next();
			// Modify the Column Of the list.
			count=count1+Integer.parseInt(tmp1.getRegister().get(indexOfColumn1));
			i1++;
		}
		double aver1=i1;
		String resultado1= String.valueOf(aver1);
		// Add to the new TableData.
		count_result1.getRegister().addFirst(resultado1);
		tableData1.getData().add(count_result1);	
		return (new ResultSet(tableData1, tableMetadata1));
		
		
		case "MAX":
			TableData tableData2 = new TableData();
			
			// TableMetadata.
			TableMetadata tableMetadata2 = pResultSet.getTableMetadata();
			
			// Register Of the database.
			TableRegister tmp2 = null;
			TableRegister count_result2 = new TableRegister();
			// Search Index Of Column.
			int indexOfColumn2 = pResultSet.getTableMetadata().indexByName(this.pColumn);
			
			// Iterator for the the all registers.
			Iterator< TableRegister > regIterator2 = 
					pResultSet.getTableData().getData().iterator();
			double var1=0;
			double var2;
			
		
			// Iterate all the registers.
			while (regIterator2.hasNext())
			{
				tmp2 = regIterator2.next();
				// Modify the Column Of the list.
				var2=Integer.parseInt(tmp2.getRegister().get(indexOfColumn2));
				if(var1<var2){
					var1=var2;
				}
				
				
			}
			double aver2=var1;
			String resultado2= String.valueOf(aver2);
			// Add to the new TableData.
			count_result2.getRegister().addFirst(resultado2);
			tableData2.getData().add(count_result2);	
			return (new ResultSet(tableData2, tableMetadata2));
			
			
		case "MIN":
			TableData tableData3 = new TableData();
			
			// TableMetadata.
			TableMetadata tableMetadata3 = pResultSet.getTableMetadata();
			
			// Register Of the database.
			TableRegister tmp3 = null;
			TableRegister count_result3 = new TableRegister();
			// Search Index Of Column.
			int indexOfColumn3 = pResultSet.getTableMetadata().indexByName(this.pColumn);
			
			// Iterator for the the all registers.
			Iterator< TableRegister > regIterator3 = 
					pResultSet.getTableData().getData().iterator();
			double var3=900000000;
			double var4;
			
			
			// Iterate all the registers.
			while (regIterator3.hasNext())
			{
				tmp3 = regIterator3.next();
				// Modify the Column Of the list.
				var4=Integer.parseInt(tmp3.getRegister().get(indexOfColumn3));
				if(var3 > var4){
					var3= var4;
				}
				
				
			}
			double aver3=var3;
			String resultado3= String.valueOf(aver3);
			// Add to the new TableData.
			count_result3.getRegister().addFirst(resultado3);
			tableData3.getData().add(count_result3);	
			return (new ResultSet(tableData3, tableMetadata3));
	}
	return null;	
	}	
}