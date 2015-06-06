//package fiuba.algo3.algocraft.otros;
//
//import fiuba.algo3.algocraft.excepciones.ErrorNombreDeJugadorInvalido;
//import fiuba.algo3.algocraft.modelo.FabricaDeElementos;
//import fiuba.algo3.algocraft.modelo.Raza;
//
//public class Jugador {
//
//	private String nombre;
//	private Raza raza;
//	private int mineral;
//	private int vespeno;
//	private int poblacion;
//	
//	public Jugador(String nombre) {
//		this.validarNombre(nombre);
//		this.mineral = 200;
//		this.vespeno = 0;
//		this.poblacion = 5;
//	}
//
//	private void validarNombre(String nombre) {
//		if (nombre.length() >= 4) this.nombre = nombre;
//		else throw new ErrorNombreDeJugadorInvalido();
//	}
//
//	public String nombre() {
//		return this.nombre;
//	}
//
//	public void asignarRaza(Raza raza) {
//		this.raza = raza;
//		
//	}
//
//	public Raza raza() {
//		return this.raza;
//	}
//	
//	public boolean equals(Object o)
//	{
//		if(this == o) return true;
//		if (!(o instanceof Jugador)) return false;
//		
//		Jugador j = (Jugador)o;
//		return j.nombre() == this.nombre;
//		
//	}
//
//	public FabricaDeElementos getFabrica() {
//		return this.raza.getFabrica();
//	}
//
////	public ExtractorDeMineral getExtractorDeMineral(Posicion posicion) {
////		ExtractorDeMineral extractor = this.raza.getFabrica().crearExtractorDeMineral(posicion);
////		extractor.setJugador(this);
////		return extractor;
////	}
////
////	public BasePrincipal crearBasePrincipal(Posicion posicion) {
////		BasePrincipal base = this.raza.getFabrica().crearBase(posicion);
////		base.setJugador(this);
////		return base;
////	}
//
//	public int mineral() {
//		return this.mineral;
//	}
//
//	public int vespeno() {
//		return this.vespeno;
//	}
//
//	public int poblacion() {
//		return this.poblacion;
//	}
//
//	public void cobrar(int costoMineral, int costoVespeno) {
//		this.mineral -= costoMineral;
//		this.vespeno -= costoVespeno;
//	}
//	
//}
