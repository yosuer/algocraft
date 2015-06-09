package fiuba.algo3.algocraft.modelo;

public class AltoTemplario extends Unidad {


	public AltoTemplario() {
		this.transporte = 2;
		this.vision = 7;
		this.costoMineral = 50;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 7;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.vida = 80;
		this.nivel = 0;
	}
	
	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public void agregarseEn(Mapa mapa) {
		// TODO Auto-generated method stub
		
	}

}
