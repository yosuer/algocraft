package fiuba.algo3.algocraft.modelo;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

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
    	nodoAEliminar.setVecinos(new ListaMU<Nodo<E>>());
    }

    public int caminoMasCorto(String de, String a) {
        // inicializamos las visitas a 0
        inicializarVisitadoa0();

        // creamos la cola y colocamos el nodo DE
        ListaMU<Nodo<E>> tocaVisitar = new ListaMU<Nodo<E>>();
        boolean encontro = false;

        Nodo<E> nodoDe = nodos.get(de);
        nodoDe.setVisitaMas1();
        tocaVisitar.push(nodoDe);

        Nodo<E> nodoA = nodos.get(a);

        // Mientras la Pila no este vacia o no hayamos encontrado a A
        while (!tocaVisitar.estaVacia() && !encontro) {
            Nodo<E> objNodo = tocaVisitar.pop();
            encontro = visitarNodo(objNodo, tocaVisitar, nodoA);
        }
        return nodoA.getVisitado() - 1;
    }

    private void inicializarVisitadoa0() {
        Iterator<Nodo<E>> i = nodos.values().iterator();
        while (i.hasNext()) {
            i.next().resetVisita();
        }
    }

    private boolean visitarNodo(Nodo<E> objVisitado, ListaMU<Nodo<E>> tocaVisitar, 
                                Nodo<E> objDestino) {
        Iterator<Nodo<E>> vecinosVisitado = 
            objVisitado.getVecinos().iterator();
        while (vecinosVisitado.hasNext()) {
            Nodo<E> vecino = vecinosVisitado.next();

            // Si es el que estamos buscando devuelve true y le coloca el numero
            // de visitado que corresponda.
            if (vecino == objDestino) {
                vecino.setVisitado(objVisitado.getVisitado() + 1);
                return true;
            }

            // Solamente lo coloca si no esta en la cola (si no ha sido visitado)
            if (vecino.getVisitado() == 0)
                tocaVisitar.push(vecino);

            // Coloca el visitado de acuerdo a lo que corresponde
            vecino.setVisitado(objVisitado.getVisitado() + 1);
        }
        // Si no lo encuentra entre los vecinos de este nodo
        return false;
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

        boolean encontro = false;

        // coloca la distancia del origen a 0
        distancias.put(origen, new Integer(0));
    }

    public ListaMU<Nodo<E>> caminoMasCortoDijkstra(String origen, String destino) {
        if (nodos.get(origen) == null || 
        		nodos.get(destino) == null) {
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

            if (idNodo.equals(destino)) {
                ListaMU<Nodo<E>> resultado = formarRespuesta(anterior, destino);
                return resultado;
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
    public static class Nodo<E> {
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
        	if ( !this.vecinos.existe(objNodoDestino) )
        		this.vecinos.insertar(objNodoDestino);
        }
    }
}