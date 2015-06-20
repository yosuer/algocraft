package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ICreadorDeElementos;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;
import fiuba.algo3.algocraft.modelo.unidades.Mutalisco;
import fiuba.algo3.algocraft.modelo.unidades.Reina;

public class Espiral extends Edificio implements IElementoCreador {

	private ICreadorDeElementos creador;
	
	public Espiral() {
		super();
		this.nombre = "Espiral";
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.estadoFisico = new Zerg(1300);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this,13);
	}
	
	public void evolucionarLarvaAMutalisco() {
		this.crearUnidad(new Mutalisco());
	}	
	
	public void evolucionarLarvaAReina() {
		this.crearUnidad(new Reina());
	}

	@Override
	public void enviarUnidadAlMapa(Unidad unidad) {
		unidad.setPosicion(posicion);
		this.mapa.encolarUnidad(unidad);
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		this.estado.estaActivo();
		this.mapa.gastarRecursos(unidad.getCostoMineral(), unidad.getCostoVespeno());
		this.creador.prepararUnidad(unidad);
	}	

}
