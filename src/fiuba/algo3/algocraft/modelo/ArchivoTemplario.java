package fiuba.algo3.algocraft.modelo;

public class ArchivoTemplario extends EdificioUnidadesAvanzadas {

	public ArchivoTemplario() {
		super();
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 200;
		this.tiempoDeConstruccion = 9;
		this.nivel= 0;
	}

	public void crearAltoTemplario()
	{
		if(this.tiempoDeConstruccion == 0)
		{
			this.colaDeProduccion.add(new AltoTemplario());
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
