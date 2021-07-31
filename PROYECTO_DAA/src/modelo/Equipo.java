/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class Equipo {
    public Jugador[] jugadores;
    Entrenador entrenador;
    String nombre;
    int cantidadJugadores;
    int MAX=15;
    int puntos;
    int partidosjugados;
    int partidosganados;
    int partidosperdidos;
    int partidosempatados;
    String codigo;
    String[] cabecerajugadores = {"NOMBRE","NRO DE CAMISETA"};
    
    
    public void aumentaPuntos(int i){
        puntos=+i;
        
    }
    
    public void AumentaPE(){
        partidosempatados++;
    }
    
    public void AumentaPP(){
        partidosperdidos++;
    }
    
    public void AumentaPG(){
        partidosganados++;
    }
    
    public void AumentaPJ(){
        partidosjugados++;
    }
    
    public int getPuntos() {
        return puntos;
    }

    public int getPartidosjugados() {
        return partidosjugados;
    }

    public int getPartidosganados() {
        return partidosganados;
    }

    public int getPartidosperdidos() {
        return partidosperdidos;
    }

    public int getPartidosempatados() {
        return partidosempatados;
    }
   
    
    

    public String[] getCabecerajugadores() {
        return cabecerajugadores;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
    public Equipo(String codigo,String nombre, Entrenador entrenador) {
        this.jugadores = new Jugador[MAX];
        this.jugadores = jugadores;
        this.entrenador = entrenador;
        this.cantidadJugadores=0;
        this.nombre=nombre;
        this.codigo=codigo;
        puntos=0;
        partidosjugados=0;
        partidosganados=0;
        partidosperdidos=0;
        partidosempatados=0;
    }
    
    public Equipo(String nombre, Jugador[] jugadores, Entrenador entrenador) {
        this.jugadores = new Jugador[MAX];
        this.jugadores = jugadores;
        this.entrenador = entrenador;
        this.cantidadJugadores=0;
        this.nombre=nombre;
        puntos=0;
        partidosjugados=0;
        partidosganados=0;
        partidosperdidos=0;
        partidosempatados=0;
    }
    
    public void addJugador(Jugador j){
        
        for(int i=0;i<cantidadJugadores;i++){
            if(jugadores[i].DNI.equals(j.DNI)){
                JOptionPane.showMessageDialog(null, "Jugador repetido");
                return;
            }
        }
        if(this.cantidadJugadores<MAX){
            jugadores[cantidadJugadores]=j;
            cantidadJugadores++;
        }else{
            JOptionPane.showMessageDialog(null, "Equipo Completo!");
        }
        ordenarJugadores();
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getCantidadJugadores() {
        return cantidadJugadores;
    }
    
    public String[][] getDatosJugadores(){
        String[][] result = new String[cantidadJugadores][2];
        
        for(int i=0;i<cantidadJugadores;i++){
            result[i][0]=jugadores[i].getNombre();
            result[i][1]=Integer.toString(jugadores[i].getNumCamiseta());
        }
        
        return result;
    }
    
    public boolean eliminarJugador(int n){
        for(int i=0;i<cantidadJugadores;i++){
            if(n==jugadores[i].numCamiseta){
                int k=1;
                while(i+k<cantidadJugadores){
                    
                    jugadores[i+k-1]=jugadores[i+k];
                    k++;
                            
                }
                cantidadJugadores--;
                Jugador[] aux=new Jugador[cantidadJugadores];
                
                System.arraycopy(jugadores, 0, aux, 0, cantidadJugadores);
                jugadores=aux;
                return true;
            }
        }
        return false;
    }
    
    public void ordenarJugadores(){
        int i;
        Jugador aux;
        boolean cambios=false;
        while(true){
            
            cambios=false;
            for(i=0;i<cantidadJugadores-1;i++){
            if(jugadores[i].numCamiseta>jugadores[i+1].numCamiseta){
                aux=jugadores[i];
                jugadores[i]=jugadores[i+1];
                    jugadores[i+1]=aux;
                    cambios=true;
            }
            
            
        }if(cambios==false){
                break;
            }
        }
        

        
    }
    public boolean camisetaRepetida(int n){
        for(int i=0;i<cantidadJugadores;i++){
            if(n==jugadores[i].numCamiseta){
                System.out.println("camiseta repetida");
                return true;
                
            }

        }
        return false;
   }
}
