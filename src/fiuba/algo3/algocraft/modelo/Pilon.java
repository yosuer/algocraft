package fiuba.algo3.algocraft.modelo;

public class Pilon extends Edificio implements ElementoProtoss,ElementoPoblacion {

	public Pilon() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 5;
		this.estadoFisico = new Protoss(300,300);
	}

	@Override
	public int getPoblacion() {
		return 10;
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
