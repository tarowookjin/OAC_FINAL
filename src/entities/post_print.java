package entities;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class post_print {
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	solveINT sol =new solveINT();
	int i=0,j=0,cont=0;
	
	public post_print(int cant) {
		if(cant!=0) {
		model.addColumn("Programa");
		i=0;
		do{
			if(interrupciones.impresion[i]!=null) {
				model.addColumn(interrupciones.impresion[i]);
			}
		}while(i!=16);//imprime los encabezados
		
		
		}
		else {
			JOptionPane.showMessageDialog(null,"ERROR NINGUN DATO QUE SIMULAR");
		}
	}
	
}
