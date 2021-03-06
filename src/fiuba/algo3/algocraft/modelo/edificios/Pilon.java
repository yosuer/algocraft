package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.IEstado;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Protoss;

public class Pilon extends Edificio implements ElementoProtoss {

	private int poblacion;

	public Pilon() {
		this.nombre = "Pilon";
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Protoss(300, 300);
		this.estado = new Construyendose(this, 5);
		this.poblacion = 5;
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

	public void actualizarEstado(IEstado estado) {
		this.estado = estado;
		this.mapa.aumentarPoblacion(poblacion, equipo);
	}

	@Override
	public void vaciarEscudo() {
		this.estadoFisico.daniarse(this.escudoRestante());
	}

	public void eliminarseDelMapa(Mapa mapa) {
		super.eliminarseDelMapa(mapa);
		mapa.restarPoblacion(this.poblacion, equipo);
	}

}
