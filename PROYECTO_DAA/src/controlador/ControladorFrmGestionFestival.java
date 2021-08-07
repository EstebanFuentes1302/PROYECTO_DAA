/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Data;
import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
                ControladorGestJugador controladorGestJugador = new ControladorGestJugador(vistaEliminarJugador);
                controladorGestJugador.frmIniciar();
                vista.dispose();
            }
        });
        
        this.vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Sistema.datos.guardarDatos();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorAgregarJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        /*this.vista.btnDataBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filtro= new FileNameExtensionFilter("*.CSV","csv");
                
                fc.setFileFilter(filtro);
                fc.setMultiSelectionEnabled(true);
                
                int selection = fc.showOpenDialog(vista);
                
                
                if (selection==JFileChooser.APPROVE_OPTION){
                    File[] ficheros = fc.getSelectedFiles();
                    Data lector= new Data();
                    
                    try {
                        //lector.leerEquipos(ficheros[0].getAbsolutePath());
                        lector.leerJugadores(ficheros[1].getAbsolutePath());
                        //Sistema.instanciarFestival();
                    } catch (IOException ex) {
                        Logger.getLogger(ControladorFrmGestionFestival.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
                
            }
        });*/
        
        this.vista.btnGestFestival.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmFestival frmfestival = new FrmFestival();
                ControladorFrmFestival controladorfestival = new ControladorFrmFestival(frmfestival);
                controladorfestival.frmIniciar();
                vista.dispose();
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
