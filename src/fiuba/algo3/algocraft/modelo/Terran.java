package fiuba.algo3.algocraft.modelo;

public class Terran implements RazaEstado {

	private int vida;
	private int poblacion = 0;
	
	public Terran(int vida) {
		this.vida = vida;
	}

	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	public void daniarse(int danio){
		this.vida -= danio;
	}

	@Override
	public int getEscudo() {
		return 0;
	}

	@Override
	public void regenerarse() {
	}
	
	public void setPoblacion(int poblacion){
		this.poblacion  = poblacion;
	}

}
