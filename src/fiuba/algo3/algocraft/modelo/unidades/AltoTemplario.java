package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.IUnidadMagica;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Magia;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.magias.Alucinacion;
import fiuba.algo3.algocraft.modelo.magias.EMP;
import fiuba.algo3.algocraft.modelo.magias.TormentaPsionica;

public class AltoTemplario extends Unidad implements ElementoProtoss,IUnidadMagica {

	private IntRango energia;

	public AltoTemplario() {
		super();
		this.nombre = "AltoTemplario";
		this.transporte = 2;
		this.vision = 7;
		this.costoMineral = 50;
		this.costoVespeno = 150;
		this.suministro = 2;
		this.estadoFisico = new Protoss(40,40);
		this.nivel = 0;
		this.estado = new Construyendose(this,7);
		this.energia = new IntRango(0,200,50);
		//this.inicializarEnergia();
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

	//@Override
	//public void inicializarEnergia() {
		//this.energia.aumentar(50);		
	//}

	@Override
	public void cargarEnergia() {
		this.energia.aumentar(15);		
	}
	
	public void pasarTurno() {
		super.pasarTurno();
		this.cargarEnergia();
	}
	
	public void lanzarTormentaPsionica() {
		//this.lanzarMagia(new TormentaPsionica());
	}
	
	public void lanzarAlucinacion() {
		//this.lanzarMagia(new Alucinacion());
	}

	//@Override
	//public void lanzarMagia(Magia magia) {
		
	//}

	@Override
	public int energiaActual() {
		// TODO Auto-generated method stub
		return 0;
	}
}
