package fp.utiles;


public record Olimpiadas(String noc, String games, String city) implements Comparable<Olimpiadas>{
	//Ya tenemos implementado: 
	// - El constructor básico 
	// - Los métodos get de las propiedades básicas
	// - toString (con todos los atributos)
	// - equals, hashCode (con todos los atributos)
	
	//Constructor vacío
	public Olimpiadas {
		checkGames(games);
	}
	
	//CompareTo
	public int compareTo(Olimpiadas o) {
		
		int r = noc().compareTo(o.noc());
		if (r == 0) {
			r = this.games().compareTo(o.games());
			if (r == 0) {
				r = this.city().compareTo(o.city());
			}
		}
		return r;
	}
	
	//Restricción
	private void checkGames(String s) {
		if (s.replaceAll(" ", "").equals("")) {
			throw new IllegalArgumentException("Games no puede estar vacio");
		}
	}
}
