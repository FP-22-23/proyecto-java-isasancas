package fp.atletas;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Atletas {
	
	private Set<Atleta> atletas;
	
	//Constructor 1
	public Atletas() {
		/**
		 * Crea un objeto de tipo Atletas sin atletas.
		 */
		this.atletas = new HashSet<Atleta>();
	}
	
	//Constructor 2
	public Atletas(Collection<Atleta> atletas) {
		/**
		 * @param atletas Colección de atletas. 
		 * Crea un objeto de tipo Atletas a partir de una colección de atletas.
		 */
		this.atletas = new HashSet<Atleta>(atletas);
	}
	
	//Constructor 3 (Stream)
	public Atletas(Stream<Atleta> atletas) {
		/**
		 * @param partidas Stream de atletas.
		 * Crea un objeto de tipo Atletas a partir de una colección de atletas.
		 */
		this.atletas = atletas.collect(Collectors.toSet());
	}
	
	public Set<Atleta> getAtletas() {
		return new HashSet<Atleta>(this.atletas); //Se hace una copia para no modificar la original
	}

	//Código hash usado en el criterio de igualdad
	public int hashCode() {
		return Objects.hash(atletas);
	}

	//Criterio de igualdad
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atletas other = (Atletas) obj;
		return Objects.equals(atletas, other.atletas);
	}

	//Representación como cadena
	public String toString() {
		return "Atletas [atletas=" + atletas + "]";
	}
	
	//Otras operaciones
	public Integer getNumeroAtletas() {
		return atletas.size();
	}
	
	public void anadirAtleta(Atleta at) {
		this.atletas.add(at);
	}
	
	public void anadirAtletas(Set<Atleta> ats) {
		this.atletas.addAll(ats);
	}
	
	public void eliminaAtleta(Atleta a) {
		atletas.remove(a);
	}
	
	//¿Existe algún atleta que cumpla dicha condición?
	/**
	 * 
	 * @param edad, year
	 * @return Devuelve true o false dependiendo si existe un atleta con la edad especificada en el año especificado.
	 */
	public Boolean existeAtletaEdadAño(Integer edad, Integer year) {
		Boolean res = false;
		for(Atleta at: atletas) {
			if(at.getAge().equals(edad) && Integer.valueOf(at.getDate().getYear()).equals(year)) {
				res = true;
				break;
			}
		}
		return res;
		}
	
	//Contador (con filtrado)
	/**
	 * 
	 * @param f Fecha con la cual filtrar
	 * @return Devuelve el número de atletas que han competido en la fecha especificada por parámetro.
	 */
	public Integer getNumeroAtletasFecha(LocalDate f) {
		Integer res = 0;
		for(Atleta a: atletas) {
			LocalDate fecha = a.getDate();
			if(fecha.equals(f)) {
				res++;
			}
		}
		return res;
	}
	
	//Selección con filtrado
	/**
	 * 
	 * @param p Peso por el cual filtrar
	 * @param t Equipo por el cual filtrar
	 * @return Devuelve un conjunto en el cual aparecen los atletas en los que coinciden el peso y el equipo pasado por parametro.
	 */
	public Set<Atleta> getAtletasPesoEquipo(Double p, String t) {
		Set<Atleta> res = new HashSet<>();
		for(Atleta at: atletas) {
			if((at.getWeight().equals(p)) && (at.getTeam().equals(t))) {
				res.add(at);
			}
		}
		return res;
	}
	
	//Map agrupación
	/**
	 * 
	 * @return Devuelve un map en el cual las claves son los equipos y los valores son conjuntos con los atletas que pertenecen a ese equipo.
	 */
	public Map<String, Set<Atleta>> getAtletasPorEquipo() {
		Map<String, Set<Atleta>> res = new HashMap<String, Set<Atleta>>();
		
		for(Atleta at: atletas) {
			String key = at.getTeam();
			if(res.containsKey(key)) {
				Set<Atleta> value = res.get(key);
				value.add(at);
				res.put(key, value);
			}
			else {
				Set<Atleta> value = new HashSet<>();
				value.add(at);
				res.put(key,  value);
			}
		}
		return res;
	}
	
	//Map acumulación
	/**
	 * 
	 * @return Devuelve un map en el cual las claves son los equipos y los valores son el numero de atletas que pertenecen a ese equipo.
	 */
	public Map<String, Long> getNumeroAtletasPorEquipo() { 
		Map<String, Long> res = new HashMap<String, Long>();
		
		for(Atleta at: atletas) {
			String key = at.getTeam();
			if(res.containsKey(key)) {
				Long value = res.get(key);
				value +=1 ;
				res.put(key, value);
			}
			else {
				Long value = 1L; //Para inicializar Long se usa 1L
				res.put(key, value);
			}
		}
		return res;
	}
	
	//Entrega 3
	
	//Método 1
	//¿Existe algún atleta que cumpla dicha condición? (Stream)
	/**
	 * 
	 * @param edad, year
	 * @return Devuelve true o false dependiendo si existe un atleta con la edad especificada en el año especificado.
	 */
	public Boolean existeAtletaEdadAñoStream(Integer edad, Integer year) {

		Predicate<Atleta> p = at -> at.getAge().equals(edad) && 
				Integer.valueOf(at.getDate().getYear()).equals(year);
		return atletas.stream().anyMatch(p);
	}
	
	//Método 2
	//Contador (con filtrado y stream)
	/**
	 * 
	 * @param f Fecha con la cual filtrar
	 * @return Devuelve el número de atletas que han competido en la fecha especificada por parámetro.
	 */
	public Integer getNumeroAtletasFechaStream(LocalDate f) {
		return Integer.valueOf((int) atletas.stream()
				.filter(av -> av.getDate().equals(f)).count());
	}
	
	//Método 3
	//Selección con filtrado (Stream)
	/**
	 * 
	 * @param p Peso por el cual filtrar
	 * @param t Equipo por el cual filtrar
	 * @return Devuelve un conjunto en el cual aparecen los atletas en los que coinciden el peso y el equipo pasado por parametro.
	 */
	public Set<Atleta> getAtletasPesoEquipoStream(Double p, String t) {
		return atletas.stream()
				.filter(at -> at.getWeight().equals(p) && at.getTeam().equals(t))
				.collect(Collectors.toSet());
	}
	
	//Método 4
	// Máximo (Con filtrado y stream)
	/**
	 * 
	 * @param t Equipo por el cual filtrar
	 * @return Devuelve el atleta de mayor peso filtrado por equipo.
	 */
	public Atleta getAtletaMayorPesoEquipo(String t) {
		Optional<Atleta> opt = atletas.stream()
				.filter(at -> at.getTeam().equals(t))
				.max(Comparator.comparing(av -> av.getWeight()));
				
		Atleta at = opt.orElse(null);

		return at;	
	}
	
	//Método 5
	//Selección  (Con filtrado y ordenación)
	/**
	 * 
	 * @param t Equipo por el cual filtrar
	 * @return Devuelve un conjunto ordenado de los nombres de los atletas ordenados alfabéticamente del equipo pasado por parámetro.
	 */
	public SortedSet<String> getNombreAtletasEquipo(String t) {
		return atletas.stream().filter(at -> at.getTeam().equals(t)).map(Atleta::getName).collect(Collectors.toCollection(TreeSet::new));
	}
	
	//Método 6
	/**
	 * 
	 * @return Devuelve un map en el cual las claves son los equipos y los valores son conjuntos con los atletas que pertenecen a ese equipo.
	 */
	public Map<String, Set<Atleta>> getAtletasPorEquipoStream() {
		return atletas.stream().collect(Collectors.groupingBy(Atleta::getTeam, Collectors.toSet()));
	}
	
	//Método 7
	/**
	 * 
	 * @return Devuelve un map que relaciona los equipos con el nombre de los atletas del equipo.
	 */
	public Map<String, Set<String>> getNombreAtletaPorEquipo() {
		return atletas.stream().collect(Collectors.groupingBy(at -> at.getTeam(), 
				Collectors.mapping(
						Atleta::getName, 	
						Collectors.toSet())));
	}
	
	//Método 8
	/**
	 * 
	 * @return Devuelve un map en el que las claves son los equipos y los valores el atleta con mayor IMC de ese equipo.
	 */
	public Map<String, Atleta> getAtletaMejorIMCPorEquipo() {
		Comparator<Atleta> cmp = Comparator.comparing(at -> at.getIMC());
		return atletas.stream().collect(Collectors.groupingBy(at -> at.getTeam(), 
				Collectors.collectingAndThen(
						Collectors.maxBy(cmp), 
						opt -> opt.get())));
	}
	
	//Método 9
	/**
	 * 
	 * @param n número de atletas que aparecen de cada equipo
	 * @return Devuelve un map en el que las claves son los equipos y los valores los n primeros atletas con mayor IMC.
	 */
	public SortedMap<String,List<String>> getNAtletasMayorIMCPorEquipo(Integer n) {
		return atletas.stream().collect(Collectors.groupingBy(Atleta::getTeam, TreeMap::new, 
				Collectors.collectingAndThen(Collectors.toList(), a -> fAux(a,n))));
	}
	
	//Función auxiliar para el método 9.
	//getNameIMC es una función declarada en el tipo base para que aparezca el nombre y el IMC del atleta.
	/**
	 * 
	 * @param a lista de atletas 
	 * @param n número de atletas que aparecen de cada equipo
	 * @return Devuelve los nombres de los N primeros atletas con IMC más alto.
	 */
	private static List<String> fAux(List<Atleta> a, Integer n) {
		Comparator<Atleta> cmp = Comparator.comparing(Atleta::getIMC);
		return a.stream().sorted(Collections.reverseOrder(cmp))
				.limit(n)
				.map(Atleta::getNameIMC)
				.collect(Collectors.toList());
	}
	
	//Método 10
	/**
	 * 
	 * @return Devuelve el equipo con el mayor IMC de un map en el que las claves son los equipos y los valores el mayor IMC entre todos los atletas 
	 * de ese equipo.
	 */
	public String getEquipoMaxIMC() {
		Comparator<Atleta> cmp = Comparator.comparing(at -> at.getIMC());
		Map<String, Atleta> m = atletas.stream().collect(Collectors.groupingBy(at -> at.getTeam(), 
				Collectors.collectingAndThen(
						Collectors.maxBy(cmp), 
						opt -> opt.get())));
		return m.entrySet().stream()
				.max(Comparator.comparing(entry -> entry.getValue()))
				.get() 
				.getKey();
	}
}
