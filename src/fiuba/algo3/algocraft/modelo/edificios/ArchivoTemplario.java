package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.ICreadorDeElementos;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.AltoTemplario;

public class ArchivoTemplario extends Edificio implements ElementoProtoss,
														IElementoCreador{

	private ICreadorDeElementos creador;
	
	public ArchivoTemplario() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 200;
		this.edificiosRequeridos.add(new PuertoEstelarProtoss());
		this.estado = new Construyendose(this, 9); //tiempo de construccion
		this.estadoFisico = new Protoss(500,500);
		this.creador = new CreadorEnCola(this);
	}

	public void crearAltoTemplario() {
		this.crearUnidad(new AltoTemplario());
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
		unidad.setPosicion(this.posicion);
		this.mapa.encolarUnidad(unidad);
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		this.estado.estaActivo();
		this.mapa.gastarRecursos(unidad.getCostoMineral(), unidad.getCostoVespeno());
		this.creador.prepararUnidad(unidad);
	}
	

	@Override
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public void ejecutarAcciones(){
		this.creador.expulsarUnidad();
		this.regenerarse();
	}

}
