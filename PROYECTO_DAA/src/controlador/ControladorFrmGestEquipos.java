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
import modelo.*;
import vista.FrmAgregarEquipo;
import vista.FrmGestEquipos;
import vista.FrmGestionFestival;
import vista.FrmModificarEquipo;

/**
 *
 * @author Esteban
 */
public class ControladorFrmGestEquipos {
    private FrmGestEquipos vista = new FrmGestEquipos();
    
    public ControladorFrmGestEquipos(FrmGestEquipos vista) {
        this.vista=vista;
        
        /*this.vista.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });*/
        
        this.vista.btnAgregarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
                FrmAgregarEquipo vistaAgregar = new FrmAgregarEquipo();
                ControladorFrmAgregarEquipo controladorAgregar = new ControladorFrmAgregarEquipo(vistaAgregar);
                vista.dispose();
                controladorAgregar.frmIniciar();
                
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
        
        this.vista.btnModificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarEquipo vista2 = new FrmModificarEquipo();
                ControladorFrmModificarEquipo controlador2 = new ControladorFrmModificarEquipo(vista2);
                controlador2.frmIniciar();
                vista.dispose();
            }
        });
        
        this.vista.btnEliminarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo=JOptionPane.showInputDialog("Ingrese código de equipo a eliminar: ");
                
                
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
    
    public void diseñarTabla(){
        TableColumnModel modelo = vista.tblEquipos.getColumnModel();
        modelo.getColumn(0).setPreferredWidth(80);
        modelo.getColumn(1).setPreferredWidth(80);
        modelo.getColumn(2).setPreferredWidth(300);
        modelo.getColumn(3).setPreferredWidth(130);
        modelo.getColumn(4).setPreferredWidth(180);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer izquierda = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        izquierda.setHorizontalAlignment(JLabel.LEADING);
        vista.tblEquipos.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        vista.tblEquipos.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );

    }
    
    
    private void actualizar(){
        DefaultTableModel modelotabla = new DefaultTableModel(Sistema.equipos.getDatosEquipos(), Sistema.equipos.getCabecera());
        vista.tblEquipos.setModel(modelotabla);
    }
    
    public void frmIniciar(){
        actualizar();
        diseñarTabla();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
