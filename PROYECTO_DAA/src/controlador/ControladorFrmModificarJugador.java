/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.xml.internal.ws.util.StringUtils;
import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Equipo;
import modelo.Jugador;
import vista.FrmGestJugador;
import vista.FrmModificarJugador;

/**
 *
 * @author Esteban
 */
public class ControladorFrmModificarJugador {
    FrmModificarJugador vista = new FrmModificarJugador();
    Jugador j=null;
    Equipo eq=null;
    public ControladorFrmModificarJugador(FrmModificarJugador vista){
        this.vista=vista;
        
        this.vista.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    j = Sistema.ablJugador.buscarDato(new Jugador(vista.txtDNIBuscar.getText()));}
                    
                catch(Exception ex){
                    
                }
                if(j==null){
                    JOptionPane.showMessageDialog(null, "No se encontró el jugador");
                }else{
                    eq = Sistema.ablEquipo.buscarDato(new Equipo(j.getCodE()));
                    JOptionPane.showMessageDialog(null, "El jugador se encuentra registrado");
                    vista.txtNombre.setText(j.getNombre());
                    
                    vista.txtNumCamiseta.setText(Integer.toString(j.getNumCamiseta()));
                    vista.btnoModificarDatos.setEnabled(true);
                    vista.txtCodigoEquipo.setText(eq.getCodigo());
                    vista.txtNombreEquipo.setText(eq.getNombre());
                }
                
            }
        });
        
        this.vista.btnoModificarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vista.btnoModificarDatos.isSelected()){
                    vista.txtNombre.setEnabled(true);
                    vista.txtNumCamiseta.setEnabled(true);
                }else{
                    vista.txtNombre.setEnabled(false);
                    vista.txtNumCamiseta.setEnabled(false);
                }
                
            }
        });
        
        this.vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestJugador vistaEliminarJugador = new FrmGestJugador();
                ControladorGestJugador controladorGestJugador = new ControladorGestJugador(vistaEliminarJugador);
                controladorGestJugador.frmIniciar();
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
        
        this.vista.btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cambiosN=false,cambiosNro=false,correcto=true;
                try{
                    if(!vista.txtNombre.getText().equals("")&&!vista.txtNumCamiseta.getText().equals("")){
                        if(vista.txtNombre.getText().matches("[ a-zA-Z]+")&&Sistema.esNumero(vista.txtNumCamiseta.getText())){
                            
                            if(j.getNumCamiseta()==Integer.parseInt(vista.txtNumCamiseta.getText())){
                                System.out.println("No cambios en camiseta...");
                            }else if(eq.camisetaRepetida(Integer.parseInt(vista.txtNumCamiseta.getText()))){
                                correcto=false;
                            }else{
                                cambiosNro=true;
                            }
                            
                            if(j.getNombre().equals(vista.txtNombre.getText())){
                                System.out.println("No cambios en nombre..");
                            }else{
                                cambiosN=true;
                            }
                            
                            if(!correcto){
                                JOptionPane.showMessageDialog(null, "Error al agregar jugador");
                            }else if(!cambiosN&&!cambiosNro){
                                JOptionPane.showMessageDialog(null, "No se han realizado cambios");
                            }else{
                                if(cambiosN){
                                    eq.getJugador(vista.txtDNIBuscar.getText()).setNombre(vista.txtNombre.getText());
                                }
                                if(cambiosNro){
                                    eq.getJugador(vista.txtDNIBuscar.getText()).setNumCamiseta(Integer.parseInt(vista.txtNumCamiseta.getText()));
                                }
                                JOptionPane.showMessageDialog(null, "Se modificó jugador");
                                eq.ordenarJugadoresPorCamiseta();
                                System.out.println(eq.getJugador(vista.txtDNIBuscar.getText()));
                            } 
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Campos incorrectos!");
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Falta rellenar campos!");
                    }
                    
                    
                    
                    /*if(j.getNombre().equals(vista.txtNombre.getText())&&j.getNumCamiseta()==Integer.parseInt(vista.txtNumCamiseta.getText())){
                        JOptionPane.showMessageDialog(null, "No se han cambiado datos!");
                    }
                    eq.getJugador(j.getDNI()).setNombre(vista.txtNombre.getText());
                    if(eq.cambiarCamiseta(Integer.parseInt(vista.txtDNIBuscar.getText()))){
                        
                    }
                    eq.getJugador(j.getDNI()).setNumCamiseta(Integer.parseInt(vista.txtNumCamiseta.getText()));
                    
                    eq.ordenarJugadoresPorCamiseta();
                    JOptionPane.showMessageDialog(null, "Se modificaron los datos!");
                    FrmGestJugador vistaEliminarJugador = new FrmGestJugador();
                    ControladorGestJugador controladorGestJugador = new ControladorGestJugador(vistaEliminarJugador);
                    controladorGestJugador.frmIniciar();
                    vista.dispose();*/
                    
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(null, "Error al agregar jugador!");
                    System.out.println("error: "+e);
                }
            }
        });
    }
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.btnoModificarDatos.setEnabled(false);
        vista.btnoModificarDatos.setSelected(false);
        vista.txtNombre.setEnabled(false);
        vista.txtNumCamiseta.setEnabled(false);
        vista.txtNombreEquipo.setEnabled(false);
        vista.txtCodigoEquipo.setEnabled(false);
    }
}
