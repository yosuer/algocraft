package fiuba.algo3.algocraft;

public abstract class ExtractorDeMineral extends Edificio implements ExtractorDeRecursos{

	public ExtractorDeMineral(Posicion posicion) {
		super(posicion);
	}

	abstract public void realizarExtraccion();

	abstract public int getRecoleccion();
	
}
