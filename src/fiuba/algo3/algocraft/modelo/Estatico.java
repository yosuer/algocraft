package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;

public abstract class Estatico extends IElemento {

	public Estatico() {
		this.nivel = 0;
	}

	@Override
	public void agregarseEn(Mapa mapa) {
		if (mapa.estaOcupado(posicion.x(), posicion.y(), posicion.z()))
			throw new ErrorPosicionOcupada();
		mapa.agregarEstatico(this);
		this.mapa = mapa;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		return (o.getClass() == this.getClass());
	}

}
