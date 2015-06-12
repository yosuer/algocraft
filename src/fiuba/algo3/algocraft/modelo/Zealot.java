package fiuba.algo3.algocraft.modelo;

public class Zealot extends Unidad implements ElementoProtoss {
	
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
		this.estadoFisico = new Protoss(100,60);
		this.nivel = 0;
		
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
