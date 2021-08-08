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
import vista.FrmEliminarJugador;
import vista.FrmGestJugador;

/**
 *
 * @author Esteban
 */
public class ControladorFrmEliminarJugador {
    private FrmEliminarJugador vista = new FrmEliminarJugador();
    
    public ControladorFrmEliminarJugador(FrmEliminarJugador vista){
        this.vista=vista;
        this.vista.btnEliminarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vista.txtEliminar.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Ingrese el número de camiseta del jugador a eliminar");
                }else{
                    if(Sistema.equipos.eliminarJugador(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText()), vista.txtEliminar.getText())){
                        JOptionPane.showMessageDialog(null, "Se eliminó jugador");
                        actualizartbl();
                        diseñarTabla();
                        try {
                            Sistema.datos.guardarDatos();
                        } catch (IOException ex) {
                            Logger.getLogger(ControladorFrmGestJugador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar jugador");
                    }
                }
            }
        });
        
        this.vista.btnBuscarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())>=0){
                    activar();
                    JOptionPane.showMessageDialog(null, "El Equipo se encuentra registrado!");
                }else{
                    desactivar();
                    JOptionPane.showMessageDialog(null, "El Equipo no se encuentra registrado!");
                }
                
            }
        });
        this.vista.btnRegresar.addActionListener(new ActionListener() {
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
    
    private void desactivar(){
        vista.txtNombreEquipo.setText("");
        vista.btnEliminarJugador.setEnabled(false);
        vista.txtEliminar.setEnabled(false);
        vista.lblNombreEquipo.setEnabled(false);
        vista.lblJugadoresDelEquipo.setEnabled(false);
        vista.lblEliminarJugador.setEnabled(false);
        limpiarTabla();
    }
    
    public void limpiarTabla(){
        vista.tblJugadores.setModel(new DefaultTableModel(Sistema.equipos.getCabecerajugadores(), 0));
    }
    
    public void actualizartbl(){
        DefaultTableModel modelotabla = new DefaultTableModel(Sistema.equipos.getDatosJugadores(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())), Sistema.equipos.getCabecerajugadores());
        vista.tblJugadores.setModel(modelotabla);
    }
    
    public void diseñarTabla(){
        TableColumnModel modelo = vista.tblJugadores.getColumnModel();
        modelo.getColumn(0).setPreferredWidth(80);
        modelo.getColumn(1).setPreferredWidth(300);
        modelo.getColumn(2).setPreferredWidth(80);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        vista.tblJugadores.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        vista.tblJugadores.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        vista.tblJugadores.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    }
    
    private void activar(){
        vista.txtNombreEquipo.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo.getText())));
        vista.btnEliminarJugador.setEnabled(true);
        vista.txtEliminar.setEnabled(true);
        vista.lblNombreEquipo.setEnabled(true);
        vista.lblJugadoresDelEquipo.setEnabled(true);
        vista.lblEliminarJugador.setEnabled(true);
        actualizartbl();
        diseñarTabla();
    }
    
    
    public void frmIniciar(){
        limpiarTabla();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        vista.txtEliminar.setEnabled(false);
        vista.lblNombreEquipo.setEnabled(false);
        vista.lblJugadoresDelEquipo.setEnabled(false);
    }
    
}
