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
import javax.swing.JOptionPane;
import modelo.Jugador;
import vista.FrmAgregarJugador;
import vista.FrmGestJugador;

/**
 *
 * @author Esteban
 */
public class ControladorFrmAgregarJugador {
    FrmAgregarJugador vista = new FrmAgregarJugador();
    
    public ControladorFrmAgregarJugador(FrmAgregarJugador vista){
        this.vista=vista;
        
        this.vista.btnAgregarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vista.txtDNI.getText().trim().equalsIgnoreCase("")||vista.txtNombreEquipo.getText().trim().equalsIgnoreCase("")||vista.txtNombreJugador.getText().trim().equalsIgnoreCase("")||vista.txtNroCamisetaJugador.getText().trim().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null, "Faltan Rellenar campos");
                }else{
                    if(Sistema.equipos.addJugador(vista.txtCodigoEquipo.getText(), new Jugador(vista.txtCodigoEquipo.getText(),vista.txtNombreJugador.getText(),Integer.parseInt(vista.txtNroCamisetaJugador.getText()),vista.txtDNI.getText()))){
                        JOptionPane.showMessageDialog(null, "Se agregó jugador");
                        vista.dispose();
                        FrmGestJugador vistaJugadores = new FrmGestJugador();
                        ControladorFrmGestJugador controladorJugadores = new ControladorFrmGestJugador(vistaJugadores);
                        controladorJugadores.frmIniciar();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo agregar jugador");
                    }
                }
                
                
                
            }
        });
        
        this.vista.btnBuscarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.txtNombreEquipo.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())));
            }
        });

        this.vista.btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestJugador vistaEliminarJugador = new FrmGestJugador();
                ControladorFrmGestJugador controladorGestJugador = new ControladorFrmGestJugador(vistaEliminarJugador);
                controladorGestJugador.frmIniciar();
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
        vista.cboEquipo.setModel(modeloequipo);
        vista.cboEquipo.setSelectedIndex(0);*/ 
        
        
    }

}
