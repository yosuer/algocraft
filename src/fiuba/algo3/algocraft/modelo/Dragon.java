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
		this.estado = new Construyendose(this, 6);
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}
	
	@Override
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public void ejecutarAcciones(){
		this.regenerarse();
	}
	
	public void actualizarEstado(IEstado estado){
		this.estado = estado;
	}

}
