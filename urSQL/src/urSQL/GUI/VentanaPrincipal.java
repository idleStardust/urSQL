package urSQL.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import urSQL.QueryProcessor.QueryProcessor;
import urSQL.RuntimeDatabaseProcessor.Components.ComponentGroup;
import urSQL.System.ResultSet;
import urSQL.System.TableAttribute;
import urSQL.System.TableData;
import urSQL.System.TableMetadata;
import urSQL.System.TableRegister;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
//import java.awt.Window.Type;

/**

 *
 */
public class VentanaPrincipal extends JFrame implements ActionListener
	{

		private JPanel miPanel;//contenedor de los componentes
		private JMenuBar barraMenu;
		private JMenu menuArchivo,menuEdicion,menuAcercaDe, subMenuGirar, menuOpciones;
		/*items del menu Archivo*/
	    private JMenuItem menuItemNuevo,menuItemAbrir,menuItemGuardar,itemSalir;
	    /*items del menu Edicion*/
	    private JMenuItem menuItemCopiar,menuItemPegar,menuItemGirar1,menuItemGirar2;
	    /*items del menu Acerca De...*/
	    private JMenuItem menuItemAplicacion,menuItemBlog;
	    /*items del menu Opciones*/
	    private JRadioButtonMenuItem jRadioButtonMenu1,jRadioButtonMenu2;
	    private JCheckBoxMenuItem jCheckMenu1,jCheckMenu2;
	    /*labels de los menus para mostrar en pantalla*/
	    private JLabel labelArchivo, labelEdicion, labelOpciones;
	    private JLabel labelArchivoSeleccionado, labelEdicionSeleccionado, labelOpcionesCheckSeleccionadas,labelOpcionesRadioSeleccionadas;
	    
	    private JPopupMenu menuEmergente;
	    private JMenuItem itemEmergente1,itemEmergente2;
	    
	    QueryProcessor q_proc;
	    String texto;
	    JFileChooser fileChooser;
	    
	    JButton botonnuevo;
	    JButton botonabrir;
	    JButton botonguardar;
	    JButton botonschema;
	    JButton botontabla;
	    JTextArea areaDeTexto;
	    
	    /*Cadenas para asignar los resultados de eventos*/
		String cadenaArchivo="";
		String cadenaEdicion="";
	
		String informacionAplicacion="";
		String TONTERAS="";
		private JScrollPane scrollPane;
		private JScrollPane scrollPane_3;
		
		
		private JTable table;
		String columnas[];
		String Matriz[][] ;
		private JScrollPane scrollPane_1;
		String bebe[][][]={{{"Base de Datos1"}},{ {"Tabla"},{"nom_col1","nom_col2"},{"noref1","nom_ref2"},{"nom_con1","nom_con2"}},{ {"Tabla2"},{"nom_col1","nom_col2"},{"noref1","nom_ref2"},{"nom_con1","nom_con2"}}};
				
		public void esquemaTree(DynamicTree treePanel,String bebe[][][]) {
				
				String p0Name = new String(bebe[0][0][0]);
				DefaultMutableTreeNode p1, p2,p3, p4,p0;
				p0 = treePanel.addObject(null, p0Name);
				int j=1;
				while(j !=bebe.length){
				String p1Name = new String(bebe[j][0][0]);
				String p2Name = new String("Columnas");
				String p3Name = new String("Referencias");
				String p4Name = new String("Constrains");
				
				p1=treePanel.addObject(p0, p1Name);
				
				p2 = treePanel.addObject(p1, p2Name);
				p3= treePanel.addObject(p1, p3Name);
				p4=treePanel.addObject(p1, p4Name);
				int i=0;
				while(i !=bebe[j][1].length){
					
					String c1Name = new String(bebe[j][1][i]);
					treePanel.addObject(p2, c1Name);
					i++;
				}	
				i=0;
				while(i!=bebe[j][2].length){
					
					String c1Name = new String(bebe[j][2][i]);
					treePanel.addObject(p3, c1Name);
					i++;
				}
				i=0;
				while(i!=bebe[j][3].length){
					
					String c1Name = new String(bebe[j][3][i]);
					treePanel.addObject(p4, c1Name);
					i++;
				}j++;	
			}j=0;
				}		
		
		public VentanaPrincipal()//constructor
		{
			setForeground(Color.GRAY);
			getContentPane().setForeground(new Color(224, 255, 255));
			getContentPane().setBackground(new Color(245, 245, 245));
			iniciarComponentes();
       		//Asigna un titulo a la barra de titulo
			setTitle("                                                                          urSQL Workbench");
			//tama�o de la ventana
			setSize(750,650);
			//pone la ventana en el Centro de la pantalla
			setLocationRelativeTo(null);
			/*impide que la ventana cambie de tama�o*/
			setResizable(false);
			this.q_proc = new QueryProcessor();
		}

		private void iniciarComponentes() {
						
			/*Inicializamos el Mensaje del menu Acerca de...*/
			informacionAplicacion="Esta es una aplicacion desarrollada \n";
			informacionAplicacion+="en el curso Bases de Datos CE3101\n";

			TONTERAS="Besame\n";
			
			miPanel = new JPanel();
			
			miPanel.setForeground(new Color(0, 0, 0));
			miPanel.setBackground(new Color(176, 224, 230));
			miPanel.setLayout(null);
			barraMenu = new JMenuBar();
	        menuArchivo = new JMenu();
	        menuEdicion = new JMenu();
	        menuOpciones = new JMenu();
	        menuAcercaDe = new JMenu();
	        subMenuGirar = new JMenu();
	        menuItemNuevo = new JMenuItem();
	        menuItemAbrir = new JMenuItem();
	        menuItemGuardar = new JMenuItem();
	        itemSalir = new JMenuItem();
	        
	        fileChooser=new JFileChooser();
	        
	        menuItemCopiar = new JMenuItem();
	        menuItemPegar = new JMenuItem();
	        menuItemGirar1 = new JMenuItem();
	        menuItemGirar2 = new JMenuItem();
	        
	        menuItemAplicacion = new JMenuItem();
	        menuItemBlog = new JMenuItem();
	        
	        itemEmergente1 = new JMenuItem();
	        itemEmergente2 = new JMenuItem();
	        
	        menuEmergente = new JPopupMenu();
	        labelOpciones =new JLabel();	
	        labelArchivoSeleccionado =new JLabel();
	        labelOpcionesCheckSeleccionadas =new JLabel();
	        labelOpcionesRadioSeleccionadas =new JLabel();
	        labelOpciones.setBounds(386,72,80,30);
	        labelOpciones.setText("Opciones : ");
	        
	        labelArchivoSeleccionado.setBounds(405,-1,200,30);
	        labelOpcionesCheckSeleccionadas.setBounds(176,61,200,30);
	        labelOpcionesRadioSeleccionadas.setBounds(30,155,200,30);
	        /*Labels*/
	        
	        /*Crea los items del menu Archivo*/
	        menuItemNuevo.setText("Nuevo Modelo");
	        menuArchivo.add(menuItemNuevo);
	        menuArchivo.addSeparator();
	        
	        menuItemAbrir.setText("Abrir Modelo");
	        menuArchivo.add(menuItemAbrir);
	        menuArchivo.addSeparator();
	                       
	        menuItemGuardar.setText("GuardarModelo");
	        menuArchivo.add(menuItemGuardar);
	        menuArchivo.addSeparator();
	        
	        itemSalir.setText("Salir");
	        menuArchivo.add(itemSalir);
	        
	   
	        /*Crea los items del menu Acerca De...*/
	        menuItemAplicacion.setText("Aplicaci�n");
	        menuAcercaDe.add(menuItemAplicacion);
	        
	        menuItemBlog.setText("Ayuda");
	        menuAcercaDe.add(menuItemBlog);
	        
	        /*Agrega los Menus de la barra de Menu*/
	        menuArchivo.setText("Archivo");
	        barraMenu.add(menuArchivo);
	        
	        menuAcercaDe.setText("Informacion");
	        barraMenu.add(menuAcercaDe);

	        setJMenuBar(barraMenu);
	        
			botonnuevo= new JButton();
	        botonnuevo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/img_nuevo.jpg")));
	        botonnuevo.setBounds(101,24, 38, 26);
	        botonnuevo.addActionListener(this);
	        
	        botonabrir= new JButton();
	        botonabrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_abrir.jpg")));
			botonabrir.setBounds(222,24, 38, 26);
			botonabrir.addActionListener(this);
			
			
			botonguardar= new JButton();
	        botonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_guardar.jpg")));
			botonguardar.setBounds(340,24, 38, 26);
			botonguardar.addActionListener(this);
			
			botonschema= new JButton();
	        botonschema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_schema.jpg")));
			botonschema.setBounds(473,24, 38, 26);
			botonschema.addActionListener(this);
			
			botontabla= new JButton();
	        botontabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_tabla.jpg")));
			botontabla.setBounds(602,24, 38, 26);
			botontabla.addActionListener(this); 
			
			
			scrollPane = new JScrollPane();
	        scrollPane.setBounds(302, 102, 410, 187);
	        
	        /*Creamos los eventos para las opciones*/
	        menuItemNuevo.addActionListener(this);
	        menuItemAbrir.addActionListener(this);
	        menuItemGuardar.addActionListener(this);
	        itemSalir.addActionListener(this);
	        miPanel.setComponentPopupMenu(menuEmergente);
	        miPanel.add(botonnuevo);
	        miPanel.add(botonabrir);
	        miPanel.add(botonschema);
	        miPanel.add(botonguardar);
	        miPanel.add(botontabla);
	        miPanel.add(scrollPane);
	        getContentPane().add(miPanel);
	        
	      
	        
	        
	        
	        areaDeTexto = new JTextArea();
	        scrollPane.setViewportView(areaDeTexto);
	        areaDeTexto.setBackground(new Color(224, 255, 255));
	        
	        JLabel lblQueryProcessor = new JLabel("                                                            Query Processor");
	        lblQueryProcessor.setForeground(new Color(0, 0, 0));
	        lblQueryProcessor.setBackground(new Color(135, 206, 250));
	        scrollPane.setColumnHeaderView(lblQueryProcessor);
	        
	        JSeparator separator = new JSeparator();
	        separator.setForeground(new Color(0, 0, 128));
	        separator.setBackground(new Color(224, 255, 255));
	        separator.setBounds(26, 11, 686, 16);
	        miPanel.add(separator);
	        
	        JSeparator separator_1 = new JSeparator();
	        separator_1.setForeground(new Color(0, 0, 128));
	        separator_1.setBackground(new Color(224, 255, 255));
	        separator_1.setBounds(26, 61, 686, 16);
	        miPanel.add(separator_1);
	        
	        JLabel lblNewLabel = new JLabel("Consultas");
	        miPanel.add(lblNewLabel);
	        
	        scrollPane_3 = new JScrollPane();
	        scrollPane_3.setBounds(300, 466, 412, 104);
	        miPanel.add(scrollPane_3);
	        labelArchivo =new JLabel();
	        scrollPane_3.setColumnHeaderView(labelArchivo);
	        labelArchivo.setBackground(new Color(154, 205, 50));
	        labelArchivo.setText("                                                   Historial de consultas ejecutadas");
	        labelEdicionSeleccionado =new JLabel();
	        labelEdicionSeleccionado.setBackground(SystemColor.activeCaption);
	        scrollPane_3.setRowHeaderView(labelEdicionSeleccionado);
	        
	        JTextArea textArea = new JTextArea();
	        textArea.setBackground(new Color(224, 255, 255));
	        scrollPane_3.setViewportView(textArea);
	        
	        
	        
	        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
					"Schema");
			// Create the components.
			DynamicTree dynamicTree = new DynamicTree(rootNode);
			dynamicTree.setBackground(new Color(100, 149, 237));
			esquemaTree(dynamicTree,bebe);

			
	        JScrollPane scrollPane_4 = new JScrollPane();
	        scrollPane_4.setBounds(26, 102, 191, 468);
	        miPanel.add(scrollPane_4);
	        
	        JTree tree = new JTree();
	        DefaultTreeCellRenderer iconos = (DefaultTreeCellRenderer)tree.getCellRenderer();
	        iconos.setLeafIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sch.jpg")));
	        iconos.setOpenIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sch.jpg")));
	        iconos.setClosedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sch.jpg")));   

	        tree.setCellRenderer(new RendererArbol());
	        scrollPane_4.setViewportView(dynamicTree);
	        labelEdicion =new JLabel();
	        labelEdicion.setBackground(new Color(30, 144, 255));
	        scrollPane_4.setColumnHeaderView(labelEdicion);
	        labelEdicion.setText("Schema");
	        
	        scrollPane_1 = new JScrollPane();
	        scrollPane_1.setBounds(302, 329, 410, 102);
	        miPanel.add(scrollPane_1);
	        
	        
	       
	        
	        
	        
		}

		@Override
		public void actionPerformed(ActionEvent evento) {
			
			/*Cada metodo valida si se presiona o no alguna de las 
			 *opciones del menu, se trabajan en metodos separados por organizacion*/
			eventosMenuArchivo(evento);
			labelArchivoSeleccionado.setText(cadenaArchivo);
			

			if (evento.getSource()==menuItemAplicacion) {
				JOptionPane.showMessageDialog(null, informacionAplicacion,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
			}
			
			if (evento.getSource()==menuItemBlog) {
				JOptionPane.showMessageDialog(null, TONTERAS,"bebes!!!",JOptionPane.WARNING_MESSAGE);
			}
			
			if (evento.getSource()==botonnuevo){
				areaDeTexto.setText("");
			}
			if (evento.getSource()==botonabrir)
			{
				String archivo=abrirArchivo();
				areaDeTexto.setText(archivo);
			}
			
			if (evento.getSource()==botonguardar)
			{
				guardarArchivo();
			}
			if (evento.getSource()==botonschema)
			{
				
			}
			if (evento.getSource()==botontabla)
			{
				this.q_proc.setQuery(areaDeTexto.getText());
				try {
					this.q_proc.execute();
					ResultSet bulldozer = this.q_proc.getRS();
					this.fillTable(bulldozer);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}


		/**
		 * Metodos para los eventos del menu Archivo
		 * @param e
		 */
		private void eventosMenuArchivo(ActionEvent e) {

			if (e.getSource()==menuItemNuevo) {
				areaDeTexto.setText("");
			}
			if (e.getSource()==menuItemAbrir) {
				String archivo=abrirArchivo();
				areaDeTexto.setText(archivo);
			}
			if (e.getSource()==menuItemGuardar) {
				guardarArchivo();
			}
			if (e.getSource()==itemSalir) {
				cadenaArchivo=""+itemSalir.getText();
				dispose();
			}
			
		}
		public void fillTable(ResultSet bulldozer){
			/*String tableName = "estudiante";
			String nombre = "carne";
			String tipo = "INTEGER";
			String nombre2 = "nombre";
			String tipo2 = "VARCHAR";
			TableAttribute pk = new TableAttribute(nombre, tipo);
			TableAttribute col1 = new TableAttribute(nombre, tipo);
			TableAttribute col2 = new TableAttribute(nombre2, tipo2);
			LinkedList<TableAttribute> columnasx = new LinkedList<TableAttribute>();
			columnasx.add(col1);
			columnasx.add(col2);
			LinkedList<String> reg1 = new LinkedList<String>();
			reg1.add("2012");
			reg1.add("hector");
			LinkedList<String> reg2 = new LinkedList<String>();
			reg2.add("2013");
			reg2.add("santiago");
			LinkedList<String> reg3 = new LinkedList<String>();
			reg3.add("2010");
			reg3.add("astro");
			LinkedList<String> reg4 = new LinkedList<String>();
			reg4.add("2005");
			reg4.add("jenkins");
			LinkedList<String> reg5 = new LinkedList<String>();
			reg5.add("2005");
			reg5.add("satan");

			TableRegister treg1 = new TableRegister(reg1);
			TableRegister treg2 = new TableRegister(reg2);
			TableRegister treg3 = new TableRegister(reg3);
			TableRegister treg4 = new TableRegister(reg4);
			TableRegister treg5 = new TableRegister(reg5);
			LinkedList<TableRegister> tdata = new LinkedList<TableRegister>();
			tdata.add(treg1);
			tdata.add(treg2);
			tdata.add(treg3);
			tdata.add(treg4);
			tdata.add(treg5);
			TableData tableData = new TableData(tdata);
			TableMetadata tMetaData = new TableMetadata(tableName, columnasx, pk);
			ResultSet bulldozer = new ResultSet(tableData, tMetaData);*/
			Iterator< TableRegister > regIterator3 = bulldozer.getTableData().getData().iterator();
			TableRegister columnRegister = new TableRegister();
			TableRegister tmp3 = null;
			
			//String columnas1[] ;
			int i=0;
			LinkedList<String> tupla = new LinkedList<String>();
			String columnasp[];
			
			while (regIterator3.hasNext())
			{
				tmp3 = regIterator3.next();
				
				//columnasp=tmp3.getRegister().toArray(new String[tmp3.getRegister().size()]);
				System.out.println(bulldozer.getTableData().getData().getFirst().getRegister().size());
			}
			Iterator< TableAttribute > regIterator4 = bulldozer.getTableMetadata().getTableColumns().iterator();
			LinkedList<String> columnasstr = new LinkedList<String>();
			TableAttribute tmp4 = null;
			
			while (regIterator4.hasNext())
			{
				tmp4 = regIterator4.next();
				System.out.println(tmp4.getName());
				columnasstr.add(tmp4.getName());
				
				
			}
			System.out.println(columnasstr);
//			String[] columnas1 = linkedlist.toArray(new String[linkedlist.size()]);
			String columnas1[];
			columnas1=columnasstr.toArray(new String[columnasstr.size()]);
			
			//Object columnas1[]=bulldozer.getTableData().getData().toArray().;
		
			String Matriz1[][]={tmp3.getRegister().toArray(new String[tmp3.getRegister().size()]),{"azul","pizza"},{"cafe","conchita"},{"rojo","pescado"},{"azul","pizza"},{"cafe","conchita"},{"rojo","pescado"},{"azul","pizza"},{"cafe","conchita"}};
			System.out.println(bulldozer.getTableData().getData().size());
			columnas=columnas1;
			Matriz=ObtieneMatriz(bulldozer.getTableData());
			table= new JTable(Matriz,columnas);
	        table.setBackground(new Color(135, 206, 250));
	        scrollPane_1.setViewportView(table);
			
			
			
		}
		

		private String[][] ObtieneMatriz(TableData BB) {

			String informacion[][] = new String [BB.getData().size()][BB.getData().getFirst().getRegister().size()];
			
			for (int x = 0; x < BB.getData().size(); x++) {
				for (int y = 0; y < BB.getData().get(x).getRegister().size(); y++) {
					informacion[x][y]= BB.getData().get(x).getRegister().get(y);
				}
			}
			return informacion;
		}

		private String abrirArchivo() {
			
			String aux=""; 		
	 		texto="";
		
	 		try
			{
	 			/*llamamos el metodo que permite cargar la ventana*/
	    		fileChooser.showOpenDialog(this);
	    		/*abrimos el archivo seleccionado*/
	 			File abre=fileChooser.getSelectedFile();

	 			/*recorremos el archivo, lo leemos para plasmarlo
	 			 *en el area de texto*/
	 			if(abre!=null)
	 			{ 				
	 				FileReader archivos=new FileReader(abre);
	 				BufferedReader lee=new BufferedReader(archivos);
	 				while((aux=lee.readLine())!=null)
	 					{
	 					 texto+= aux+ "\n";
	 					}

	 		  		lee.close();
	 			} 			
	 		}
	 		catch(IOException ex)
			{
			  JOptionPane.showMessageDialog(null,ex+"" +
			  		"\nNo se ha encontrado el archivo",
			  		"ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}
				return texto;
		}
		
		/**
		 * Guardamos el archivo del area 
		 * de texto en el equipo
		 */
		public class RendererArbol extends DefaultTreeCellRenderer{



		    /** Creates a new instance of RendererArbol */

		    ImageIcon conectados;

		    ImageIcon noConectados;

		    public RendererArbol() {

		        conectados = new ImageIcon(getClass().getResource("/imagenes/tbl.jpg"));

		        noConectados = new ImageIcon(getClass().getResource("/imagenes/sch.jpg"));

		    }

		  

		    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)

		    {               

		        super.getTreeCellRendererComponent(tree,value,selected,expanded,leaf,row,hasFocus);

		        String val = value.toString();

		        ImageIcon i;

		        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)value;

		        if(val.compareTo("Conectados")!=0 && val.compareTo("Columnas")!=0 && val.compareTo("Contactos")!=0){   

		            TreeNode t = nodo.getParent();

		            if(t!=null){

		                if(t.toString().compareTo("Conectados")==0){

		                    setIcon(conectados);

		                }else if(t.toString().compareTo("Columnas")==0){

		                    setIcon(noConectados);

		                }

		            }

		        }                           

		        return this;

		    }

		}
		public void guardarArchivo() {

	 		try
	 		{
				String nombre="";
				JFileChooser file=new JFileChooser();
				file.showSaveDialog(this);
				File guarda =file.getSelectedFile();
		
				if(guarda !=null)
				{
		 			nombre=file.getSelectedFile().getName();
		 			/*guardamos el archivo y le damos el formato directamente,
		 			 * si queremos que se guarde en formato doc lo definimos como .doc*/
		 			FileWriter  save=new FileWriter(guarda+".txt");
		 			save.write(areaDeTexto.getText());
		 			save.close();
		 			JOptionPane.showMessageDialog(null,
		 					"El archivo se a guardado Exitosamente",
		 					"Informaci�n",JOptionPane.INFORMATION_MESSAGE);
			    }
	 		 }
	 	   catch(IOException ex)
		   {
			 JOptionPane.showMessageDialog(null,
					 "Su archivo no se ha guardado",
					 "Advertencia",JOptionPane.WARNING_MESSAGE);
		   }
		}
	}
		