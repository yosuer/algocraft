package fiuba.algo3.algocraft.modelo.unidades;

import java.util.LinkedList;
import java.util.Queue;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ITransportable;
import fiuba.algo3.algocraft.modelo.ITransporte;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;

public class NaveTransporteTerran extends Unidad implements ITransporte{

	private Queue<ITransportable> unidadesCargadas;
	private IntRango capacidad;
	
	public NaveTransporteTerran() {
		this.transporte = 0;
		this.vision = 8;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.suministro = 2;
		this.estadoFisico = new Terran(150);
		this.estado = new Construyendose(this,7);
		this.nivel = 1;
		this.unidadesCargadas = new LinkedList<ITransportable>();
		this.capacidad = new IntRango(0,7,7);
	}

	@Override
	public void transportar(ITransportable elemento) {
		elemento.transportardoPor(this);
		unidadesCargadas.add(elemento);
		this.capacidad.disminuir(elemento.getOcupacion());
	}

	@Override
	public void descargar() {
		int cantUnidades = unidadesCargadas.size();
		for (int i=1; i<= cantUnidades; i++) {
			expulsarUnTransportable(posicion.x(),posicion.y());
		}
	}

	@Override
	public void descargar(int x, int y) {
		int cantUnidades = unidadesCargadas.size();
		for (int i=1; i<= cantUnidades; i++) {
			expulsarUnTransportable(x,y);
		}
	}

	@Override
	public int capacidadDisponible() {
		return this.capacidad.valor();
	}
	
	private void expulsarUnTransportable(int x, int y){
		ITransportable t = unidadesCargadas.remove();
		t.descargarseEn(x,y);
		this.capacidad.aumentar(t.getOcupacion());
	}

}
