package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;

public class Terran implements IRazaEstado {

	private IntRango vida;
	
	public Terran(int vida) {
		this.vida = new IntRango(vida);
	}

	@Override
	public int getVida() {
		return this.vida.valor();
	}

	@Override
	public void daniarse(int danio){
		if (danio == 0) throw new ErrorObjetivoFueraDelAlcance();
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
