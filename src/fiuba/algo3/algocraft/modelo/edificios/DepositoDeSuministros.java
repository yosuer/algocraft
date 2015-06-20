package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Terran;

public class DepositoDeSuministros extends Edificio {

	private int poblacion = 5;
	
	public DepositoDeSuministros() {
		this.nombre = "DepositoDeSuministros";
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Terran(500);
		this.estado = new Construyendose(this, 6);
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public void agregarseEn(Mapa mapa){
		super.agregarseEn(mapa);
		this.mapa.aumentarPoblacion(poblacion,equipo);
	}
	
	public void eliminarseDelMapa(Mapa mapa){
		super.eliminarseDelMapa(mapa);
		mapa.restarPoblacion(this.poblacion,equipo);
	}

}
