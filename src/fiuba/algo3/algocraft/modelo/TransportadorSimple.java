package fiuba.algo3.algocraft.modelo;

import java.util.LinkedList;
import java.util.Queue;

import fiuba.algo3.algocraft.excepciones.ErrorElementoNoTransportable;

public class TransportadorSimple implements ITransportador {

	private ITransporte transporte;
	private Queue<ITransportable> unidadesCargadas;
	private IntRango capacidad;

	public TransportadorSimple(ITransporte transporte, IntRango capacidad) {
		this.transporte = transporte;
		this.capacidad = capacidad;
		this.unidadesCargadas = new LinkedList<ITransportable>();
	}

	@Override
	public void transportar(ITransportable elemento) {
		if (elemento.getOcupacion() == 0)
			throw new ErrorElementoNoTransportable();
		elemento.transportardoPor(transporte);
		unidadesCargadas.add(elemento);
		this.capacidad.disminuir(elemento.getOcupacion());
	}

	@Override
	public void descargar(int x, int y) {
		int cantUnidades = unidadesCargadas.size();
		for (int i = 1; i <= cantUnidades; i++)
			expulsarUnTransportable(x, y);
	}

	@Override
	public int capacidadDisponible() {
		return this.capacidad.valor();
	}

	@Override
	public void expulsarUnTransportable(int x, int y) {
		ITransportable t = unidadesCargadas.remove();
		t.descargarseEn(x, y);
		this.capacidad.aumentar(t.getOcupacion());
	}
}
