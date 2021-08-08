/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.*;

/**
 *
 * @author Esteban
 */
public class ControladorFrmGestionFestival {
    FrmGestionFestival vista = new FrmGestionFestival();

    public ControladorFrmGestionFestival(FrmGestionFestival vista) {
        this.vista=vista;
        
        this.vista.btnGestEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestEquipos vistaEquipos = new FrmGestEquipos();
                ControladorFrmGestEquipos controladorEquipos = new ControladorFrmGestEquipos(vistaEquipos);
                controladorEquipos.frmIniciar();
                vista.dispose();
            }
        });
        
        this.vista.btnGestJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestJugador vistaEliminarJugador = new FrmGestJugador();
                ControladorFrmGestJugador controladorGestJugador = new ControladorFrmGestJugador(vistaEliminarJugador);
                controladorGestJugador.frmIniciar();
                vista.dispose();
            }
        });
        
        this.vista.btnGestFestival.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmFestival frmfestival = new FrmFestival();
                ControladorFrmFestival controladorfestival = new ControladorFrmFestival(frmfestival);
                controladorfestival.frmIniciar();
                vista.dispose();
            }
        });
        
        //GUARDAR AL CERRAR
        this.vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Sistema.datos.guardarDatos();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorFrmAgregarJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.btnGestEquipos.setFocusable(true);
        vista.btnGestFestival.setFocusable(true);
        vista.btnGestJugadores.setFocusable(true);
    }
    
}
