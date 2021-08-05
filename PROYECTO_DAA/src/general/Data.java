/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Entrenador;
import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author Esteban
 */
public class Data {
    private BufferedReader lector;
    private String linea;
    private String partes[]=null;
    private String rutaEquipos="Equipos.csv";
    private String rutaJugadores="Jugadores.csv";
    
    
    
    public void leerEquipos() throws IOException{
        try {
            lector = new BufferedReader(new FileReader(rutaEquipos ));
            while((linea = lector.readLine())!=null){
                partes=linea.split(",");
                //imprimirpartes();

                
                Sistema.equipos.addEquipo(new Equipo(partes[0], partes[1].trim(), new Entrenador(partes[2].trim(),partes[3].trim())));
            }
            
            lector.close();
        
        
        } catch (FileNotFoundException ex) {
            System.out.println("Base de datos no encontrada, creando uno nuevo...");
            FileWriter fw = new FileWriter(rutaEquipos);
            fw.close();
        }
    }
    
    public void leerJugadores() throws IOException{
        try {
            lector = new BufferedReader(new FileReader(rutaJugadores));
            while((linea = lector.readLine())!=null){
                partes=linea.split(",");
                
                Sistema.equipos.addJugador(partes[0], new Jugador(partes[0],partes[1], Integer.parseInt(partes[2]), partes[3]));
            }
            lector.close();
        
        } catch (FileNotFoundException ex) {
            System.out.println("Base de datos no encontrada, creando uno nuevo...");
            FileWriter fw = new FileWriter(rutaJugadores);
            fw.close();
        }
    }
    
    public void guardarDatos() throws IOException{
        PrintWriter guardarEquipos=new PrintWriter(rutaEquipos);
        PrintWriter guardarJugadores=new PrintWriter(rutaJugadores);
        
        String datosEquipos = "";
        String datosJugadores = "";
        
        for(int i=0;i<Sistema.equipos.getCantidadEquipos();i++){
             datosEquipos+=Sistema.equipos.getEquipo(i).getCodigo()+","+Sistema.equipos.getEquipo(i).getNombre()+","+Sistema.equipos.getEquipo(i).getEntrenador().getNombre()+","+Sistema.equipos.getEquipo(i).getEntrenador().getDni()+"\n";
        }
        
        for(int j=0;j<Sistema.equipos.getCantidadEquipos();j++){
            for(int k=0;k<Sistema.equipos.getCantidadJugadores(j);k++){
                datosJugadores+=Sistema.equipos.getEquipo(j).getCodigo()+","+Sistema.equipos.getEquipo(j).getJugadores().get(k).getNombre()+","+Sistema.equipos.getEquipo(j).getJugadores().get(k).getNumCamiseta()+","+Sistema.equipos.getEquipo(j).getJugadores().get(k).getDNI()+"\n";
            }
        }
        //System.out.println(datosEquipos);
        //System.out.println(datosJugadores);
        guardarEquipos.print(datosEquipos);
        guardarJugadores.print(datosJugadores);
        guardarEquipos.close();
        guardarJugadores.close();
    }
    
    public void imprimirpartes(){
        for (int i=0;i<partes.length;i++){
            System.out.print("-"+partes[i]+",");
        }
        System.out.println("");
    }
}
