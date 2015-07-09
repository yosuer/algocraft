package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ITransportable;
import fiuba.algo3.algocraft.modelo.ITransportador;
import fiuba.algo3.algocraft.modelo.ITransporte;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.TransportadorSimple;
import fiuba.algo3.algocraft.modelo.Unidad;

public class NaveTransporteTerran extends Unidad implements ITransporte {

	private ITransportador transportador;

	public NaveTransporteTerran() {
		super();
		this.nombre = "NaveTransporteTerran";
		this.transporte = 0;
		this.vision = 8;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.suministro = 2;
		this.estadoFisico = new Terran(150);
		this.estado = new Construyendose(this, 7);
		this.nivel = 1;
		this.transportador = new TransportadorSimple(this,
				new IntRango(0, 7, 7));
	}

	@Override
	public void transportar(ITransportable elemento) {
		transportador.transportar(elemento);
	}

	@Override
	public void descargar() {
		transportador.descargar(posicion.x(), posicion.y());
	}

	@Override
	public void descargar(int x, int y) {
		transportador.descargar(x, y);
	}

	@Override
	public int capacidadDisponible() {
		return transportador.capacidadDisponible();
	}

	@Override
	public void expulsarUnTransportable(int x, int y) {
		transportador.expulsarUnTransportable(x, y);
	}
}