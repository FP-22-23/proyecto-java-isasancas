package fp.atletas;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import fp.utiles.Medal;
import fp.utiles.Olimpiadas;
import fp.utiles.Season;


public class Atleta implements Comparable<Atleta> {
	//Propiedades básicas
	private String name;
	private Boolean sex;
	private Integer age;
	private Integer height;
	private Double weight;
	private String team;
	private Season season;
	private String sport;
	private String event;
	private Medal medal;
	private LocalDate date;
	private List<String> other_sports;
	private Olimpiadas olimp;
	
	
	//Propiedad derivada: obtener el Índice de Masa Corporal en función del peso y la altura.
	/**
	 * @return El Indice de Masa Corporal del atleta. Se calcula a partir de la altura y el peso.
	 */
	public Double getIMC() {
		Double res = getWeight()/((getHeight()/100)^2);
		return res;
	}
	
	//Restricción 1
	private void checkName(String s) {
		if (s.replaceAll(" ", "").equals("")) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
	}
	
	//Restricción 2
	private void checkDate(LocalDate date) {
		LocalDate f1 = LocalDate.of(1900, 1, 1);
		LocalDate f2 = LocalDate.of(2017, 1, 1);
		if (date.isBefore(f1) || date.isAfter(f2)) {
		throw new IllegalArgumentException(
		"La fecha debe estar comprendida entre el 1/1/1900 y el 1/1/2017." + date.toString());
		}
	}
	
	//Constructor 1
	public Atleta(String name, String team, String event, Medal medal, LocalDate date, String other_sports) {
		
		//Restricciones
		checkName(name);
		checkDate(date);
		
		//Asignaciones
		this.name = name;
		this.sex = null;
		this.age = null;
		this.height = null;
		this.weight = null;
		this.team = team;
		this.season = null;
		this.sport = null;
		this.event = event;
		this.medal = medal;
		this.date = date;
		this.other_sports = parseaOtherSports(other_sports);
		this.olimp = null;
	}
	
	/**
	 * @param name Indica el nombre del atleta. 
	 * @param sex Indica el sexo del atleta. Si es Masculino asociamos true y si es femenino asociamos false.
	 * @param age Indica la edad del atleta. Si no se conoce, aparece un 0.
	 * @param height Indica la altura del atleta. Si no se conoce, aparece un 0.
	 * @param weight Indica el peso del atleta. Si no se conoce, aparece un 0.
	 * @param team Indica el equipo al que pertenece el atleta. 
	 * @param season Indica la estacion de los Juegos. Puede ser Summer o Winter.
	 * @param sport Indica en que deporte ha participado el atleta.
	 * @param event Indica en que evento en concreto ha participado el atleta dentro de su deporte.
	 * @param medal Indica la medalla que ha ganado el atleta en ese evento. Puede ser bronze, silver o gold.
	 * @param date Indica la fecha de apertura de los juegos. Ha sido generado aleatoriamente.
	 * @param other_sports Indica otros deportes que practica el atleta. Ha sido generado aleatoriamente.
	 * @param olimp Indica informacion sobre los Juegos en los que ha participado el atleta, mas concretamente las siglas del Comite Olimpico, 
	 * el nombre de los Juegos y la ciudad.
	 * @throws IllegalArgumentException si el nombre esta vacio.
	 * @throws IllegalArgumentException si la fecha no esta entre el 1/1/1900 y el 1/1/2017.
	 */
	
	//Constructor 2
	public Atleta(String name, String sex, Integer age, Integer height, Double weight, String team, Season season,
			String sport, String event, Medal medal, LocalDate date, String other_sports, Olimpiadas olimp) {
		
		//Restricciones
		checkName(name);
		checkDate(date);
				
		this.name = name;
		this.sex = parseaSex(sex);
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.team = team;
		this.season = season;
		this.sport = sport;
		this.event = event;
		this.medal = medal;
		this.date = date;
		this.other_sports = parseaOtherSports(other_sports);
		this.olimp = olimp;
	}

	//Parseos
	private Boolean parseaSex(String sex) {
		Boolean res = false;
		if (sex.equals("M")) {
			res = true;
		}
		return res;
	}
	
	private List<String> parseaOtherSports(String other_sports) {
		String[] trozos = other_sports.split("/");
		return Arrays.asList(trozos);
	}

	//Getters and setters
	/**
	 * @return El nombre del atleta.
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return El sexo del atleta.
	 */
	public String getSex() {
		String res = "M";
		if(sex == false) {
			res = "F";
		}
		return res;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	/**
	 * @return La edad del atleta
	 */
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return La altura del atleta.
	 */
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	/**
	 * @return El peso del atleta.
	 */
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return El equipo del atleta.
	 */
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @return La estacion de los Juegos.
	 */
	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	/**
	 * @return El deporte que practica el atleta.
	 */
	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	/**
	 * @return El evento en el que participa el atleta.
	 */
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return La medalla que gano el atleta.
	 */
	public Medal getMedal() {
		return medal;
	}

	public void setMedal(Medal medal) {
		this.medal = medal;
	}

	/**
	 * @return La fecha de apertura de los Juegos.
	 */
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return Otro deportes que practica el atleta.
	 */
	public List<String> getOther_sports() {
		return other_sports;
	}

	/**
	 * @return Informacion de los Juegos.
	 */
	public Olimpiadas getOlimp() {
		return olimp;
	}

	//Código hash usado en el criterio de igualdad
	public int hashCode() {
		return Objects.hash(age, date, event, height, medal, name, olimp, other_sports, season, sex, sport, team,
				weight);
	}

	//Criterio de igualdad
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(age, other.age) && Objects.equals(date, other.date) && Objects.equals(event, other.event)
				&& Objects.equals(height, other.height) && medal == other.medal && Objects.equals(name, other.name)
				&& Objects.equals(olimp, other.olimp) && Objects.equals(other_sports, other.other_sports)
				&& season == other.season && Objects.equals(sex, other.sex) && Objects.equals(sport, other.sport)
				&& Objects.equals(team, other.team) && Objects.equals(weight, other.weight);
	}

	//Criterio de orden natural
	/**
	 * @return Los atletas se ordenan por nombre y evento.
	 */
	public int compareTo(Atleta a) {
		
		int r = getName().compareTo(a.getName());
		if (r == 0) {
			r = this.getEvent().compareTo(a.getEvent());
		}
		return r;
	}

	//Representación como cadena
	public String toString() {
		return "Atleta [name=" + name + ", sex=" + sex + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", team=" + team + ", season=" + season + ", sport=" + sport + ", event=" + event + ", medal=" + medal
				+ ", date=" + date + ", other_sports=" + other_sports + ", olimp=" + olimp + "]";
	}
	
}
