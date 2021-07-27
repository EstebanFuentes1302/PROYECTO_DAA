/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Sistema;
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
        
        this.vista.cboEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelotabla = new DefaultTableModel(Sistema.equipos.getDatosJugadores(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())), Sistema.equipos.getCabeceraJugadores(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())));
                vista.tblJugadores.setModel(modelotabla);
                vista.txtNombreEquipo.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())));
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
                if(Sistema.equipos.eliminarJugador(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()), Integer.parseInt(vista.txtEliminar.getText()))){
                    JOptionPane.showMessageDialog(null, "Se eliminó jugador");
                    actualizartbl();
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar jugador");
                }
            }
        });
    }
    
    public void actualizartbl(){
        DefaultTableModel modelotabla = new DefaultTableModel(Sistema.equipos.getDatosJugadores(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())), Sistema.equipos.getCabeceraJugadores(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())));
                vista.tblJugadores.setModel(modelotabla);
                vista.txtNombreEquipo.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString())));
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
        /*DefaultComboBoxModel modelojugadores = new DefaultComboBoxModel();
        for(int i=0;i<Sistema.equipos.getCantidadJugadores(Sistema.equipos.verificarEquipo(vista.cboEquipo.getSelectedItem().toString()));i++){
            modelojugadores.addElement(i+1);
        }*/
        
    }
}
