package fiuba.algo3.algocraft.modelo;


public class Zealot extends Unidad implements ElementoProtoss {

	public int escudo;
	
	public Zealot() {
		this.transporte = 2;
		this.vision = 7;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
		this.danioAire = 0;
		this.danioTierra = 8;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 1;
		this.vida = 100;
		this.nivel = 0;
		this.escudo = 60;
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida+this.escudo;
	}

	@Override
	public int escudoRestante() {
		return this.escudo;
	}


	@Override
	public void regenerarse() {
		this.escudo+=5;
	}

}
