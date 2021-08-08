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
import vista.FrmAgregarPartido;
import vista.FrmFestival;

/**
 *
 * @author Esteban
 */
public class ControladorFrmAgregarPartido {
    FrmAgregarPartido vista = new FrmAgregarPartido();
    private int verif=0;
    private boolean enabled=false;
    
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
                    
                    
                    try {
                        if(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())>=0&&Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())>=0){
                            //Sistema.partidos.agregarPartido(new Partido(Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())), Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())), Integer.parseInt(vista.txtGolesEquipo1.getText()), Integer.parseInt(vista.txtGolesEquipo2.getText())));
                            
                            if(Integer.parseInt(vista.txtGolesEquipo1.getText())>Integer.parseInt(vista.txtGolesEquipo2.getText())){
                                Sistema.equipos.realizarPartido(1, Sistema.equipos.getEquipo(vista.txtCodigoEquipo1.getText()), Sistema.equipos.getEquipo(vista.txtCodigoEquipo2.getText()),Integer.parseInt(vista.txtGolesEquipo1.getText()),Integer.parseInt(vista.txtGolesEquipo2.getText()));
                            }else if(Integer.parseInt(vista.txtGolesEquipo1.getText())<Integer.parseInt(vista.txtGolesEquipo2.getText())){
                                Sistema.equipos.realizarPartido(3, Sistema.equipos.getEquipo(vista.txtCodigoEquipo1.getText()), Sistema.equipos.getEquipo(vista.txtCodigoEquipo2.getText()),Integer.parseInt(vista.txtGolesEquipo1.getText()),Integer.parseInt(vista.txtGolesEquipo2.getText()));
                            }else if(Integer.parseInt(vista.txtGolesEquipo1.getText())==Integer.parseInt(vista.txtGolesEquipo2.getText())){
                                Sistema.equipos.realizarPartido(2, Sistema.equipos.getEquipo(vista.txtCodigoEquipo1.getText()), Sistema.equipos.getEquipo(vista.txtCodigoEquipo2.getText()),Integer.parseInt(vista.txtGolesEquipo1.getText()),Integer.parseInt(vista.txtGolesEquipo2.getText()));
                            }
                            
                            FrmFestival frmfestival = new FrmFestival();
                            ControladorFrmFestival controladorfrmfestival = new ControladorFrmFestival(frmfestival);
                            controladorfrmfestival.frmIniciar();
                            vista.dispose();
                        }
                        
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Resultado Inválido!");
                    }
                    

                    //Sistema.equipos.getEquiposOrdenados();
                    

                }
                    
                
            }
        });
        
        
        
        this.vista.btnBuscarEquipo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())>=0){
                    vista.txtNombreEquipo1.setText(Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText().trim())).getNombre());
                    JOptionPane.showMessageDialog(null, "Equipo Encontrado");
                    verificar();
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
                    verificar();
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
    
    private void verificar(){
        if(Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo1.getText())>=0&&Sistema.equipos.verificarEquipo(vista.txtCodigoEquipo2.getText())>=0){
            vista.btnAgregar.setEnabled(true);
            vista.txtGolesEquipo1.setEnabled(true);
            vista.txtGolesEquipo2.setEnabled(true);
        }else{
            vista.btnAgregar.setEnabled(false);
            vista.txtGolesEquipo1.setEnabled(false);
            vista.txtGolesEquipo2.setEnabled(false);
        }
    }
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.btnAgregar.setEnabled(false);
        vista.txtGolesEquipo1.setEnabled(false);
        vista.txtGolesEquipo2.setEnabled(false);
    }
}
