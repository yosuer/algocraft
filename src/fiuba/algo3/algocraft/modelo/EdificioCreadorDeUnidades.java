package fiuba.algo3.algocraft.modelo;

public class EdificioCreadorDeUnidades extends Edificio implements IElementoCreador {
	
	protected ICreadorDeElementos creador;
	
	public EdificioCreadorDeUnidades()
	{
		super();
		this.creador = new CreadorEnCola(this);
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

}
