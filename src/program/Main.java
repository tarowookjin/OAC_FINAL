package program;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ele;
		do{
			String tempele =JOptionPane.showInputDialog(null,"\t\t\t\tInterrupciones Programadas\n\t\t\t\n1-Ver integrantes del grupo\n2-Ver Tabla\n3- Agregar Interrupcion\n4-Eliminar Interrupcion\n5-Iniciar\n6-Salir");
			 ele = Integer.parseInt(tempele);
			switch(ele)
			{
				case 1:
					JOptionPane.showMessageDialog(null, "\t\t\t\nUniversidad Tecnol�gica de Panam�\n\n\t\t\t\nFacultad de Ingenier�a de Sistemas Computacionales\n\n\t\t\t\nDepartamento: Ingenier�a de Software\n\n\t\t\t\nOrganizacion y Arquitectura de Computadora\n\n\t\t\t\nProyecto Semestral\n\n\t\t\t\nTema:\nInterrupciones\n\n\t\t\t\nProfesor:\nSergio Cotes\n\n\t\t\t\nIntegrantes:\n\t\t\t\nEnocCastillo 8-915-1407 \t\t\t\n Moises Chin 8-922-248\t\t\t\nEddie Pan 8-915-1407\n\n");
	
				break;
				
				case 2 :
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
					default:
						JOptionPane.showMessageDialog(null,"Porfavor elija una de las opciones disponibles");
						break;
					
			
			}
		
		}while(ele !=6);
	}

}
