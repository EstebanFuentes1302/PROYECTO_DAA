/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.FrmAgregarEquipo;
import vista.FrmAgregarJugador;
import vista.FrmEliminarJugador;
import vista.FrmGestEquipos;

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
        
        this.vista.btnAgregarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAgregarJugador vistaAgregarJugador = new FrmAgregarJugador();
                ControladorAgregarJugador controladorAgregarJugador = new ControladorAgregarJugador(vistaAgregarJugador);
                
                controladorAgregarJugador.frmIniciar();
                vista.dispose();
            }
        });
        
        this.vista.btnEliminarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEliminarJugador vistaEliminarJugador = new FrmEliminarJugador();
                ControladorEliminarJugador controladorEliminarJugador = new ControladorEliminarJugador(vistaEliminarJugador);
                controladorEliminarJugador.frmIniciar();
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
