package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorNoSePuedeAtacarElemento;

public class Protoss implements IRazaEstado {

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
		if (danio == 0) throw new ErrorNoSePuedeAtacarElemento();
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
