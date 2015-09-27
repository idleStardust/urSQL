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
 * @author ArturoMora™
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
		
		TableRegister tmp = new TableRegister();

		LinkedList< Integer > colIndex = new LinkedList<>();
		LinkedList< Integer > colNull = new LinkedList<>();

		Iterator< String > i = this._Columns.iterator();

		String col;

		while (i.hasNext())
		{
			col = i.next();
			int indexOfColumn = tableMetadata.indexByName(col);
			colIndex.add(indexOfColumn);
		}

		for (int c = 0; c < tableMetadata.getTableColumns().size(); c++)
		{
			if (!colIndex.contains(c))
			{
				colNull.add(c);
			}
		}

		for (int j = 0; j < this._Values.size(); j++)
		{
			tmp.getRegister().set(colIndex.get(j), this._Values.get(j));
		}

		for (int k = 0; k < colNull.size(); k++)
		{
			tmp.getRegister().set(colNull.get(k), TableAttribute.NULL_DATA);
		}
		
		return (new ResultSet(tmp, tableMetadata));
	}
}