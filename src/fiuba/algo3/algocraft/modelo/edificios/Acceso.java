package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.ICreadorDeElementos;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.unidades.Zealot;

public class Acceso extends Edificio implements ElementoProtoss, 
											IElementoCreador {

	private ICreadorDeElementos creador;
	
	public Acceso() {
		super();
		this.nombre = "Acceso";
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
		this.mapa.gastarRecursos(unidad.getCostoMineral(), unidad.getCostoVespeno());
		this.mapa.consumirPoblacion(unidad.getSuministro());
		this.creador.prepararUnidad(unidad);
	}
	
	public void crearZealot() {
		this.crearUnidad(new Zealot());
	}
	
	public void crearDragon() {
		this.crearUnidad(new Dragon());
	}
	
	public void enviarUnidadAlMapa(Unidad unidad) {
		unidad.setPosicion(this.posicion);
		this.mapa.encolarUnidad(unidad);
	}

	public void ejecutarAcciones(){
		this.creador.expulsarUnidad();
		this.estadoFisico.regenerarse();
	}
	
	@Override
	public void vaciarEscudo() {
		this.estadoFisico.daniarse(this.escudoRestante());
	}
}

