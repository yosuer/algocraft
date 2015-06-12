package fiuba.algo3.algocraft.modelo;


public class PuertoEstelarTerran extends EdificioConstructorDeNaves {

	public PuertoEstelarTerran() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
		this.estadoFisico = new Terran(1300);
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

}
