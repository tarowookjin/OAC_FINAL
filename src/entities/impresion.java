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

		
		 // prueba de llenado de el arreglo para ver si sirve 
		indice[0]= 0;
		indice[1]=1;
		indice[2]=7;
		indice[3]=1;
		tempInd[0] ="0"; 
		tempInd[1]= "1";
		tempInd[2] = "7";
		tempInd[3]="1";
		// hasta aqui prueba de llenado
		
		// agrego cuantas columnas por funcion sean necesarias
/* si el arreglo TempInd tiene contenido indica que se ingreso una funcion y se crea una columna
 * si no es null lo que quiere decir que ya no hay mas nada que agregar y se cierra
 * */
		
		
		String FuncUsadas[] = new String [30]; // arreglo que almacena las funciones que ya se usaron
		boolean esta =false; // comprobante si la funcion ya esta o no
		
		for(int i=0; i<30;i++)
		{

			if(tempInd[i] != null ) {
				
				for( int j=0; j<30;j++) {
					
						if(Funciones[indice[i]] == FuncUsadas[j] )
						{
						esta= true;
					}
				}
				// si la funcion ya esta no se agrega, si no esta si se agrega
				if(esta == false) {
					modelo.addColumn(Funciones[indice[i]]);		
					FuncUsadas[i] =Funciones[indice[i]];
				}
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
