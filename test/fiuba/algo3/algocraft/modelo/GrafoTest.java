package fiuba.algo3.algocraft.modelo;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class GrafoTest {

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
		
		grafo.arista("1,1,0", "1,2,0");
		grafo.arista("1,2,0", "1,3,0");
		grafo.arista("1,3,0", "1,4,0");
		grafo.arista("1,4,0", "1,5,0");
		grafo.arista("1,5,0", "1,4,0");
		grafo.arista("1,4,0", "1,3,0");
		
		List<Posicion> camino = grafo.getCaminoMinimo("1,5,0", "1,3,0");

		Assert.assertEquals(camino.size(), 3);
		Assert.assertEquals(new Posicion(1,4,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,3,0),camino.get(2));
	}
	
	@Test
	public void test04_caminosMinimos(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				grafo.nuevoNodo(new Posicion(x,y,0));	
			}
		}
		
		grafo.arista("1,1,0", "1,2,0"); 
		grafo.arista("1,2,0", "1,3,0");	
		grafo.arista("1,3,0", "1,4,0");	
		
		grafo.arista("2,1,0", "1,1,0");
		grafo.arista("2,1,0", "1,2,0");
		
		grafo.arista("2,4,0", "1,4,0");
		grafo.arista("2,3,0", "2,4,0");
		
		List<Posicion> camino= grafo.getCaminoMinimo("2,1,0", "2,3,0");

		Assert.assertEquals(6, camino.size());
		Assert.assertEquals(new Posicion(2,1,0),camino.get(0));
		Assert.assertEquals(new Posicion(1,2,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,4,0),camino.get(3));
		Assert.assertEquals(new Posicion(2,3,0),camino.get(5));
	}
	
	@Test
	public void test05_caminosMinimos2(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();

		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				grafo.nuevoNodo(new Posicion(x,y,0));	
			}
		}
		
		grafo.arista("1,1,0", "1,2,0"); 
		grafo.arista("1,2,0", "1,3,0");	
		grafo.arista("1,3,0", "1,4,0");	
		
		grafo.arista("2,1,0", "1,1,0");
		grafo.arista("2,1,0", "1,2,0");
		
		grafo.arista("2,4,0", "1,4,0");
		grafo.arista("2,3,0", "2,4,0");
		grafo.arista("1,4,0", "2,3,0");
		
		List<Posicion> camino= grafo.getCaminoMinimo("2,1,0", "2,3,0");

		Assert.assertEquals(camino.size(), 5);
		Assert.assertEquals(new Posicion(2,1,0),camino.get(0));
		Assert.assertEquals(new Posicion(1,2,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,4,0),camino.get(3));
		Assert.assertEquals(new Posicion(2,3,0),camino.get(4));
	}
	
	@Test
	public void test06_caminosMinimos3(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		List<Posicion> camino;
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				Posicion pos = new Posicion(x,y,0);
				grafo.nuevoNodo(pos);
				
				grafo.arista(pos.toString(), (x-1)+","+(y-1)+",0");
				grafo.arista(pos.toString(), (x-1)+","+y+",0");
				grafo.arista(pos.toString(), (x-1)+","+(y+1)+",0");
				
				grafo.arista(pos.toString(),  x+","+(y-1)+",0");
				grafo.arista(pos.toString(),  x+","+(y+1)+",0");
				
				grafo.arista(pos.toString(), (x+1)+","+(y-1)+",0");
				grafo.arista(pos.toString(), (x+1)+","+y+",0");
				grafo.arista(pos.toString(), (x+1)+","+(y+1)+",0");
			}
		}
		
		camino = grafo.getCaminoMinimo("2,1,0", "2,4,0");
		Assert.assertEquals(camino.size(), 4);
		
		camino= grafo.getCaminoMinimo("5,5,0", "1,1,0");
		Assert.assertEquals(camino.size(), 5);
	}
	
	@Test
	public void test07_EliminarNodosYElCaminoMinimoEvitaLosNodosEliminados(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		List<Posicion> camino;

		for (int x=1; x <= 4; x++){
			for (int y=1; y<= 4; y++){
				Posicion pos = new Posicion(x,y,0);
				grafo.nuevoNodo(pos);
				
				grafo.arista(pos.toString(), (x-1)+","+(y-1)+",0");
				grafo.arista(pos.toString(), (x-1)+","+y+",0");
				grafo.arista(pos.toString(), (x-1)+","+(y+1)+",0");
				
				grafo.arista(pos.toString(),  x+","+(y-1)+",0");
				grafo.arista(pos.toString(),  x+","+(y+1)+",0");
				
				grafo.arista(pos.toString(), (x+1)+","+(y-1)+",0");
				grafo.arista(pos.toString(), (x+1)+","+y+",0");
				grafo.arista(pos.toString(), (x+1)+","+(y+1)+",0");
			}
		}
		
		grafo.eliminarNodo("2,2,0");

		camino= grafo.getCaminoMinimo("1,3,0", "3,1,0");
		Assert.assertEquals(camino.size(), 4);
		Assert.assertEquals(new Posicion(1,3,0),camino.get(0));
		Assert.assertEquals(new Posicion(1,2,0),camino.get(1));
		Assert.assertEquals(new Posicion(2,1,0),camino.get(2));
		Assert.assertEquals(new Posicion(3,1,0),camino.get(3));

		Posicion pos = new Posicion(1,2,0);
		grafo.arista(pos.toString(), "0,1,0");
		grafo.arista(pos.toString(), "0,2,0");
		grafo.arista(pos.toString(), "0,3,0");
		grafo.arista(pos.toString(), "1,1,0");
		grafo.arista(pos.toString(), "1,3,0");
		grafo.arista(pos.toString(), "2,1,0");
		grafo.arista(pos.toString(), "2,2,0");
		grafo.arista(pos.toString(), "2,3,0");
		
		camino= grafo.getCaminoMinimo("1,1,0", "1,3,0");
		Assert.assertEquals(camino.size(), 3);
		Assert.assertEquals(new Posicion(1,1,0),camino.get(0));
		Assert.assertEquals(new Posicion(1,2,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,3,0),camino.get(2));
		//grafo.imprimirCamino(camino);
	}
	
	@Test
	public void test08_SiNoExisteUnCaminoPosibleSeDevuelveNull(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();

		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				Posicion pos = new Posicion(x,y,0);
				grafo.nuevoNodo(pos);
				
				grafo.arista(pos.toString(), (x-1)+","+(y-1)+",0");
				grafo.arista(pos.toString(), (x-1)+","+y+",0");
				grafo.arista(pos.toString(), (x-1)+","+(y+1)+",0");
				
				grafo.arista(pos.toString(),  x+","+(y-1)+",0");
				grafo.arista(pos.toString(),  x+","+(y+1)+",0");
				
				grafo.arista(pos.toString(), (x+1)+","+(y-1)+",0");
				grafo.arista(pos.toString(), (x+1)+","+y+",0");
				grafo.arista(pos.toString(), (x+1)+","+(y+1)+",0");
			}
		}
		
		grafo.eliminarNodo("1,2,0");

		Assert.assertNull(grafo.getCaminoMinimo("1,4,0", "1,2,0"));
	}
	
	@Test
	public void test09_SePuedeCrearUnCaminoDesdeUnNodoEliminado(){
		Grafo<Posicion> grafo = new Grafo<Posicion>();
		List<Posicion> camino;
		
		for (int x=1; x <= 5; x++){
			for (int y=1; y<= 5; y++){
				Posicion pos = new Posicion(x,y,0);
				grafo.nuevoNodo(pos);
				
				grafo.arista(pos.toString(), (x-1)+","+(y-1)+",0");
				grafo.arista(pos.toString(), (x-1)+","+y+",0");
				grafo.arista(pos.toString(), (x-1)+","+(y+1)+",0");
				
				grafo.arista(pos.toString(),  x+","+(y-1)+",0");
				grafo.arista(pos.toString(),  x+","+(y+1)+",0");
				
				grafo.arista(pos.toString(), (x+1)+","+(y-1)+",0");
				grafo.arista(pos.toString(), (x+1)+","+y+",0");
				grafo.arista(pos.toString(), (x+1)+","+(y+1)+",0");
			}
		}
		
		grafo.eliminarNodo("1,2,0");
		camino = grafo.getCaminoMinimo("1,2,0", "1,4,0");
		Assert.assertEquals(3, camino.size());
		Assert.assertEquals(new Posicion(1,2,0),camino.get(0));
		Assert.assertEquals(new Posicion(2,3,0),camino.get(1));
		Assert.assertEquals(new Posicion(1,4,0),camino.get(2));
	}
}
