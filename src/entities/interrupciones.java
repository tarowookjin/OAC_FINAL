package entities;

import javax.sound.midi.Synthesizer;

public class interrupciones {
	static String funcion[]=new String[17];
	String prioridad[]=new String[17];
	static String IRQ[]=new String[50];
	String impresion[]=new String[16];
	static int time_int[]=new int[50];
	public static int duration[]=new int[50];
	int stack=0; //variable para saber por donde va la introduccion de funciones

	public void ini_interrupciones(){
		impresion[0]="Programa";
		//constructor para la tabla de interrupciones
		//las IRQ son los indices
		funcion[0]="Reloj del Sitema";
		funcion[1]="Teclado";
		funcion[2]="Reservada (PIC)";
		funcion[3]="COM2/COM4";
		funcion[4]="COM1/COM3";
		funcion[5]="Libre";
		funcion[6]="Floppy/Diskette";
		funcion[7]="Impresora";
		funcion[8]="CMOS";
		funcion[9]="red/sonido/SCSI";
		funcion[10]="red/sonido/SCSI";
		funcion[11]="red/sonido/SCSI";
		funcion[12]="PS-Mouse";
		funcion[13]="Co-Procesado";
		funcion[14]="Disco";
		funcion[15]="Libre";
		funcion[15]="Programa";
		
		prioridad[0]="1";
		prioridad[1]="2";
		prioridad[2]=null;
		prioridad[3]="11";
		prioridad[4]="12";
		prioridad[5]="13";
		prioridad[6]="14";
		prioridad[7]="15";
		prioridad[8]="3";
		prioridad[9]="4";
		prioridad[10]="5";
		prioridad[11]="6";
		prioridad[12]="7";
		prioridad[13]="8";
		prioridad[14]="9";
		prioridad[15]="10";
		prioridad[16]="99";
		
		for(int i=0;i<50;i++) {
			IRQ[i]=null;
		}//inicializo el arreglo
	}

	//con esta funcion agregamos una interrpcion
	public void agregarINT(int IRQ, int time,int duration){
		this.IRQ[stack]=Integer.toString(IRQ);
		time_int[stack]=time;
		this.duration[stack]=duration;
		stack++;
		System.out.println("Stack"+stack);
	}
	
	
	//funcion para eliminar interrupciones con el ID
	public void deleteINT(int num) {
		if(IRQ[num+1].equals(null)) {
			IRQ[num]=null;
			time_int[num]=0;
			duration[num]=0;
			stack--;
		}else{
			int cont=num;//esto es para mover las interrupciones al eliminarla
			do {
				IRQ[cont]=IRQ[cont+1];
				time_int[cont]=time_int[cont+1];
				duration[cont]=duration[cont+1];
				cont++;
			}while(!IRQ[cont].equals(null));
			stack--;
		}
	}
	
	public int verificar(){
		int cant=0;
		boolean cantidad[]=new boolean[16];//para verificar cuantas funciones no iguales exiten
		
		for(int i=0;i>16;i++) {
			cantidad[i]=false;
		}//inicializo el arreglo booleano como falso
		
		for(int i=0;i<=stack;i++) {
			if(IRQ[i]!=null) {
				System.out.println("IRQ:"+Integer.parseInt(IRQ[i]));
				cantidad[Integer.parseInt(IRQ[i])]=true;
			}
		}//cambia las funciones existentes a verdadero
		
		for(int i=0;i<16;i++) {
			System.out.println("i="+i);
			if(cantidad[i]==true) {
				System.out.println("Paso aqui");
				cant++;
				impresion[cant]=funcion[i];
			}
			System.out.println("cantidad:"+cant);
		}//con esto determino la cantidad de funciones existentes
		
		
		return cant;
	}
	public int getprioridad(int num) {
		return Integer.parseInt(prioridad[Integer.parseInt(IRQ[num])]);
	}
	
	public String[] getIRQ()
	{
		return IRQ;
	}
	
	public String[] getFunciones()
	{
		return funcion;
	}
	
}
