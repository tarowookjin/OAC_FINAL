package entities;

import java.util.Stack;

public class solveINT {
	
	//data guardada
	String dispo[]=new String[100];
	int timeini[]=new int[100];
	int timefini[]=new int[100];
	boolean inte[]=new boolean[100];
	int timeleft[]=new int[100];
	int data=0;
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
		
		//almaceno todo en una pila
		for(int i=in.stack;i>=0;i--) {
			E.push(interrupciones.IRQ[i]);
		}
		E.push("16");
		String dispactual="16";
		int priact=99;//prioridad actual
		int i=0;
		do {
			inte=false;
			if(time==interrupciones.time_int[i]) {
				inte=compare(priact);
				if(inte==true) {
					timef=time;
					savedata(dispactual,timei,timef,true,temptime);
					timei=timef;
					S.push(dispactual);
					P.push(Integer.toString(temptime));
					dispactual=E.pop();
					priact=Integer.parseInt(in.prioridad[Integer.parseInt(E.peek())]);
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
					timei=timef;
					dispactual=S.pop();
					temptime=Integer.parseInt(P.pop());
					temptime--;
					time++;
				}	
			}
			
		}while(time!=finaltime);
	}
	
	
	public boolean compare(int pref){
		if(pref>Integer.parseInt(in.prioridad[Integer.parseInt(E.peek())])){
			return true;
		}
		else {
			return false;		
		}
		
	}

	public void ordenarpila(int i) {
		int prio,prio2;
		prio=Integer.parseInt(in.prioridad[Integer.parseInt(S.peek())]);
		prio2=Integer.parseInt(in.prioridad[Integer.parseInt(E.peek())]);
		if(prio>prio2){
			S.push(E.pop());
			P.push(Integer.toString(in.duration[i]));
		}else {
			A.push(S.pop());
			S.push(E.pop());
			S.push(A.pop());
			
			A.push(P.pop());
			P.push(Integer.toString(in.duration[i]));
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
}
