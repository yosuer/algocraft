package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

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
		Mapa mapa = new Mapa();
		CentroDeMineral centro = new CentroDeMineral();
		Mineral mineral = new Mineral();
		
		mapa.agregarElemento(1, 1, mineral);
		mapa.agregarElemento(1, 1, centro);
	
		for (int i = 1; i <=4; i++) 
			mapa.pasarTurnoMapa();
		
		for (int i = 1; i <=2; i++)
			centro.realizarExtraccion();
		
		Assert.assertEquals(20,centro.getRecolectado());
		
		mapa.pasarTurnoMapa();
		Assert.assertEquals(220, mapa.getMineralTotal());
		Assert.assertEquals(10, centro.getRecolectado());
	}
	
	@Test
	public void test05_LaRecoleccionDeRecursosSeReflejaDesdeElMapa(){
		Mapa mapa = new Mapa();
		CentroDeMineral centro = new CentroDeMineral();
		Mineral mineral = new Mineral();
		
		mapa.agregarElemento(1, 1, mineral);
		mapa.agregarElemento(1, 1, centro);
	
		Assert.assertEquals(200,mapa.getMineralTotal());
		
		for (int i = 1; i <= 10; i++) {
			mapa.pasarTurnoMapa();
		}
		
		Assert.assertEquals(250,mapa.getMineralTotal());
	}
	
	@Test
	public void test05_NexoMineralProtossRecolectaMineralYEntregaMineralAlPasarElTurno(){
		Mapa mapa = new Mapa();
		NexoMineral nexoMineral = new NexoMineral();
		Mineral mineral = new Mineral();
		
		mapa.agregarElemento(4, 4, mineral);
		mapa.agregarElemento(4, 4, nexoMineral);
	
		for (int i = 1; i <=4; i++) 
			mapa.pasarTurnoMapa();
		
		for (int i = 1; i <=20; i++) 
			nexoMineral.realizarExtraccion();
		
		Assert.assertEquals(200,nexoMineral.getRecolectado());
		
		mapa.pasarTurnoMapa();
		Assert.assertEquals(400, mapa.getMineralTotal());
		Assert.assertEquals(0, nexoMineral.getRecolectado());
	}
	
	@Test
	public void test05_ZergMineralRecolectaMineralYEntregaMineralAlPasarElTurno(){
		Mapa mapa = new Mapa();
		ZergMineral zergMineral = new ZergMineral();
		Mineral mineral = new Mineral();
		
		mapa.agregarElemento(10, 10, mineral);
		mapa.agregarElemento(10, 10, zergMineral);
	
		for (int i = 1; i <=4; i++) 
			mapa.pasarTurnoMapa();
		
		for (int i = 1; i <=20; i++) 
			zergMineral.realizarExtraccion();
		
		Assert.assertEquals(200,zergMineral.getRecolectado());
		
		mapa.pasarTurnoMapa();
		Assert.assertEquals(400, mapa.getMineralTotal());
		Assert.assertEquals(0, zergMineral.getRecolectado());
	}
}
