package urSQL.API;

import java.util.Iterator;

/**
 * ResultSet is a object that contains the data of the table 
 * and the information of attributes of the table.
 * @author ArturoMora™
 *
 */
public class ResultSet
{
	private int current_index; // Fila en que se encuentra el cursor de la tabla resultante
	/**
	 *  The matrix of strings of chars that represent the information.
	 */
	protected TableData _TableData;
	
	/**
	 * The information about the attributes of the table.
	 */
	protected TableMetadata _TableMetadata;
	
	/**
	 *  Default constructor for ResultSet.
	 */
	public ResultSet(TableData pTableData, TableMetadata pTableMetadata)
	{
		this._TableData = pTableData;
		this._TableMetadata = pTableMetadata; 
		this.current_index = 0; // Inicia en la primera
	}
	
	public ResultSet()
	{
		 this.current_index = 0; // Inicia en la primera
	}
	
	public int getIndex()
	{
		return this.current_index; // Obtiene la fila donde apunta el cursor
	}

	/**
	 * Get of _TableData
	 */
	public TableData getTableData() 
	{
		return this._TableData;
	}

	/**
	 * Set of _TableData
	 */
	public void setTableData(TableData pTableData) 
	{
		this._TableData = pTableData;
	}

	/**
	 * Get of _TableMetadata
	 */
	public TableMetadata getTableMetadata()
	{
		return this._TableMetadata;
	}

	/**
	 * Set of _TableMetadata
	 */
	public void setTableMetadata(TableMetadata pMetadata)
	{
		this._TableMetadata = pMetadata;
	}
	
	/**
	 *  Print the MetaData And Data Information.
	 */
	public void print()
	{
		this._TableMetadata.print();
		System.out.println("");
		this._TableData.print();
	}	
	
	// Apunta el cursor al primer registro
	public boolean first() 
	{
		this.current_index = 0;
		return true;
	}
	
	// Apunta el cursor al último registro
	public boolean last() {
		this.current_index = this._TableMetadata.getTableColumns().size() - 1;
		return true;
	}
	
	public boolean absolute(int row) {
		int size = this._TableData._Data.size();
		if (row < 0) // Si es un índice negativo
		{
			System.out.println("Invalid row");
			return false;
		} else if (row >= size) // Si es mayor a la cantidad de filas
		{
			System.out.println("Invalid row");
			return false;
		} else // Actualiza el cursor
		{
			this.current_index = row;
			return true;
		}
		
	}
	
	public boolean relative(int row) {
		int size = this._TableData._Data.size();
		if (this.current_index + row >= size) { // Verifica que no sea mayor al índice máximo
			return false;
		} else {
			this.current_index += row; // Actualiza el cursor
			return true;
		}
	}
	
	public boolean previous() {
		if (this.current_index == 0) { // Si está en la inicial no puede ir más atras
			return false;
		} else {
			this.current_index--; // Disminuye el cursor
			return true;
		}
	}
	
	public boolean next() {
		int size = this._TableData._Data.size() - 1;
		if (this.current_index == size) { // Si está en la final no puede avanzar
			return false;
		} else {
			this.current_index++; // Avanza el cursor
			return true;
		}
	}
	
	public int getRow() {
		return this.current_index; // Obtiene el número de fila donde apunta el cursor
	}
	
	// Obtiene valor por nombre de columna
	public String getColumn(String colName) {
		Iterator<TableAttribute> i = this._TableMetadata._TableColumns.iterator();
		TableAttribute tmp = null;
		int x = 0;
		for (x = 0; i.hasNext(); x++)
		{
			tmp = i.next();
			if (tmp.getName().equals(colName))
			{
				break;
			}
		}
		return (this._TableData._Data.get(current_index).get(x));
	}

	// Obtiene valor por índice de columna
	public String getColumn(int colIndex) {
		return (this._TableData._Data.get(current_index).get(colIndex));
	}
	
}