package fiuba.algo3.algocraft.modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.ExtractorDeMineral;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Recurso;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.NexoMineral;
import fiuba.algo3.algocraft.modelo.edificios.ZergMineral;
import fiuba.algo3.algocraft.modelo.natural.Mineral;

public class ExtractorMineralTest {

	@Test
	public void test01_soloSePuedeAgregarExtractorDeMineralSobreMineral() {
		Recurso mineral = new Mineral();
		ExtractorDeMineral centroDeMineral = new CentroDeMineral();
		
		Posicion pos = new Posicion(4,3,0);
		mineral.setPosicion(pos);
		centroDeMineral.setPosicion(pos);

		mineral.asignarExtractor(centroDeMineral);
	}

	@Test
	public void test02_CadaExtraccionDeMineralSuma10EnElDepositoDelExtractor() {
		Recurso mineral = new Mineral();
		ExtractorDeMineral centroDeMineral = new CentroDeMineral();
		Posicion pos = new Posicion(3,2,0);
		
		Assert.assertEquals(centroDeMineral.getRecolectado(), 0);
		
		mineral.setPosicion(pos);
		centroDeMineral.setPosicion(pos);
		centroDeMineral.asignarRecurso(mineral);

		centroDeMineral.realizarExtraccion();

		Assert.assertEquals(centroDeMineral.getRecolectado(), 10);
	}

	@Test
	public void test03_SiSeExtraeSeisVecesSeTiene60DeMineralRecolectado() {
		Recurso mineral = new Mineral();
		ExtractorDeMineral centroDeMineral = new CentroDeMineral();
		
		Posicion pos = new Posicion(9,2,0);
		mineral.setPosicion(pos);
		centroDeMineral.setPosicion(pos);

		mineral.asignarExtractor(centroDeMineral);

		for (int i = 0; i < 6; i++) {
			centroDeMineral.realizarExtraccion();
		}
		Assert.assertEquals(60, centroDeMineral.getRecolectado());
	}
	
	@Test
	public void test04_UnCentroDeMineralTieneCostoMinera50YCostoVespeno0(){
		ExtractorDeMineral extractor = new CentroDeMineral();
		
		Assert.assertEquals(50,extractor.getCostoMineral());
		Assert.assertEquals(0,extractor.getCostoVespeno());
	}
	
	@Test
	public void test04_CentroDeMineralConTurnos(){
		Mapa mapa = new Mapa(40, 40);
		CentroDeMineral centro = new CentroDeMineral();
		mapa.agregarElemento(2, 2, centro);
		Assert.assertEquals(150, mapa.getMineralTotal());
		
		for (int i = 1; i <=2; i++) 
			mapa.pasarTurnoMapa();
		
		Assert.assertEquals(150, mapa.getMineralTotal());
	}
	
	@Test
	public void test05_LaRecoleccionDeRecursosSeReflejaDesdeElMapa(){
		Mapa mapa = new Mapa(40, 40);
		CentroDeMineral centro = new CentroDeMineral();

		mapa.agregarElemento(2, 2, centro);
	
		Assert.assertEquals(150,mapa.getMineralTotal());
		
		for (int i = 1; i <= 24; i++) {
			mapa.pasarTurnoMapa();
		}
		
		Assert.assertEquals(350,mapa.getMineralTotal());
	}
	
	@Test
	public void test05_NexoMineralProtossRecolectaMineralYEntregaMineralAlPasarElTurno(){
		Mapa mapa = new Mapa(40, 40);
		NexoMineral nexoMineral = new NexoMineral();

		mapa.agregarElemento(2, 5, nexoMineral);
		
		Assert.assertEquals(150, mapa.getMineralTotal());
	
		for (int i = 1; i <=60; i++) 
			mapa.pasarTurnoMapa();

		Assert.assertEquals(350, mapa.getMineralTotal());
	}
	
	@Test
	public void test05_ZergMineralRecolectaMineralYEntregaMineralAlPasarElTurno(){
		Mapa mapa = new Mapa(40, 40);
		ZergMineral zergMineral = new ZergMineral();

		mapa.agregarElemento(2, 2, zergMineral);
	
		Assert.assertEquals(150, mapa.getMineralTotal());
		
		for (int i = 1; i <=24; i++) 
			mapa.pasarTurnoMapa();

		Assert.assertEquals(350, mapa.getMineralTotal());
	}
}
