package fiuba.algo3.algocraft.modelo;

public class Protoss implements Raza {

	private FabricaProtoss fabrica;

	public Protoss() {
		this.fabrica = new FabricaProtoss();
	}

	@Override
	public FabricaDeElementos getFabrica() {
		return this.fabrica;
	}
}
