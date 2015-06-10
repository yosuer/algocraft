package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;
import fiuba.algo3.algocraft.excepciones.ErrorNoExisteCaminoPosible;

public class GrafoTest {

	@Test
	public void testPila_0(){
		ListaMU<Posicion> pila = new ListaMU<Posicion>();
		pila.push(new Posicion(1,1,0));
		pila.push(new Posicion(1,2,0));
		pila.push(new Posicion(1,3,0));
		pila.push(new Posicion(1,4,0));
		
		Assert.assertEquals(pila.tamano(),4);
		Assert.assertTrue(pila.existe(new Posicion(1,2,0)));
		Assert.assertEquals(pila.primero(),new Posicion(1,1,0));
		
	}
	
	@Test
	public void testPila_1(){
		ListaMU<Posicion> pila = new ListaMU<Posicion>();
		pila.push(new Posicion(1,1,0));
		pila.push(new Posicion(1,2,0));
		pila.push(new Posicion(1,3,0));
		
		Assert.assertEquals(pila.pop(), new Posicion(1,3,0));
		Assert.assertEquals(pila.pop(), new Posicion(1,2,0));
		Assert.assertEquals(pila.pop(), new Posicion(1,1,0));
	}
	
	@Test
	public void testPila_2(){
		ListaMU<Posicion> pila = new ListaMU<Posicion>();
		pila.push(new Posicion(1,1,0));
		pila.push(new Posicion(1,2,0));
		pila.push(new Posicion(1,3,0));
		
		pila.eliminarContenido(new Posicion(1,2,0));
		
		Assert.assertEquals(pila.pop(), new Posicion(1,3,0));
		Assert.assertEquals(pila.pop(), new Posicion(1,1,0));
	}
	
	@Test
	public void testPila_3(){
		ListaMU<Posicion> pila = new ListaMU<Posicion>();
		pila.push(new Posicion(1,1,0));
		pila.push(new Posicion(1,2,0));
		pila.push(new Posicion(1,3,0));
		
		pila.insertar(new Posicion(2,2,0));
		
		Assert.assertEquals(pila.pop(), new Posicion(1,3,0));
		Assert.assertEquals(pila.pop(), new Posicion(1,2,0));
		Assert.assertEquals(pila.pop(), new Posicion(1,1,0));
		Assert.assertEquals(pila.pop(), new Posicion(2,2,0));
	}
	
	@Test
	public void test01_instanciarGrafo(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
	}
	
	@Test
	public void test02_agregarNodosAlGrafo(){
		Grafo<String> grafo = new Grafo<String>();
		
		grafo.nuevoNodo("A", "Nodo1");
		Assert.assertEquals(grafo.getNodos().size(),1);

		grafo.nuevoNodo("B", "Nodo2");
		Assert.assertEquals(grafo.getNodos().size(),2);
	}
	
	@Test
	public void test03_agregarNodosAlGrafo(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		int n = 0;
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				grafo.nuevoNodo(new Posicion(x,y,n));	
			}
		}
		
		grafo.arista("1,1", "1,2");
		grafo.arista("1,2", "1,3");
		grafo.arista("1,3", "1,4");
		grafo.arista("1,4", "1,5");
		grafo.arista("1,5", "1,4");
		grafo.arista("1,4", "1,3");
		
		ArrayList<Posicion> camino = grafo.getCaminoMinimo("1,5", "1,3");

		Assert.assertEquals(camino.size(), 3);
		Assert.assertEquals(new Posicion(1,4,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,3,0),camino.get(2));
	}
	
	@Test
	public void test04_caminosMinimos(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		int n = 0;
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				grafo.nuevoNodo(new Posicion(x,y,n));	
			}
		}
		
		grafo.arista("1,1", "1,2"); 
		grafo.arista("1,2", "1,3");	
		grafo.arista("1,3", "1,4");	
		
		grafo.arista("2,1", "1,1");
		grafo.arista("2,1", "1,2");
		
		grafo.arista("2,4", "1,4");
		grafo.arista("2,3", "2,4");
		
		ArrayList<Posicion> camino= grafo.getCaminoMinimo("2,1", "2,3");

		Assert.assertEquals(6, camino.size());
		Assert.assertEquals(new Posicion(2,1,0),camino.get(0));
		Assert.assertEquals(new Posicion(1,2,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,4,0),camino.get(3));
		Assert.assertEquals(new Posicion(2,3,0),camino.get(5));
	}
	
	@Test
	public void test05_caminosMinimos2(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		int n = 0;
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				grafo.nuevoNodo(new Posicion(x,y,n));	
			}
		}
		
		grafo.arista("1,1", "1,2"); 
		grafo.arista("1,2", "1,3");	
		grafo.arista("1,3", "1,4");	
		
		grafo.arista("2,1", "1,1");
		grafo.arista("2,1", "1,2");
		
		grafo.arista("2,4", "1,4");
		grafo.arista("2,3", "2,4");
		grafo.arista("1,4", "2,3");
		
		ArrayList<Posicion> camino= grafo.getCaminoMinimo("2,1", "2,3");

		Assert.assertEquals(camino.size(), 5);
		Assert.assertEquals(new Posicion(2,1,0),camino.get(0));
		Assert.assertEquals(new Posicion(1,2,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,4,0),camino.get(3));
		Assert.assertEquals(new Posicion(2,3,0),camino.get(4));
	}
	
	@Test
	public void test06_caminosMinimos3(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		ArrayList<Posicion> camino;
		int n = 0;
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				grafo.nuevoNodo(new Posicion(x,y,n));
				
				grafo.arista(x+","+y, (x-1)+","+(y-1));
				grafo.arista(x+","+y, (x-1)+","+y);
				grafo.arista(x+","+y, (x-1)+","+(y+1));
				
				grafo.arista(x+","+y,  x+","+(y-1));
				grafo.arista(x+","+y,  x+","+(y+1));
				
				grafo.arista(x+","+y, (x+1)+","+(y-1));
				grafo.arista(x+","+y, (x+1)+","+y);
				grafo.arista(x+","+y, (x+1)+","+(y+1));
			}
		}
		
		camino= grafo.getCaminoMinimo("2,1", "2,4");
		Assert.assertEquals(camino.size(), 4);
		
		camino= grafo.getCaminoMinimo("5,5", "1,1");
		Assert.assertEquals(camino.size(), 5);
	}
	
	@Test
	public void test07_EliminarNodosYElCaminoMinimoEvitaLosNodosEliminados(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		ArrayList<Posicion> camino;
		int n = 0;
		
		for (int x=1; x <= 4; x++){
			for (int y=1; y<= 4; y++){
				grafo.nuevoNodo(new Posicion(x,y,n));
				grafo.arista(x+","+y, (x-1)+","+(y-1));
				grafo.arista(x+","+y, (x-1)+","+y);
				grafo.arista(x+","+y, (x-1)+","+(y+1));
				
				grafo.arista(x+","+y,  x+","+(y-1));
				grafo.arista(x+","+y,  x+","+(y+1));
				
				grafo.arista(x+","+y, (x+1)+","+(y-1));
				grafo.arista(x+","+y, (x+1)+","+y);
				grafo.arista(x+","+y, (x+1)+","+(y+1));
			}
		}
		
		grafo.eliminarNodo("2,2");

		camino= grafo.getCaminoMinimo("1,3", "3,1");
		Assert.assertEquals(camino.size(), 4);
		Assert.assertEquals(new Posicion(1,3,0),camino.get(0));
		Assert.assertEquals(new Posicion(2,3,0),camino.get(1));
		Assert.assertEquals(new Posicion(3,2,0),camino.get(2));
		Assert.assertEquals(new Posicion(3,1,0),camino.get(3));
		//grafo.imprimirCamino(camino);
		
		grafo.arista("1,2", "0,1");
		grafo.arista("1,2", "0,2");
		grafo.arista("1,2", "0,3");
		grafo.arista("1,2", "1,1");
		grafo.arista("1,2", "1,3");
		grafo.arista("1,2", "2,1");
		grafo.arista("1,2", "2,2");
		grafo.arista("1,2", "2,3");
		
		camino= grafo.getCaminoMinimo("1,1", "1,3");
		Assert.assertEquals(camino.size(), 3);
		Assert.assertEquals(new Posicion(1,1,0),camino.get(0));
		Assert.assertEquals(new Posicion(1,2,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,3,0),camino.get(2));
		//grafo.imprimirCamino(camino);
	}
	
	@Test//(expected = ErrorNoExisteCaminoPosible.class)
	public void test08_SiNoExisteUnCaminoPosibleSeDevuelveNull(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		ArrayList<Posicion> camino;
		int n = 0;
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				grafo.nuevoNodo(new Posicion(x,y,n));
				
				grafo.arista(x+","+y, (x-1)+","+(y-1));
				grafo.arista(x+","+y, (x-1)+","+y);
				grafo.arista(x+","+y, (x-1)+","+(y+1));
				
				grafo.arista(x+","+y,  x+","+(y-1));
				grafo.arista(x+","+y,  x+","+(y+1));
				
				grafo.arista(x+","+y, (x+1)+","+(y-1));
				grafo.arista(x+","+y, (x+1)+","+y);
				grafo.arista(x+","+y, (x+1)+","+(y+1));
			}
		}
		
		grafo.eliminarNodo("1,2");

		Assert.assertNull(grafo.getCaminoMinimo("1,4", "1,2"));
	}
	
	@Test
	public void test09_SePuedeCrearUnCaminoDesdeUnNodoEliminado(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		ArrayList<Posicion> camino;
		int n = 0;
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				grafo.nuevoNodo(new Posicion(x,y,n));
				
				grafo.arista(x+","+y, (x-1)+","+(y-1));
				grafo.arista(x+","+y, (x-1)+","+y);
				grafo.arista(x+","+y, (x-1)+","+(y+1));
				
				grafo.arista(x+","+y,  x+","+(y-1));
				grafo.arista(x+","+y,  x+","+(y+1));
				
				grafo.arista(x+","+y, (x+1)+","+(y-1));
				grafo.arista(x+","+y, (x+1)+","+y);
				grafo.arista(x+","+y, (x+1)+","+(y+1));
			}
		}
		
		grafo.eliminarNodo("1,2");
		camino = grafo.getCaminoMinimo("1,2", "1,4");
		Assert.assertEquals(3, camino.size());
		Assert.assertEquals(new Posicion(1,2,0),camino.get(0));
		Assert.assertEquals(new Posicion(1,3,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,4,0),camino.get(2));
	}
}
