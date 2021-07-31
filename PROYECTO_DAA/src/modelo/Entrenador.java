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
public class Entrenador extends Persona {
    String nombre;
    String dni;
    
    
    public Entrenador(String nombre) {
        this.nombre = nombre;
    }
    
    public Entrenador(String nombre,String dni) {
        this.nombre = nombre;
        this.dni=dni;
    }

    public String getNombre() {
        return nombre;
    }
}
