package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;

public class Equipo {
	private Collection<IElemento> elementosActivos;
	private String nombre;
	private Mapa mapa;
	private GestorDeRecursos gestorDeRecursos;
	private FloatRango poblacionTotal;

	public Equipo(String nombre){
		this.nombre = nombre;
		this.elementosActivos = new ArrayList<IElemento>();
		this.gestorDeRecursos = new GestorDeRecursos();
		this.poblacionTotal = new FloatRango(0,200,10);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void pasarTurno(){
		Iterator<IElemento> it = elementosActivos.iterator();
		while (it.hasNext()){
			it.next().pasarTurno();
		}
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
		mapa.agregarEquipo(this);
	}
	
	public void agregarElemento(IElemento elemento) {
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
	
	public void gastarRecursos(int mineral, int vespeno){
		this.gestorDeRecursos.gastarRecursos(mineral,vespeno);
	}

	public void removerElemento(IElemento elemento) {
		this.elementosActivos.remove(elemento);
	}

	public boolean existen(Collection<IElemento> aBuscar) {
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

}
