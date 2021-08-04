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
import vista.FrmAgregarPartido;
import vista.FrmFestival;
import vista.FrmGestionFestival;

/**
 *
 * @author Esteban
 */
public class ControladorFrmFestival {
    FrmFestival vista = new FrmFestival();
    
    public ControladorFrmFestival(FrmFestival vista){
        this.vista=vista;
        
        this.vista.btnAgregarPartido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                FrmAgregarPartido frmagrregarp = new FrmAgregarPartido();
                ControladorFrmAgregarPartido controladorfrmagregarp = new ControladorFrmAgregarPartido(frmagrregarp);
                controladorfrmagregarp.frmIniciar();
                
                vista.dispose();
                
            }
        });
        
        this.vista.btnRegresar.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestionFestival vistaGestFestival = new FrmGestionFestival();
                ControladorFrmGestionFestival controladorFrmGestFestival = new ControladorFrmGestionFestival(vistaGestFestival);
                controladorFrmGestFestival.frmIniciar();
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
    
    public void diseñarTabla(){
        TableColumnModel modelo = vista.tblFestival.getColumnModel();
        modelo.getColumn(0).setPreferredWidth(100);
        modelo.getColumn(1).setPreferredWidth(100);
        modelo.getColumn(2).setPreferredWidth(400);
        modelo.getColumn(3).setPreferredWidth(100);
        modelo.getColumn(4).setPreferredWidth(100);
        modelo.getColumn(5).setPreferredWidth(100);
        modelo.getColumn(6).setPreferredWidth(100);
        modelo.getColumn(7).setPreferredWidth(100);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        vista.tblFestival.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
    }
    public void frmIniciar(){
        
        DefaultTableModel modelotabla = new DefaultTableModel(Sistema.equipos.getDatosEquiposTorneo(), Sistema.equipos.getCabeceraFest());
        vista.tblFestival.setModel(modelotabla);
        diseñarTabla();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
