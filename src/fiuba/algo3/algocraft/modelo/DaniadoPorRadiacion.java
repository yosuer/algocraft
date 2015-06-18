package fiuba.algo3.algocraft.modelo;


public class DaniadoPorRadiacion implements IEstado {

	private Unidad elemento;
	private IArma arma;
	
	public DaniadoPorRadiacion(Unidad unaUnidad)
	{
		this.elemento = unaUnidad;
		this.arma = new ArmaSimple(20,20,0,0);
		this.elemento.recibirDanioDe(arma, 0);
	}
	
	@Override
	public void pasarTurno() {
		this.elemento.recibirDanioDe(arma, 0);
	}
	
	public void aplicarRadiacionAUnidadesCercanas()
	{
		
	}

	@Override
	public void estaActivo() {
		
	}

}
