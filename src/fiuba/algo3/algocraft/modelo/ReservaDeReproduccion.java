package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.modelo.unidades.Zerling;

public class ReservaDeReproduccion extends Edificio 
										implements IElementoCreador{

	public ReservaDeReproduccion() {
		super();
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
		this.mapa.gastarRecursos(unidad.costoMineral, unidad.costoVespeno);
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
