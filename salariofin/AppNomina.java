package salariofin;

import java.util.Scanner;

public class AppNomina {
	
	public static void Cargar(Nomina P1) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("El mes que vas a calcular: ");
		P1.setMes(sc.nextLine());
		System.out.println("Salario base: ");
		P1.setSb(sc.nextFloat());
		System.out.println("Introduce todos los complementos salariales (introduce 0 para acabar): ");
		do {
		P1.setCs(P1.getCs()+sc.nextFloat());
		}while(sc.nextFloat()!=0);
		System.out.println("Horas extras del mes: ");
		P1.setHe(sc.nextFloat());
		System.out.println("Pagas extras: ");
		P1.setPe(sc.nextFloat());		
		System.out.println("Salario en especie: ");
		P1.setSe(sc.nextFloat());
		System.out.println("Pagos no salariales: ");
		P1.setNoSal(sc.nextFloat());
		System.out.println("  ");
		
	}

	public static void main(String[] args) {
		Nomina P1=new Nomina();
		double porciento;
		System.out.println("Introduce los datos de la persona");
		Cargar(P1);
		
		P1.PagasExtra();
		P1.HorasExtra();
		P1.Bases();
		P1.Devengos();
		P1.Deducciones();
		porciento=(P1.getDevengos()-P1.getDeducciones())*0.3;
		if(P1.getSe()<=porciento) {
			System.out.println(P1);
		}else {
			System.out.println("El el Salario en especie es superior al permitido");
		}
		
		
	}

}
