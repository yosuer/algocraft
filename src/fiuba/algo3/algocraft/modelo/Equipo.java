package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.modelo.edificios.BasePrincipal;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.Criadero;
import fiuba.algo3.algocraft.modelo.edificios.Nexo;

public class Equipo {
	private Collection<Controlable> elementosActivos;
	private Queue<Unidad> unidadesPreparadas;
	private String nombre;
	private Mapa mapa;
	private GestorDeRecursos gestorDeRecursos;
	private FloatRango poblacionTotal;
	private BasePrincipal base;

	public Equipo(String nombre) {
		this.nombre = nombre;
		this.elementosActivos = new ArrayList<Controlable>();
		this.unidadesPreparadas = new LinkedList<Unidad>();
		this.gestorDeRecursos = new GestorDeRecursos();
		this.poblacionTotal = new FloatRango(0, 200, 0);
	}

	private void setRaza(String raza) {
		if (raza == "Terran")
			base = new CentroDeMando();
		else if (raza == "Protoss")
			base = new Nexo();
		else if (raza == "Zerg")
			base = new Criadero();

	}

	public String getNombre() {
		return nombre;
	}

	public BasePrincipal getBasePrincipal() {
		return base;
	}

	public void setNombre(String nombre, String razaJ1) {
		this.nombre = nombre;
		setRaza(razaJ1);
	}

	public void pasarTurno() {
		Iterator<Controlable> it = elementosActivos.iterator();
		while (it.hasNext()) {
			it.next().pasarTurno();
		}

		for (int i = 1; i <= unidadesPreparadas.size(); i++) {
			Unidad u = unidadesPreparadas.remove();
			mapa.agregarElemento(u.getPosicion().x(), u.getPosicion().y(), u);
		}
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public void agregarElemento(Controlable elemento) {
		elemento.setEquipo(this);
		this.elementosActivos.add(elemento);
	}

	public int getMineralTotal() {
		return this.gestorDeRecursos.getMineralTotal();
	}

	public int getVespenoTotal() {
		return this.gestorDeRecursos.getVespenoTotal();
	}

	public void recibirMineral(int recolectado) {
		this.gestorDeRecursos.recibirMineral(recolectado);
	}

	public void recibirVespeno(int recolectado) {
		this.gestorDeRecursos.recibirVespeno(recolectado);
	}

	public void gastarRecursos(int mineral, int vespeno) {
		this.gestorDeRecursos.gastarRecursos(mineral, vespeno);
	}

	public void removerElemento(IElemento elemento) {
		this.elementosActivos.remove(elemento);
	}

	public boolean existen(Collection<Controlable> aBuscar) {
		return this.elementosActivos.containsAll(aBuscar);
	}

	public int cantidadElementos() {
		return this.elementosActivos.size();
	}

	public void aumentarPoblacion(float suministro) {
		this.poblacionTotal.aumentar(suministro);
	}

	public void restarPoblacion(float suministro) {
		this.poblacionTotal.disminuir(suministro);
	}

	public void consumirPoblacion(float suministro) {
		if (this.poblacionTotal.val() < suministro)
			throw new ErrorCapacidadDePoblacionInsuficiente();
		this.poblacionTotal.disminuir(suministro);
	}

	public void encolarUnidad(Unidad u) {
		this.unidadesPreparadas.add(u);
	}

	public double getPoblacionTotal() {
		return this.poblacionTotal.val();
	}

}
