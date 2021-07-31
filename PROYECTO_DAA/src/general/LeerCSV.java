/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Entrenador;
import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author Esteban
 */
public class LeerCSV {
    private BufferedReader lector;
    private String linea;
    private String partes[];
    
    public void leerEquipos(String ruta) throws IOException{
        try {
            lector = new BufferedReader(new FileReader(ruta));
            while((linea = lector.readLine())!=null){
                partes=linea.split(",");
                imprimirpartes();
                Sistema.equipos.addEquipo(new Equipo(partes[0], partes[1], new Entrenador(partes[2],partes[3])));
                System.out.println("");
            }
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leerJugadores(String ruta) throws IOException{
        try {
            lector = new BufferedReader(new FileReader(ruta));
            while((linea = lector.readLine())!=null){
                partes=linea.split(",");
                imprimirpartes();
                Sistema.equipos.addJugador(partes[0], new Jugador(partes[1], Integer.parseInt(partes[2]), partes[3]));
                //System.out.println("se guardo en "+partes[0]);
                System.out.println("");
            }
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void imprimirpartes(){
        for (int i=0;i<partes.length;i++){
            System.out.print(partes[i]+",");
        }
        System.out.println("");
    }
}
