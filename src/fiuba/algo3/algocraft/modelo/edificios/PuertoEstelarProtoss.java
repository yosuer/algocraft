package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.ICreadorDeElementos;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.NaveDeTransporteProtoss;
import fiuba.algo3.algocraft.modelo.unidades.Scout;

public class PuertoEstelarProtoss extends Edificio implements ElementoProtoss,
		IElementoCreador {

	protected ICreadorDeElementos creador;

	public PuertoEstelarProtoss() {
		super();
		this.nombre = "PuertoEstelarProtoss";
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.edificiosRequeridos.add(new ArchivoTemplario());
		this.estadoFisico = new Protoss(600, 600);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this, 10);
	}

	public void crearScout() {
		this.crearUnidad(new Scout());
	}

	public void crearNaveDeTransporteProtoss() {
		this.crearUnidad(new NaveDeTransporteProtoss());
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
		this.mapa.gastarRecursos(unidad.getCostoMineral(),
				unidad.getCostoVespeno());
		this.mapa.consumirPoblacion(unidad.getSuministro());
		this.creador.prepararUnidad(unidad);
	}

	@Override
	public void vaciarEscudo() {
		this.estadoFisico.daniarse(this.escudoRestante());
	}

	public void ejecutarAcciones() {
		this.creador.expulsarUnidad();
	}

}
