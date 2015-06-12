package fiuba.algo3.algocraft.modelo;

public class Criadero extends BasePrincipal {

	public Criadero() {
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
		this.estadoFisico = new Zerg(1500);
	}

}
