package entities;

import java.util.Stack;

public class solveINT {
	
	//data guardada
	static String dispo[]=new String[100];
	static int timeini[]=new int[100];
	static int timefini[]=new int[100];
	static boolean inte[]=new boolean[100];
	static int timeleft[]=new int[100];
	static int data=0;
	int time;
	interrupciones in = new interrupciones();
	
    //Declaración de las pilas
	Stack < String > E = new Stack < String > (); //Pila entrada
    Stack < String > P = new Stack < String > (); //Pila temporal para guardar los tiempos
    Stack < String > S = new Stack < String > (); //Pila que guarda los dispositivos
    Stack < String > A = new Stack < String > (); //Pila para ordenar

	
	public void solve(int finaltime,int programtime){
		time=0;
		int temptime=programtime,timei=0,timef=0;
		boolean inte=false;
		System.out.println("Stack"+in.getstack());
		//almaceno todo en una pila
		for(int i=in.getstack()-1;i>=0;i--) {
			E.push(interrupciones.IRQ[i]);
            System.out.println(interrupciones.IRQ[i]);
		}
		E.push("16");
		String dispactual="15";
		int priact=99;//prioridad actual
		int i=0;
		dispactual=E.pop();
		do {
			inte=false;
			if(time==interrupciones.time_int[i]) {
				inte=compare(priact);
				if(inte==true) {
					timef=time;
					savedata(dispactual,timei,timef,true,temptime);
					System.out.println("Save Data:\n"+dispactual+"\n"+timei+" "+timef);
					timei=timef;
					S.push(dispactual);
					System.out.println("guardar time:"+temptime);
					P.push(Integer.toString(temptime));
					priact=Integer.parseInt(interrupciones.prioridad[Integer.parseInt(E.peek())]);
					dispactual=E.pop();
					temptime=interrupciones.duration[i];
				}
				if(inte==false)
				{
					ordenarpila(i);
				}
				i++;
				temptime--;
				time++;
			}
			else {
				if(temptime!=0) {
					temptime--;
					time++;
				}
				else {
					timef=time;
					savedata(dispactual,timei,timef,false,temptime);
					System.out.println("Save Data:\n"+dispactual+"\n"+timei+" "+timef);
					timei=timef;
					dispactual=S.pop();
					temptime=Integer.parseInt(P.pop());
					temptime--;
					time++;
				}	
			}
		System.out.println("Dispactua: "+dispactual+" TIME: "+time);
		}while(time!=finaltime);
	}
	
	
	public boolean compare(int pref){
		int indice=Integer.parseInt(E.peek());
		int pref2=Integer.parseInt(interrupciones.prioridad[indice]);
		if(pref>pref2){
			return true;
		}
		else {
			return false;		
		}
		
	}

	public void ordenarpila(int i) {
		int prio,prio2;
		prio=Integer.parseInt(interrupciones.prioridad[Integer.parseInt(S.peek())]);
		prio2=Integer.parseInt(interrupciones.prioridad[Integer.parseInt(E.peek())]);
		if(prio< 	prio2){
			S.push(E.pop());
			P.push(Integer.toString(interrupciones.duration[i]));
		}else {
			A.push(S.pop());
			S.push(E.pop());
			S.push(A.pop());
			
			A.push(P.pop());
			P.push(Integer.toString(interrupciones.duration[i]));
			S.push(A.pop());
		}
	}
	
	public void savedata(String disp, int tempi, int tempf,boolean interrup,int timelef){
		dispo[data]=disp;
		timeini[data]=tempi;
		timefini[data]=tempf;
		inte[data]=interrup;
		timeleft[data]=timelef;
		data++;
	}
	
	public int getdata() {
		return data;
	}
}
