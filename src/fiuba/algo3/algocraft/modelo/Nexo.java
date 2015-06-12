package fiuba.algo3.algocraft.modelo;

public class Nexo extends BasePrincipal implements ElementoProtoss {

	public Nexo() {
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 9;
		this.estadoFisico = new Protoss(750,750);
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

}
