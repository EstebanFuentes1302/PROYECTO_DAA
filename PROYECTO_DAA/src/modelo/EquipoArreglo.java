/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class EquipoArreglo {
    private Equipo equipos[];
    private int cantidadEquipos;
    private String [] cabecera={"Nro","Nombre","Nro de jugadores","Entrenador"};
    private String [] cabeceraFest={"Nro","Código","Nombre","PJ","PG","PE","PP","Puntos"};
    
    public EquipoArreglo(){
        this.cantidadEquipos=0;
        this.equipos= new Equipo[0];
    }
    
    public void addEquipo(Equipo e){
        boolean repetido=false;
        for(int k=0;k<cantidadEquipos;k++){
            if(equipos[k].getCodigo()==e.getCodigo()){
                System.out.println("Equipo Repetido!");
                repetido=true;
            }
        }
         if(!repetido){
             Equipo[] aux=equipos;
            this.equipos=new Equipo[cantidadEquipos+1];
            for(int i=0;i<aux.length;i++){
                this.equipos[i]=aux[i];
            }
            this.equipos[this.cantidadEquipos] = e;
            this.cantidadEquipos++;
            //JOptionPane.showMessageDialog(null, "Se agregó equipo!");
         }
        
    }
    
    public String getCodigoEquipo(int i){
        return equipos[i].getCodigo();
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
    
    public void realizarPartido(int op, Equipo equipo1, Equipo equipo2){
        switch (op){
                case 1:
                    System.out.println("1");
                    equipo1.AumentaPG();
                    equipo1.AumentaPJ();
                    equipo1.aumentaPuntos(3);
                    
                    equipo2.AumentaPJ();
                    equipo2.AumentaPP();
                    break;
                case 2:
                    System.out.println("2");
                    equipo1.AumentaPE();
                    equipo1.AumentaPJ();
                    equipo1.aumentaPuntos(1);
                    
                    equipo2.AumentaPE();
                    equipo2.AumentaPJ();
                    equipo2.aumentaPuntos(1);
                    break;
                case 3:
                    System.out.println("3");
                    equipo2.AumentaPG();
                    equipo2.AumentaPJ();
                    equipo2.aumentaPuntos(3);
                    
                    equipo1.AumentaPJ();
                    equipo1.AumentaPP();
                    break;
                    
        }
        ordenarEquiposPuntos();
    }
    
    public String[][] getDatosEquiposTorneo(){
        String[][] result = new String[this.cantidadEquipos][8];
        for(int i=0;i<this.cantidadEquipos;i++){
            result[i][0]=Integer.toString(i+1);
            result[i][1]=equipos[i].getCodigo();
            result[i][2]=equipos[i].getNombre();
            result[i][3]=Integer.toString(equipos[i].getPartidosjugados());
            result[i][4]=Integer.toString(equipos[i].getPartidosganados());
            result[i][5]=Integer.toString(equipos[i].getPartidosempatados());
            result[i][6]=Integer.toString(equipos[i].getPartidosperdidos());
            result[i][7]=Integer.toString(equipos[i].getPuntos());
        }
        return result;
    }

    public String[] getCabeceraFest() {
        return cabeceraFest;
    }
    
    public String getNombreEquipo(int i){
        return equipos[i].getNombre();
    }        
    
    public Equipo getEquipo(int i){
        return equipos[i];
    }
    
    public void ordenarEquiposPuntos(){
        int i;
        Equipo aux;
        boolean cambios=false;
        while(true){
            
            cambios=false;
            for(i=0;i<cantidadEquipos-1;i++){
            if(equipos[i].getPuntos()<equipos[i+1].getPuntos()){
                aux=equipos[i];
                equipos[i]=equipos[i+1];
                equipos[i+1]=aux;
                cambios=true;
            }
            
            
        }if(cambios==false){
                break;
            }
        }
    }
    
    public boolean verificarCamisetaRepetida(int i,int n){
        return equipos[i].camisetaRepetida(n);
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
    
    public boolean eliminarJugador(int i, int n){
        return equipos[i].eliminarJugador(n);
    }
    
    public boolean verificarExistencia(String codigo){
        for(int i=0;i<cantidadEquipos;i++){
            if(codigo.equals(equipos[i].getCodigo())){
                return true;
            }
        }
        return false;
    }
    
    
    
    public int verificarEquipo(String codigo){
        System.out.println(codigo);
        for(int i=0;i<cantidadEquipos;i++){
            if (codigo.equals(equipos[i].getCodigo())){
                return i;
            }else if(codigo.equals("E01")){
                return i;
            }
        }
        System.out.println("No se encontró equipo");
        return -1;
        
    }
    
    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    
    public String[] getCabecera(){
        return this.cabecera;
    }
    
    public void addJugador(String codigo,Jugador j){
        //System.out.println(cantidadEquipos);
        for(int k=0;k<cantidadEquipos;k++){
           if(codigo.equals(equipos[k].getCodigo())){
               if(equipos[k].getCantidadJugadores()>=equipos[k].MAX){
                   System.out.println("EQUIPO LLENO");
               }else{
                   equipos[k].addJugador(j);
                break;
               }
               
           }else if (codigo.equals("E01")){
               //Para evitar error en la lectura del archivo
               equipos[k].addJugador(j);
               
               break;
           }
        }
    }
    
    public void addJugador(int i,Jugador j){
        if(equipos[i].getCantidadJugadores()>=equipos[i].MAX){
            System.out.println("no");
        }else{
            equipos[i].addJugador(j);
        }
    }
    
    public String [][] getDatosJugadores(int i){
        return equipos[i].getDatosJugadores();
    }
    
}
