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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import vista.FrmAgregarJugador;
import vista.FrmEliminarJugador;
import vista.FrmModificarJugador;
import vista.FrmGestJugador;
import vista.FrmGestionFestival;

/**
 *
 * @author Esteban
 */
public class ControladorFrmGestJugador {
    FrmGestJugador vista = new FrmGestJugador();

    public ControladorFrmGestJugador(FrmGestJugador vista) {
        this.vista=vista;

        this.vista.btnAgregarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAgregarJugador vistaAgregarJugador = new FrmAgregarJugador();
                ControladorFrmAgregarJugador controladorAgregarJugador = new ControladorFrmAgregarJugador(vistaAgregarJugador);
                
                controladorAgregarJugador.frmIniciar();
                vista.dispose();
            }
        });

        this.vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestionFestival vistaGestFestival = new FrmGestionFestival();
                ControladorFrmGestionFestival controladorFrmGestFestival = new ControladorFrmGestionFestival(vistaGestFestival);
                controladorFrmGestFestival.frmIniciar();
                vista.dispose();
            }
        });
        
        this.vista.btnEliminarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEliminarJugador vistaElim = new FrmEliminarJugador();
                ControladorFrmEliminarJugador controladorElim = new ControladorFrmEliminarJugador(vistaElim);
                controladorElim.frmIniciar();
                vista.dispose();
            }
        });
        
        
        this.vista.btnModificarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarJugador vista2 = new FrmModificarJugador();
                ControladorFrmModificarJugador controlador2 = new ControladorFrmModificarJugador(vista2);
                controlador2.frmIniciar();
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
        
        /*DefaultComboBoxModel modeloequipo = new DefaultComboBoxModel();
        for(int i=0;i<Sistema.equipos.getCantidadEquipos();i++){
            modeloequipo.addElement(Sistema.equipos.getCodigoEquipo(i));
        }

        
        vista.cboEquipo.setModel(modeloequipo);*/
        
    }
}
