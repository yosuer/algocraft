package fiuba.algo3.algocraft.modelo;


public class Marine extends Unidad {

	public Marine() {
		this.vida = 40;
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 3;
	}

	@Override
	public int getNivel() {
		return 0;
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
