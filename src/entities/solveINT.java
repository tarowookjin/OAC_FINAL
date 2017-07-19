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
    Stack < String > A = new Stack < String > (); //Pila para ordenar

	
	public void solve(int finaltime,int programtime){
		time=0;
		int temptime=programtime;
		boolean inte=false;
		time_faltante=new int[finaltime];
		timeini=new int[finaltime];
		timefini=new int[finaltime];
		hayINT=new boolean[finaltime];
		disp=new String[finaltime];
		rango=new String[finaltime];
		
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
	
	public void savetime(int time){
		
	}
}
