package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.excepciones.ErrorCargaDeEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.modelo.ArmaMagicaConPosicion;
import fiuba.algo3.algocraft.modelo.ArmaMagicaParaUnaUnidad;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.IUnidadMagica;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;
import fiuba.algo3.algocraft.modelo.magias.Infestar;
import fiuba.algo3.algocraft.modelo.magias.Red;


public class Reina extends Unidad implements IUnidadMagica {

	private IntRango energia;
	private ArmaMagicaParaUnaUnidad armaInfestar;
	private ArmaMagicaConPosicion armaRed;
	
	public Reina() {
		super();
		this.nombre = "Reina";
		this.transporte = 0;
		this.vision = 10;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.suministro = 2;
		this.estadoFisico = new Zerg(120);
		this.nivel = 1;
		this.estado = new Construyendose(this,7);
		this.energia = new IntRango(0,200,50);
		this.armaInfestar = new ArmaMagicaParaUnaUnidad(10,10);
		this.armaRed = new ArmaMagicaConPosicion(10,10);
		this.armaInfestar.setMagia(new Infestar(this));
		this.armaRed.setMagia(new Red(this));
	}
	

	@Override
	public void cargarEnergia() {
		this.energia.aumentar(10);		
	}
	
	public void pasarTurno() {
		super.pasarTurno();
		this.cargarEnergia();
	}
	
//	public void lanzarRed(Posicion pos) {
//		
//		if( this.energia.valor() >=75)
//		{
//			this.armaRed.aplicarMagiaA(pos);
//			this.energia.disminuir(75);
//		}
//	}
	
//	public void lanzarInfestar(Unidad unaUnidad){
//		if()
//		this.armaInfestar.aplicarMagiaA(unaUnidad);
//		this.energia.disminuir(150);
//	}

	@Override
	public int energiaActual() {
		return this.energia.valor();
	}

	@Override
	public void perderEnergia() {
		this.energia.disminuir(this.energiaActual());
	}


	@Override
	public void lanzarMagiaAUnidad(Unidad unidad) {
		
		if( this.energia.valor() >= 150 )
		{
			Posicion posObjetivo = unidad.getPosicion();
			int distancia = this.mapa.getDistancia(this.posicion, posObjetivo);
			if (distancia > this.armaInfestar.getAlcance(unidad.getNivel())) throw new ErrorObjetivoFueraDelAlcance();
			
			this.armaInfestar.aplicarMagiaA(unidad);
			this.energia.disminuir(150);
		}
		else
		{
			throw new ErrorCargaDeEnergiaInsuficiente();
		}
	}


	@Override
	public void lanzarMagiaAPosicion(Posicion posicion) {
		if( this.energia.valor() >=75)
			{
				int distancia = this.mapa.getDistancia(this.posicion, posicion);
				if (distancia > this.armaRed.getAlcance(0)) throw new ErrorObjetivoFueraDelAlcance();
		
			
				this.armaRed.aplicarMagiaA(posicion);
				this.energia.disminuir(75);
			}
		else
		{
			throw new ErrorCargaDeEnergiaInsuficiente();
		}
	}


}