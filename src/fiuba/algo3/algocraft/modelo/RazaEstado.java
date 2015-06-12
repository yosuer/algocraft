package fiuba.algo3.algocraft.modelo;

public interface RazaEstado {

	public int getVida();
	
	public int getEscudo();
	
	public void daniarse(int danio);
	
	public void regenerarse();
}
