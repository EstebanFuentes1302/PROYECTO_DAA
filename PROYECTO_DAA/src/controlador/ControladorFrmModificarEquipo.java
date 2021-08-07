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
import modelo.Entrenador;
import modelo.Equipo;
import vista.FrmGestEquipos;
import vista.FrmModificarEquipo;

/**
 *
 * @author Esteban
 */
public class ControladorFrmModificarEquipo {
    FrmModificarEquipo vista = new FrmModificarEquipo();
    Equipo eq;
    
    public ControladorFrmModificarEquipo(FrmModificarEquipo vista){
        this.vista=vista;
        
        this.vista.btnoModificarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vista.btnoModificarDatos.isSelected()){
                    vista.txtCodigoEquipoMod.setEnabled(true);
                    vista.txtDNIEntrenador.setEnabled(true);
                    vista.txtNombreEntrenador.setEnabled(true);
                    vista.txtNombreEquipo.setEnabled(true);
                }else{
                    vista.btnoModificarDatos.setSelected(false);
                    vista.txtCodigoEquipoMod.setEnabled(false);
                    vista.txtDNIEntrenador.setEnabled(false);
                    vista.txtNombreEntrenador.setEnabled(false);
                    vista.txtNombreEquipo.setEnabled(false);
                }
            }
        });
        
        this.vista.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eq =Sistema.ablEquipo.buscarDato(new Equipo(vista.txtCodigoEquipo.getText()));
                if(vista.txtCodigoEquipo.getText()==""){
                    JOptionPane.showMessageDialog(null, "Faltan rellenar campos");
                }else{
                    if(eq==null){
                    JOptionPane.showMessageDialog(null, "No se encontró equipo");
                    }else{
                        JOptionPane.showMessageDialog(null, "El Equipo se encuentra registrado!");
                        vista.btnoModificarDatos.setEnabled(true);
                        vista.txtCodigoEquipo.setText(eq.getCodigo());
                        vista.txtNombreEquipo.setText(eq.getNombre());
                        vista.txtNombreEntrenador.setText(eq.getEntrenador().getNombre());
                        vista.txtDNIEntrenador.setText(eq.getEntrenador().getDni());
                        vista.txtCodigoEquipoMod.setText(eq.getCodigo());
                    }
                }
                
            }
        });
                
        
        this.vista.btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                boolean cambiosN=false,cambiosC=false,cambiosNE=false,cambiosDNIE=false,correcto=true;
                
                if(vista.txtCodigoEquipoMod.getText().trim().equals("")||vista.txtNombreEntrenador.getText().trim().equals("")||!Sistema.esNumero(vista.txtDNIEntrenador.getText())||vista.txtNombreEquipo.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Campos incorrectos!");
                }else{
                    if(vista.txtCodigoEquipoMod.getText().matches("[A-Za-z0-9]+")&&vista.txtNombreEquipo.getText().matches("[ A-Za-z0-9]+")&&vista.txtNombreEntrenador.getText().matches("[ A-Za-z0-9]+")){
                        if(eq.getCodigo().equals(vista.txtCodigoEquipoMod.getText())){
                            System.out.println("No cambio en codigo...");
                        }else if(Sistema.equipos.equipoRepetido(vista.txtCodigoEquipoMod.getText())){
                            JOptionPane.showMessageDialog(null, "Código de equipo repetido!");
                            correcto=false;
                        }
                        else{
                            cambiosC=true;
                        }

                        if(eq.getNombre().equals(vista.txtNombreEquipo.getText())){
                            System.out.println("No cambio en nombre...");
                        }else{
                            eq.setNombre(vista.txtNombreEquipo.getText());
                            cambiosN=true;
                        }

                        if(eq.getEntrenador().getNombre().equals(vista.txtNombreEntrenador.getText())){
                            System.out.println("No cambio en Nombre de entrenador...");
                        }else{
                            eq.setEntrenador(new Entrenador(vista.txtNombreEntrenador.getText(), vista.txtDNIEntrenador.getText()));
                            cambiosNE=true;
                        }

                        if(eq.getEntrenador().getDni().equals(vista.txtDNIEntrenador.getText())){
                            System.out.println("No cambio en DNI de entrenador...");
                        }else{
                            cambiosDNIE=true;
                        }
                        
                        if(correcto){
                            if(!cambiosC&&!cambiosDNIE&&cambiosN&&!cambiosNE){
                                JOptionPane.showMessageDialog(null, "No se han realizado cambios!");
                            }else{
                                if(cambiosN){
                                    eq.setNombre(vista.txtNombreEquipo.getText());
                                }
                                if(cambiosC){
                                    eq.setCodigo(vista.txtCodigoEquipoMod.getText());
                                }
                                if(cambiosDNIE){
                                    eq.getEntrenador().setDNI(vista.txtDNIEntrenador.getText());
                                }
                                if(cambiosNE){
                                    eq.getEntrenador().setNombre(vista.txtNombreEntrenador.getText());
                                }
                                JOptionPane.showMessageDialog(null, "Se modificó el equipo!");
                            }    
                        }
                            
                        
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Campos incorrectos!");
                    }
                }
                    
                
                
            }
        });
        
        vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestEquipos vista2 = new FrmGestEquipos();
                ControladorFrmGestEquipos controlador2 = new ControladorFrmGestEquipos(vista2);
                controlador2.frmIniciar();
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
        
        vista.btnoModificarDatos.setEnabled(false);
        vista.txtCodigoEquipoMod.setEnabled(false);
        vista.txtDNIEntrenador.setEnabled(false);
        vista.txtNombreEntrenador.setEnabled(false);
        vista.txtNombreEquipo.setEnabled(false);
    }

}

