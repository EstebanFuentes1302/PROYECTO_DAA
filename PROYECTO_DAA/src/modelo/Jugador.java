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
    String numCamiseta;   
    String nombre;

    public String getNumCamiseta() {
        return numCamiseta;
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador(String nombre, String numCamiseta) {
        this.numCamiseta = numCamiseta;
        this.nombre = nombre;
    }
}
