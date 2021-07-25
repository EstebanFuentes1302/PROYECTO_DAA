/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorFrmGestionFestival;
import modelo.Entrenador;
import modelo.Equipo;
import general.sistema;
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
        sistema.equipos.addEquipo(new Equipo("Los Fisianos", new Entrenador("Javier Nuñez")));
        sistema.equipos.addEquipo(new Equipo("Los Gozus", new Entrenador("Manuel Gonzales")));
        sistema.equipos.addJugador(0, new Jugador("Manuel Gonzales", "20"));
        sistema.equipos.addJugador(0, new Jugador("Choquote", "10"));
        sistema.equipos.addJugador(0, new Jugador("Esteban Fuentes", "1"));
        
        FrmGestionFestival vistaGestFestival = new FrmGestionFestival();
        ControladorFrmGestionFestival controladorGestFestival = new ControladorFrmGestionFestival(vistaGestFestival);
        controladorGestFestival.frmIniciar();
    }
    
}
