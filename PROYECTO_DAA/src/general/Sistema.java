/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.util.Comparator;
import modelo.Arbol;
import modelo.ArbolBinarioBusqueda;
import modelo.Entrenador;
import modelo.Equipo;
import modelo.EquipoArreglo;
import modelo.Jugador;
import modelo.Partido;
import modelo.PartidoArreglo;

/**
 *
 * @author Esteban
 */
public class Sistema {
    public static EquipoArreglo equipos=new EquipoArreglo();
    public static Data datos = new Data();
    public static ArbolBinarioBusqueda<Jugador> ablJugador = new ArbolBinarioBusqueda<Jugador>(new Comparator<Jugador>(){
            @Override
            public int compare(Jugador j1, Jugador j2) {
                return Integer.valueOf(j1.getDNI()).compareTo(Integer.valueOf(j2.getDNI()));
            }
        });
    //public static Arbol<Equipo> ablEquipo = new Arbol<Equipo>();
    public static PartidoArreglo partidos = new PartidoArreglo();
    public static ArbolBinarioBusqueda<Equipo> ablEquipo= new ArbolBinarioBusqueda<Equipo>(new Comparator<Equipo>(){
            @Override
            public int compare(Equipo e1, Equipo e2) {
                return e1.getCodigo().compareTo(e2.getCodigo());
            }
        });;
    
    public static boolean esNumero(String s){
        try {
            int i=Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        
    }


}


