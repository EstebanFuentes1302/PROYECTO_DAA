/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.System;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                if(System.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())<0 || System.equipos.verificarNumCamiseta(Integer.parseInt(vista.txtNroCamisetaJugador.getText()))|| vista.txtDNI.getText().length()!=8){
                    JOptionPane.showMessageDialog(null, "Error al agregar jugador!");
                    
                }else{
                    System.equipos.addJugador(System.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()), new Jugador(vista.txtNombreJugador.getText(),vista.txtNroCamisetaJugador.getText(),vista.txtDNI.getText()));
                    JOptionPane.showMessageDialog(null, "Se agregó jugador");
                    vista.dispose();
                    FrmGestJugador vistaJugadores = new FrmGestJugador();
                    ControladorGestJugador controladorJugadores = new ControladorGestJugador(vistaJugadores);
                    controladorJugadores.frmIniciar();
                }
                
                
            }
        });

    }
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        DefaultComboBoxModel modeloequipo = new DefaultComboBoxModel();
        for(int i=0;i<System.equipos.getCantidadEquipos();i++){
            modeloequipo.addElement(System.equipos.getNombreEquipo(i));
        }
        vista.cboEquipo.setModel(modeloequipo);
        
        

    }
}
