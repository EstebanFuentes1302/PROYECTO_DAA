/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.BufferedReader;
import java.io.File;
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
    private String rutaPartidos = "Partidos.csv";
    
    
    public  void leerDatos() throws IOException{
        leerEquipos();
        leerJugadores();
        leerPartidos();
    }
    
    public void borrarDatos(){
        File f1=new File(rutaEquipos);
        File f2=new File(rutaJugadores);
        File f3=new File(rutaPartidos);
        if(f1.delete()&&f2.delete()&&f3.delete()){
            System.out.println("Se borraron los archivos");
        }else{
            System.out.println("No se borraron los archivos");
        }

    }
    
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
    
    public void leerPartidos() throws IOException{
        try {
            lector = new BufferedReader(new FileReader(rutaPartidos));
            while((linea = lector.readLine())!=null){
                imprimirpartes();
                partes=linea.split(",");
                Sistema.equipos.realizarPartido(Integer.parseInt(partes[0]), Sistema.equipos.getEquipo(partes[1]),Sistema.equipos.getEquipo(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]));
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
        PrintWriter guardarPartidos = new PrintWriter(rutaPartidos);
        
        String datosEquipos = "";
        String datosJugadores = "";
        String datosPartidos ="";
        for(int i=0;i<Sistema.equipos.getCantidadEquipos();i++){
             datosEquipos+=Sistema.equipos.getEquipo(i).getCodigo()+","+Sistema.equipos.getEquipo(i).getNombre()+","+Sistema.equipos.getEquipo(i).getEntrenador().getNombre()+","+Sistema.equipos.getEquipo(i).getEntrenador().getDni()+"\n";
        }
        
        for(int i=0;i<Sistema.equipos.getCantidadEquipos();i++){
            for(int k=0;k<Sistema.equipos.getCantidadJugadores(i);k++){
                datosJugadores+=Sistema.equipos.getEquipo(i).getCodigo()+","+Sistema.equipos.getEquipo(i).getJugadores().get(k).getNombre()+","+Sistema.equipos.getEquipo(i).getJugadores().get(k).getNumCamiseta()+","+Sistema.equipos.getEquipo(i).getJugadores().get(k).getDNI()+"\n";
            }
        }
        
        for (int i = 0; i < Sistema.equipos.getCantidadPartidos(); i++) {
            datosPartidos+=Sistema.partidos.getPartidos().get(i).getIndiceResultado()+","+Sistema.partidos.getPartidos().get(i).getEquipo1().getCodigo()+","+Sistema.partidos.getPartidos().get(i).getEquipo2().getCodigo()+","+Sistema.partidos.getPartidos().get(i).getG1()+","+Sistema.partidos.getPartidos().get(i).getG2()+"\n";
        }

        guardarEquipos.print(datosEquipos);
        guardarJugadores.print(datosJugadores);
        guardarPartidos.print(datosPartidos);
        System.out.println(datosPartidos);
        
        guardarEquipos.close();
        guardarJugadores.close();
        guardarPartidos.close();
        
        
        
    }
    
    public void imprimirpartes(){
        for (int i=0;i<partes.length;i++){
            System.out.print("-"+partes[i]+",");
        }
        System.out.println("");
    }
}
