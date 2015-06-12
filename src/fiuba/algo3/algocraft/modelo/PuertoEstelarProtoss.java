package fiuba.algo3.algocraft.modelo;

public class PuertoEstelarProtoss extends EdificioConstructorDeNaves
									implements ElementoProtoss{

	public PuertoEstelarProtoss() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 10;
		this.edificiosRequeridos.add(new Fabrica());
		this.estadoFisico = new Protoss(600,600);
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
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

}
