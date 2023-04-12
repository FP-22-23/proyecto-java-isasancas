package fp.atletas.test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import fp.atletas.Atleta;
import fp.atletas.Atletas;
import fp.atletas.FactoriaAtletas;

public class TestAtletas { //IMPORTANTE DESMARCAR LA OPCIÓN DE LÍMITE DE LA CONSOLA PARA QUE APAREZCA TODO YA QUE LOS DICCIONARIOS SON DEMASIADO 
							//LARGOS PARA EL LÍMITE QUE VIENE POR DEFECTO -> 
							//Window->Preferences->Run/Debug->Console->Limit Console Output

	public static void main(String[] args) {
		
		Atletas atletas = FactoriaAtletas.leerAtletas("data/athlete_events.csv");
		
		System.out.println("\ntestGetNumeroAtletas");
		System.out.println("====================");
		testgetNumeroAtletas(atletas);
		
		System.out.println("\ntestExisteAtletaEdadAño");
		System.out.println("=======================");
		testexisteAtletaEdadAño(atletas, 24, 2016);
		testexisteAtletaEdadAño(atletas, 23, 1934);
		
		System.out.println("\ntestGetNumeroAtletasFecha");
		System.out.println("=========================");
		testgetNumeroAtletasFecha(atletas, LocalDate.of(2016, 7, 5));
		testgetNumeroAtletasFecha(atletas, LocalDate.of(1966, 4, 3));
		
		System.out.println("\ntestGetAtletasPesoEquipo");
		System.out.println("========================");
		testgetAtletasPesoEquipo(atletas, 64.0, "Norway");
		testgetAtletasPesoEquipo(atletas, 0.0, "United States");
		
		System.out.println("\ntestGetAtletasPorEquipo"); 
		System.out.println("=======================");
		testgetAtletasPorEquipo(atletas);
		
		System.out.println("\ntestGetNumeroAtletasPorEquipo");
		System.out.println("=============================");
		testgetNumeroAtletasPorEquipo(atletas);
	}
	
	private static void testgetNumeroAtletas(Atletas atletas) {
		try {
			String msg = String.format("El número de atletas es " + atletas.getNumeroAtletas());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testexisteAtletaEdadAño(Atletas atletas, Integer edad, Integer year) {
		try {
			String msg = String.format("¿Hay algún atleta que tenga " + edad + " años en el año " +
		year + "? " + atletas.existeAtletaEdadAño(edad, year));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testgetNumeroAtletasFecha(Atletas atletas, LocalDate f) {
		try {
			String msg = String.format("El número de atletas en la fecha " + f + " es " + atletas.getNumeroAtletasFecha(f));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testgetAtletasPesoEquipo(Atletas atletas, Double p, String t) {
		try {
			String msg = String.format("Los atletas con peso " + p + " y equipo " + t + " son " + atletas.getAtletasPesoEquipo(p, t));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	public static void testgetAtletasPorEquipo(Atletas atletas) {
		try {
			String msg = String.format("Los atletas agrupados por equipos: ");
			System.out.println(msg);
			Map<String, Set<Atleta>> m = atletas.getAtletasPorEquipo();
			System.out.println(m);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetNumeroAtletasPorEquipo(Atletas atletas) {
		try {
			String msg = String.format("El número de atletas por equipo: ");
			System.out.println(msg);
			Map<String, Long> m = atletas.getNumeroAtletasPorEquipo();
			System.out.println(m);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}

}
