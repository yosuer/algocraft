package fiuba.algo3.algocraft.modelo;

public class AmoSupremo extends Unidad implements ElementoPoblacion {

	public AmoSupremo() {
		this.transporte = 8;
		this.vision = 9;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 10;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Zerg(200);
		this.nivel = 0;
	}

	@Override
	public int getPoblacion() {
		// TODO Auto-generated method stub
		return 0;
	}

}
