package fiuba.algo3.algocraft.modelo;

public class Dragon extends Unidad implements ElementoProtoss {

	private int escudo;
	
	public Dragon(){
		this.transporte = 4;
		this.vision = 8;
		this.costoMineral = 125;
		this.costoVespeno = 50;
		this.tiempoDeConstruccion = 6;
		this.danioAire = 20;
		this.danioTierra = 20;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 4;
		this.vida = 100;
		this.nivel = 0;
		this.escudo = 80;
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
	
	public void daniarse(int danio){
		if (this.escudo > 0)
		{
			this.escudo -= danio;
			if (this.escudo < 0) this.vida += this.escudo;
		} else this.vida -= danio;
		
		if (this.vida <= 0)this.mapa.quitarElemento(this);
	}

}
