package fiuba.algo3.algocraft;

public class Vespeno extends Elemento implements Recurso {

	private Posicion posicion;
	private int reserva;

	public Vespeno(Posicion posicion) {
		super(posicion);
		this.reserva = 5000;
	}

	@Override
	public int reservaDisponible() {
		return this.reserva;
	}

	@Override
	public int extraer() {
		return 0;
	}
	
}
