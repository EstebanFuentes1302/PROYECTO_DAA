/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmGestEquipos;
import vista.FrmGestionFestival;

/**
 *
 * @author Esteban
 */
public class ControladorFrmGestionFestival {
    FrmGestionFestival vista = new FrmGestionFestival();

    public ControladorFrmGestionFestival(FrmGestionFestival vista) {
        this.vista=vista;
        
        this.vista.btnGestEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestEquipos vistaEquipos = new FrmGestEquipos();
                ControladorFrmGestEquipos controladorEquipos = new ControladorFrmGestEquipos(sistema.equipos, vistaEquipos);
                controladorEquipos.frmIniciar();
                vista.dispose();
            }
        });
        
    }
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
}
