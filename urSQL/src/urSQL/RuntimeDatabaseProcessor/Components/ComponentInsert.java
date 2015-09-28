package urSQL.RuntimeDatabaseProcessor.Components;

import java.util.Iterator;
import java.util.LinkedList;

import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

/**
 * 
 * @author ArturoMora
 *
 */
public class ComponentInsert implements Component 
{
	LinkedList< String > _Columns;
	LinkedList< String > _Values;
	
	public ComponentInsert(LinkedList< String > pColumnas, LinkedList< String > pValores) 
	{
		this._Columns = pColumnas;
		this._Values = pValores;
	}

	@Override
	public ResultSet apply(ResultSet pResultSet) 
	{
		TableMetadata tableMetadata = pResultSet.getTableMetadata();
		
		LinkedList<String> tmp = new LinkedList<String>();
		
		for (int x = 0; x < tableMetadata.getTableColumns().size(); x++)
		{
			tmp.add("null");
		}

		LinkedList< Integer > colIndex = new LinkedList<>();
		LinkedList< Integer > colNull = new LinkedList<>();

		Iterator< String > i = this._Columns.iterator();

		String col;

		while (i.hasNext())
		{
			col = i.next();
			int indexOfColumn = tableMetadata.indexByName(col);
			System.out.println(indexOfColumn);
			colIndex.add(indexOfColumn);
		}

		for (int c = 0; c < tableMetadata.getTableColumns().size(); c++)
		{
			System.out.println("concha");
			if (!colIndex.contains(c))
			{
				System.out.println("culo");
				colNull.add(c);
			}
		}

		for (int j = 0; j < this._Values.size(); j++)
		{
			System.out.println("pene");
			tmp.set(colIndex.get(j), this._Values.get(j));
		}

		for (int k = 0; k < colNull.size(); k++)
		{
			System.out.println("astro");
			tmp.set(colNull.get(k), "null");
		}
		TableRegister tr = new TableRegister(tmp); 
		LinkedList<TableRegister> list = new LinkedList<TableRegister>();
		list.add(tr);
		TableData t = new TableData(list);
		
		return (new ResultSet(t, tableMetadata));
	}
}