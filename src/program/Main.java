package program;

import entities.bitacora;
import entities.interrupciones;
import entities.post_print;
import entities.pre_print;
import entities.solveINT;

//import entities.impresion_ching;
import java.util.EmptyStackException;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hola
		int x=1;
		int ele=0;
		int t_Eje = 0;//tiempo de ejecucion
		int t_total=0;//tiempo total con la suma de todas las interrupcions
		int program = 0;
		interrupciones inte = new interrupciones();
		solveINT sol =new solveINT();
		bitacora bit = new bitacora();
		do{
			try{
			ele=0;
			String tempele =JOptionPane.showInputDialog(null,"\t\t\t\tInterrupciones Programadas\n\t\t\t\nIntrodusca el tiempo de ejecucion del programa");
			if(tempele==null)
			{throw new EmptyStackException();}
			ele = Integer.parseInt(tempele);
			t_Eje = ele;
			program=ele;
			t_total = t_total + t_Eje;
			inte.ini_interrupciones();
			x=0;
			}
			catch (NumberFormatException io)
			{
				JOptionPane.showMessageDialog(null, "Introduzca una opcion valida","ERROR",JOptionPane.WARNING_MESSAGE);
				x=1;
			}
			catch (EmptyStackException io)//si el usuario apreta cancelar o quit sale del programa ya que devuelve un null
			{System.exit(0);}
			finally
			{}
		}while(x!=0);
		do{
			try {
			ele=0;
			String tempele =JOptionPane.showInputDialog(null,"\t\t\t\tInterrupciones Programadas\n\t\t\t\n1-Ver integrantes del grupo\n2-Ver Tabla\n3- Agregar Interrupcion\n4-Iniciar\n5-Salir");
			if(tempele==null)
			{throw new EmptyStackException();}
			ele = Integer.parseInt(tempele);
			}
			catch (NumberFormatException io)
			{JOptionPane.showMessageDialog(null, "Introduzca una opcion valida","ERROR",JOptionPane.WARNING_MESSAGE);}
			catch (EmptyStackException io)//si el usuario apreta cancelar o quit sale del programa ya que devuelve un null
			{System.exit(0);}
			finally
			{}
			switch(ele)
			{
				case 1:
					JOptionPane.showMessageDialog(null, "\t\t\t\nUniversidad Tecnologica de Panama\n\n\t\t\t\nFacultad de Ingenieria de Sistemas Computacionales\n\n\t\t\t\nDepartamento: Ingenieria de Software\n\n\t\t\t\nOrganizacion y Arquitectura de Computadora\n\n\t\t\t\nProyecto Semestral\n\n\t\t\t\nTema:\nInterrupciones\n\n\t\t\t\nProfesor:\nSergio Cotes\n\n\t\t\t\nIntegrantes:\n\t\t\t\nEnocCastillo 8-915-1407 \t\t\t\n Moises Chin 8-922-248\t\t\t\nEddie Pan 8-915-1407\n\n");
	
				break;
				
				case 2 :
					pre_print pre_impre = new pre_print(inte.getstack());
					pre_impre.MostrarTabla();
					
					break;
				case 3:
				{
					boolean z = false;
					int ans=0,ans2=0,ans3=0;
					String tempele;
					try{
						do{
							tempele =JOptionPane.showInputDialog(null,"\t\t\t\tAgregar Interrupciones\n\t\t\t\n Introdusca el IRQ");
							if(tempele==null){
								throw new EmptyStackException();}
							ele = Integer.parseInt(tempele);
							if(ele >= 0 && ele <= 15){
								ans = ele;
								z = true;
							}
							else{
								JOptionPane.showMessageDialog(null, "Los IRQ solo son de 0 a 15!!!","ERROR",JOptionPane.WARNING_MESSAGE);}
						}while(z != true );
					}
					catch (NumberFormatException io){
						JOptionPane.showMessageDialog(null, "Introduzca una opcion valida","ERROR",JOptionPane.WARNING_MESSAGE);}
					catch (EmptyStackException io)//si el usuario apreta cancelar o quit sale del programa ya que devuelve un null
						{System.exit(0);}
					z = false;
					try{
						do{
							tempele =JOptionPane.showInputDialog(null,"\t\t\t\tAgregar Interrupciones\n\t\t\t\n Introdusca el tiempo donde interrumpe");
							if(tempele==null){
								throw new EmptyStackException();}
							ele = Integer.parseInt(tempele);
							ans2 = ele;
							z = true;
						}while(z != true);
					}
					catch (NumberFormatException io){
						JOptionPane.showMessageDialog(null, "Introduzca una opcion valida","ERROR",JOptionPane.WARNING_MESSAGE);}
					catch (EmptyStackException io)//si el usuario apreta cancelar o quit sale del programa ya que devuelve un null
					{System.exit(0);}
					z = false;
					try{
						do{
							tempele =JOptionPane.showInputDialog(null,"\t\t\t\tAgregar Interrupciones\n\t\t\t\n Introdusca el tiempo en segundos");
							if(tempele==null){
								throw new EmptyStackException();}
							ele = Integer.parseInt(tempele);
							ans3 = ele;
							t_total=t_total+ans3;
							z = true;
						}while(z != true );
						ele=0;
						}
					catch (NumberFormatException io){
						JOptionPane.showMessageDialog(null, "Introduzca una opcion valida","ERROR",JOptionPane.WARNING_MESSAGE);}
					catch (EmptyStackException io)//si el usuario apreta cancelar o quit sale del programa ya que devuelve un null
					{System.exit(0);}
					inte.agregarINT(ans,ans2,ans3);
					break;}
				case 4:
					int cant=0,cont=0;
					sol.solve(t_total,program);
					post_print post_imp = new post_print(inte.verificar());
					post_imp.MostrarTabla();
					System.out.println("paso aqui");
					cant=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca cuantos tiempos quiere evaluara en la bitacora"));
					for(cont=0;cont<=cant-1;cont++) {
						int time=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el tiempo "+(cont+1)));
						bit.agre_row(time);
					}
					bit.MostrarTabla();
					break;
				case 5:
					break;
				case 7:
					System.out.print(t_total);
					break;
				default:
					JOptionPane.showMessageDialog(null,"Porfavor elija una de las opciones disponibles");
					break;
					
			
			}
		}while(ele!=5);
		
	}

}
