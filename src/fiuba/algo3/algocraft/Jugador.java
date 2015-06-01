package fiuba.algo3.algocraft;

public class Jugador {

	private String nombre;
	private Raza raza;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public String nombre() {
		return this.nombre;
	}

	public void asignarRaza(Raza raza) {
		this.raza = raza;
		
	}

	public Raza raza() {
		return this.raza;
	}
	
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if (!(o instanceof Jugador)) return false;
		
		Jugador j = (Jugador)o;
		return j.nombre() == this.nombre;
		
	}

}
