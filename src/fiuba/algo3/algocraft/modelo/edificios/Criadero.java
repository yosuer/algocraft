package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.CreadorEnCola;
import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;

public class Criadero extends Edificio implements IElementoCreador{

	public Criadero() {
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
		this.estadoFisico = new Zerg(1500);
		this.creador = new CreadorEnCola(this);
		this.estado = new Construyendose(this, 10);
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
