/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorFrmGestionFestival;
import modelo.Entrenador;
import modelo.Equipo;
import general.Sistema;
import modelo.Jugador;
import vista.FrmGestionFestival;

/**
 *
 * @author Esteban
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema.equipos.addEquipo(new Equipo("01","Los Fisianos", new Entrenador("Javier Nuñez")));
        Sistema.equipos.addEquipo(new Equipo("02","Los Gozus", new Entrenador("Manuel Gonzales")));
        Sistema.equipos.addJugador(0, new Jugador("Manuel Gonzales", "20","48576849"));
        Sistema.equipos.addJugador(0, new Jugador("Choquote", "10","42849586"));
        Sistema.equipos.addJugador(0, new Jugador("Esteban Fuentes", "1","47485735"));
        
        FrmGestionFestival vistaGestFestival = new FrmGestionFestival();
        ControladorFrmGestionFestival controladorGestFestival = new ControladorFrmGestionFestival(vistaGestFestival);
        controladorGestFestival.frmIniciar();
    }
    
}
