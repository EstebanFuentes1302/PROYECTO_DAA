/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.System;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.FrmAgregarEquipo;
import vista.FrmAgregarJugador;
import vista.FrmGestJugador;
import vista.FrmGestEquipos;
import vista.FrmGestionFestival;

/**
 *
 * @author Esteban
 */
public class ControladorFrmGestEquipos {
    private FrmGestEquipos vista = new FrmGestEquipos();
    private EquipoArreglo equipos;
    
    public ControladorFrmGestEquipos(EquipoArreglo equipos, FrmGestEquipos vista) {
        this.equipos = equipos;
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
     
    }
   
    
    private void actualizar(){
        DefaultTableModel modelotabla = new DefaultTableModel(equipos.getDatosEquipos(), equipos.getCabecera());
        vista.tblEquipos.setModel(modelotabla);
    }
    
    public void frmIniciar(){
        actualizar();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
