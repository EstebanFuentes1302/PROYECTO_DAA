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
        
        FrmGestionFestival vistaGestFestival = new FrmGestionFestival();
        ControladorFrmGestionFestival controladorGestFestival = new ControladorFrmGestionFestival(vistaGestFestival);
        controladorGestFestival.frmIniciar();
    }
    
}
