package entities;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class post_print {
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	int i=0,j=0;
	public post_print(int cant) {
		if(cant!=0) {
		model.addColumn("Programa");
		i=0;
		do{
			if(interrupciones.impresion[i]!=null) {
				model.addColumn(interrupciones.impresion[i]);
			}
		}while(i!=16);//imprime los encabezados
		
		do{
			if(interrupciones.impresion[j]!=null) {
				
			}
		}while(j!=16);//imprime los encabezados
		
		}
		else {
			JOptionPane.showMessageDialog(null,"ERROR NINGUN DATO QUE SIMULAR");
		}
	}
	
	public void impresiones(int cant, String IRQ) {
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
