package entities;

import program.Main;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class impresion {
	
	DefaultTableModel modelo= new DefaultTableModel();	
	JTable tabla = new JTable(modelo);
	
	public impresion(){
		
		interrupciones objInterrup = new interrupciones();	
			
		
int indice[] = new int [50]; // indice de las interrupciones
		// procesos para transfomar los datos

		String tempInd[] = new String [50]; // traigo el irq aka indices
		tempInd = objInterrup.getIRQ();
		
		//transformo los indices de string a int
		for (int i=0;i<50;i++) {
			if(tempInd[i]  != null)
			{
				indice[i]=Integer.parseInt(tempInd[i]);
			}
			else{
				break;
			}
		}
		
		String Funciones [] = new String [15]; 
		Funciones = objInterrup.getFunciones(); // traigo lista de funciones
		// hasta aqui transformaciones
		
		// creo las columnas
		modelo.addColumn("ID");
		modelo.addColumn("Programa");

		
		
		indice[0]= 0;
		indice[1]=3; // prueba de llenado de el arreglo para ver si sirve 
		indice[2]=7;
		tempInd[0] ="0"; 
		tempInd[1]= "3";
		tempInd[2] = "7";
		// agrego cuantas columnas por funcion sean necesarias
/* si el arreglo TempInd tiene contenido indica que se ingreso una funcion y se crea una columna
 * si no es null lo que quiere decir que ya no hay mas nada que agregar y se cierra
 * */
		for(int i=0; i<30;i++)
		{

			if(tempInd[i] != null) {
			modelo.addColumn(Funciones[indice[i]]);
			}
			else {
				break;
			}
			
		}
		modelo.addColumn("Tiempo");
		modelo.addColumn("Duracion");

	}
	
	public void MostrarTabla()
	{
		JOptionPane.showMessageDialog(null, new JScrollPane(tabla));
	}
	
	
}
