/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import general.Sistema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Esteban
 */
public class EquipoArreglo {
    private int cantidadEquipos;
    private final String [] cabecera={"Nro","Nombre","Nro de jugadores","Entrenador"};
    private final String [] cabeceraFest={"Nro","Código","Nombre","PJ","PG","PE","PP","Puntos"};
    ArrayList<Equipo> equipos;
    
    public EquipoArreglo(){
        this.cantidadEquipos=0;
        this.equipos= new ArrayList<Equipo>();
    }
    
    public void addEquipo(Equipo e){
        boolean repetido=false;
        for(int k=0;k<cantidadEquipos;k++){
            if(equipos.get(k).getCodigo()==e.getCodigo()){
                System.out.println("Equipo Repetido!");
                repetido=true;
            }
        }
         if(!repetido){
             equipos.add(e);
             Sistema.ablEquipo.insertar(e);
             cantidadEquipos++;
         }
        
    }
    
    public String getCodigoEquipo(int i){
        return equipos.get(i).getCodigo();
    }
    
    public String[][] getDatosEquipos(){
        String[][] result = new String[this.cantidadEquipos][4];
        for(int i=0;i<this.cantidadEquipos;i++){
            result[i][0]=Integer.toString(i+1);
            result[i][1]=equipos.get(i).getNombre();
            result[i][2]=Integer.toString(equipos.get(i).getCantidadJugadores());
            result[i][3]=equipos.get(i).entrenador.getNombre();
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
            result[i][1]=equipos.get(i).getCodigo();
            result[i][2]=equipos.get(i).getNombre();
            result[i][3]=Integer.toString(equipos.get(i).getPartidosjugados());
            result[i][4]=Integer.toString(equipos.get(i).getPartidosganados());
            result[i][5]=Integer.toString(equipos.get(i).getPartidosempatados());
            result[i][6]=Integer.toString(equipos.get(i).getPartidosperdidos());
            result[i][7]=Integer.toString(equipos.get(i).getPuntos());
        }
        return result;
    }

    public String[] getCabeceraFest() {
        return cabeceraFest;
    }
    
    public String getNombreEquipo(int i){
        return equipos.get(i).getNombre();
    }        
    
    public Equipo getEquipo(int i){
        return equipos.get(i);
    }
    
    public void ordenarEquiposPuntos(){
        Collections.sort(equipos,new Comparator<Equipo>(){
            @Override
            public int compare(Equipo e1, Equipo e2) {
                return Integer.valueOf(e2.getPuntos()).compareTo(e1.getPuntos());
            }
            
        });
    }
    
    public boolean verificarCamisetaRepetida(int i,int n){
        return equipos.get(i).camisetaRepetida(n);
    }
    
    public int getCantidadJugadores(int i){
        return equipos.get(i).getCantidadJugadores();
    }
    
    public String[] getCabeceraJugadores(int i){
        return equipos.get(i).getCabecerajugadores();
    }
    
    public ArrayList<Equipo> getEquipos() {  
        return equipos;
    }
    
    public boolean eliminarJugador(int i, int n){
        return equipos.get(i).eliminarJugador(n);
    }
    
    public boolean verificarExistencia(String codigo){
        for(int i=0;i<cantidadEquipos;i++){
            if(codigo.equals(equipos.get(i).getCodigo())){
                return true;
            }
        }
        return false;
    }
    
    public int verificarEquipo(String codigo){
        System.out.println(codigo);
        int result=-1;
        for(int i=0;i<cantidadEquipos;i++){
            System.out.println(equipos.get(i).getCodigo());
            if (codigo.equals(equipos.get(i).getCodigo())){
                System.out.println("encontro");
                System.out.println(i);
                return i;
            }
        }
        
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
        /*System.out.println(equipos[0].getCodigo().getClass());
        System.out.println(codigo.getClass());*/
        if(Sistema.ablJugador.buscarDato(j)==null){
            for(int k=0;k<cantidadEquipos;k++){
                
               if(codigo.equals(equipos.get(k).getCodigo())){
                   if(equipos.get(k).getCantidadJugadores()>=equipos.get(k).getMAX()){
                       System.out.println("EQUIPO LLENO");
                   }else{
                       equipos.get(k).addJugador(j);
                       Sistema.ablJugador.insertar(j);
                    break;
                   }

               }/*else if (codigo.equals("E01")){
                   //Para evitar error en la lectura del archivo
                   equipos[k].addJugador(j);

                   break;
               }*/
            }
            }else{
                System.out.println("Jugador Repetido!");
            }
    }
    
    public void addJugador(int i,Jugador j){
        if(equipos.get(i).getCantidadJugadores()>=equipos.get(i).getMAX()){
            System.out.println("no");
        }else{
            equipos.get(i).addJugador(j);
        }
    }
    
    public Jugador getJugador(String codE,String DNI){
        for (int i = 0; i < cantidadEquipos; i++) {
            if(codE.equals(equipos.get(i).getCodigo())){
                for (int j = 0; j < 10; j++) {
                    
                }
            }
        }
        return null;
        
    }
    
    public String [][] getDatosJugadores(int i){
        return equipos.get(i).getDatosJugadores();
    }
    
}
