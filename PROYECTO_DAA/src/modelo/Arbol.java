package modelo;



public class Arbol<T extends Comparable> {
    private Nodo raiz;

    public Arbol(){
    }

    public void insertar(T dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        }else{
            this.insertar(this.raiz, dato);
        }
    }
    
    private void insertar(Nodo padre, T dato) {
        if (dato.compareTo(padre.getDato())>0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } 
            else {
                this.insertar(padre.getDerecha(), dato);
            }
        }else{
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } 
            else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }
    
    public T buscarDato(T dato) {
        return buscarDato(this.raiz, dato);
    }

    private T buscarDato(Nodo n, T dato) {
        if (n == null) {
            return null;
        }
        if ( dato.compareTo(n.getDato())==0) {
            System.out.println("SE ENCONTRÓ EN ARBOL");
            return (T) n.getDato();
        } 
        else{
            if (dato.compareTo(n.getDato())<0) {
                return buscarDato(n.getIzquierda(), dato);
            } 
            else {
                return buscarDato(n.getDerecha(), dato);
            }
        }
    }	 
}
