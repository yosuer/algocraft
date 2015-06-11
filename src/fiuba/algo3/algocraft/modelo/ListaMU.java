package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class ListaMU<E> extends ArrayList<E>{

    public int tamano() {
        return size();
    }
    
	public void push(E e) {
        add(e);
    }
	
	public void encolar(E e) {
		this.add(e);
    }

	public E desEncolar() {
		if (empty()) throw new EmptyStackException();
		return this.remove(0);
    }

    public E pop() throws EmptyStackException {
    	if (empty()) throw new EmptyStackException();
        return remove(size() - 1);
    }
    
    public boolean empty() {
        return size() == 0;
    }
    
    public E peek() {
        return get(size() - 1);
    }
    
    public boolean eliminarContenido(E e) {
        return this.remove(e);
    }
    
    public void insertar(E e) {
        this.add(0, e);
    }
    public boolean estaVacia() {
        return this.isEmpty();
    }
    
    public E primero() throws IndexOutOfBoundsException {
        return this.get(0);
    }
                       
    public E ultimo() throws IndexOutOfBoundsException {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("Vacia");
        return get(size() - 1);
    }
    
    public boolean existe(E e) {
    	return this.contains(e);
    }
    


}
