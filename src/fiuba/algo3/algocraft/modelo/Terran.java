package fiuba.algo3.algocraft.modelo;

public class Terran implements RazaEstado {

	private IntRango vida;
	
	public Terran(int vida) {
		this.vida = new IntRango(vida);
	}

	@Override
	public int getVida() {
		return this.vida.val();
	}

	@Override
	public void daniarse(int danio){
		vida.disminuir(danio);
	}

	@Override
	public int getEscudo() {
		return 0;
	}

	@Override
	public void regenerarse() {
	}

}
