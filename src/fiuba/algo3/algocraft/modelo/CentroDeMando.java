package fiuba.algo3.algocraft.modelo;

public class CentroDeMando extends BasePrincipal {

	public CentroDeMando() {
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.estadoFisico = new Terran(1500);
		this.estado = new Construyendose(this,7);
	}

}
