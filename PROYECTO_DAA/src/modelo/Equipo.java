/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Esteban
 */
public class Equipo implements Comparable<Equipo> {
    //public Jugador[] jugadores;
    ArrayList<Jugador> jugadores;
    Entrenador entrenador;
    String nombre;
    int cantidadJugadores;
    int MAX=15;
    int puntos;
    int partidosjugados;
    int partidosganados;
    int partidosperdidos;
    int partidosempatados;
    int GolesAFavor;
    int GolesEnContra;
    String codigo;

    
    String[] cabecerajugadores = {"NOMBRE","NRO DE CAMISETA"};
    
    
    public void aumentaPuntos(int i){
        puntos+=i;
        
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
    
    public Entrenador getEntrenador() {
        return entrenador;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    public int getDiferencia(){
        return GolesAFavor-GolesEnContra;
    }
    
    public Equipo(String codigo,String nombre, Entrenador entrenador) {
        //this.jugadores = new Jugador[MAX];
        this.jugadores = new ArrayList<Jugador>();
        //this.jugadores = jugadores;
        this.entrenador = entrenador;
        this.cantidadJugadores=0;
        this.nombre=nombre;
        this.codigo=codigo;
        this.puntos=0;
        this.partidosjugados=0;
        this.partidosganados=0;
        this.partidosperdidos=0;
        this.partidosempatados=0;
        this.GolesAFavor=0;
        this.GolesEnContra=0;
    }
    
    public Equipo(String nombre, ArrayList<Jugador> jugadores, Entrenador entrenador) {
        //this.jugadores = new Jugador[MAX];
        //this.jugadores = jugadores;
        this.jugadores=jugadores;
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
        
        this.jugadores.add(j);
        cantidadJugadores++;
        /*for(int i=0;i<cantidadJugadores;i++){
            if(jugadores[i].DNI.equals(j.DNI)){
                JOptionPane.showMessageDialog(null, "Jugador repetido");
                return;
            }
        }
        System.out.println("cantidad de jugadores antes: "+cantidadJugadores);
        if(this.cantidadJugadores<MAX){
            Jugador[] aux= new Jugador[cantidadJugadores+1];
            jugadores[cantidadJugadores]=j;
            cantidadJugadores++;
            System.out.println("cantidad de jugadores despues: "+cantidadJugadores);
        }else{
            JOptionPane.showMessageDialog(null, "Equipo Completo!");
        }*/
        ordenarJugadoresPorCamiseta();
    }

    public int getMAX() {
        return MAX;
    }

    public String getNombre() {
        return nombre.trim();
    }
    
    public int getCantidadJugadores() {
        return cantidadJugadores;
    }
    
    public String[][] getDatosJugadores(){
        String[][] result = new String[cantidadJugadores][2];
        
        for(int i=0;i<cantidadJugadores;i++){
            result[i][0]=jugadores.get(i).getNombre();
            result[i][1]=Integer.toString(jugadores.get(i).getNumCamiseta());
        }
        return result;
    }
    
    public void aumentarGF(int i){
        GolesAFavor+=i;
    }
    
    public void aumentaGC(int i){
        GolesEnContra+=i;
    }

    public int getGolesAFavor() {
        return GolesAFavor;
    }

    public void setGolesAFavor(int GolesAFavor) {
        this.GolesAFavor = GolesAFavor;
    }

    public int getGolesEnContra() {
        return GolesEnContra;
    }

    public void setGolesEnContra(int GolesEnContra) {
        this.GolesEnContra = GolesEnContra;
    }
    
    public boolean eliminarJugador(int n){
        for(int i=0;i<cantidadJugadores;i++){
            if(n==jugadores.get(i).getNumCamiseta()){
                jugadores.remove(i);
                cantidadJugadores--;
                return true;
            }
        }
        return false;
    }
    
    public void ordenarJugadoresPorCamiseta(){
        Collections.sort(jugadores,new Comparator<Jugador>(){
            @Override
            public int compare(Jugador j1, Jugador j2) {
                return Integer.valueOf(j1.getNumCamiseta()).compareTo(j2.getNumCamiseta());
            }
        });
       
        
    }
    
    public Jugador getJugador(String DNI){
        for (int i = 0; i < cantidadJugadores; i++) {
            if(DNI.equals(jugadores.get(i).getDNI())){
                return jugadores.get(i);
            }
        }
        return null;
    }
    
    public Equipo(String codigo) {
        this.codigo = codigo;
    }
    public boolean camisetaRepetida(int n){
        for(int i=0;i<cantidadJugadores;i++){
            if(n==jugadores.get(i).getNumCamiseta()){
                System.out.println("camiseta repetida");
                return true;
                
            }

        }
        return false;
   }

    @Override
    public int compareTo(Equipo e) {
        return getCodigo().compareTo(e.getCodigo());
    }
}
