package entities;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class post_print {
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	
	public post_print(int cant) {
		if(cant!=0) {
		model.addColumn("Programa");
		for(int i=0;i<=cant;i++) {
			model.addColumn(interrupciones.impresion[i]);
		}//imprime los encabezados
		
		
		}
		else {
			JOptionPane.showMessageDialog(null,"ERROR NINGUN DATO QUE SIMULAR");
		}
	}
	
	public void impresiones(int cant) {
		if(cant==1) {
			
		}
		if(cant==2) {
			
		}
		if(cant==3) {
			
		}
		if(cant==4) {
			
		}
		if(cant==5) {
			
		}
		if(cant==6) {
			
		}
		if(cant==7) {
			
		}
		if(cant==8) {
			
		}
		if(cant==9) {
			
		}
		if(cant==10) {
			
		}
		if(cant==11) {
			
		}
		if(cant==12) {
			
		}
		if(cant==13) {
			
		}
		if(cant==14) {
			
		}
		if(cant==15) {
			
		}
		if(cant==16) {
			
		}
	}
}
