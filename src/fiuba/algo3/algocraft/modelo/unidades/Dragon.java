package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.IEstado;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Dragon extends Unidad implements ElementoProtoss {
	
	public Dragon(){
		super();
		this.nombre = "Dragon";
		this.transporte = 4;
		this.vision = 8;
		this.costoMineral = 125;
		this.costoVespeno = 50;
		this.suministro = 2;
		this.estadoFisico = new Protoss(100,80);
		this.nivel = 0;
		this.estado = new Construyendose(this, 6);
		this.arma = new ArmaSimple(20,20,4,4);
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
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public void ejecutarAcciones(){
		this.regenerarse();
	}
	
	public void actualizarEstado(IEstado estado){
		this.estado = estado;
	}

	@Override
	public void vaciarEscudo() {
		this.estadoFisico.daniarse(this.escudoRestante());
	}
}
