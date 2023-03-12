package fp.atletas.test;

import java.time.LocalDate;

import fp.atletas.Atleta;
import fp.utiles.Medal;
import fp.utiles.Olimpiadas;
import fp.utiles.Season;

public class AtletaTest {

	public static void main(String[] args) {
		
		Olimpiadas olimp = new Olimpiadas("FIN","2014 Winter","Sochi");
		
		Atleta at = new Atleta("Juhamatti Tapio Aaltonen","M",28,184,85.0,"Finland",Season.WINTER,
				"Ice Hockey","Ice Hockey Men's Ice Hockey",Medal.BRONZE, LocalDate.now(),"paddle/swimming/tennis", 
				olimp);
		
		System.out.println("Atleta 1:");
		System.out.println(at);
		System.out.println("Índice de Masa Corporal del atleta 1:");
		System.out.println(at.getIMC());
		System.out.println("Sexo del atleta 1:");
		System.out.println(at.getSex());

		Atleta at2 = new Atleta("Juhamatti Tapio Aaltonen","M",28,184,85.0,"Finland",Season.WINTER,
				"Ice Hockey","Ice Hockey Men's Ice Hockey",Medal.BRONZE,LocalDate.now(),"paddle/swimming/tennis", 
				olimp);
		
		System.out.println("¿Son el atleta 1 y el atleta 2 iguales?");
		System.out.println(at.equals(at2));
		
		Atleta at3 = new Atleta("Kjetil Andr Aamodt","M",28,184,85.0,"Finland",Season.WINTER,
				"Ice Hockey","Ice Hockey Men's Ice Hockey",Medal.BRONZE,LocalDate.now(),"paddle/swimming/tennis", 
				olimp);
		
		System.out.println("¿Son el atleta 2 y el atleta 3 iguales?");
		System.out.println(at2.equals(at3));
		
		System.out.println("Criterio de orden natural del atleta 1 y 2:");
		System.out.println(at.compareTo(at2));
		System.out.println("Criterio de orden natural del atleta 2 y 3:");
		System.out.println(at2.compareTo(at3));
		
		System.out.println("Representación como cadena del atleta 1:");
		System.out.println(at.toString());
		
		Atleta at4 = new Atleta("","M",28,184,85.0,"Finland",Season.WINTER,
				"Ice Hockey","Ice Hockey Men's Ice Hockey",Medal.BRONZE,LocalDate.now(),"paddle/swimming/tennis", 
				olimp);
		
		//Aquí salta la excepción ya que el nombre no puede estar vacío
		System.out.println("Atleta 4:");
		System.out.println(at4);
	}

}
