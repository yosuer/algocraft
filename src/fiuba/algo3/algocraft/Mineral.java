package fiuba.algo3.algocraft;

public class Mineral extends Elemento implements Recurso {

	
	private Posicion posicion;
	private int reserva;

	public Mineral(Posicion posicion) {
		super(posicion);
		this.reserva = 1000;
	}

	@Override
	public int reservaDisponible() {
		return this.reserva;
	}

	@Override
	public int extraer() {
		if (this.reserva > 0) {
			this.reserva-=10;
			return 10;
		}
		else return 0;
	}
	

}
