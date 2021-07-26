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
import javax.swing.table.DefaultTableModel;
import vista.FrmAgregarJugador;
import vista.FrmGestJugador;
import vista.FrmGestionFestival;

/**
 *
 * @author Esteban
 */
public class ControladorGestJugador {
    FrmGestJugador vista = new FrmGestJugador();

    public ControladorGestJugador(FrmGestJugador vista) {
        this.vista=vista;
        
        this.vista.btnAnalizarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                DefaultTableModel modelotabla = new DefaultTableModel(System.equipos.getDatosJugadores(System.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())), System.equipos.getCabeceraJugadores(System.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())));
                vista.tblJugadores.setModel(modelotabla);
                vista.txtNombreEquipo.setText(System.equipos.getNombreEquipo(System.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())));
                /*DefaultComboBoxModel modelojugadores = new DefaultComboBoxModel();                
                
                for(int i=0;i<Sistema.equipos.getCantidadJugadores(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()));i++){
                    int num=i+1;
                    modelojugadores.addElement(num);
                }*/
                
            }
        });
        this.vista.btnAgregarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAgregarJugador vistaAgregarJugador = new FrmAgregarJugador();
                ControladorAgregarJugador controladorAgregarJugador = new ControladorAgregarJugador(vistaAgregarJugador);
                
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
                if(System.equipos.eliminarJugador(System.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()), vista.txtEliminar.getText())){
                    JOptionPane.showMessageDialog(null, "Se eliminó jugador");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo agregar jugador");
                }
            }
        });
    }
    
    
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        DefaultComboBoxModel modeloequipo = new DefaultComboBoxModel();
        for(int i=0;i<System.equipos.getCantidadEquipos();i++){
            modeloequipo.addElement(System.equipos.getCodigoEquipo(i));
        }
        vista.cboEquipo.setModel(modeloequipo);
        
        /*DefaultComboBoxModel modelojugadores = new DefaultComboBoxModel();
        for(int i=0;i<Sistema.equipos.getCantidadJugadores(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()));i++){
            modelojugadores.addElement(i+1);
        }*/
        
    }
}
