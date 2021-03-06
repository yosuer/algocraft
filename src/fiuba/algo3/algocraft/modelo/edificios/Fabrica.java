package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ICreadorDeElementos;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.Golliat;

public class Fabrica extends Edificio implements IElementoCreador {

	private ICreadorDeElementos creador;

	public Fabrica() {
		super();
		this.nombre = "Fabrica";
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

	public void ejecutarAcciones() {
		this.creador.expulsarUnidad();
	}

	@Override
	public void pasarTurno() {
		this.estado.pasarTurno();
	}

}
