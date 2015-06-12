package fiuba.algo3.algocraft.modelo;

public class Barraca extends Edificio 
							implements IElementoCreador{
	
	IEstado estado;
	ICreadorDeElementos creador;
	
	public Barraca() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 12;
		this.estadoFisico = new Terran(1000);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this,12);
	}
	
	public void crearMarine() {
		this.crearUnidad(new Marine());
	}

	@Override
	public void expulsarUnidad(Unidad u) {
		Posicion pos = new Posicion(2,2,0);
		u.setPosicion(pos);
		this.mapa.encolarUnidad(u);
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
		this.creador.expulsarUnidad();
	}
	
	public void actualizarEstado(IEstado estado){
		this.estado = estado;
	}

	@Override
	public void crearUnidad(Unidad u) {
		this.estado.elementoActivo();
		this.creador.prepararUnidad(new Marine());
	}
}
