package fiuba.algo3.algocraft.modelo;


public abstract class ExtractorDeMineral extends Edificio 
										implements ExtractorDeRecursos{

	protected Mineral recurso;
	protected int recolectado;
	protected int costoMineral;
	protected int costoVespeno;
	
	public ExtractorDeMineral(){
	}

	public void realizarExtraccion(){
		recolectado += recurso.extraer();
	}

	public int getRecoleccion(){
		return recolectado;
	}
	
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Mineral) recurso;
	}

	public int getCostoMineral(){
		return costoMineral;
	}
	
	public int getCostoVespeno(){
		return costoVespeno;
	}
	
}
