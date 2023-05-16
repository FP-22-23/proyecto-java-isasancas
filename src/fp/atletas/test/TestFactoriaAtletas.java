package fp.atletas.test;

import fp.atletas.Atletas;
import fp.atletas.FactoriaAtletas;

public class TestFactoriaAtletas {

	public static void main(String[] args) {
		testLeerAtletas("data/athlete_events.csv");
		testLeerAtletasStream("data/athlete_events.csv");
		
	}

	private static void testLeerAtletas(String fichero) {
		System.out.println("\nTestLeerAtletas =============");
		Atletas atletas = FactoriaAtletas.leerAtletas(fichero);
		System.out.println("Atletas: "+ atletas);
	}
	
	private static void testLeerAtletasStream(String fichero) {
		System.out.println("\nTestLeerAtletas =============");
		Atletas atletas = FactoriaAtletas.leerAtletasStream(fichero);
		System.out.println("Atletas: "+ atletas);
	}

}
