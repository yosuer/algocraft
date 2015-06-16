package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.modelo.edificios.ReservaDeReproduccion;
import fiuba.algo3.algocraft.modelo.unidades.Hidralisco;

public class GuaridaDeHidralisco extends Edificio 
									implements IElementoCreador{

	public GuaridaDeHidralisco() {
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
		this.edificiosRequeridos.add(new ReservaDeReproduccion());
		this.estadoFisico = new Zerg(1250);
		this.creador = new CreadorEnCola(this);
	}

	//Faltaria poner que se hace Hidralisco a raiz de una Larva
	public void evolucionarLarva() {
		this.crearUnidad(new Hidralisco());
	}

	@Override
	public void enviarUnidadAlMapa(Unidad unidad) {
		unidad.setPosicion(this.posicion);
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
		this.estadoFisico.regenerarse();
	}
	
}
