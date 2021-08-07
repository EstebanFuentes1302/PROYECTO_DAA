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

    
    public Entrenador(String nombre,String dni) {
        this.Nombre = nombre;
        this.DNI=dni;
    }

    public String getDni() {
        return DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
