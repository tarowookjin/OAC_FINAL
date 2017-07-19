package entities;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class post_print {
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	int i=0,j=0,cont=0;
	
	public post_print(int cant) {
		if(cant!=0) {
		i=0;
		do{
			if(interrupciones.impresion[i]!=null) {
				model.addColumn(interrupciones.impresion[i]);
				
				i++;
			}
			else {
				i++;
			}
		}while(i!=16);//imprime los encabezados
		model.addRow(new Object[]{solveINT.timeini[0],null,null,null,null});
		model.addRow(new Object[]{solveINT.timefini[0],solveINT.timeini[1],null,null,null});
		model.addRow(new Object[]{null,solveINT.timefini[1],solveINT.timeini[2],null,null});
		model.addRow(new Object[]{null,solveINT.timeini[3],solveINT.timefini[2],null,null});
		model.addRow(new Object[]{null,solveINT.timefini[3],null,null,solveINT.timeini[4]});
		model.addRow(new Object[]{null,null,null,solveINT.timeini[5],solveINT.timefini[4]});
		model.addRow(new Object[]{null,solveINT.timeini[6],null,solveINT.timefini[5],null});
		model.addRow(new Object[]{null,solveINT.timefini[6],null,solveINT.timeini[7],null});
		model.addRow(new Object[]{solveINT.timeini[8],null,null,solveINT.timefini[7],null});
		model.addRow(new Object[]{solveINT.timefini[8],null,solveINT.timeini[9],null,null});
		model.addRow(new Object[]{solveINT.timeini[10],null,solveINT.timefini[9],null,null});
		model.addRow(new Object[]{solveINT.timefini[11],null,null,null,null});
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
