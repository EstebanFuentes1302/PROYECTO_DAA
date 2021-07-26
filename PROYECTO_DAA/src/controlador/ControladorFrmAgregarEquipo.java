/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.System;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Entrenador;
import modelo.Equipo;
import vista.FrmAgregarEquipo;
import vista.FrmGestEquipos;

public class ControladorFrmAgregarEquipo {
    FrmAgregarEquipo vista= new FrmAgregarEquipo();
    
    public ControladorFrmAgregarEquipo(FrmAgregarEquipo vista){
        this.vista=vista;
        this.vista.btnAgregarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vista.txtNombreEntrenador.getText().equals("")||vista.txtNombreEquipo.getText().equals("")||vista.txtCodigo.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Faltan Rellenar campos");
                }else if(System.equipos.verificarExistencia(vista.txtCodigo.getText(),vista.txtNombreEquipo.getText())){
                    JOptionPane.showMessageDialog(null, "El equipo ya existe");
                }else{
                    System.equipos.addEquipo(new Equipo(vista.txtCodigo.getText(),vista.txtNombreEquipo.getText(), new Entrenador(vista.txtNombreEntrenador.getText())));
                    vista.dispose();

                    FrmGestEquipos vistaEquipos = new FrmGestEquipos();
                    ControladorFrmGestEquipos controladorEquipos = new ControladorFrmGestEquipos(System.equipos, vistaEquipos);
                    controladorEquipos.frmIniciar();
                }
            
            
            }
        });
    }
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
