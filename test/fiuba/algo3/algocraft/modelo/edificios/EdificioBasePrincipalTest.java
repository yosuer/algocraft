package fiuba.algo3.algocraft.modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.Criadero;
import fiuba.algo3.algocraft.modelo.edificios.Nexo;

public class EdificioBasePrincipalTest {

	@Test
	public void test01_PropiedadesBasicasDeUnCentroDeMando(){
		CentroDeMando centroDeMando = new CentroDeMando();
		
		Assert.assertEquals(centroDeMando.vidaActual(), 1500);
		Assert.assertEquals(centroDeMando.getCostoMineral(), 100);
		Assert.assertEquals(centroDeMando.getCostoVespeno(), 100);
		Assert.assertEquals(centroDeMando.getNivel(), 0);
	}
	
	@Test
	public void test02_ElTiempoDeConstruccionDeUnCentroDeMandoEs7(){
		Mapa mapa = new Mapa();
		mapa.recibirMineral(1000);
		mapa.recibirVespeno(1000); //para pruebas aumento directamente
		
		CentroDeMando centroDeMando = new CentroDeMando();
		mapa.agregarElemento(1, 1, centroDeMando);
		
		for (int i=1; i <=7; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(1, 1, 0), centroDeMando);
	}
	
	@Test
	public void test03_CrearUnNexo(){
		Mapa mapa = new Mapa();
		Nexo nexo = new Nexo();
		mapa.recibirMineral(1000);
		mapa.recibirVespeno(1000); //para pruebas aumento directamente
		
		mapa.agregarElemento(2, 1, nexo);
		Assert.assertEquals(mapa.getElemento(2, 1, 0), new Nexo());
		
		for (int i=1; i <=9; i++){
			mapa.pasarTurnoMapa();
		}
				
		Assert.assertEquals(nexo.vidaActual(), 1500);
		Assert.assertEquals(nexo.escudoRestante(), 750);
		Assert.assertEquals(nexo.getCostoMineral(), 100);
		Assert.assertEquals(nexo.getCostoVespeno(), 100);
		Assert.assertEquals(nexo.getNivel(), 0);
	}
	
	@Test
	public void test04_CrearUnCriadero(){
		Mapa mapa = new Mapa();
		mapa.recibirMineral(1000);
		mapa.recibirVespeno(1000); //para pruebas aumento directamente
		
		Criadero criadero = new Criadero();
		
		mapa.agregarElemento(2, 3, criadero);
		Assert.assertEquals(mapa.getElemento(2, 3, 0), new Criadero());
		
		for (int i=1; i <=10; i++){
			mapa.pasarTurnoMapa();
		}
		
		Assert.assertEquals(criadero.getTiempoDeConstruccion(),0);
		
		Assert.assertEquals(criadero.vidaActual(), 1500);
		Assert.assertEquals(criadero.getCostoMineral(), 100);
		Assert.assertEquals(criadero.getCostoVespeno(), 100);
		Assert.assertEquals(criadero.getNivel(), 0);
	}
}
