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
public class Jugador extends Persona implements Comparable<Jugador>{
    int numCamiseta;
    String codE; 
    
    public Jugador(String DNI){
        this.DNI=DNI;
    }

    public void setCodE(String codE) {
        this.codE = codE;
    }
    
    public int getNumCamiseta() {
        return numCamiseta;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public Jugador(String codE, String nombre, int numCamiseta, String dni) {
        this.codE=codE;
        this.numCamiseta = numCamiseta;
        this.Nombre = nombre;
        this.DNI=dni;
    }

    public String getCodE() {
        return codE;
    }

    public String getDNI() {
        return DNI;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public int compareTo(Jugador j) {
        if(Integer.parseInt(j.getDNI())>Integer.parseInt(this.DNI)){
            return -1;
        }else if(Integer.parseInt(j.getDNI())<Integer.parseInt(this.DNI)){
            return 1;
        }else{
            return 0;
        }
        
    }

    @Override
    public String toString() {
        return "Nombre:" +super.Nombre +"\tDNI: " +super.DNI+ "\tNúmero de camiseta: " + numCamiseta;
    }
    
    
}
