package fiuba.algo3.algocraft.modelo;

public class Protoss implements RazaEstado {

	private int vida;
	private int escudo;

	public Protoss(int vida, int escudo) {
		this.vida = vida;
		this.escudo = escudo;
	}

	@Override
	public int getVida() {
		return this.vida+this.escudo;
	}

	@Override
	public void daniarse(int danio){
		if (this.escudo > 0)
		{
			this.escudo -= danio;
			if (this.escudo < 0) this.vida += this.escudo;
		} else this.vida -= danio;
	}
	
	@Override
	public int getEscudo() {
		return this.escudo;
	}

	@Override
	public void regenerarse() {
		if (this.escudo > 0) this.escudo+=5;
	}
}
