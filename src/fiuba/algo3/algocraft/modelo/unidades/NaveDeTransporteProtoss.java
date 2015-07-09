package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.ITransportable;
import fiuba.algo3.algocraft.modelo.ITransportador;
import fiuba.algo3.algocraft.modelo.ITransporte;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.TransportadorSimple;
import fiuba.algo3.algocraft.modelo.Unidad;

public class NaveDeTransporteProtoss extends Unidad implements ElementoProtoss,
		ITransporte {

	private ITransportador transportador;

	public NaveDeTransporteProtoss() {
		super();
		this.nombre = "NaveTransporteProtoss";
		this.transporte = 8;
		this.vision = 8;
		this.costoMineral = 200;
		this.costoVespeno = 0;
		this.suministro = 2;
		this.estadoFisico = new Protoss(80, 60);
		this.estado = new Construyendose(this, 8);
		this.nivel = 1;
		this.transportador = new TransportadorSimple(this,
				new IntRango(0, 7, 7));
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

	@Override
	public void vaciarEscudo() {
		this.estadoFisico.daniarse(this.escudoRestante());
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