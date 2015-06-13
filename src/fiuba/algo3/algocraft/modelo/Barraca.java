package fiuba.algo3.algocraft.modelo;

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
		Posicion pos = new Posicion(2,2,0);
		u.setPosicion(pos);
		this.mapa.encolarUnidad(u);
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
	}

	@Override
	public void crearUnidad(Unidad u) {
		this.estado.estaActivo();
		this.mapa.gastarRecursos(u.costoMineral, u.costoVespeno);
		this.creador.prepararUnidad(u);
	}
	
	public void ejecutarAcciones(){
		this.creador.expulsarUnidad();
	}
}
