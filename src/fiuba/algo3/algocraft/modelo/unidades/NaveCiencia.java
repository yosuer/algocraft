package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.modelo.ArmaMagicaConPosicion;
import fiuba.algo3.algocraft.modelo.ArmaMagicaParaUnaUnidad;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.IUnidadMagica;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.magias.EMP;
import fiuba.algo3.algocraft.modelo.magias.Radiacion;


public class NaveCiencia extends Unidad implements IUnidadMagica {
	
	private IntRango energia;
	private ArmaMagicaParaUnaUnidad armaDeRadiacion;
	private ArmaMagicaConPosicion misilEMP;
	
	public NaveCiencia() {
		super();
		this.nombre = "NaveCiencia";
		this.transporte = 0;
		this.vision = 10;
		this.costoMineral = 100;
		this.costoVespeno = 225;
		this.suministro = 2;
		this.nivel = 1;
		this.estadoFisico = new Terran(200);
		this.estado = new Construyendose(this,10);
		this.energia = new IntRango(0,200,50);
		this.armaDeRadiacion = new ArmaMagicaParaUnaUnidad(10,10);
		this.armaDeRadiacion.setMagia(new Radiacion());
		this.misilEMP = new ArmaMagicaConPosicion(10, 10);
		this.misilEMP.setMagia(new EMP(this));
	}
	
	@Override
	public void cargarEnergia() {
		this.energia.aumentar(10);
	}
	
	public void pasarTurno() {
		super.pasarTurno();
		this.cargarEnergia();
	}
	
	public void lanzarEMP(Posicion pos) {
		int distancia = this.mapa.getDistancia(this.posicion, pos);
		if (distancia > this.misilEMP.getAlcance(0)) throw new ErrorObjetivoFueraDelAlcance();
		
		this.misilEMP.aplicarMagiaA(pos);
		
		this.energia.disminuir(100);
	}
	
	public void lanzarRadiacion(Unidad unaUnidad) {
		Posicion posObjetivo = unaUnidad.getPosicion();
		int distancia = this.mapa.getDistancia(this.posicion, posObjetivo);
		if (distancia > this.armaDeRadiacion.getAlcance(unaUnidad.getNivel())) throw new ErrorObjetivoFueraDelAlcance();
		
		this.armaDeRadiacion.aplicarMagiaA(unaUnidad);
		
		
		this.energia.disminuir(75);
	}

	@Override
	public int energiaActual() {
		return this.energia.valor();
	}

	@Override
	public void perderEnergia() {
		this.energia.disminuir(1000);
	}
}
