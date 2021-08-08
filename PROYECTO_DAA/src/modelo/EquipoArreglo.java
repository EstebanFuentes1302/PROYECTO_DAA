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
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class EquipoArreglo {
    private int cantidadEquipos;
    private final String [] cabecera={"Nro","Codigo","Nombre","Nro de jugadores","Entrenador"};
    private final String [] cabeceraFest={"Nro","Código","Nombre","PJ","PG","PE","PP","GF","GC","Puntos"};
    private final String[] cabecerajugadores = {"DNI","NOMBRE","NRO DE CAMISETA"};
    ArrayList<Equipo> equipos;
    int cantidadPartidos;

    
    
    
    public EquipoArreglo(){
        this.cantidadEquipos=0;
        this.equipos= new ArrayList<Equipo>();
    }
    
    public boolean equipoRepetido(String codigo){
        for(int k=0;k<cantidadEquipos;k++){
            if(equipos.get(k).getCodigo().equals(codigo)){
                System.out.println(equipos.get(k).getCodigo()+"\t"+codigo);
                System.out.println("Equipo Repetido!");
                return true;
            }
        }
        return false;
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
        String[][] result = new String[this.cantidadEquipos][5];
        for(int i=0;i<this.cantidadEquipos;i++){
            result[i][0]=Integer.toString(i+1);
            result[i][1]=equipos.get(i).getCodigo();
            result[i][2]=equipos.get(i).getNombre();
            result[i][3]=Integer.toString(equipos.get(i).getCantidadJugadores());
            result[i][4]=equipos.get(i).entrenador.getNombre();
        }
        return result;
    }
    
    public String[] getCabecerajugadores() {
        return cabecerajugadores;
    }
    
    public void realizarPartido(int op, Equipo equipo1, Equipo equipo2,int g1,int g2){
        switch (op){
                case 1:
                    //GANA LOCAL
                    equipo1.AumentaPG();
                    equipo1.AumentaPJ();
                    equipo1.aumentaPuntos(3);
                    
                    
                    equipo2.AumentaPJ();
                    equipo2.AumentaPP();
                    
                    break;
                case 2:
                    //EMPATE
                    equipo1.AumentaPE();
                    equipo1.AumentaPJ();
                    equipo1.aumentaPuntos(1);
                    
                    equipo2.AumentaPE();
                    equipo2.AumentaPJ();
                    equipo2.aumentaPuntos(1);
                    break;
                case 3:
                    //GANA VISITA
                    equipo2.AumentaPG();
                    equipo2.AumentaPJ();
                    equipo2.aumentaPuntos(3);
                    
                    equipo1.AumentaPJ();
                    equipo1.AumentaPP();
                    break;
                    
        }
        equipo1.aumentarGF(g1);
        equipo1.aumentaGC(g2);
        
        equipo2.aumentarGF(g2);
        equipo2.aumentaGC(g1);
        
        Sistema.partidos.agregarPartido(new Partido(op,equipo1, equipo2, g1, g2));
        cantidadPartidos++;
    }

    public int getCantidadPartidos() {
        return cantidadPartidos;
    }
    
    public String[][] getDatosEquiposTorneo(){
        String[][] result = new String[this.cantidadEquipos][10];
        ArrayList<Equipo> aux = getEquiposOrdenados();
        for(int i=0;i<this.cantidadEquipos;i++){
            result[i][0]=Integer.toString(i+1);
            result[i][1]=aux.get(i).getCodigo();
            result[i][2]=aux.get(i).getNombre();
            result[i][3]=Integer.toString(aux.get(i).getPartidosjugados());
            result[i][4]=Integer.toString(aux.get(i).getPartidosganados());
            result[i][5]=Integer.toString(aux.get(i).getPartidosempatados());
            result[i][6]=Integer.toString(aux.get(i).getPartidosperdidos());
            result[i][7]=Integer.toString(aux.get(i).getGolesAFavor());
            result[i][8]=Integer.toString(aux.get(i).getGolesEnContra());
            result[i][9]=Integer.toString(aux.get(i).getPuntos());
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
    
    public Equipo getEquipo(String codigo){
        return getEquipo(verificarEquipo(codigo));
    }
    
    public ArrayList<Equipo> getEquiposOrdenados(){
        ArrayList<Equipo> aux = (ArrayList<Equipo>) equipos.clone();
        Collections.sort(aux,new Comparator<Equipo>(){
            @Override
            public int compare(Equipo e1, Equipo e2) {
                if(e1.getPuntos()==e2.getPuntos()){
                    return Integer.valueOf(e2.getDiferencia()).compareTo( e1.getDiferencia());
                }else{
                    return Integer.valueOf(e2.getPuntos()).compareTo(e1.getPuntos());
                }
                
            }
            
        });
        return aux;
    }
    
    public boolean verificarCamisetaRepetida(int i,int n){
        return equipos.get(i).camisetaRepetida(n);
    }
    
    public int getCantidadJugadores(int i){
        return equipos.get(i).getCantidadJugadores();
    }
    
    public ArrayList<Equipo> getEquipos() {  
        return equipos;
    }
    
    public boolean eliminarJugador(int i, String n){
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
        for(int i=0;i<cantidadEquipos;i++){
            if (codigo.equals(equipos.get(i).getCodigo())){
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
    
    public boolean addJugador(String codigoE,Jugador j){
        
        if(codigoE.trim().equalsIgnoreCase("")|j.getNombre().trim().equalsIgnoreCase("")||Integer.toString(j.getNumCamiseta()).trim().equalsIgnoreCase("")||j.getDNI().trim().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Falta rellenar campos!");
        }else{
            //SI NO HAY CAMPOS VACIOS
            if(j.getNombre().matches("[ a-zA-ZñÑáÁéÉíÍóÓúÚ]+")&&Sistema.esNumero(Integer.toString(j.getNumCamiseta()))&&j.getDNI().length()==8&&Sistema.esNumero(j.getDNI())){
                //SI EL FORMATO DE LOS CAMPOS ESTÁ BIEN
                    if(Sistema.ablJugador.buscarDato(j)==null){
                        //EL JUGADOR NO SE REPITE 
                        Equipo aux = Sistema.ablEquipo.buscarDato(new Equipo(codigoE));
                            if(aux.getCantidadJugadores()<aux.getMAX()){
                                //EL EQUIPO NO ESTÁ LLENO
                                if(aux.addJugador(j)){
                                    //SE PUDO AGREGAR JUGADOR
                                    Sistema.ablJugador.insertar(j);
                                    return true;
                                }
                             else{
                                System.out.println("EQUIPO LLENO");
                                return false;
                            }
                        }
                    }else{
                        System.out.println("Jugador Repetido!");
                    }     
            }else{
                JOptionPane.showMessageDialog(null, "Campos incorrectos!");
            }
        }
        return false;
    }
    
    public void addJugador(int i,Jugador j){
        if(equipos.get(i).getCantidadJugadores()>=equipos.get(i).getMAX()){
        }else{
            equipos.get(i).addJugador(j);
        }
    }
    
    
    public String [][] getDatosJugadores(int i){
        return equipos.get(i).getDatosJugadores();
    }
    
}
