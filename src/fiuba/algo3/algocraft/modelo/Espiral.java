package fiuba.algo3.algocraft.modelo;


public class Espiral extends EdificioConstructorDeNaves {

	public Espiral() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 10;
		this.estadoFisico = new Zerg(1300);
	}

}
