package entities;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class impresion {
	
	public impresion(){
		
		interrupciones objInterrup = new interrupciones();	
			
		DefaultTableModel modelo= new DefaultTableModel();
		
		JTable tabla = new JTable(modelo);
		
		// creo las columnas
		modelo.addColumn("ID");
		
		int indice[] = new int [50]; // indice de las interrupciones
		
		
		
		// agrego cuantas columnas por funcion sean necesarias
		for(int i=0; i<30;i++)
		{
			
			
		}
		
	}
	
}
