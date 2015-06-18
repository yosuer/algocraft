package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.IUnidadMagica;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Magia;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;
import fiuba.algo3.algocraft.modelo.magias.Infestar;
import fiuba.algo3.algocraft.modelo.magias.Red;

public class Reina extends Unidad implements IUnidadMagica {

	private IntRango energia;
	
	public Reina() {
		this.transporte = 0;
		this.vision = 10;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.suministro = 2;
		this.estadoFisico = new Zerg(120);
		this.nivel = 1;
		this.estado = new Construyendose(this,7);
		this.energia = new IntRango(0,200,50);
		//this.inicializarEnergia();

	}

	//@Override
	//public void inicializarEnergia() {
		//this.energia.aumentar(50);		
	//}

	@Override
	public void cargarEnergia() {
		this.energia.aumentar(10);		
	}
	
	public void pasarTurno() {
		super.pasarTurno();
		this.cargarEnergia();
	}
	
	public void lanzarRed() {
		//this.lanzarMagia(new Red());
	}
	
	public void lanzarInfestar() {
		//this.lanzarMagia(new Infestar());
	}

	@Override
	public int energiaActual() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	//public void lanzarMagia(Magia magia) {
		// TODO Auto-generated method stub
		
	//}

}