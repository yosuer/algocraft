package fiuba.algo3.algocraft.modelo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class EdificioUnidadesAvanzadasTest {

	@Test
	public void test01_CrearUnidadesYVerificarPropiedasBasicas(){
		
	}
	
	@Test
	public void test02_CrearUnaFabrica(){
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca(mapa);
		
		//Falta verificar que se cree la Fabrica si previamente se crea una Barraca 
		Fabrica fabrica = new Fabrica(mapa);
		
		Assert.assertEquals(fabrica.vidaActual(), 1250);
		Assert.assertEquals(fabrica.getCostoMineral(), 200);
		Assert.assertEquals(fabrica.getCostoVespeno(), 100);
		Assert.assertEquals(fabrica.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnArchivoTemplario(){
		Mapa mapa = new Mapa();
		
		//Falta verificar que se cree el ArchivoTemplario si previamente se crea un puertoEstelar
		ArchivoTemplario archivoTemplario = new ArchivoTemplario(mapa);
		
		Assert.assertEquals(archivoTemplario.vidaActual(), 1000);
		//Assert.assertEquals(acceso.escudoActual(), 500);
		Assert.assertEquals(archivoTemplario.getCostoMineral(), 150);
		Assert.assertEquals(archivoTemplario.getCostoVespeno(), 200);
		Assert.assertEquals(archivoTemplario.getNivel(), 0);
	}
	
	@Test
	public void test04_CrearUnaGuaridaDeHidralisco(){
		Mapa mapa = new Mapa();
		GuaridaDeHidralisco guarida = new GuaridaDeHidralisco(mapa);
		
		Assert.assertEquals(guarida.vidaActual(), 1100);
		Assert.assertEquals(guarida.getCostoMineral(), 150);
		Assert.assertEquals(guarida.getCostoVespeno(), 100);
		Assert.assertEquals(guarida.getNivel(), 0);
	}

}
