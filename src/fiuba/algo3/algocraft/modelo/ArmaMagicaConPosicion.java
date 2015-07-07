package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.modelo.magias.TormentaPsionica;

public class ArmaMagicaConPosicion implements IArma {

	private int[] alcances;
	private MagiaPosicion unaMagia;
	private Posicion posicion;

	
	public ArmaMagicaConPosicion(int alcanceTierra,int alcanceAire)
	{
		this.alcances = new int[2];
		this.alcances[0] = alcanceTierra;
		this.alcances[1] = alcanceAire;
	}
	
	@Override
	public int getDanio(int nivel) {
		return 0;
	}

	@Override
	public int getAlcance(int nivel) {
		return this.alcances[nivel];
	}

	@Override
	public void atacar(IDaniable daniable, int distancia) {
		
	}
	
	public void aplicarMagiaA(Posicion pos)
	{	
		unaMagia.aplicarA(pos);
		this.posicion = pos;
		
	}

	public void setMagia(MagiaPosicion unaMagia) {
		this.unaMagia = unaMagia;
	}
	
	public void repetirMagia()
	{
		this.unaMagia.aplicarA(posicion);
	}


}
