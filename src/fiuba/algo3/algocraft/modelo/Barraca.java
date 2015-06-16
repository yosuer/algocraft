package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.modelo.unidades.Marine;

public class Barraca extends Edificio 
							implements IElementoCreador{
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
		this.mapa.gastarRecursos(unidad.costoMineral, unidad.costoVespeno);
		this.mapa.consumirPoblacion(unidad.getSuministro());
		this.creador.prepararUnidad(unidad);

	}
	
	public void ejecutarAcciones(){
		this.creador.expulsarUnidad();
	}
}
