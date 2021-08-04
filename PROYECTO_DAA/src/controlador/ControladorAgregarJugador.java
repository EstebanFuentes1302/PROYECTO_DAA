/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Data;
import general.Sistema;
import static general.Sistema.equipos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Equipo;
import modelo.Jugador;
import vista.FrmAgregarJugador;
import vista.FrmGestEquipos;
import vista.FrmGestJugador;

/**
 *
 * @author Esteban
 */
public class ControladorAgregarJugador {
    FrmAgregarJugador vista = new FrmAgregarJugador();
    
    public ControladorAgregarJugador(FrmAgregarJugador vista){
        this.vista=vista;
        
        this.vista.btnAgregarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())<0 || Sistema.equipos.verificarCamisetaRepetida(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()),Integer.parseInt(vista.txtNroCamisetaJugador.getText()))|| vista.txtDNI.getText().length()!=8){
                    JOptionPane.showMessageDialog(null, "Error al agregar jugador!");
                    
                }else{
                    Sistema.equipos.addJugador(vista.cboEquipo.getSelectedItem().toString(), new Jugador(vista.cboEquipo.getSelectedItem().toString(),vista.txtNombreJugador.getText(),Integer.parseInt(vista.txtNroCamisetaJugador.getText()),vista.txtDNI.getText()));
                    JOptionPane.showMessageDialog(null, "Se agregó jugador");
                    vista.dispose();
                    /*FrmGestJugador vistaJugadores = new FrmGestJugador();
                    ControladorGestJugador controladorJugadores = new ControladorGestJugador(vistaJugadores);
                    controladorJugadores.frmIniciar();*/
                }
                
                
            }
        });
        
        this.vista.cboEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.txtNombreEquipo.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())));
            }
        });
        
        this.vista.btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*FrmGestJugador vistaEliminarJugador = new FrmGestJugador();
                ControladorGestJugador controladorGestJugador = new ControladorGestJugador(vistaEliminarJugador);
                controladorGestJugador.frmIniciar();*/
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
        
    }
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        DefaultComboBoxModel modeloequipo = new DefaultComboBoxModel();
        for(int i=0;i<Sistema.equipos.getCantidadEquipos();i++){
            modeloequipo.addElement(Sistema.equipos.getCodigoEquipo(i));
        }
        vista.cboEquipo.setModel(modeloequipo);
        vista.cboEquipo.setSelectedIndex(0);
        
        
    }

}
