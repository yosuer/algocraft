package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ErrorNombreDeJugadorInvalido;

public class Jugador {

	private String nombre;
	private Raza raza;
	
	public Jugador(String nombre) {
		this.validarNombre(nombre);
	}

	private void validarNombre(String nombre) {
		if (nombre.length() >= 4) this.nombre = nombre;
		else throw new ErrorNombreDeJugadorInvalido();
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
