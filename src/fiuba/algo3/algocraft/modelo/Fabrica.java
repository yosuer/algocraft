package fiuba.algo3.algocraft.modelo;

public class Fabrica extends EdificioUnidadesAvanzadas {

	public Fabrica() {
		super();
		this.vida = 1250;
		this.costoMineral = 200;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 12;
		this.edificiosRequeridos.add(new Barraca());
	}

	public void crearGoliat()
	{	
		if(this.tiempoDeConstruccion ==0)
		{
			this.colaDeProduccion.add(new Golliat());
		}
	}
	
	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

}
