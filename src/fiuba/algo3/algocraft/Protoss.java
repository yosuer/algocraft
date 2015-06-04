package fiuba.algo3.algocraft;

public class Protoss implements Raza {

	static Protoss instance = null;
	
	private FabricaProtoss fabrica;

	static public Protoss getInstance() {
		if(instance == null) {
	         instance = new Protoss();
	      }
	     return instance;
	}

	private Protoss() {
		this.fabrica = new FabricaProtoss();
	}

	@Override
	public FabricaDeElementos getFabrica() {
		return this.fabrica;
	}
}
