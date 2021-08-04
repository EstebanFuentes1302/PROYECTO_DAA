/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Jugador;
import vista.FrmBuscarJugador;

/**
 *
 * @author Esteban
 */
public class ControladorFrmBuscarJugador {
    FrmBuscarJugador vista = new FrmBuscarJugador();
    
    public ControladorFrmBuscarJugador(FrmBuscarJugador vista){
        this.vista=vista;
        
        this.vista.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador j = Sistema.ablJugador.buscarDato(new Jugador(vista.txtDNIBuscar.getText()));
                if(j==null){
                    JOptionPane.showMessageDialog(null, "No se encontró el jugador");
                }else{
                    JOptionPane.showMessageDialog(null, "El jugador se encuentra registrado");
                    vista.txtNombre.setText(j.getNombre());
                    vista.txtEquipo.setText(Sistema.equipos.getEquipo(Sistema.equipos.verificarEquipo(j.getCodE())).getNombre());
                    vista.txtNumCamiseta.setText(Integer.toString(j.getNumCamiseta()));
                }
                
            }
        });
    }
    
    public void frmIniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
