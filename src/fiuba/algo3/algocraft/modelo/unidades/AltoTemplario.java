package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.modelo.ArmaMagicaConPosicion;
import fiuba.algo3.algocraft.modelo.ArmaMagicaParaUnaUnidad;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.IUnidadMagica;
import fiuba.algo3.algocraft.modelo.IntRango;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.magias.Alucinacion;
import fiuba.algo3.algocraft.modelo.magias.TormentaPsionica;


public class AltoTemplario extends Unidad implements ElementoProtoss,IUnidadMagica {

	private IntRango energia;
	private ArmaMagicaConPosicion armaTormentaPsionica;
	private ArmaMagicaParaUnaUnidad armaAlucinacion;
	private int tormentaUsos;

	public AltoTemplario() {
		super();
		this.nombre = "AltoTemplario";
		this.transporte = 2;
		this.vision = 7;
		this.costoMineral = 50;
		this.costoVespeno = 150;
		this.suministro = 2;
		this.estadoFisico = new Protoss(40,40);
		this.nivel = 0;
		this.estado = new Construyendose(this,7);
		this.energia = new IntRango(0,200,50);
		this.armaAlucinacion = new ArmaMagicaParaUnaUnidad(7,7);
		this.armaAlucinacion.setMagia(new Alucinacion(this));
		this.armaTormentaPsionica = new ArmaMagicaConPosicion(7,7);
		this.armaTormentaPsionica.setMagia(new TormentaPsionica(this));
		this.tormentaUsos = 0;
	}


	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

	@Override
	public void cargarEnergia() {
		this.energia.aumentar(15);		
	}
	
	public void pasarTurno() {
		super.pasarTurno();
		this.cargarEnergia();
		if( this.tormentaUsos > 0 )
		{
			this.armaTormentaPsionica.repetirMagia();
			this.tormentaUsos--;
		}
	}
	
	public void lanzarTormentaPsionica(Posicion pos) {
		int distancia = this.mapa.getDistancia(this.posicion, pos);
		if (distancia > this.armaTormentaPsionica.getAlcance(0)) throw new ErrorObjetivoFueraDelAlcance();
		
		this.armaTormentaPsionica.aplicarMagiaA(pos);
		this.tormentaUsos++;
		
		this.energia.disminuir(75);
	}
	
	public void lanzarAlucinacion(Unidad unaUnidad) {
		Posicion pos = unaUnidad.getPosicion();
		int distancia = this.mapa.getDistancia(this.posicion, pos);
		if (distancia > this.armaAlucinacion.getAlcance(0)) throw new ErrorObjetivoFueraDelAlcance();
		
		this.armaAlucinacion.setUnidadAAfectar(unaUnidad);
		
		this.energia.disminuir(100);
	}

	@Override
	public int energiaActual() {
		return this.energia.valor();
	}

	@Override
	public void perderEnergia() {
		this.energia.setValor(0);
	}

	@Override
	public void vaciarEscudo() {
		this.estadoFisico.daniarse(this.escudoRestante());
	}
}
