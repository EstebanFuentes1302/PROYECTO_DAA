/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import vista.FrmEliminarJugador;

/**
 *
 * @author Esteban
 */
public class ControladorEliminarJugador {
    FrmEliminarJugador vista = new FrmEliminarJugador();

    public ControladorEliminarJugador(FrmEliminarJugador vista) {
        this.vista=vista;
        
        this.vista.btnAnalizarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                DefaultTableModel modelotabla = new DefaultTableModel(sistema.equipos.getDatosJugadores(sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())), sistema.equipos.getCabeceraJugadores(sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())));
                vista.tblJugadores.setModel(modelotabla);
                DefaultComboBoxModel modelojugadores = new DefaultComboBoxModel();                
                
                for(int i=0;i<sistema.equipos.getCantidadJugadores(sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()));i++){
                    modelojugadores.addElement(i+1);
                }
                
            }
        });
    }
    
    
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        DefaultComboBoxModel modeloequipo = new DefaultComboBoxModel();
        for(int i=0;i<sistema.equipos.getCantidadEquipos();i++){
            modeloequipo.addElement(sistema.equipos.getNombreEquipo(i));
        }
        vista.cboEquipo.setModel(modeloequipo);
        
        DefaultComboBoxModel modelojugadores = new DefaultComboBoxModel();
        for(int i=0;i<sistema.equipos.getCantidadJugadores(sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()));i++){
            modelojugadores.addElement(i+1);
        }
        
    }
}
