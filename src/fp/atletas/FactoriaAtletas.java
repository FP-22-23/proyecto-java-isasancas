package fp.atletas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fp.utiles.Medal;
import fp.utiles.Olimpiadas;
import fp.utiles.Season;

public class FactoriaAtletas {
	
	/**
	 * @param nombreFichero Nombre del fichero con datos de atletas.
	 * Devuelve un objeto de tipo Atletas con los datos del fichero.
	 */
	public static Atletas leerAtletas(String nombreFichero) { //Le paso el fichero
		Atletas res=null;
		try {
			Set<Atleta>  atletas=Files.lines(Paths.get(nombreFichero))
					.skip(1)
					.map(FactoriaAtletas::parsearAtleta)
					.collect(Collectors.toSet());
			
			res=new Atletas(atletas);
			} catch(IOException e) {
			System.out.println("Fichero no encontrado: "+ nombreFichero);
			e.printStackTrace();
		}
	return res;
	}
	
	private static Atleta parsearAtleta(String linea) {
		String[] trozos = linea.split(","); //split para separar los elementos de la lista
		//Comprobar que tenemos tantos elementos en el array como atributos esperamos
		if(trozos.length != 15) {
			throw new IllegalArgumentException("La cadena no tiene formato valido");
		}
		//Restricciones
		checkName(trozos[0].trim());
		//Asignaciones con casting si es necesario
		String name = trozos[0].trim(); //trim se usa para eliminar espacios en blanco del principio y final
		String sex = trozos[1].trim();
		Integer age = Integer.valueOf(trozos[2].trim());
		Integer height = Integer.valueOf(trozos[3].trim());
		Double weight = Double.valueOf(trozos[4].trim());
		String team = trozos[5].trim();
		String noc = trozos[6].trim();
		String games = trozos[7].trim();
		Season season = Season.valueOf(trozos[8].trim());
		String city = trozos[9].trim();
		String sport = trozos[10].trim();
		String event = trozos[11].trim();
		Medal medal = Medal.valueOf(trozos[12].trim());
		LocalDate date = LocalDate.parse(trozos[13].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		String other_sports = trozos[14].trim();
		Olimpiadas olimp = new Olimpiadas(noc, games, city);
		return new Atleta(name, sex, age, height, weight, team, season, sport, event, medal, date, other_sports, olimp);
	}
	
	private static void checkName(String s) {
		if (s.replaceAll(" ", "").equals("")) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
	}
}

