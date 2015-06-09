package fiuba.algo3.algocraft.modelo;

public class PuertoEstelarProtoss extends EdificioConstructorDeNaves {

	public PuertoEstelarProtoss() {
		super();
		this.vida = 1200;
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 10;
		this.edificiosRequeridos.add(new Fabrica());
	}

	public void crearScout()
	{
		if(this.tiempoDeConstruccion == 0)
		{
			this.colaDeProduccion.add(new Scout());
		}
	}
	
	public void crearNaveDeTransporteProtoss()
	{
		if(this.tiempoDeConstruccion == 0)
		{
			this.colaDeProduccion.add(new NaveDeTransporteProtoss());
		}
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}


}
