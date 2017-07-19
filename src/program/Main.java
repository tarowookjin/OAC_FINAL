package program;		//hola oni-cha xD	

import entities.interrupciones;
import entities.pre_print;
import entities.impresion;
import java.util.EmptyStackException;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hola
		int ele=0;
		int t_Eje = 0;//tiempo de ejecucion
		int t_total=0;//tiempo total con la suma de todas las interrupcions
		interrupciones inte = new interrupciones();
		try{
		ele=0;
		String tempele =JOptionPane.showInputDialog(null,"\t\t\t\tInterrupciones Programadas\n\t\t\t\nIntrodusca el tiempo de ejecuci�n del programa");
		if(tempele==null)
		{throw new EmptyStackException();}
		ele = Integer.parseInt(tempele);
		t_Eje = ele;
		t_total = t_total + t_Eje;
		inte.ini_interrupciones();
		}
		catch (NumberFormatException io)
		{JOptionPane.showMessageDialog(null, "Introduzca una opcion valida","ERROR",JOptionPane.WARNING_MESSAGE);}
		catch (EmptyStackException io)//si el usuario apreta cancelar o quit sale del programa ya que devuelve un null
		{System.exit(0);}
		finally
		{}
		do{
			try {
			ele=0;
			String tempele =JOptionPane.showInputDialog(null,"\t\t\t\tInterrupciones Programadas\n\t\t\t\n1-Ver integrantes del grupo\n2-Ver Tabla\n3- Agregar Interrupcion\n4-Eliminar Interrupcion\n5-Iniciar\n6-Salir");
			if(tempele==null)
			{throw new EmptyStackException();}
			ele = Integer.parseInt(tempele);
			}
			catch (NumberFormatException io)
			{JOptionPane.showMessageDialog(null, "Introduzca una opcion valida","ERROR",JOptionPane.WARNING_MESSAGE);}
			catch (EmptyStackException io)//si el usuario apreta cancelar o quit sale del programa ya que devuelve un null
			{ele=6;}
			finally
			{}
			switch(ele)
			{
				case 1:
					JOptionPane.showMessageDialog(null, "\t\t\t\nUniversidad Tecnol�gica de Panam�\n\n\t\t\t\nFacultad de Ingenier�a de Sistemas Computacionales\n\n\t\t\t\nDepartamento: Ingenier�a de Software\n\n\t\t\t\nOrganizacion y Arquitectura de Computadora\n\n\t\t\t\nProyecto Semestral\n\n\t\t\t\nTema:\nInterrupciones\n\n\t\t\t\nProfesor:\nSergio Cotes\n\n\t\t\t\nIntegrantes:\n\t\t\t\nEnocCastillo 8-915-1407 \t\t\t\n Moises Chin 8-922-248\t\t\t\nEddie Pan 8-915-1407\n\n");
	
				break;
				
				case 2 :
					pre_print pre_impre = new pre_print(inte.verificar());
					pre_impre.MostrarTabla();
					
					break;
				case 3:
					try{
						int index=0;//variable para guardar irq
						int ans,ans2,ans3;
						String tempele =JOptionPane.showInputDialog(null,"\t\t\t\tAgregar Interrupciones\n\t\t\t\n Introdusca el IRQ");
						if(tempele==null){
							throw new EmptyStackException();}
						String temtimeint =JOptionPane.showInputDialog(null,"\t\t\t\tAgregar Interrupciones\n\t\t\t\n Introdusca el tiempo donde interrumpe");
						if(temtimeint==null){
							throw new EmptyStackException();}
						String temtime =JOptionPane.showInputDialog(null,"\t\t\t\tAgregar Interrupciones\n\t\t\t\n Introdusca el tiempo en segundos");
						if(temtime==null){
							throw new EmptyStackException();}
						ans = Integer.parseInt(tempele);
						ans2 = Integer.parseInt(temtimeint);
						ans3 = Integer.parseInt(temtime);
						if(ele >= 0 && ele <= 15){ 
							inte.agregarINT(ans,ans2,ans3);
							index=ele;
						}
						else{
							JOptionPane.showMessageDialog(null, "Los IRQ solo son de 0 a 15!!!","ERROR",JOptionPane.WARNING_MESSAGE);
						}
					}
					catch (NumberFormatException io){
						JOptionPane.showMessageDialog(null, "Introduzca una opcion valida","ERROR",JOptionPane.WARNING_MESSAGE);}
					catch (EmptyStackException io)//si el usuario apreta cancelar o quit sale del programa ya que devuelve un null
					{ele=6;}
					finally
					{}
					
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
