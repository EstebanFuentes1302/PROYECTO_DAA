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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Equipo;
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
        
        this.vista.btnTerminarFestival.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                ArrayList<Equipo> equiposaux = new ArrayList<Equipo>();
                Equipo champ=Sistema.equipos.getEquipo(0);
                equiposaux.add(champ);
                while(true){
                    System.out.println(Sistema.equipos.getEquipo(i).getPuntos()+"\t"+Sistema.equipos.getEquipo(i+1).getPuntos());
                    if(Sistema.equipos.getEquipo(i).getPuntos()==Sistema.equipos.getEquipo(i+1).getPuntos()){
                        if(Sistema.equipos.getEquipo(i).getDiferencia()==Sistema.equipos.getEquipo(i+1).getDiferencia()){
                            equiposaux.add(Sistema.equipos.getEquipo(i+1));
                            i++;
                        }else{
                                    break;}
                    }else{
                        break;
                    }
                    
                }
                System.out.println("tamaño"+equiposaux.size());
                Random rand = new Random();
                int r =rand.nextInt(equiposaux.size());
                System.out.println("random: "+r);
                
                equiposaux.get(r).aumentaPuntos(1);
                
                Collections.sort(equiposaux,new Comparator<Equipo>(){
                    @Override
                    public int compare(Equipo e1, Equipo e2) {
                        if(e1.getPuntos()==e2.getPuntos()){
                            return Integer.valueOf(e2.getDiferencia()).compareTo( e1.getDiferencia());
                        }else{
                            return Integer.valueOf(e2.getPuntos()).compareTo(e1.getPuntos());
                        }

                    }

                });
                
                champ=equiposaux.get(0);
                
                
                JOptionPane.showMessageDialog(null, ("¡CAMPEÓN MUNDIAL: "+champ.getNombre()+"!"));
                try {
                    Sistema.datos.guardarDatos();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorFrmFestival.class.getName()).log(Level.SEVERE, null, ex);
                }
                Sistema.datos.borrarDatos();
                System.exit(0);

                
                
                
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
        TableColumnModel modelo = vista.tblFestival.getColumnModel();
        modelo.getColumn(0).setPreferredWidth(100);
        modelo.getColumn(1).setPreferredWidth(100);
        modelo.getColumn(2).setPreferredWidth(400);
        modelo.getColumn(3).setPreferredWidth(100);
        modelo.getColumn(4).setPreferredWidth(100);
        modelo.getColumn(5).setPreferredWidth(100);
        modelo.getColumn(6).setPreferredWidth(100);
        modelo.getColumn(7).setPreferredWidth(100);
        modelo.getColumn(8).setPreferredWidth(100);
        modelo.getColumn(9).setPreferredWidth(150);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer izquierda = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        izquierda.setHorizontalAlignment(JLabel.LEADING);
        vista.tblFestival.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(2).setCellRenderer( izquierda );
        vista.tblFestival.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
        vista.tblFestival.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
    }
    public void frmIniciar(){
        
        DefaultTableModel modelotabla = new DefaultTableModel(Sistema.equipos.getDatosEquiposTorneo(), Sistema.equipos.getCabeceraFest());
        vista.tblFestival.setModel(modelotabla);
        diseñarTabla();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
