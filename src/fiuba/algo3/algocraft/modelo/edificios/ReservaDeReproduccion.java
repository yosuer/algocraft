package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ICreadorDeElementos;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;
import fiuba.algo3.algocraft.modelo.unidades.Zerling;

public class ReservaDeReproduccion extends Edificio 
										implements IElementoCreador{

	private ICreadorDeElementos creador;
	
	public ReservaDeReproduccion() {
		super();
		this.nombre = "ReservaDeReproduccion";
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.estado = new Construyendose(this, 10); //tiempo de construccion
		this.creador = new CreadorEnCola(this);
		this.estadoFisico = new Zerg(1000);
	}

	public void evolucionarLarva() {
		this.crearUnidad(new Zerling());
	}

	@Override
	public void enviarUnidadAlMapa(Unidad unidad) {
		Posicion pos = new Posicion(2,2,0);
		unidad.setPosicion(pos);
		this.mapa.encolarUnidad(unidad);
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		this.estado.estaActivo();
		this.mapa.gastarRecursos(unidad.getCostoMineral(), unidad.getCostoVespeno());
		this.creador.prepararUnidad(unidad);
	}
	
	public void ejecutarAcciones(){
		this.creador.expulsarUnidad();
	}
	
	@Override
	public void pasarTurno() {
		this.estado.pasarTurno();
	}

}
