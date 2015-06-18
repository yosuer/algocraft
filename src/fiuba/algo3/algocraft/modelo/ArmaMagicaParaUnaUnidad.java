package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;

public class ArmaMagicaParaUnaUnidad implements IArma {

	private int[] alcances;

	
	public ArmaMagicaParaUnaUnidad(int alcanceTierra,int alcanceAire)
	{
		this.alcances = new int[2];
		this.alcances[0] = alcanceTierra;
		this.alcances[1] = alcanceAire;
	}
	public void aplicarMagia(Unidad unaUnidad, Magia unaMagia, int distancia)
	{	
		if (distancia > this.getAlcance(unaUnidad.getNivel())) throw new ErrorObjetivoFueraDelAlcance();
		unaMagia.aplicar(unaUnidad);
	}
	@Override
	public int getDanio(int nivel) {
		return 0;
	}
	@Override
	public int getAlcance(int nivel) {
		return alcances[nivel];
	}
	@Override
	public void atacar(IDaniable daniable, int distancia) {
		
	}
}


