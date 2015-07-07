package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorNoSePuedeAtacarElemento;

public class RazaAlucinacion implements IRazaEstado {
	
	private IntRango escudo;

	public RazaAlucinacion(int escudo) {
		this.escudo = new IntRango(escudo);
	}

	@Override
	public int getVida() {
		return escudo.valor();
	}

	@Override
	public void daniarse(int danio){
		if (danio == 0) throw new ErrorNoSePuedeAtacarElemento();
		escudo.disminuir(danio);
	}
	
	@Override
	public int getEscudo() {
		return this.escudo.valor();
	}

	@Override
	public void regenerarse() {
		this.escudo.aumentar(5);
	}
	
	public void perderEscudo()
	{
		this.escudo.disminuir(this.escudo.valor());
	}
	
	public int getEscudoCompleto()
	{
		return this.escudo.getMaximo();
	}

}
