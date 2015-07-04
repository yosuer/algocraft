package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fiuba.algo3.algocraft.excepciones.ErrorPosicionFueraDeRango;
import fiuba.algo3.algocraft.modelo.natural.Tierra;

public class GestorDeUbicaciones {

	private int ancho; // x
	private int largo; // y
	private int alto; // z

	private Grafo<Posicion> grafo;
	private IElemento[][][] elementos;

	public GestorDeUbicaciones(int ancho, int largo, int alto) {
		this.grafo = new Grafo<Posicion>();
		this.ancho = ancho;
		this.largo = largo;
		this.alto = alto;
		this.elementos = new IElemento[this.ancho + 1][this.largo + 1][this.alto + 1];

		for (int x = 1; x <= this.ancho; x++) {
			for (int y = 1; y <= this.largo; y++) {
				for (int z = 0; z <= this.alto; z++) {
					this.nuevoNodo(new Posicion(x, y, z));
					this.elementos[x][y][z] = null;
				}
				this.elementos[x][y][0] = new Tierra(new Posicion(x, y, 0));
			}
		}
	}

	public IElemento getElemento(int x, int y, int z) {
		IElemento elemento = null;
		try {
			elemento = this.elementos[x][y][z];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ErrorPosicionFueraDeRango();
		}
		return elemento;
	}

	public boolean estaOcupado(int x, int y, int z) {
		if (x == 0 || y == 0)
			return true;
		if (z == 0)
			return (!elementos[x][y][z].equals(new Tierra()));
		return elementos[x][y][z] != null;
	}

	public void desocuparPosicion(Posicion pos) {
		if (pos.z() == 0)
			elementos[pos.x()][pos.y()][pos.z()] = new Tierra(pos);
		else
			elementos[pos.x()][pos.y()][pos.z()] = null;
		this.nuevoNodo(pos);
	}

	public void ocuparPosicion(IElemento elemento, Posicion pos) {
		this.elementos[pos.x()][pos.y()][pos.z()] = elemento;
		this.grafo.eliminarNodo(pos.toString());
	}

	public Collection<Posicion> getHojaDeRuta(Posicion inicial, Posicion destino) {
		return grafo.getCaminoMinimo(inicial.toString(), destino.toString());
	}

	private void nuevoNodo(Posicion pos) {
		grafo.nuevoNodo(pos);
		int x = pos.x();
		int y = pos.y();
		int z = pos.z();

		grafo.arista(pos.toString(), (x - 1) + "," + (y - 1) + "," + z);
		grafo.arista(pos.toString(), (x - 1) + "," + y + "," + z);
		grafo.arista(pos.toString(), (x - 1) + "," + (y + 1) + "," + z);

		grafo.arista(pos.toString(), x + "," + (y - 1) + "," + z);
		grafo.arista(pos.toString(), x + "," + (y + 1) + "," + z);

		grafo.arista(pos.toString(), (x + 1) + "," + (y - 1) + "," + z);
		grafo.arista(pos.toString(), (x + 1) + "," + y + "," + z);
		grafo.arista(pos.toString(), (x + 1) + "," + (y + 1) + "," + z);
	}

	public Posicion getPosicionProxima(Posicion posAnt) {
		int x = posAnt.x();
		int y = posAnt.y();
		int z = posAnt.z();
		int n = 1;

		if (!this.estaOcupado(x, y, z))
			return posAnt;

		while (n < 5) {
			if (!this.estaOcupado(x - n, y - n, z))
				return new Posicion(x - n, y - n, z);
			if (!this.estaOcupado(x - n, y, z))
				return new Posicion(x - n, y, z);
			if (!this.estaOcupado(x - n, y + n, z))
				return new Posicion(x - n, y + n, z);
			if (!this.estaOcupado(x, y - n, z))
				return new Posicion(x, y - n, z);
			if (!this.estaOcupado(x, y + n, z))
				return new Posicion(x, y + n, z);
			if (!this.estaOcupado(x + n, y - n, z))
				return new Posicion(x + n, y - n, z);
			if (!this.estaOcupado(x + n, y, z))
				return new Posicion(x + n, y, z);
			if (!this.estaOcupado(x + n, y + n, z))
				return new Posicion(x + n, y + n, z);
			n++;
		}

		return null;
	}

	public List<Unidad> getUnidadesProximas(Posicion pos, int radio) {
		List<Unidad> unidades = new ArrayList<Unidad>();

		for (int x = pos.x() - radio; x <= pos.x() + radio; x++) {
			for (int y = pos.y() - radio; y <= pos.y() + radio; y++) {
				for (int z = 0; z <= 1; z++) {
					try {
						Unidad u = (Unidad) this.elementos[x][y][z];
						if (u != null)
							unidades.add(u);
					} catch (ClassCastException e1) {
					} catch (ArrayIndexOutOfBoundsException e2) {
					}

				}
			}
		}
		return unidades;
	}

	public int getDistancia(Posicion posInicial, Posicion posFinal) {
		int difX = Math.abs(posInicial.x() - posFinal.x());
		int difY = Math.abs(posInicial.y() - posFinal.y());
		return (int) Math.round(Math.sqrt(difX * difX + difY * difY));
	}

}
