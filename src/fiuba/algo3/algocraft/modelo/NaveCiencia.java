package fiuba.algo3.algocraft.modelo;

public class NaveCiencia extends Unidad {

	private int cargaDeEnergia;
	
	public NaveCiencia() {
		this.nivel = 1;
		this.vida = 200;
		this.cargaDeEnergia = 0;
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
