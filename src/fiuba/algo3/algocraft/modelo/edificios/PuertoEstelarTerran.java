package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.unidades.NaveTransporteTerran;

public class PuertoEstelarTerran extends Edificio
										implements IElementoCreador{

	public PuertoEstelarTerran() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.edificiosRequeridos.add(new Fabrica());
		this.estadoFisico = new Terran(1300);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this,10);
	}
	
	public void crearEspectro() {
		this.crearUnidad(new Espectro());
	}
	
	public void crearNaveCiencia() {
		this.crearUnidad(new NaveCiencia());
	}
	
	public void crearNaveDeTransporteTerran() {
		this.crearUnidad(new NaveTransporteTerran());
	}

	@Override
	public void enviarUnidadAlMapa(Unidad unidad) {
		unidad.setPosicion(new Posicion(2,2,0));
		this.mapa.encolarUnidad(unidad);
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
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

}