package entities;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class post_print {
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	int i=0,j=0,cont=0;
	solveINT sol = new solveINT();

	public post_print(int cant) {
		if(cant!=0) {
		i=0;
		model.addColumn("Dispositivo");
		model.addColumn("Inicio");
		model.addColumn("Paro en");
		model.addColumn("Pendiente");
		do{
			model.addRow(new Object[] {interrupciones.funcion[Integer.parseInt(solveINT.dispo[i])],solveINT.timeini[i],solveINT.timefini[i],solveINT.timeleft[i]});
			i++;
		}while(i!=sol.getdata());//imprime los encabezados
		}
		else {
			JOptionPane.showMessageDialog(null,"ERROR NINGUN DATO QUE SIMULAR");
		}
	}
	public void MostrarTabla()
	{
		JOptionPane.showMessageDialog(null, new JScrollPane(table));
	}
}
