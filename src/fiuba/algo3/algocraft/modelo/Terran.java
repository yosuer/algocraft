package fiuba.algo3.algocraft.modelo;

public class Terran implements Raza{

	private FabricaTerran fabrica;
	
	public Terran() {
		this.fabrica = new FabricaTerran();
	}

	@Override
	public FabricaDeElementos getFabrica() {
		return this.fabrica;
	}
	
}
