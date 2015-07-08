package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.excepciones.ErrorNoExisteRecursoEnLaPosicion;
import fiuba.algo3.algocraft.modelo.natural.Vespeno;

public abstract class ExtractorDeGasVespeno extends Edificio implements
		IExtractorDeRecursos {

	protected Vespeno recurso;
	protected int recolectado = 0;

	public int getRecolectado() {
		return this.recolectado;
	}

	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Vespeno) recurso;
	}

	public void agregarseEn(Mapa mapa) {

		try {
			Recurso vespeno = (Recurso) mapa.getElemento(posicion.x(),
					posicion.y(), posicion.z());
			vespeno.asignarExtractor(this);
			mapa.gastarRecursos(costoMineral, costoVespeno);

		} catch (NullPointerException e) {
			throw new ErrorNoExisteRecursoEnLaPosicion();
		} catch (ClassCastException e) {
			throw new ErrorExtractorDeRecursosIncompatible();
		}
		mapa.agregarControlable(this);
		this.mapa = mapa;
	}

	@Override
	public void pasarTurno() {
		this.estado.pasarTurno();
	}

	public void ejecutarAcciones() {
		this.realizarExtraccion();
		this.depositarRecolectado();
	}

	public void depositarRecolectado() {
		this.mapa.recibirVespeno(this.recolectado, this.equipo);
		this.recolectado = 0;
	}

	public void realizarExtraccion() {
		this.recolectado += recurso.extraer();
	}
}
