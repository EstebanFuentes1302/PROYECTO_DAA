/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.bulenkov.darcula.DarculaLaf;
import controlador.ControladorFrmGestionFestival;
import general.Data;
import general.Sistema;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
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
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        BasicLookAndFeel darcula = new DarculaLaf();
        UIManager.setLookAndFeel(darcula);

        Data lector = new Data();
        lector.leerEquipos();
        lector.leerJugadores();
        FrmGestionFestival vistaGestFestival = new FrmGestionFestival();
        ControladorFrmGestionFestival controladorGestFestival = new ControladorFrmGestionFestival(vistaGestFestival);
        controladorGestFestival.frmIniciar();
    }
    
}
