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
    public Jugador[] jugadores;
    Entrenador entrenador;
    String nombre;
    int cantidadJugadores;
    int MAX=11;
    String[] cabecerajugadores = {"NOMBRE","NRO DE CAMISETA"};

    public String[] getCabecerajugadores() {
        return cabecerajugadores;
    }
    
    
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
    
    public int getCantidadJugadores() {
        return cantidadJugadores;
    }
    
    public String[][] getDatosJugadores(){
        String[][] result = new String[cantidadJugadores][2];
        
        for(int i=0;i<cantidadJugadores;i++){
            result[i][0]=jugadores[i].getNombre();
            result[i][1]=jugadores[i].getNumCamiseta();
        }
        
        return result;
    }
    
    public boolean eliminarJugador(String n){
        for(int i=0;i<cantidadJugadores;i++){
            if(n.equals(jugadores[i].numCamiseta)){
                int k=1;
                while(i+k<cantidadJugadores){
                    
                    jugadores[i+k-1]=jugadores[i+k];
                    k++;
                            
                }
                cantidadJugadores--;
                return true;
            }
        }
        return false;
    }
    
}
