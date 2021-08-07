/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import general.Sistema;
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

    
    String[] cabecerajugadores = {"DNI","NOMBRE","NRO DE CAMISETA"};
    
    
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
    
    public void cambiarCodigoEquipo(String codigo){
        for(int i=0;i<cantidadJugadores;i++){
            jugadores.get(i).setCodE(codigo);
        }
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Equipo(String codigo,String nombre, Entrenador entrenador) {
        this.jugadores = new ArrayList<Jugador>();
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
        if(camisetaRepetida(j.numCamiseta)){
            System.out.println("Camiseta de jugador repetida");
        }else{
            this.jugadores.add(j);
            cantidadJugadores++;
            ordenarJugadoresPorCamiseta();
        }
        
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
        String[][] result = new String[cantidadJugadores][3];
        
        for(int i=0;i<cantidadJugadores;i++){
            result[i][0]=jugadores.get(i).getDNI();
            result[i][1]=jugadores.get(i).getNombre();
            result[i][2]=Integer.toString(jugadores.get(i).getNumCamiseta());
            
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
    
    public boolean eliminarJugador(String n){
        for(int i=0;i<cantidadJugadores;i++){
            if(n.equals(jugadores.get(i).getDNI())){
                jugadores.remove(i);
                Sistema.ablJugador.eliminar(new Jugador(n));
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
    
    public boolean cambiarCamiseta(int numCamiseta){
        for (int i = 0; i < cantidadJugadores; i++) {
            if(numCamiseta == jugadores.get(i).getNumCamiseta()){
                return false;
            }
        }
        
        return true;
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

    @Override
    public String toString() {
        return "\tCodigo: "+ codigo;
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
