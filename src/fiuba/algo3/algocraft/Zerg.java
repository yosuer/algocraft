package fiuba.algo3.algocraft;

public class Zerg implements Raza {

	private FabricaZerg fabrica;

	public Zerg() {
		this.fabrica = new FabricaZerg();
	}

	@Override
	public FabricaDeElementos getFabrica() {
		return this.fabrica;
	}
}
