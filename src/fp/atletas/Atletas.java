package fp.atletas;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
	 * @return Devuelve true o false dependiendo si existe un atleta con la edad especificada en el año especificado.
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
}
