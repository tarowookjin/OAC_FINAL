package entities;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class bitacora {
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	solveINT sol = new solveINT();
	int tim,cont=0;
	public void impre_bitacora(int cant){
		model.addColumn("tiempo");
		model.addColumn("Dispositivo");
		model.addColumn("Hubo Interrupcion");
		model.addColumn("Rango");
		model.addColumn("Tiempo Restante");
		for(int i=0;i<=cant;i++) {
			tim=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el tiempo "+i));
			do {
				if(solveINT.timeini[cont]<tim) {
					if(solveINT.timefini[cont]>tim) {
						model.addRow(new Object[] {tim,sol.dispo[cont],sol.inte[cont],solveINT.timeini+"-"+solveINT.timefini,sol.timeleft});
					}
				}
				cont++;
			}while(cont!=sol.getdata());
		}
		
	}
}
