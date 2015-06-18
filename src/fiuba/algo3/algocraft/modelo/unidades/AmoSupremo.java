package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;

public class AmoSupremo extends Unidad {

	private int poblacion;
	
	public AmoSupremo() {
		super();
		this.transporte = 8;
		this.vision = 9;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.suministro = 0;
		this.estadoFisico = new Zerg(200);
		this.nivel = 1;
		this.poblacion = 5;
		this.estado = new Construyendose(this,4);
	}
	
	public void agregarseEn(Mapa mapa){
		super.agregarseEn(mapa);
		mapa.aumentarPoblacion(poblacion,equipo);
	}
	
	public void eliminarseDelMapa(Mapa mapa){
		super.eliminarseDelMapa(mapa);
		mapa.restarPoblacion(this.poblacion,equipo);
	}

}
