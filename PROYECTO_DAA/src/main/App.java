/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorFrmGestionFestival;
import general.Data;
import general.Sistema;
import java.io.IOException;
import vista.FrmGestionFestival;

/**
 *
 * @author Esteban
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        //Sistema.instanciarFestival();
        
        Data lector = new Data();
        lector.leerEquipos();
        lector.leerJugadores();
        //Sistema.InsertarArbol();
        FrmGestionFestival vistaGestFestival = new FrmGestionFestival();
        ControladorFrmGestionFestival controladorGestFestival = new ControladorFrmGestionFestival(vistaGestFestival);
        controladorGestFestival.frmIniciar();
    }
    
}
