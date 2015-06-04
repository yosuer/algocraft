package fiuba.algo3.algocraft;

public class Terran implements Raza{

	static Terran instance = null;
	private FabricaTerran fabrica;
	
	static public Terran getInstance() {
		if(instance == null) {
	         instance = new Terran();
	      }
	     return instance;
	}
	
	private Terran() {
		this.fabrica = new FabricaTerran();
	}

	@Override
	public FabricaDeElementos getFabrica() {
		return this.fabrica;
	}
	
}
