package modelo;



 /**
 * @(#)NodoArbol.java
 *		Clase para manejar los nodos de arboles
 * @Descripcion: M�todo principal para poder manejar el arbol binario de b�squeda.
 * @author Fuentes Sandoval Esteban Sebastian UNMSM
 * @version 1.00 2021/7/26
 *	@since
 */

public class NodoArbol {
  public Object valor;           
  public NodoArbol izquierda;
  public NodoArbol derecha;

  /*
   * Constructor por omision. Inicializa con null el nodo creado.
   */
  public NodoArbol () {
      this (null, null, null);
  }

  /**
   * Constructor que inicializa el nodo con el valor dado como parametro
   * @param valor --  valor del nodo
   */
  public NodoArbol (Object valor) { 
      this (null, valor, null);
  }

  /**
   * Constructor que inicializa el nodo con los valores dados como parametros
   * @param v -- valor  del nodo
   * @param iz -- liga al hijo izquierdo
   * @param der -- liga al hijo derecho
   */
  public NodoArbol (NodoArbol iz, Object v, NodoArbol der) {
    valor = v;
    izquierda = iz;
    derecha = der;
  }

}
