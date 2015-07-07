package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.modelo.magias.Alucinacion;

public class ArmaMagicaParaUnaUnidad implements IArma {

	private int[] alcances;
	private MagiaUnidad magia;

	
	public ArmaMagicaParaUnaUnidad(int alcanceTierra,int alcanceAire)
	{
		this.alcances = new int[2];
		this.alcances[0] = alcanceTierra;
		this.alcances[1] = alcanceAire;
	}
	public void aplicarMagiaA(Unidad unaUnidad)
	{	
		this.magia.aplicarA(unaUnidad);
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
	public void setMagia(MagiaUnidad unaMagia) {
		this.magia = unaMagia;
	}
	public void setUnidadAAfectar(Unidad unaUnidad) {
		this.magia.aplicarA(unaUnidad);
	}
}


