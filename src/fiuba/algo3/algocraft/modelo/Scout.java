package fiuba.algo3.algocraft.modelo;

public class Scout extends Unidad implements ElementoProtoss {

	public Scout() {
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 300;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 9;
		this.danioAire = 14;
		this.danioTierra = 8;
		this.suministro = 3;
		this.rangoAtaqueAire = 4;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Protoss(150,100);
		this.nivel = 1;
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

}
