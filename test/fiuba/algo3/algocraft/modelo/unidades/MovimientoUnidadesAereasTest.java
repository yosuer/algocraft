package fiuba.algo3.algocraft.modelo.unidades;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Tierra;
import fiuba.algo3.algocraft.modelo.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.unidades.Marine;

public class MovimientoUnidadesAereasTest {
	
	@Test
	public void test01_agregarUnidadAereaAlMapa(){
		Mapa mapa = new Mapa();
		Espectro esp = new Espectro();
		mapa.agregarElemento(3, 3, esp);
		
		Assert.assertEquals(esp,mapa.getElemento(3, 3, 1));
	}
	
	@Test
	public void test02_moverUnidadAerea(){
		Mapa mapa = new Mapa();
		Espectro esp = new Espectro();
		mapa.agregarElemento(1, 1, esp);
		for (int i=1;i<=8;i++) mapa.pasarTurnoMapa();
		Collection<Posicion> camino = esp.mover(4, 4);
		
		Assert.assertEquals(3, camino.size());
		
		for (int i=1;i<=3;i++) mapa.pasarTurnoMapa();
		
		Assert.assertNull(mapa.getElemento(1, 1, 1));
		Assert.assertEquals(esp,mapa.getElemento(4, 4, 1));
		Assert.assertEquals(0, camino.size());
	}
	
	public void test03_unaUnidadAereaNoObstruyeElCaminoDeUnaUnidadTerrestre(){
		Mapa mapa = new Mapa();
		Espectro espectro = new Espectro();
		Marine marine = new Marine();
		mapa.agregarElemento(2, 2, espectro);
		mapa.agregarElemento(1, 1, marine);
		
		Collection<Posicion> camino = marine.mover(3, 3);
		
		Assert.assertNull(mapa.getElemento(1, 1, 0));
		Assert.assertEquals(marine,mapa.getElemento(3, 3, 1));
		Assert.assertEquals(3, camino.size());
	}
	
	public void test03_unaUnidadAereaObstruyeOtraUnidadAerea(){
		Mapa mapa = new Mapa();
		Espectro espectro1 = new Espectro();
		Espectro espectro2 = new Espectro();

		mapa.agregarElemento(2, 2, espectro1);
		mapa.agregarElemento(3, 3, espectro2);
		
		Collection<Posicion> camino = espectro1.mover(4, 4);
		
		Assert.assertNull(mapa.getElemento(2, 2, 1));
		Assert.assertEquals(espectro1,mapa.getElemento(4, 4, 1));
		Assert.assertEquals(4, camino.size());
	}
	
	public void test04_UnaUnidadAereaSeMueveYOtraUnidadAereaOcupaSuLugar(){
		Mapa mapa = new Mapa();
		Espectro espectro1 = new Espectro();
		Espectro espectro2 = new Espectro();

		mapa.agregarElemento(2, 4, espectro1);
		mapa.agregarElemento(4, 3, espectro2);
		
		Collection<Posicion> caminoE2 = espectro2.mover(4,4);
		Collection<Posicion> caminoE1 = espectro1.mover(4,3);

		Assert.assertNull(mapa.getElemento(2, 4, 1));
		Assert.assertEquals(espectro2,mapa.getElemento(4, 1, 1));
		Assert.assertEquals(espectro1,mapa.getElemento(4, 3, 1));
		Assert.assertEquals(2, caminoE1.size());
		Assert.assertEquals(2, caminoE2.size());
	}
}
