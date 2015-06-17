package fiuba.algo3.algocraft.modelo;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
    	
    	List<Nodo<E>> vecinos = nodoAEliminar.getVecinos();
    	Iterator<Nodo<E>> it = vecinos.iterator();
    	while (it.hasNext()){
    		it.next().eliminarVecino(nodoAEliminar);
    	}
    }

    private String getNodoDistanciaMasCortaEnAnalizados(List<String> analizados, 
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

    private List<E> formarRespuesta(Hashtable<String, String> anterior, 
    															String destino) {
    	List<E> resultado = new LinkedList<E>();

    	Nodo<E> recorre = nodos.get(destino);
    	resultado.add(recorre.getValor());

    	while (true) {
    		String idAnterior = anterior.get(recorre.getId());
    		if (idAnterior == null)
    				break;
    		recorre = nodos.get(idAnterior);
    		resultado.add(0,recorre.getValor());
    	}

    	return resultado;
    }

    private void inicializarParaDijkstra(String origen, 
                                         List<String> analizados, 
                                         Hashtable<String, Integer> distancias) {
    	
        Iterator<Nodo<E>> i = this.nodos.values().iterator();
        while (i.hasNext()) {
            Nodo<E> objNodo = i.next();
            distancias.put(objNodo.getId(), new Integer(Integer.MAX_VALUE));
            analizados.add(objNodo.getId());
        }
        // coloca la distancia del origen a 0
        distancias.put(origen, new Integer(0));
    }
    
    public List<E> getCaminoMinimo(String origen, String destino) {
        if (origen == null || 
        		destino == null) {
            return null;
        }
        
        // Coloca las distancias de todos los nodos a infinito
        // Se aqrma una cadena analizados con todos los nodos
        List<String> analizados = new LinkedList<String>();
        Hashtable<String, Integer> distancias = new Hashtable<String, Integer>();
        Hashtable<String, String> anterior = new Hashtable<String, String>();

        inicializarParaDijkstra(origen, analizados, distancias);

        // comienza la iteracion
        while (analizados.size() > 0) {
            String idNodo = 
                getNodoDistanciaMasCortaEnAnalizados(analizados, distancias);
            // Lo quita de la lista de analizados
            analizados.remove(idNodo);
            try {
            if (idNodo.equals(destino)) {
                return formarRespuesta(anterior, destino);
            	}
            } catch( NullPointerException e){
            	//throw new ErrorNoExisteCaminoPosible();
            	return null;
            }
            

            Iterator<Nodo<E>> i = nodos.get(idNodo).getVecinos().iterator();
            while (i.hasNext()) {
                Nodo<E> objNodo = i.next();
                // Solamente los que estan en analizados
                if (!analizados.contains(objNodo.getId())) {
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

	public void imprimirCamino(List<Posicion> lista){
    	Iterator<Posicion> it = lista.iterator();
    	while (it.hasNext()) {
    		System.out.println(it.next());
    	}
    	System.out.println("-----------------------");
    }

	
    /* 
     * Solo para uso interno del Grafo
     */
    private static class Nodo<E> {
        private String id;
        private E valor;
        private List<Nodo<E>> vecinos;

        public Nodo(String identificador, E v) {
            this.id = identificador;
            this.valor = v;
            this.vecinos = new LinkedList<Nodo<E>>();
        }


        public String getId() {
            return id;
        }

        public E getValor() {
            return valor;
        }

        public List<Nodo<E>> getVecinos() {
            return vecinos;
        }

        private void insertarVecino(Nodo<E> objNodoDestino) {
        	if ( !this.vecinos.contains(objNodoDestino) )
        		this.vecinos.add(objNodoDestino);
        }
        
        private void eliminarVecino(Nodo<E> objNodo) {
        	this.vecinos.remove(objNodo);
        }
    }
}