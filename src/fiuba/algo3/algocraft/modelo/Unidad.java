package fiuba.algo3.algocraft.modelo;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDeTransporteInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;

public abstract class Unidad extends Controlable implements IAtacante,
		ITransportable {

	protected List<Posicion> movimientos; // guardar movimientos
	protected float suministro;
	protected int transporte;
	protected IArma arma;

	public Unidad() {
		this.movimientos = new LinkedList<Posicion>();
	}

	public int vidaActual() {
		return this.estadoFisico.getVida();
	}

	public int getTransporte() {
		return this.transporte;
	}

	public float getSuministro() {
		return this.suministro;
	}

	public List<Posicion> mover(int x, int y) {

		this.estado.estaActivo();

		List<Posicion> movimientos = (List<Posicion>) this.mapa.getHojaDeRuta(
				this.posicion, new Posicion(x, y, nivel));
		movimientos.remove(0);
		this.movimientos = movimientos;
		return movimientos;
	}

	public void moverse() {
		if (!this.movimientos.isEmpty()) {
			Posicion posNueva = this.movimientos.remove(0);
			mapa.moverElemento(this, posNueva);
			this.posicion = posNueva;
		}
	}

	public void agregarseEn(Mapa mapa) {
		Posicion pos = mapa.getPosicionProxima(this.posicion);
		this.setPosicion(pos);
		mapa.agregarControlable(this);
		this.mapa = mapa;
	}

	public Posicion buscarPosicionEnMapa(Mapa mapa) {
		return mapa.getPosicionProxima(this.posicion);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;

		Unidad p = (Unidad) o;
		return (p.getPosicion() == this.posicion);
		// return (o.getClass() == this.getClass());
	}

	public void atacar(IDaniable elemento) {
		Posicion posObjetivo = ((Controlable) elemento).getPosicion();
		int distancia = this.mapa.getDistancia(this.posicion, posObjetivo);

		this.arma.atacar(elemento, distancia);
	}

	public void recibirDanioDe(IArma arma, int distancia) {
		if (distancia > arma.getAlcance(nivel))
			throw new ErrorObjetivoFueraDelAlcance();
		this.estadoFisico.daniarse(arma.getDanio(nivel));
		if (this.estadoFisico.getVida() <= 0)
			this.mapa.quitarElemento(this);
	}

	public void ejecutarAcciones() {
		this.estadoFisico.regenerarse();
		this.moverse();
	}

	public void eliminarseDelMapa(Mapa mapa) {
		this.mapa.desocuparPosicion(this.posicion);
	}

	public boolean listaParaSalir() {
		try {
			this.estado.estaActivo();
		} catch (ErrorEdificioEnConstruccion e) {
			return false;
		} catch (Exception e) {

		}
		return true;
	}

	public Mapa getMapa() {
		return this.mapa;
	}

	public IRazaEstado getEstado() {
		return this.estadoFisico;
	}

	@Override
	public void transportardoPor(ITransporte transporte) {
		if (transporte.capacidadDisponible() < this.transporte)
			throw new ErrorCapacidadDeTransporteInsuficiente();
		this.mapa.desocuparPosicion(this.posicion);
	}

	@Override
	public void descargarseEn(int x, int y) {
		this.mapa.ubicarElemento(this,
				mapa.getPosicionProxima(new Posicion(x, y, nivel)));
		this.posicion = new Posicion(x, y, nivel);
	}

	@Override
	public int getOcupacion() {
		return this.transporte;
	}

}
