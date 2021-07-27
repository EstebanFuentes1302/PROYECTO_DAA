/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Esteban
 */
public class Jugador extends Persona{
    int numCamiseta;

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public Jugador(String nombre, int numCamiseta, String dni) {
        this.numCamiseta = numCamiseta;
        this.Nombre = nombre;
        this.DNI=dni;
    }

    public String getDNI() {
        return DNI;
    }
    
    
}
