package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.ICreadorDeElementos;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.NaveDeTransporteProtoss;
import fiuba.algo3.algocraft.modelo.unidades.Scout;

public class PuertoEstelarProtoss extends Edificio
									implements ElementoProtoss, IElementoCreador{

	protected ICreadorDeElementos creador;
	
	public PuertoEstelarProtoss() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.edificiosRequeridos.add(new Acceso());
		this.estadoFisico = new Protoss(600,600);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this,10);
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
	public void enviarUnidadAlMapa(Unidad u) {
		Posicion pos = new Posicion(2,2,0);
		u.setPosicion(pos);
		this.mapa.encolarUnidad(u);
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		this.estado.estaActivo();
		this.creador.prepararUnidad(unidad);
	}

}
