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
            result[i][2]=Integer.toString(equipos[i].getCantidadJugadores());
            result[i][3]=equipos[i].entrenador.getNombre();
        }
        return result;
    }
    
    public String getNombreEquipo(int i){
        return equipos[i].getNombre();
    }        
    
    public int getCantidadJugadores(int i){
        return equipos[i].getCantidadJugadores();
    }
    
    public String[] getCabeceraJugadores(int i){
        return equipos[i].getCabecerajugadores();
    }
    
    public Equipo[] getEquipos() {  
        return equipos;
    }
    
    public int verificarEquipo(String nombre){
        for(int i=0;i<cantidadEquipos;i++){
            if (nombre.equals(equipos[i].getNombre())){
                return i;
            }
        }
        return -1;
    }
    
    public int getCantidadEquipos() {
        return cantidadEquipos;
    }
    
    public int getCantidadJugadores(){
        
        return 0;
    }
    
    public String[] getCabecera(){
        return this.cabecera;
    }
    
    public void addJugador(int i,Jugador j){
        equipos[i].addJugador(j);
    }
    
    public String [][] getDatosJugadores(int i){
        return equipos[i].getDatosJugadores();
    }
}
