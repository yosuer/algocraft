package fiuba.algo3.algocraft.modelo;

public class Criadero extends Edificio implements IElementoCreador{

	public Criadero() {
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
		this.estadoFisico = new Zerg(1500);
		this.creador = new CreadorEnCola(this);
	}

	@Override
	public void enviarUnidadAlMapa(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}

}
