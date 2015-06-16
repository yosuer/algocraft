package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Magia;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.IUnidadMagica;
import fiuba.algo3.algocraft.modelo.magias.EMP;
import fiuba.algo3.algocraft.modelo.magias.Radiacion;

public class NaveCiencia extends Unidad implements IUnidadMagica {
	
	private IntRango energia;
	
	public NaveCiencia() {
		this.transporte = 0;
		this.vision = 10;
		this.costoMineral = 100;
		this.costoVespeno = 225;
		this.tiempoDeConstruccion = 10;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Terran(200);
		this.nivel = 1;
		
		this.energia = new IntRango(200);
		this.inicializarEnergia();
	}
	
	@Override
	public void inicializarEnergia() {
		this.energia.aumentar(50);
	}
	
	@Override
	public void cargarEnergia() {
		this.energia.aumentar(10);
	}
	
	public void pasarTurno() {
		super.pasarTurno();
		this.cargarEnergia();
	}
	
	public void lanzarEMP() {
		this.lanzarMagia(new EMP());
	}
	
	public void lanzarRadiacion() {
		this.lanzarMagia(new Radiacion());
	}
	
	@Override
	public void lanzarMagia(Magia magia) {
		// TODO Auto-generated method stub
		
	}

}
