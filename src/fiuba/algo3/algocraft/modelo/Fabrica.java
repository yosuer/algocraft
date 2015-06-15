package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.modelo.unidades.Golliat;

public class Fabrica extends Edificio implements ElementoProtoss, 
												IElementoCreador{

	public Fabrica() {
		super();
		this.costoMineral = 200;
		this.costoVespeno = 100;
		this.edificiosRequeridos.add(new Barraca());
		this.estadoFisico = new Terran(1250);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this, 12);
	}
	
	public void crearGolliat() {
		this.crearUnidad(new Golliat());
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
