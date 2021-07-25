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
import vista.FrmEquipos;

/**
 *
 * @author Esteban
 */
public class ControladorFrmEquipos {
    private FrmEquipos vista = new FrmEquipos();
    private EquipoArreglo equipos;
    
    public ControladorFrmEquipos(EquipoArreglo equipos, FrmEquipos vista) {
        this.equipos = equipos;
        this.vista=vista;
        
        this.vista.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });
        
        this.vista.btnAgregarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAgregarEquipo vistaAgregar = new FrmAgregarEquipo();
                ControladorFrmAgregarEquipo controladorAgregar = new ControladorFrmAgregarEquipo(vistaAgregar);
                vista.dispose();
                controladorAgregar.frmIniciar();
                
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
