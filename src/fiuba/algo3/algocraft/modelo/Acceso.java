package fiuba.algo3.algocraft.modelo;

public class Acceso extends Edificio 
								implements ElementoProtoss, 
											IElementoCreador {

	IEstado estado;
	ICreadorDeElementos creador;
	
	public Acceso() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 8;
		this.estadoFisico = new Protoss(500,500);
		this.estado = new Construyendose(this, 8);
		this.creador = new CreadorEnCola(this);
	}
	
	public void crearZealot() {
		this.crearUnidad(new Zealot());
	}
	
	public void crearDragon() {
		this.crearUnidad(new Dragon());
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}
	
	public void actualizarEstado(IEstado estado){
		this.estado = estado;
	}
	
	@Override
	public void pasarTurno() {
		this.estado.pasarTurno();
		this.creador.expulsarUnidad();
	}
	
	public void expulsarUnidad(Unidad u){
		Posicion pos = new Posicion(2,2,0);
		u.setPosicion(pos);
		this.mapa.encolarUnidad(u);
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		this.estado.elementoActivo();
		this.creador.prepararUnidad(unidad);
	}

}
