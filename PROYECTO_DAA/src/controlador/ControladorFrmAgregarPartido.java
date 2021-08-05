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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vista.FrmAgregarPartido;
import vista.FrmFestival;

/**
 *
 * @author Esteban
 */
public class ControladorFrmAgregarPartido {
    FrmAgregarPartido vista = new FrmAgregarPartido();
    int verif=0;
    public ControladorFrmAgregarPartido(FrmAgregarPartido vista){
        this.vista = vista;
        
        /*this.vista.cboEquipo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.txtNombreEquipo1.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.cboEquipo1.getSelectedItem().toString())));
                
            }
        });
        
        this.vista.cboEquipo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.txtNombreEquipo2.setText(Sistema.equipos.getNombreEquipo(Sistema.equipos.verificarEquipo(vista.cboEquipo2.getSelectedItem().toString())));
                
            }
        });*/
        
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vista.txtCodigoEquipo1.getText().equalsIgnoreCase(vista.txtCodigoEquipo2.getText())){
                    JOptionPane.showMessageDialog(null, "¡EQUIPOS IGUALES!");
                    
                }else {
                    if(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())>=0&&Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())>=0){
                        if(vista.cboResultado.getSelectedItem().toString().equals("Gana L")){
                            Sistema.equipos.realizarPartido(1, Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())), Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())));
                        }else if(vista.cboResultado.getSelectedItem().toString().equals("Empate")){
                            Sistema.equipos.realizarPartido(2, Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())), Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())));
                        }else if(vista.cboResultado.getSelectedItem().toString().equals("Gana V")){
                            Sistema.equipos.realizarPartido(3, Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())), Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())));
                        }
                            Sistema.equipos.ordenarEquiposPuntos();
                            FrmFestival frmfestival = new FrmFestival();
                            ControladorFrmFestival controladorfrmfestival = new ControladorFrmFestival(frmfestival);
                            controladorfrmfestival.frmIniciar();
                            vista.dispose();
                    }/*else if(){
                        JOptionPane.showMessageDialog(null, "Un equipo no se ha encontrado");
                    }*/
                }
                    
                
            }
        });
        
        this.vista.btnBuscarEquipo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())>=0){
                    vista.txtNombreEquipo1.setText(Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText().trim())).getNombre());
                    JOptionPane.showMessageDialog(null, "Equipo Encontrado");
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró equipo");
                }
            }
        });
        
        this.vista.btnBuscarEquipo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())>=0){
                    vista.txtNombreEquipo2.setText(Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())).getNombre());
                    JOptionPane.showMessageDialog(null, "Equipo Encontrado");
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró equipo");
                }
            }
        });
        this.vista.btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmFestival frmfestival = new FrmFestival();
                ControladorFrmFestival controladorfestival = new ControladorFrmFestival(frmfestival);
                controladorfestival.frmIniciar();
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
        vista.btnAgregar.setEnabled(true);
        /*DefaultComboBoxModel modeloequipo1 = new DefaultComboBoxModel();
        for(int i=0;i<Sistema.equipos.getCantidadEquipos();i++){
            modeloequipo1.addElement(Sistema.equipos.getCodigoEquipo(i));
        }
        
        DefaultComboBoxModel modeloequipo2 = new DefaultComboBoxModel();
        for(int i=0;i<Sistema.equipos.getCantidadEquipos();i++){
            modeloequipo2.addElement(Sistema.equipos.getCodigoEquipo(i));
        }
        
        vista.cboEquipo1.setModel(modeloequipo1);
        vista.cboEquipo2.setModel(modeloequipo2);*/
    }
}
