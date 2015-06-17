package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ICreadorDeElementos;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.Marine;

public class Barraca extends Edificio 
							implements IElementoCreador{
	
	private ICreadorDeElementos creador;
	
	public Barraca() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.estadoFisico = new Terran(1000);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this,12);
	}
	
	public void crearMarine() {
		this.crearUnidad(new Marine());
	}

	@Override
	public void enviarUnidadAlMapa(Unidad u) {
		u.setPosicion(posicion);
		this.mapa.encolarUnidad(u);
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		this.estado.estaActivo();
		this.mapa.gastarRecursos(unidad.getCostoMineral(), unidad.getCostoVespeno());
		this.mapa.consumirPoblacion(unidad.getSuministro());
		this.creador.prepararUnidad(unidad);
	}
	
	public void ejecutarAcciones(){
		this.creador.expulsarUnidad();
	}
	
	public int unidadesEnProduccion() {
		return this.creador.unidadesEnProduccion();
	}
}
