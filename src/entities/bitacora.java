package entities;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class bitacora {
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	solveINT sol = new solveINT();
	int tim,cont=0;
	
	public bitacora(){
		model.addColumn("tiempo");
		model.addColumn("Dispositivo");
		model.addColumn("Hubo Interrupcion");
		model.addColumn("Rango");
		model.addColumn("Tiempo Restante");
	}
	
	public void agre_row(int tim){
		System.out.println("Data"+solveINT.data);
		cont=0;
		do {
			System.out.println("Timeini "+solveINT.timeini[cont]);
			if(solveINT.timeini[cont]<tim) {
				if(solveINT.timefini[cont]>tim) {
					model.addRow(new Object[] {tim,interrupciones.funcion[Integer.parseInt(solveINT.dispo[cont])],solveINT.inte[cont],solveINT.timeini[cont]+"-"+solveINT.timefini[cont],solveINT.timeleft[cont]});
				}
			}
			cont++;
		}while(cont!=solveINT.data);	
	}
	
	public void MostrarTabla()
	{
		JOptionPane.showMessageDialog(null, new JScrollPane(table));
	}
}
