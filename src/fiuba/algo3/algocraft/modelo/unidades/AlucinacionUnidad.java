package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.RazaAlucinacion;
import fiuba.algo3.algocraft.modelo.Unidad;

public class AlucinacionUnidad extends Unidad implements ElementoProtoss {

	public AlucinacionUnidad(Unidad unidad)
	{
		super();
		this.transporte = unidad.getTransporte();
		this.vision = unidad.getVision();
		this.estadoFisico = new RazaAlucinacion(unidad.getEstado().getEscudoCompleto());
		this.nivel = unidad.getNivel();
	}
	
	@Override
	public int vidaActual() {
		return this.estadoFisico.getEscudo();
	}
	
	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

	@Override
	public void vaciarEscudo() {
		this.estadoFisico.daniarse(this.escudoRestante());
	}
	
	@Override
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public void ejecutarAcciones(){
		this.regenerarse();
	}

}
