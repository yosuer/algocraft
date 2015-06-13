package fiuba.algo3.algocraft.modelo;

public class AmoSupremo extends Unidad {

	private int poblacion;
	
	public AmoSupremo() {
		this.transporte = 8;
		this.vision = 9;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 0;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Zerg(200);
		this.nivel = 1;
		this.poblacion = 5;
	}
	
	public void agregarseEn(Mapa mapa){
		super.agregarseEn(mapa);
		this.mapa.aumentarPoblacion(poblacion);
	}
	
	public void eliminarseDelMapa(){
		this.mapa.consumirPoblacion(poblacion);
	}

}
