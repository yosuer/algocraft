package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.modelo.unidades.Mutalisco;
import fiuba.algo3.algocraft.modelo.unidades.Reina;

public class Espiral extends Edificio implements IElementoCreador {

	public Espiral() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 13;
		this.estadoFisico = new Zerg(1300);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this,12);
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
		this.mapa.gastarRecursos(unidad.costoMineral, unidad.costoVespeno);
		this.creador.prepararUnidad(unidad);
	}	

}
