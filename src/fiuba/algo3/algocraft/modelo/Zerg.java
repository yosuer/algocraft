package fiuba.algo3.algocraft.modelo;

public class Zerg implements RazaEstado {

	private IntRango vida;
	
	public Zerg(int vida) {
		this.vida = new IntRango(vida);
	}

	@Override
	public int getVida() {
		return this.vida.valor();
	}

	@Override
	public void daniarse(int danio) {
		this.vida.disminuir(danio);
	}

	@Override
	public int getEscudo() {
		return 0;
	}

	@Override
	public void regenerarse() {
		this.vida.aumentar(5);
	}


}
