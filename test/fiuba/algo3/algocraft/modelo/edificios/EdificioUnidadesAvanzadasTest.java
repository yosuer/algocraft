package fiuba.algo3.algocraft.modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.GuaridaDeHidralisco;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.edificios.ArchivoTemplario;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;

public class EdificioUnidadesAvanzadasTest {

	@Test
	public void test01_CrearUnaFabrica(){
		Fabrica fabrica = new Fabrica();
		
		Assert.assertEquals(fabrica.vidaActual(), 1250);
		Assert.assertEquals(fabrica.getCostoMineral(), 200);
		Assert.assertEquals(fabrica.getCostoVespeno(), 100);
		Assert.assertEquals(fabrica.getNivel(), 0);
	}
	
	@Test
	public void test02_CrearUnArchivoTemplario(){
		ArchivoTemplario archivoTemplario = new ArchivoTemplario();
		
		Assert.assertEquals(archivoTemplario.vidaActual(), 1000);
		Assert.assertEquals(archivoTemplario.escudoRestante(), 500);
		Assert.assertEquals(archivoTemplario.getCostoMineral(), 150);
		Assert.assertEquals(archivoTemplario.getCostoVespeno(), 200);
		Assert.assertEquals(archivoTemplario.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnaGuaridaDeHidralisco(){
		GuaridaDeHidralisco guarida = new GuaridaDeHidralisco();
		
		Assert.assertEquals(guarida.vidaActual(), 1250);
		Assert.assertEquals(guarida.getCostoMineral(), 150);
		Assert.assertEquals(guarida.getCostoVespeno(), 100);
		Assert.assertEquals(guarida.getNivel(), 0);
	}
	
	@Test(expected = ErrorAgregandoElementoAlMapa.class)
	public void test04_NoSePuedeCrearUnaFabricaSinUnaBarracaEnElMapa(){
		Mapa mapa = new Mapa();
		Fabrica fabrica = new Fabrica();
		mapa.agregarElemento(1, 10, fabrica);
	}
	
	@Test (expected = ErrorRecursosInsuficientes.class)
	public void test04_NoSePuedeCrearUnaFabricaSinLosRecursosSuficientes(){
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca();
		Fabrica fabrica = new Fabrica();
		
		mapa.agregarElemento(1, 11, barraca);
		mapa.agregarElemento(1, 10, fabrica);
	}
	
	@Test ()
	public void test05_SePuedeCrearUnaFabricaSoloDespuesDeCrearUnaBarraca(){
		Mapa mapa = new Mapa();
		mapa.recibirMineral(1000);
		mapa.recibirVespeno(1000); //para pruebas aumento directamente
		Barraca barraca = new Barraca();
		Fabrica fabrica = new Fabrica();
		
		mapa.agregarElemento(1, 11, barraca);
		mapa.agregarElemento(1, 10, fabrica);
		
		Assert.assertEquals(mapa.getElemento(1,10,0),fabrica);
	}
	

}
