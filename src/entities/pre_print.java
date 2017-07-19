package entities;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pre_print {
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	
	public pre_print(int cant){
		int cont=0;
		model.addColumn("ID");
		model.addColumn("Interrupcion");
		model.addColumn("Tiempo de Entrada");
		model.addColumn("Duracion");
		do {
			if(interrupciones.IRQ[cont]!=null) {
			model.addRow(new Object[] {cont,interrupciones.funcion[Integer.parseInt(interrupciones.IRQ[cont])],interrupciones.time_int[cont],interrupciones.duration[cont]});
			cont++;
			}
		}while(cont!=cant);
		
	}
	
	public void MostrarTabla()
	{
		JOptionPane.showMessageDialog(null, new JScrollPane(table));
	}
}
