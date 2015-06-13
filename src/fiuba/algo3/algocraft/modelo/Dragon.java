package fiuba.algo3.algocraft.modelo;

public class Dragon extends Unidad implements ElementoProtoss {
	
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
		this.estadoFisico = new Protoss(100,80);
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
