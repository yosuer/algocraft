package fiuba.algo3.algocraft.modelo;

public class Pilon extends Edificio implements ElementoProtoss {

	private int poblacion;
	
	public Pilon() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Protoss(300,300);
		this.estado = new Construyendose(this,5);
		this.poblacion = 5;
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public void agregarseEn(Mapa mapa){
		super.agregarseEn(mapa);
		this.mapa.aumentarPoblacion(poblacion);
	}

}
