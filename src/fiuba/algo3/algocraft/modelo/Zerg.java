package fiuba.algo3.algocraft.modelo;

public class Zerg implements RazaEstado {

	private int vida;
	
	public Zerg(int vida) {
		this.vida = vida;
	}

	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	public void daniarse(int danio) {
		this.vida-=danio;
	}

	@Override
	public int getEscudo() {
		return 0;
	}

	@Override
	public void regenerarse() {
		this.vida+=10;
	}


}
