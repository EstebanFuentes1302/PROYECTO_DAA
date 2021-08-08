package modelo;

import java.util.Comparator;

/**
 * Clase para trabajar con arboles binarios de busqueda
 * @author Fuentes Sandoval Esteban Sebastian UNMSM
 * @version 1.00 2021/7/26
 */
public class ArbolBinarioBusqueda<T extends Comparable> {
    private NodoArbol raiz = null;
    private int nElementos = 0;
    public final Comparator prueba;

    /**
     * Inicializa un arbol binario de busqueda.
     * @param c comparador usado para colocar elementos en secuencia.
     */
    public ArbolBinarioBusqueda (Comparator c) {
	prueba = c;
	raiz = null;
	nElementos = 0;
    }


    /**
     * Constructor por omision. Compara enteros.
     */

    /**
     * Determina si el arbol esta vacio.
     * @return boolean -- true en caso de que el arbol este vacio.
     */
    public boolean estaVacio () { 
	return raiz == null; 
    }

   /**
     * Metodo para eliminar todos los elementos de un arbol
     */
    public void vaciar() {
	raiz = null;
    }

    /**
      * Determina el numero de elementos en el arbol
      * @return int -- cantidad de elementos en el arbol
      */
    public int tamanio () { 
	return nElementos; 
    }

    /**
     * Inserta en el arbol, ignora duplicados.
     * @param elemento el dato a insertaar
     */
    public void insertar(T elemento) { 
	raiz = agregar(elemento, raiz); 
    }

    /**
     * Elimina un elemento del arbol, en caso de no encontrarlo no hace nada.
     * @param elemento el dato a eliminar
     */
    public void eliminar(T elemento) {
        raiz = eliminar(elemento, raiz);
    }
    /**
     * Encuentra el menor elemento del arbol.
     * @return el menor elemento en el arbol o nulo si esta vacio.
     */
    public Object encontrarMin() {
	NodoArbol n = encontrarMin(raiz);
	return (n == null) ? null : n.valor;
    }

    /**
     * Encuentra el mayor elemento del arbol.
     * @return el mayor elemento en el arbol o nulo si esta vacio.
     */
    public Object encontrarMax() {
	NodoArbol n = encontrarMax(raiz);
	return (n == null) ? null : n.valor;
    }

    /**
     * Determina si el elemento dato se encuentra en el arbol.
     * @param elemento -- el dato a buscar.
     * @return boolean -- true si el elemento esta en el arbol y false en otro caso
     */
    public T buscarDato(T elemento) { 
        return ArbolBinarioBusqueda.this.Obtener(elemento, raiz);
    }

    /**
     * Metodo interno para obtener el valor de un nodo.
     * @param nodo el nodo raiz del sub-arbol en donde se buscara
     * @return el valor del nodo o null si nodo es null.
     */
    private Object elementoEn(NodoArbol nodo) {
        return nodo == null ? null : nodo.valor;
    }

    /**
     * Metodo interno para insertar en un sub-arbol.
     * @param elemento el dato a insertar.
     * @param nodo la raiz del arbol.
     * @return la nueva raiz.
     */
    private NodoArbol agregar(T elemento, NodoArbol nodo) {
        if(nodo == null) {
          nodo = new NodoArbol(elemento);
          nElementos ++;
        } else if(prueba.compare(elemento ,nodo.valor) < 0)
		nodo.izquierda = agregar(elemento, nodo.izquierda);
	else if(prueba.compare(elemento, nodo.valor) > 0)
		nodo.derecha = agregar(elemento, nodo.derecha);
        else{
            System.out.println("Equipo repetido!");
        }      // Esta duplicado; no hace nada
        return nodo;
    }

    /**
     * Metodo interno para eliminar de un subarbol.
     * @param elemento -- el dato a eliminar.
     * @param nodo -- raiz del arbol.
     * @return NodoArbol -- la nueva raiz.
     */
    private NodoArbol eliminar(T elemento, NodoArbol nodo) {
        if(nodo == null){
            System.out.println("No se encontró equipo");
           return nodo;}   // No se encuentra el elemento; no hace nada
        if(prueba.compare(elemento, nodo.valor) < 0)
           nodo.izquierda = eliminar(elemento, nodo.izquierda);
        else if(prueba.compare(elemento, nodo.valor) > 0)
           nodo.derecha = eliminar(elemento, nodo.derecha);
        else if(nodo.izquierda != null && nodo.derecha != null) {
           nodo.valor = encontrarMin(nodo.derecha).valor;
           nodo.derecha = eliminar(nodo.valor, nodo.derecha);
        } else
           nodo = (nodo.izquierda != null) ? nodo.izquierda : nodo.derecha;
        return nodo;
    }

    /**
     * Metodo interno para encontrar el menor elemento en un subarbol.
     * @param t nodo raiz del arbol.
     * @return NodoArbol - el nodo que buscarDato el elemento menor.
     */
    private NodoArbol encontrarMin(NodoArbol nodo) {
        if(nodo == null)
            return null;
        else if(nodo.izquierda == null)
            return nodo;
        return encontrarMin(nodo.izquierda);
    }
    /**
     * Metodo interno para encontrar el mayor elemento en un subarbol.
     * @param t nodo raiz del arbol.
     * @return NodoArbol - el nodo que buscarDato el elemento mayor.
     */
    private NodoArbol encontrarMax(NodoArbol nodo) {
        if(nodo != null)
            while(nodo.derecha != null)
                nodo = nodo.derecha;
        return nodo;
    }
    /**
     * Metodo interno para encontrar un elemento en un subarbol.
     * @param elemento -- el objeto a buscar.
     * @param nodo -- raiz del arbol.
     * @return boolean -- true si el elemento esta en el arbol y false en otro caso
     */
    private T Obtener(T elemento, NodoArbol nodo) {
        if(nodo == null)
            return null;
        if(prueba.compare (elemento, nodo.valor) < 0)
            return ArbolBinarioBusqueda.this.Obtener(elemento, nodo.izquierda);
        else if(prueba.compare(elemento, nodo.valor) > 0)
            return ArbolBinarioBusqueda.this.Obtener(elemento, nodo.derecha);
        else
            return (T) nodo.valor;    // Lo encontro
    }

    /**
     * Metodo para imprimir un arbol en orden.
     */
    public void imprimirArbol() {
        if(estaVacio())
	    System.out.println("El arbol esta vacio");
	else 
            imprimirArbol(raiz);
    }

    private void imprimirArbol(NodoArbol nodo) {
        if(nodo != null) {
            imprimirArbol(nodo.izquierda);
            System.out.print(nodo.valor+ "\n");
            imprimirArbol(nodo.derecha);
        }
    }

    private NodoArbol eliminar(Object valor, NodoArbol derecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
