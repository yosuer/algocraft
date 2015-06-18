package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaMagicaParaUnaUnidad;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Controlable;
import fiuba.algo3.algocraft.modelo.DaniadoPorRadiacion;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Magia;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.IUnidadMagica;
import fiuba.algo3.algocraft.modelo.magias.EMP;
import fiuba.algo3.algocraft.modelo.magias.Radiacion;

public class NaveCiencia extends Unidad implements IUnidadMagica {
	
	private IntRango energia;
	private ArmaMagicaParaUnaUnidad armaDeRadiacion;
	
	public NaveCiencia() {
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
	}
	
	@Override
	public void cargarEnergia() {
		this.energia.aumentar(10);
	}
	
	public void pasarTurno() {
		super.pasarTurno();
		this.cargarEnergia();
	}
	
	public void lanzarEMP() {
		//this.lanzarMagia(new EMP());
	}
	
	public void lanzarRadiacion(Unidad unaUnidad) {
		Posicion posObjetivo = ((Controlable)unaUnidad).getPosicion();
		int distancia = this.mapa.getDistancia(this.posicion, posObjetivo);
		
		this.armaDeRadiacion.aplicarMagia(unaUnidad, new Radiacion(),distancia);
		
		
		this.energia.disminuir(75);
	}

	@Override
	public int energiaActual() {
		return this.energia.valor();
	}
}
