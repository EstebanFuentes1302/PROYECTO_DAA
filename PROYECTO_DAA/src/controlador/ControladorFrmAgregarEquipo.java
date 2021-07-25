/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.sistema;
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
                if(!vista.txtNombreEntrenador.getText().equals("")&&!vista.txtNombreEquipo.getText().equals("")){
                sistema.equipos.addEquipo(new Equipo(vista.txtNombreEquipo.getText(), new Entrenador(vista.txtNombreEntrenador.getText())));
                vista.dispose();
                
                FrmGestEquipos vistaEquipos = new FrmGestEquipos();
                ControladorFrmGestEquipos controladorEquipos = new ControladorFrmGestEquipos(sistema.equipos, vistaEquipos);
                controladorEquipos.frmIniciar();
            }else{
                    JOptionPane.showMessageDialog(null, "Faltan Rellenar campos");
                }}
        });
    }
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
