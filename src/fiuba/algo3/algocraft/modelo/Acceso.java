package fiuba.algo3.algocraft.modelo;

public class Acceso extends Edificio implements ElementoProtoss, 
											IElementoCreador {

	public Acceso() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.estadoFisico = new Protoss(500,500);
		this.estado = new Construyendose(this, 8); //tiempo de construccion
		this.creador = new CreadorEnCola(this);
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
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	@Override
	public void crearUnidad(Unidad unidad) {
		this.estado.estaActivo();
		this.mapa.gastarRecursos(unidad.costoMineral, unidad.costoVespeno);
		this.creador.prepararUnidad(unidad);
	}
	
	public void crearZealot() {
		this.crearUnidad(new Zealot());
	}
	
	public void crearDragon() {
		this.crearUnidad(new Dragon());
	}
	
	public void enviarUnidadAlMapa(Unidad unidad){
		Posicion pos = new Posicion(2,2,0);
		unidad.setPosicion(pos);
		this.mapa.encolarUnidad(unidad);
	}

	public void ejecutarAcciones(){
		this.creador.expulsarUnidad();
	}

}
