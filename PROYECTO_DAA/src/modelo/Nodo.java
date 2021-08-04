package modelo;


  
public class Nodo<T extends Comparable>{
	private T dato;
	private Nodo izquierda, derecha;
	
	public Nodo() {
	}
	public Nodo(T dato) {
		this.dato = dato;
		this.izquierda = this.derecha = null;
	}
		
	public T getDato() {
		return dato;
	}
	
	public Nodo getIzquierda() {
		return izquierda;
	}
	
	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}
	
	public Nodo getDerecha() {
		return derecha;
	}
	
	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
	
	public void imprimirDato() {
		System.out.println(this.getDato());
	}
	
        @Override
	public String toString(){
            return(dato.toString());
	}
}