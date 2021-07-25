
package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivoCSV {
    private String h="";
    private char sexo;
    private String [] part;
    public static String [] nombreColumnas = new String [] {"N°", "Primer nombre", "Segundo nombre", "Apellido paterno", "Apellido materno", "Fecha nacimiento", "Correo", "Genero", "Departamento", "Provincia", "Distrito", "Direccion", "Telefono", "Facultad", "Escuela", "Año", "DNI"};
    public static String [][] data = new String[0][];
    public static String [] valores = new String [0];
  
    
    public void ruta(String F){ 
        try{
            BufferedReader reader = new BufferedReader(new FileReader(F));           
            String line =null;
            while ((line= reader.readLine())!=null){
                part=line.split(";");
                //if()
                //Sistema.equipos.addEquipo(new Equipo);
            }
           
        }catch (IOException e) {
            
              System.out.println("Se produjo un error al leer el archivo .csv");
        }
        
    }
          
     
} 

