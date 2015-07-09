package fiuba.algo3.algocraft.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorUnidadInmovilizada;
import fiuba.algo3.algocraft.modelo.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.unidades.AlucinacionUnidad;
import fiuba.algo3.algocraft.modelo.unidades.Marine;
import fiuba.algo3.algocraft.modelo.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.unidades.Reina;
import fiuba.algo3.algocraft.modelo.unidades.Scout;
import fiuba.algo3.algocraft.modelo.unidades.Zealot;
import fiuba.algo3.algocraft.modelo.unidades.Zerling;

public class MagiaTest {

	@Test
	public void test01_NaveCienciaLanzaUnEMPyDaniaElEscudoDeLasUnidadesAlrededorDeLaPosicionObjetivo(){
		Mapa mapa = new Mapa(40, 40);
		Unidad zeratul = new Zealot();
		Marine raynor = new Marine();
		AltoTemplario altoTemplario = new AltoTemplario();
		Scout scout = new Scout();
		
		// turno jugador 1
		
		mapa.agregarElemento(9, 9, altoTemplario);
		mapa.agregarElemento(7, 9, raynor);
		mapa.agregarElemento(8, 9, zeratul);
		mapa.agregarElemento(7, 7, scout);
		
		mapa.pasarTurnoMapa();  //Turno jugador 2
		
		NaveCiencia naveCiencia = new NaveCiencia();
		mapa.agregarElemento(5, 5, naveCiencia);
		
		mapa.pasarTurnoMapa();// turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();// turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();// turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2

		Assert.assertEquals(160, zeratul.vidaActual());
		Assert.assertEquals(40, raynor.vidaActual());
		Assert.assertEquals(80,altoTemplario.vidaActual());
		Assert.assertEquals(155,altoTemplario.energiaActual());
		Assert.assertEquals(250, scout.vidaActual());

		
		Assert.assertEquals(110,naveCiencia.energiaActual());	
		
//		naveCiencia.lanzarEMP(new Posicion(9,9,0));
		
		naveCiencia.lanzarMagiaAPosicion(new Posicion(9,9,0));
		
		Assert.assertEquals(100, zeratul.vidaActual());
		Assert.assertEquals(150, scout.vidaActual());
		Assert.assertEquals(40, raynor.vidaActual());
		Assert.assertEquals(40,altoTemplario.vidaActual());
		Assert.assertEquals(0,altoTemplario.energiaActual());		
		Assert.assertEquals(10,naveCiencia.energiaActual());
	}
	
	@Test
	public void test02_unaNaveCieciaLanzaEMPaUnaUnidadYDichaUnidadPierdeVidaEnCadaTurno()
	{
		Mapa mapa = new Mapa(40, 40);
		NaveCiencia nave = new NaveCiencia();
		Marine unMarine = new Marine();
		
		//turno jugador 1
		
		Assert.assertEquals(nave.energiaActual(), 50);
		
		mapa.agregarElemento(7, 8, nave);
		
		
		mapa.pasarTurnoMapa();
		
		//turno jugador 2
		
		mapa.agregarElemento(10, 10, unMarine);
		
		mapa.pasarTurnoMapa(); //turno jugador 1
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		
		Assert.assertEquals(nave.energiaActual(), 90);
		
//		nave.lanzarRadiacion(unMarine);
		
		nave.lanzarMagiaAUnidad(unMarine);
		
		Assert.assertEquals(unMarine.vidaActual(),20);
		Assert.assertEquals(nave.energiaActual(), 15);

		
		mapa.pasarTurnoMapa();
		
		Assert.assertFalse(mapa.estaOcupado(10, 10, 0));
		Assert.assertEquals(nave.energiaActual(), 25);
		
		
		
		
	}
	
	@Test  
	public void test03_unaNaveCienciaLanzaEMPaUnaUnidadYDichaUnidadPierdeVidaEnCadaTurnoYLasUnidadesCercanasTambien()
	{
		Mapa mapa = new Mapa(40, 40);
		NaveCiencia nave = new NaveCiencia();
		Marine unMarine = new Marine();
		Marine otroMarine = new Marine();
		Zealot unZealot = new Zealot();
		
		//turno jugador 1
		
		Assert.assertEquals(nave.energiaActual(), 50);
		
		mapa.agregarElemento(7, 8, nave);
		
		
		mapa.pasarTurnoMapa();
		
		//turno jugador 2
		
		mapa.agregarElemento(10, 10, unMarine);
		mapa.agregarElemento(11, 10, otroMarine);
		mapa.agregarElemento(11,11,unZealot);
		
		mapa.pasarTurnoMapa(); //turno jugador 1
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		
		Assert.assertEquals(nave.energiaActual(), 90);
		
//		nave.lanzarRadiacion(unMarine);
		
		nave.lanzarMagiaAUnidad(unMarine);
		
		Assert.assertEquals(unMarine.vidaActual(),20);
		Assert.assertEquals(otroMarine.vidaActual(),40);
		Assert.assertEquals(unZealot.vidaActual(),160);
		Assert.assertEquals(nave.energiaActual(), 15);

		
		mapa.pasarTurnoMapa();
		
		Assert.assertFalse(mapa.estaOcupado(10, 10, 0));
		Assert.assertEquals(otroMarine.vidaActual(),20);
		Assert.assertEquals(unZealot.vidaActual(),140);
		Assert.assertEquals(nave.energiaActual(), 25);
	}
	
	@Test
	public void test04_LaReinaLanzaInfestacionAUnaUnidadYEstaSeDestruyeYNacen2Zerlings()
	{
		Mapa mapa = new Mapa(40, 40);
		Reina unaReina = new Reina();
		Marine unMarine = new Marine();
		
		//turno jugador 1
		
		mapa.agregarElemento(10, 10, unaReina);
		
		mapa.pasarTurnoMapa();
		
		//turno Jugdor 2
		
		mapa.agregarElemento(14, 14, unMarine);
		Assert.assertTrue(mapa.estaOcupado(14,14,0));

		
		mapa.pasarTurnoMapa();// turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();// turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();// turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();// turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();// turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();// turno jugador 1
		
		Assert.assertEquals(unaReina.energiaActual(), 170);
		
//		unaReina.lanzarInfestar(unMarine);
		
		unaReina.lanzarMagiaAUnidad(unMarine);
		
		Assert.assertTrue(mapa.estaOcupado(14,14,0));
		Assert.assertTrue(mapa.estaOcupado(13,13,0));
		Assert.assertEquals(unaReina.energiaActual(), 20);
		Assert.assertEquals(mapa.getElemento(14, 14, 0).getClass(), Zerling.class);
		Assert.assertEquals(mapa.getElemento(13, 13, 0).getClass(), Zerling.class);
	}
	
	@Test  
	public void test05_unaAlucinacionSolotieneEscudoYCuandoSeTerminaDesaparece()
	{
		Mapa mapa = new Mapa(40,40);
		Zealot unZealot = new Zealot();
		AltoTemplario altoTemplario = new AltoTemplario();
		Marine marine = new Marine();
		
		
		//turno jugador 1
		
		Assert.assertEquals(altoTemplario.energiaActual(), 50);
		
		mapa.agregarElemento(7, 8, altoTemplario);				
		mapa.agregarElemento(11,11,unZealot);
		mapa.agregarElemento(9, 9, marine);
		
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		
		Assert.assertEquals(altoTemplario.energiaActual(), 110);
		
//		altoTemplario.lanzarAlucinacion(unZealot);
		
		altoTemplario.lanzarMagiaAUnidad(unZealot);;
		
		Assert.assertEquals(altoTemplario.energiaActual(), 10);
		Assert.assertTrue(mapa.estaOcupado(10,11,0));
		Assert.assertTrue(mapa.estaOcupado(10,10,0));
		Assert.assertTrue(mapa.estaOcupado(11,11,0));
		
		Unidad unaAlucinacion = (Unidad) mapa.getElemento(10,11,0);
		Unidad otraAlucinacion = (Unidad) mapa.getElemento(10,10,0);
		
		Assert.assertEquals(unaAlucinacion.getEstado().getEscudo(), 60);
		Assert.assertEquals(otraAlucinacion.getEstado().getEscudo(), 60);
		Assert.assertEquals(unaAlucinacion.getEstado().getVida(), 60);
		Assert.assertEquals(otraAlucinacion.getEstado().getVida(), 60);
		
		marine.atacar(unaAlucinacion);
		
		Assert.assertEquals(unaAlucinacion.getEstado().getEscudo(), 54);
		

	}
		
		
	@Test  
	public void test06_unAltoTemplarioLanzaTormentaPsionicaYEstaDura2Turnos()
	{
		Mapa mapa = new Mapa(40,40);
		Marine unMarine = new Marine();
		Marine otroMarine = new Marine();
		Zealot unZealot = new Zealot();
		AltoTemplario altoTemplario = new AltoTemplario();
		Scout scout = new Scout();
		
		
		//turno jugador 1
		
		Assert.assertEquals(altoTemplario.energiaActual(), 50);
		
		mapa.agregarElemento(7, 8, altoTemplario);
		
		
		mapa.pasarTurnoMapa();
		
		//turno jugador 2
		
		mapa.agregarElemento(10, 10, unMarine);
		mapa.agregarElemento(11, 10, otroMarine);
		mapa.agregarElemento(11,11,unZealot);
		mapa.agregarElemento(12, 12, scout);
		
		mapa.pasarTurnoMapa(); //turno jugador 1
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		
		Assert.assertEquals(altoTemplario.energiaActual(), 110);
		
//		altoTemplario.lanzarTormentaPsionica(new Posicion(11,11,0));
		
		altoTemplario.lanzarMagiaAPosicion(new Posicion(11,11,0));
		
		Assert.assertFalse(mapa.estaOcupado(10,10,0));
		Assert.assertFalse(mapa.estaOcupado(11,10,0));
		Assert.assertEquals(unZealot.vidaActual(),60);
		Assert.assertEquals(scout.vidaActual(), 150);
		Assert.assertEquals(altoTemplario.energiaActual(), 35);

		
		mapa.pasarTurnoMapa();
		
		Assert.assertFalse(mapa.estaOcupado(11,11,0));
		Assert.assertEquals(scout.vidaActual(),50);
		Assert.assertEquals(altoTemplario.energiaActual(), 50);
	}
	

	@Test  
	public void test07_unAltoTemplarioLanzaCreaUnaAlucinacion()
	{
		Mapa mapa = new Mapa(40,40);
		Zealot unZealot = new Zealot();
		AltoTemplario altoTemplario = new AltoTemplario();
		
		
		//turno jugador 1
		
		Assert.assertEquals(altoTemplario.energiaActual(), 50);
		
		mapa.agregarElemento(7, 8, altoTemplario);				
		mapa.agregarElemento(11,11,unZealot);
		
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		
		Assert.assertEquals(altoTemplario.energiaActual(), 110);
		
//		altoTemplario.lanzarAlucinacion(unZealot);
		
		altoTemplario.lanzarMagiaAUnidad(unZealot);
		
		Assert.assertEquals(altoTemplario.energiaActual(), 10);
		Assert.assertTrue(mapa.estaOcupado(10,11,0));
		Assert.assertTrue(mapa.estaOcupado(10,10,0));
		Assert.assertTrue(mapa.estaOcupado(11,11,0));
		
		Unidad unaAlucinacion = (Unidad) mapa.getElemento(10,11,0);
		Unidad otraAlucinacion = (Unidad) mapa.getElemento(10,10,0);		
		Assert.assertEquals(unaAlucinacion.getEstado().getEscudo(), 60);
		Assert.assertEquals(otraAlucinacion.getEstado().getEscudo(), 60);
		
	}
	
	@Test  (expected = ErrorUnidadInmovilizada.class)
	public void test08_reinaLanaRedLasUnidadesAfectadasNoSePuedeMover()
	{
		Mapa mapa = new Mapa(40,40);
		Marine unMarine = new Marine();
		Marine otroMarine = new Marine();
		Reina reina = new Reina();		
		
		//turno jugador 1
		
		Assert.assertEquals(reina.energiaActual(), 50);
		
		mapa.agregarElemento(7, 8, reina);
		
		mapa.pasarTurnoMapa();
		
		//turno jugador 2
		
		mapa.agregarElemento(10, 10, unMarine);
		mapa.agregarElemento(11, 10, otroMarine);
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();//turno jugador 1
		
		Assert.assertEquals(reina.energiaActual(), 100);
		Assert.assertTrue(mapa.estaOcupado(10, 10, 0));
		
//		reina.lanzarRed(new Posicion(11,11,0));
		
		reina.lanzarMagiaAPosicion(new Posicion(11,11,0));
		
		Assert.assertEquals(reina.energiaActual(),25);
		
		List<Posicion> movimientos = unMarine.mover(10,11);


	}
	
	@Test
	public void test09_UnaUnidadQueFueAfectadaPorRedPuedeMoverseEnTresTurnos()
	{
		Mapa mapa = new Mapa(40,40);
		Marine unMarine = new Marine();
		Marine otroMarine = new Marine();
		Reina reina = new Reina();		
		
		//turno jugador 1
		
		Assert.assertEquals(reina.energiaActual(), 50);
		
		mapa.agregarElemento(7, 8, reina);
		
		mapa.pasarTurnoMapa();
		
		//turno jugador 2
		
		mapa.agregarElemento(10, 10, unMarine);
		mapa.agregarElemento(11, 10, otroMarine);
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		mapa.pasarTurnoMapa();// turno jugador 2
		mapa.pasarTurnoMapa();//turno jugador 1
		
		Assert.assertEquals(reina.energiaActual(), 100);
		Assert.assertTrue(mapa.estaOcupado(10, 10, 0));
		
//		reina.lanzarRed(new Posicion(11,11,0));
		
		reina.lanzarMagiaAPosicion(new Posicion(11,11,0));
		
		Assert.assertEquals(reina.energiaActual(),25);
		
		mapa.pasarTurnoMapa(); //turno jugador 2
		mapa.pasarTurnoMapa(); //turno jugador 1
		mapa.pasarTurnoMapa(); //turno jugador 2
		
		List<Posicion> posiciones = unMarine.mover(11,11);
		
		mapa.pasarTurnoMapa();
		
		Assert.assertTrue(mapa.estaOcupado(11, 11, 0));
		Assert.assertFalse(mapa.estaOcupado(10, 10, 0));
				
	}
}
