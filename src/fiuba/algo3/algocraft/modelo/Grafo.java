package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import fiuba.algo3.algocraft.excepciones.ErrorNoExisteCaminoPosible;

public class Grafo<E> {

    private Hashtable<String, Nodo<E>> nodos;

    public Grafo() {
        nodos = new Hashtable<String, Nodo<E>>();
    }

    public Collection<Nodo<E>> getNodos() {
        return nodos.values();
    }

    public void nuevoNodo(E v) {
        nuevoNodo(v.toString(), v);
    }

    public void nuevoNodo(String id, E v) {
        Nodo<E> objNodo = new Nodo<E>(id, v);
        nodos.put(id, objNodo);
    }

    public void arista(String nodoOrigen, String nodoDestino) {
        Nodo<E> objNodoOrigen = this.nodos.get(nodoOrigen);
        Nodo<E> objNodoDestino = this.nodos.get(nodoDestino);
        
        if (objNodoOrigen != null && 
        		objNodoDestino != null) {
        	 objNodoOrigen.insertarVecino(objNodoDestino);
             objNodoDestino.insertarVecino(objNodoOrigen);
        }
    }
    
    public void eliminarNodo(String nodo){
    	Nodo<E> nodoAEliminar = this.nodos.get(nodo);
    	
    	ListaMU<Nodo<E>> vecinos = nodoAEliminar.getVecinos();
    	Iterator<Nodo<E>> it = vecinos.iterator();
    	while (it.hasNext()){
    		it.next().eliminarVecino(nodoAEliminar);
    	}
    }

    private String getNodoDistanciaMasCortaEnAnalizados(ListaMU<String> analizados, 
                                                        Hashtable<String, Integer> distancias) {
        String resultado = null;
        int minDistancia = Integer.MAX_VALUE;

        Iterator<String> i = analizados.iterator();
        while (i.hasNext()) {
            String idNodo = i.next();
            int distanciaNodo = distancias.get(idNodo).intValue();
            if (distanciaNodo < minDistancia) {
                minDistancia = distanciaNodo;
                resultado = idNodo;
            }
        }
        return resultado;
    }

    private ListaMU<Nodo<E>> formarRespuesta(Hashtable<String, String> anterior, 
                                          						String destino) {
        ListaMU<Nodo<E>> resultado = new ListaMU<Nodo<E>>();
        
        Nodo<E> recorre = nodos.get(destino);
        resultado.encolar(recorre);

        while (true) {
            String idAnterior = anterior.get(recorre.getId());
            if (idAnterior == null)
                break;
            recorre = nodos.get(idAnterior);
            resultado.encolar(recorre);
        }
        
        return resultado;
    }

    private void inicializarParaDijkstra(String origen, 
                                         ListaMU<String> analizados, 
                                         Hashtable<String, Integer> distancias) {
    	
        Iterator<Nodo<E>> i = this.nodos.values().iterator();
        while (i.hasNext()) {
            Nodo<E> objNodo = i.next();
            distancias.put(objNodo.getId(), new Integer(Integer.MAX_VALUE));
            analizados.insertar(objNodo.getId());
        }

        // coloca la distancia del origen a 0
        distancias.put(origen, new Integer(0));
    }

    public ArrayList<E> getCaminoMinimo(String origen, String destino) {
        if (origen == null || 
        		destino == null) {
            return null;
        }
        
        // Coloca las distancias de todos los nodos a infinito
        // Se aqrma una cadena analizados con todos los nodos
        ListaMU<String> analizados = new ListaMU<String>();
        Hashtable<String, Integer> distancias = new Hashtable<String, Integer>();
        Hashtable<String, String> anterior = new Hashtable<String, String>();

        inicializarParaDijkstra(origen, analizados, distancias);

        // comienza la iteracion
        while (analizados.tamano() > 0) {
            String idNodo = 
                getNodoDistanciaMasCortaEnAnalizados(analizados, distancias);
            // Lo quita de la lista de analizados
            analizados.eliminarContenido(idNodo);
            try {
            if (idNodo.equals(destino)) {
                ListaMU<Nodo<E>> resultado = formarRespuesta(anterior, destino);
                return this.crearListadoDeElemento(resultado);
            	}
            } catch( NullPointerException e){
            	//throw new ErrorNoExisteCaminoPosible();
            	return null;
            }
            

            Iterator<Nodo<E>> i = nodos.get(idNodo).getVecinos().iterator();
            while (i.hasNext()) {
                Nodo<E> objNodo = i.next();
                // Solamente los que estan en analizados
                if (!analizados.existe(objNodo.getId())) {
                    continue;
                }

                int calculoDistancia = distancias.get(idNodo).intValue() + 1;
                int distanciaParaNodoVecino = 
                    distancias.get(objNodo.getId()).intValue();
                if (calculoDistancia < distanciaParaNodoVecino) {
                    distancias.put(objNodo.getId(), 
                                   new Integer(calculoDistancia));
                    anterior.put(objNodo.getId(), idNodo);
                }
            }
        }

        return null;
    }
    
    private ArrayList<E> crearListadoDeElemento(ListaMU<Nodo<E>> resultado) {
		ArrayList<E> elementos = new ListaMU<E>();
		Iterator<Nodo<E>> it = resultado.iterator();
		while (it.hasNext()) {
			elementos.add(0,it.next().getValor());
		}
		return elementos;
	}

	public void imprimirCamino(ListaMU<Nodo<E>> lista){
    	Iterator<Nodo<E>> it = lista.iterator();
    	while (it.hasNext()) {
    		System.out.println(it.next().getValor());
    	}
    	System.out.println("-----------------------");
    }

	
    /* 
     * Solo para uso interno del Grafo
     */
    private static class Nodo<E> {
        private String id;
        private E valor;
        private ListaMU<Nodo<E>> vecinos;
        private int visitado;

        public Nodo(String identificador, E v) {
            this.id = identificador;
            this.valor = v;
            this.vecinos = new ListaMU<Nodo<E>>();
            this.visitado = 0;
        }


        public String getId() {
            return id;
        }

        public E getValor() {
            return valor;
        }
        

        public int getVisitado() {
            return visitado;
        }

        public void setVisitado(int v) {
            this.visitado = v;
        }

        public void setVecinos(ListaMU<Nodo<E>> newvecinos) {
            this.vecinos = newvecinos;
        }

        public ListaMU<Nodo<E>> getVecinos() {
            return vecinos;
        }

        public void setVisitaMas1() {
            this.visitado++;
        }

        public void resetVisita() {
            this.visitado = 0;
        }

        private void insertarVecino(Nodo<E> objNodoDestino) {
        	if ( !this.vecinos.contains(objNodoDestino) )
        		this.vecinos.insertar(objNodoDestino);
        }
        
        private void eliminarVecino(Nodo<E> objNodo) {
        	this.vecinos.eliminarContenido(objNodo);
        }
    }
}