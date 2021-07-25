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
public class CanchaArreglo {
    Cancha[] canchas;
    int cantidadCanchas;
    
    public CanchaArreglo() {
        this.canchas = new Cancha[0];
        this.cantidadCanchas = 0;
    }
    
    
    
    
    public void addCancha(Cancha c){
        Cancha[] aux=canchas;
        this.canchas=new Cancha[cantidadCanchas+1];
        for(int i=0;i<aux.length;i++){
            this.canchas[i]=aux[i];
        }
        this.canchas[this.cantidadCanchas] = c;
        this.cantidadCanchas++;
    }
    
    public boolean eliminarCancha(String codigo){
        for(int i=0;i<cantidadCanchas;i++){
            if(codigo.equals(canchas[i].codigo)){
                int k=1;
                while(i+k<cantidadCanchas){
                    
                    canchas[i+k-1]=canchas[i+k];
                    k++;
                            
                }
                cantidadCanchas--;
                return true;
            }
        }
        return false;
    }
    
}
