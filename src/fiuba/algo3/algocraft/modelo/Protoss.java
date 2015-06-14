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
		return vida.val() + escudo.val();
	}

	@Override
	public void daniarse(int danio){
		vida.disminuir(escudo.disminuir(danio));
	}
	
	@Override
	public int getEscudo() {
		return this.escudo.val();
	}

	@Override
	public void regenerarse() {
		this.escudo.aumentar(5);
	}
}
