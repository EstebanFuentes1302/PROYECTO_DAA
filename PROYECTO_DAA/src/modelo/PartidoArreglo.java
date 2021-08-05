/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class PartidoArreglo {
    ArrayList<Partido> partidos;
    int cantidadPartidos;
    
    public PartidoArreglo(){
        this.partidos=new ArrayList<>();
        this.cantidadPartidos=0;
    }
    
    public void agregarPartido(Partido p){
        partidos.add(p);
        cantidadPartidos++;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public int getCantidadPartidos() {
        return cantidadPartidos;
    }
}
