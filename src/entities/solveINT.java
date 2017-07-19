package entities;

import java.util.Stack;

public class solveINT {
	
	int time_faltante[];
	boolean hayINT[];
	String disp[];
	String rango[];
	int time;
	interrupciones in = new interrupciones();
    //Declaración de las pilas
	Stack < String > E = new Stack < String > (); //Pila entrada
    Stack < String > P = new Stack < String > (); //Pila temporal para guardar los tiempos
    Stack < String > S = new Stack < String > (); //Pila que guarda los dispositivos

	
	public void solve(int finaltime,int programtime){
		time=0;
		int temptime=programtime;
		boolean inte=false;
		time_faltante=new int[finaltime];
		hayINT=new boolean[finaltime];
		disp=new String[finaltime];
		rango=new String[finaltime];
		
		//almaceno todo en una pila
		for(int i=in.stack;i>=0;i--) {
			E.push(in.IRQ[i]);
		}
		E.push("Programa");
		
		int priact=99;//prioridad actual
		int i=0;
		do {
			inte=false;
			if(time==in.time_int[i]) {
				inte=compare(priact);
				if(inte==true) {
					priact=Integer.parseInt(in.prioridad[Integer.parseInt(E.peek())]);
					P.push(Integer.toString(temptime));
					temptime=in.duration[i];
				}
				if(inte==false)
				{
					S.push(E.pop());
					P.push(Integer.toString(in.duration[i]));
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

	public void ordenarpila() {
		
	}
}
