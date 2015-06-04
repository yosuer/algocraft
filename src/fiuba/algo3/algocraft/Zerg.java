package fiuba.algo3.algocraft;

public class Zerg implements Raza {

	static Zerg instance = new Zerg();
	private FabricaZerg fabrica;
	
	static public Zerg getInstance() {
		return instance;
	}
	
	private Zerg() {
		this.fabrica = new FabricaZerg();
	}

	@Override
	public FabricaDeElementos getFabrica() {
		return this.fabrica;
	}
}
