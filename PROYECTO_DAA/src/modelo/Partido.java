/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import general.Sistema;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author Esteban
 */
public class Partido {
    Equipo equipo1,equipo2;
    int g1,g2;
    private Timer timer = new Timer();
    private int indiceResultado;

    public int getIndiceResultado() {
        return indiceResultado;
    }
    
    public Partido(int indice,Equipo equipo1, Equipo equipo2, int g1, int g2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.g1 = g1;
        this.g2 = g2;
        this.indiceResultado=indice;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getG1() {
        return g1;
    }

    public int getG2() {
        return g2;
    }
    
    
    public synchronized void ejecutarPartido(){
        this.timer.cancel(); //this will cancel the current task. if there is no active task, nothing happens
        this.timer = new Timer();

        TimerTask action = new TimerTask() {
            @Override
            public void run() {
                realizarPartido();
            }

        };
        this.timer.schedule(action, 5000);
    }
    
    public void realizarPartido(){
        randomPartido();
        System.out.println("ACABÓ");
        //Sistema.partidos.getPartidos().remove(this);
        
    }
    
    private void randomPartido(){
        int a=(int)Math.random()*10;
        int b=(int)Math.random()*10;
        System.out.println("e1: "+a+"\te2: "+b);
        if(a>b){
            System.out.println("e1: "+a+"\te2: "+b);
            System.out.println("GANA LOCAL");
        }else if(a<b){
            System.out.println("GANA VISITA");
        }else if(a==b){
            System.out.println("EMPATE");
        }
    }
    public Partido() {
    }
}
