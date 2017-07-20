package entities;

import javax.swing.JOptionPane;
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
		do {
			if(solveINT.timeini[cont]<tim) {
				if(solveINT.timefini[cont]>tim) {
					model.addRow(new Object[] {tim,solveINT.dispo[cont],solveINT.inte[cont],solveINT.timeini+"-"+solveINT.timefini,solveINT.timeleft});
				}
			}
			cont++;
		}while(cont!=solveINT.data);	
	}
}
