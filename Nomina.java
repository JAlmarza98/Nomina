package salariofin;

import java.util.Scanner;

public class Nomina {
	
	//atributos
	private String mes;
	private float sb;
	private float cs;
	private float he;
	private float pe;
	private float se;
	private float noSal;
	private boolean fuerzaMayor;
	private float dinero; //Se refiere al valor de las horas extra
	private float bccc;
	private float bccp;
	private float bche;
	private double cc;
	private double dhe;
	private double des;
	private double fp;
	private double irpf;
	private double dse;
	private float devengos;
	private double deducciones;
	
	//constructores
	Nomina(){};
	Nomina(float sb,float cs,float he,float pe,float se, float noSal, String mes, boolean fuerzaMayor, float dinero){
		this.mes=mes;
		this.sb=sb;
		this.cs=cs;
		this.he=he;
		this.pe=pe;
		this.se=se;
		this.noSal=noSal;
		this.fuerzaMayor=fuerzaMayor;
		
		this.dinero=dinero;
	}
	
	//getter y setter
	public void setMes(String mes) {
		this.mes=mes;
	}
	public String getMes() {
		return mes;
	}
	
	public void setSb(float sb) {
		this.sb=sb;
	}
	public float getSb() {
		return sb;
	}
	
	public void setCs(float cs) {
		this.cs=cs;
	}
	public float getCs() {
		return cs;
	}
	
	public void setHe(float he) {
		this.he=he;
	}
	public float getHe() {
		return he;
	}
	
	public void setPe(float pe) {
		this.pe=pe;
	}
	public float getPe() {
		return pe;
	}
	
	public void setSe(float se) {
		this.se=se;
	}
	public float getSe() {
		return se;
	}
	
	public void setNoSal(float noSal) {
		this.noSal=noSal;
	}
	public float getNoSal() {
		return noSal;
	}
	
	public void setDevengos(float devengos) {
		this.devengos=devengos;
	}
	public float getDevengos() {
		return devengos;
	}
	
	public void setDeducciones(double deducciones) {
		this.deducciones=deducciones;
	}			
	public double getDeducciones() {
		return deducciones;
	}
	//metodos

	public void HorasExtra() {
		Scanner sc=new Scanner(System.in);
		if(he!=0) {
			char horas;
			System.out.println("¿A cuantose pagan las horas extra?");
			dinero=sc.nextFloat();
			do {
				System.out.println("¿Fueron por fuerza mayor? S/N");
				horas=sc.next().charAt(0);
				if(horas=='S' || horas=='s') {
					fuerzaMayor=true;
				}else if(horas=='N' || horas=='n') {
					fuerzaMayor=false;
				}else {
					System.out.println("Introduce S o N");
				}
			}while(horas!='S' && horas!='N');
		}
	}
	
	public void PagasExtra() {
		Scanner sc=new Scanner(System.in);
		char prorra;
		do {
			System.out.println("¿Tienes las pagas prorateadas? S/N");
			prorra=sc.next().charAt(0);
		
			if(prorra=='S' || prorra=='s') {
				pe=(sb+cs)/12;
			
			}else if(prorra=='N' || prorra=='n'){
				if("Junio".compareToIgnoreCase(mes)==0 || "Diciembre".compareToIgnoreCase(mes)==0) {
					pe=sb+cs;
				}
			}else {
				System.out.println("Introduce S o N");
			}
		}while(prorra!='S' && prorra!='N');
	}
	
	public void Bases() {
		float rm=sb+cs;
		float ppe=(pe*2)/12;
		 bccc=rm+ppe;
		 bccp=rm+ppe+he;
		 bche=he*dinero;
	}	
	
	public void Devengos() {
		devengos=sb+cs+bche+pe+se+noSal;
	} 
	
	public void Deducciones() {
		Scanner sc=new Scanner(System.in);
		cc=bccc*0.047;
		System.out.println("Introduce el porcentaje a deducir por desempleo en tanto por uno (Ejemplo: 1,55%=0,0155)");
		double num=sc.nextDouble();
		des=bccp*num;
		fp=bccp*0.0001;
		if(fuerzaMayor==true) {
			dhe=bche*0.02;
		}else {
			dhe=bche*0.047;
		}
		System.out.println("Introduce el porcentaje a deducir por irpf en tanto por uno (Ejemplo: 1,55%=0,0155)");
		num=sc.nextDouble();
		irpf=devengos*num;
		System.out.println("Introduce el porcentaje a deducir por salario en especie en tanto por uno Ejemplo: 1,55%=0.0155 \n (Si no tiene salario en especio ponga 0)");
		num=sc.nextDouble();
		dse=devengos*num; //revisar esto
		deducciones=cc+des+fp+dhe+irpf+dse;
	}
	
	public String toString() {
		return "DEVENGOS\n +P.SAL\n  -Salario base: "+sb+"\n  -Total de complementos: "+cs+"\n  -Horas extra: "+he+"\n  -Paga extra: "+pe+"\n  -Sarario en especias: "+se+"\n +P.NO SAL\n  -No Salarial: "+noSal+"\n TOTAL DEVENGADO ---> "+devengos+"\n"
				+ "DEDUCCIONES\n +Cuotas a la seguridad social\n  -Contigencias comunes"+cc+"\n  -Desempleo: "+des+"\n  -Formacion profesional: "+fp+"\n  -Horas extra: "+dhe+"\n +IRPF: "+irpf+"\n +Salario en especie: "+dse+"\n TOTAL DEDUCIDO ---> "+deducciones+"\n"+
				"BASES DE COTIZACION\n +BCCC: "+bccc+"\n +BCCP: "+bccp+"\n +BCHE: "+bche+"\n LIQUIDO A PERCIBIR ---> "+(devengos-deducciones);
	}
}
