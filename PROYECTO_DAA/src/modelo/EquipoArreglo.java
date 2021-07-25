/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Esteban
 */
public class EquipoArreglo {
    private Equipo equipos[];
    private int cantidadEquipos;
    private String [] cabecera={"Nro","Nombre","Nro de jugadores","Entrenador"};
    
    public EquipoArreglo(){
        this.cantidadEquipos=0;
        this.equipos= new Equipo[0];
    }
    
    public void addEquipo(Equipo e){
        Equipo[] aux=equipos;
        this.equipos=new Equipo[cantidadEquipos+1];
        for(int i=0;i<aux.length;i++){
            this.equipos[i]=aux[i];
        }
        this.equipos[this.cantidadEquipos] = e;
        this.cantidadEquipos++;
    }
    
    public String[][] getDatosEquipos(){
        String[][] result = new String[this.cantidadEquipos][4];
        for(int i=0;i<this.cantidadEquipos;i++){
            result[i][0]=Integer.toString(i+1);
            result[i][1]=equipos[i].getNombre();
            result[i][2]=equipos[i].getCantidadJugadores();
            result[i][3]=equipos[i].entrenador.getNombre();
        }
        return result;
    }
    
    public String[] getCabecera(){
        return this.cabecera;
    }
    
}
