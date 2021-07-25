/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class Equipo {
    Jugador[] jugadores;
    Entrenador entrenador;
    String nombre;
    int cantidadJugadores;
    int MAX=11;
    
    public Equipo(String nombre, Entrenador entrenador) {
        this.jugadores = new Jugador[11];
        this.jugadores = jugadores;
        this.entrenador = entrenador;
        this.cantidadJugadores=0;
        this.nombre=nombre;
    }
    
    public Equipo(String nombre, Jugador[] jugadores, Entrenador entrenador) {
        this.jugadores = new Jugador[11];
        this.jugadores = jugadores;
        this.entrenador = entrenador;
        this.cantidadJugadores=0;
        this.nombre=nombre;
    }
    
    public void addJugador(Jugador j){
        if(this.cantidadJugadores<MAX){
            jugadores[cantidadJugadores]=j;
            cantidadJugadores++;
        }else{
            JOptionPane.showMessageDialog(null, "Equipo Completo!");
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidadJugadores() {
        return Integer.toString(cantidadJugadores);
    }
    
    
    
}
