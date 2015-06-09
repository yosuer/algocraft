package fiuba.algo3.algocraft.modelo;

public class AltoTemplario extends Unidad {


	public AltoTemplario()
	{
		this.tiempoDeConstruccion = 7;
		this.vida = 80;
		this.costoMineral = 50;
		this.costoVespeno = 150;
		this.nivel = 0;
	}
	
	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public void agregarseEn(Mapa mapa) {
		// TODO Auto-generated method stub
		
	}

}
