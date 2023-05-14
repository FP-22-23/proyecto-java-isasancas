package fp.atletas.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import fp.atletas.Atleta;
import fp.atletas.Atletas;
import fp.atletas.FactoriaAtletas;

public class TestAtletas { //IMPORTANTE DESMARCAR LA OPCIÓN DE LÍMITE DE LA CONSOLA PARA QUE APAREZCA TODO YA QUE LOS DICCIONARIOS SON DEMASIADO 
							//LARGOS PARA EL LÍMITE QUE VIENE POR DEFECTO -> 
							//Window->Preferences->Run/Debug->Console->Limit Console Output

	public static void main(String[] args) {
		
		Atletas atletas = FactoriaAtletas.leerAtletas("data/athlete_events.csv");
		
		System.out.println("\ntestGetNumeroAtletas");
		System.out.println("--------------------");
		testgetNumeroAtletas(atletas);
		
		System.out.println("\ntestExisteAtletaEdadAño");
		System.out.println("-----------------------");
		testexisteAtletaEdadAño(atletas, 24, 2016);
		testexisteAtletaEdadAño(atletas, 23, 1934);
		
		System.out.println("\ntestGetNumeroAtletasFecha");
		System.out.println("-------------------------");
		testgetNumeroAtletasFecha(atletas, LocalDate.of(2016, 7, 5));
		testgetNumeroAtletasFecha(atletas, LocalDate.of(1966, 4, 3));
		
		System.out.println("\ntestGetAtletasPesoEquipo");
		System.out.println("------------------------");
		testgetAtletasPesoEquipo(atletas, 64.0, "Norway");
		testgetAtletasPesoEquipo(atletas, 0.0, "United States");
		
		System.out.println("\ntestGetAtletasPorEquipo"); 
		System.out.println("-----------------------");
		testgetAtletasPorEquipo(atletas);
		
		System.out.println("\ntestGetNumeroAtletasPorEquipo");
		System.out.println("-----------------------------");
		testgetNumeroAtletasPorEquipo(atletas);
		
		System.out.println("\ntestexisteAtletaEdadAñoStream");
		System.out.println("-----------------------------");
		testexisteAtletaEdadAñoStream(21, 2016, atletas);
		
		System.out.println("\ntestgetNumeroAtletasFechaStream");
		System.out.println("-------------------------------");
		testgetNumeroAtletasFechaStream(LocalDate.of(2016, 5, 5), atletas);
		
		System.out.println("\ntestgetAtletasPesoEquipoStream");
		System.out.println("------------------------------");
		testgetAtletasPesoEquipoStream(86.0, "France", atletas);
		
		System.out.println("\ntestgetAtletaMayorPesoEquipo");
		System.out.println("----------------------------");
		testgetAtletaMayorPesoEquipo("Spain", atletas);
		
		System.out.println("\ntestgetNombreAtletasEquipo");
		System.out.println("--------------------------");
		testgetNombreAtletasEquipo("Spain", atletas);
		
		System.out.println("\ntestgetAtletasPorEquipoStream");
		System.out.println("-----------------------------");
		testgetAtletasPorEquipoStream(atletas);
		
		System.out.println("\ntestgetNombreAtletaPorEquipo");
		System.out.println("----------------------------");
		testgetNombreAtletaPorEquipo(atletas);
		
		System.out.println("\ntestgetAtletaMejorIMCPorEquipo");
		System.out.println("------------------------------");
		testgetAtletaMejorIMCPorEquipo(atletas);
		
		System.out.println("\ntestgetNAtletasMayorIMCPorEquipo");
		System.out.println("--------------------------------");
		testgetNAtletasMayorIMCPorEquipo(2 , atletas);
		
		System.out.println("\ntestgetEquipoMaxIMC");
		System.out.println("-------------------");
		testgetEquipoMaxIMC(atletas);
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
	
	public static void testexisteAtletaEdadAñoStream(Integer edad, Integer year, Atletas atletas) {
		try {
			String msg = String.format("¿Hay algún atleta que tenga "+ edad + " años en el año " + year + "? " + atletas.existeAtletaEdadAñoStream(edad, year));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetNumeroAtletasFechaStream(LocalDate f, Atletas atletas) {
		try {
			String msg = String.format("Número de atletas que participaron en la fecha " + f + ": " + atletas.getNumeroAtletasFechaStream(f));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetAtletasPesoEquipoStream(Double p, String t, Atletas atletas) {
		try {
			String msg = String.format("Los atletas con peso " + p + " y equipo " + t + " son: " + atletas.getAtletasPesoEquipoStream(p, t));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetAtletaMayorPesoEquipo(String t, Atletas atletas) {
		try {
			String msg = String.format("El atleta con mayor peso del equipo " + t + " es: " + atletas.getAtletaMayorPesoEquipo(t));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetNombreAtletasEquipo(String t, Atletas atletas) {
		try {
			String msg = String.format("Los atletas del equipo " + t + " ordenados por orden alfabético son: " + atletas.getNombreAtletasEquipo(t));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetAtletasPorEquipoStream(Atletas atletas) {
		try {
			String msg = String.format("Los atletas por equipo: ");
			System.out.println(msg);
			Map<String, Set<Atleta>> m = atletas.getAtletasPorEquipoStream();
			System.out.println(m);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetNombreAtletaPorEquipo(Atletas atletas) {
		try {
			String msg = String.format("Los nombres de los atletas por equipo: ");
			System.out.println(msg);
			Map<String, Set<String>> m = atletas.getNombreAtletaPorEquipo();
			System.out.println(m);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetAtletaMejorIMCPorEquipo(Atletas atletas) {
		try {
			String msg = String.format("El atleta con el mayor IMC por equipo: ");
			System.out.println(msg);
			Map<String, Atleta> m = atletas.getAtletaMejorIMCPorEquipo();
			System.out.println(m);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetNAtletasMayorIMCPorEquipo(Integer n, Atletas atletas) {
		try {
			String msg = String.format("Los " + n + " mejores atletas con mayor IMC por equipo: ");
			System.out.println(msg);
			SortedMap<String,List<String>> m = atletas.getNAtletasMayorIMCPorEquipo(n);
			System.out.println(m);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testgetEquipoMaxIMC(Atletas atletas) {
		try {
			String msg = String.format("El equipo con el atleta de mayor IMC es: " + atletas.getEquipoMaxIMC());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}

}
