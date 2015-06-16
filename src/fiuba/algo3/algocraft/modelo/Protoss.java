package fiuba.algo3.algocraft.modelo;

public class Protoss implements RazaEstado {

	private IntRango vida;
	private IntRango escudo;

	public Protoss(int vida, int escudo) {
		this.vida = new IntRango(vida);
		this.escudo = new IntRango(escudo);
	}

	@Override
	public int getVida() {
		return vida.valor() + escudo.valor();
	}

	@Override
	public void daniarse(int danio){
		vida.disminuir(escudo.disminuir(danio));
	}
	
	@Override
	public int getEscudo() {
		return this.escudo.valor();
	}

	@Override
	public void regenerarse() {
		this.escudo.aumentar(5);
	}
}
