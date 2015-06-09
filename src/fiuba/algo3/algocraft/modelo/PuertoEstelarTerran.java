package fiuba.algo3.algocraft.modelo;


public class PuertoEstelarTerran extends EdificioConstructorDeNaves {

	public PuertoEstelarTerran() {
		super();
		this.vida = 1300;
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
	}

	public void crearEspectro()
	{
		if(this.tiempoDeConstruccion == 0)
		{
			this.colaDeProduccion.add(new Espectro());
		}
	}
	
	public void crearNaveCiencia()
	{
		if(this.tiempoDeConstruccion == 0)
		{
			this.colaDeProduccion.add(new NaveCiencia());
		}
	}
	
	public void crearNaveDeTransporteTerran()
	{
		if(this.tiempoDeConstruccion == 0)
		{
			this.colaDeProduccion.add(new NaveTransporteTerran());
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
