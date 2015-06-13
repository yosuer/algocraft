package fiuba.algo3.algocraft.modelo;

public class DepositoDeSuministros extends Edificio {

	private int poblacion = 5;
	
	public DepositoDeSuministros() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Terran(500);
		this.estado = new Construyendose(this, 6);
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public void agregarseEn(Mapa mapa){
		super.agregarseEn(mapa);
		this.mapa.aumentarPoblacion(poblacion);
	}
	
	public void eliminarseDelMapa(){
		this.mapa.consumirPoblacion(poblacion);
	}

}
