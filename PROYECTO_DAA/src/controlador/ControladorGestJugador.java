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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import vista.FrmAgregarJugador;
import vista.FrmBuscarJugador;
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
        
        /*this.vista.cboEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizartbl();
                diseñarTabla();
                vista.txtNombreEquipo.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())));

            }
        });*/

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
                if(vista.txtEliminar.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Ingrese el número de camiseta del jugador a eliminar");
                }else{
                    if(Sistema.equipos.eliminarJugador(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText()), Integer.parseInt(vista.txtEliminar.getText()))){
                        JOptionPane.showMessageDialog(null, "Se eliminó jugador");
                        actualizartbl();
                        diseñarTabla();
                        try {
                            Sistema.datos.guardarDatos();
                        } catch (IOException ex) {
                            Logger.getLogger(ControladorGestJugador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar jugador");
                    }
                }
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
        
        this.vista.btnBuscarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizartbl();
                diseñarTabla();
                vista.txtNombreEquipo.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())));
            }
        });
        
        this.vista.btnBuscarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmBuscarJugador vista2 = new FrmBuscarJugador();
                ControladorFrmBuscarJugador controlador2 = new ControladorFrmBuscarJugador(vista2);
                controlador2.frmIniciar();
            }
        });
        
        this.vista.getRootPane().setDefaultButton(vista.btnEliminarJugador);
        
    }
    
    public void diseñarTabla(){
        TableColumnModel modelo = vista.tblJugadores.getColumnModel();
        modelo.getColumn(0).setPreferredWidth(300);
        modelo.getColumn(1).setPreferredWidth(100);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        vista.tblJugadores.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
    }
    
    public void actualizartbl(){
        DefaultTableModel modelotabla = new DefaultTableModel(Sistema.equipos.getDatosJugadores(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())), Sistema.equipos.getCabeceraJugadores(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())));
        vista.tblJugadores.setModel(modelotabla);
        vista.txtNombreEquipo.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())));

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
