package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorNoSePuedeAtacarElemento;
import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;

public class Zerg implements IRazaEstado {

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
		if (danio == 0) throw new ErrorObjetivoFueraDelAlcance();
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

	@Override
	public int getEscudoCompleto() {
		// TODO Auto-generated method stub
		return 0;
	}


}
