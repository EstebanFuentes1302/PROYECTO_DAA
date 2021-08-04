/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import modelo.Arbol;
import modelo.Entrenador;
import modelo.Equipo;
import modelo.EquipoArreglo;
import modelo.Jugador;

/**
 *
 * @author Esteban
 */
public class Sistema {
    public static EquipoArreglo equipos=new EquipoArreglo();
    public static Data datos = new Data();
    public static Arbol<Jugador> ablJugador = new Arbol<Jugador>();
    
    public static void InsertarArbol(){
        for(int i=0;i<equipos.getCantidadEquipos();i++){
            for (int j = 0; j < equipos.getCantidadJugadores(i); j++) {
                ablJugador.insertar(equipos.getEquipo(i).getJugadores().get(j));
            }
        }
    }
    
    
    
    public static void instanciarFestival(){
        /*equipos.addEquipo(new Equipo("01","Los Fisianos", new Entrenador("Alonso Peves")));
        equipos.addEquipo(new Equipo("02","Los Gozus", new Entrenador("Manuel Gonzales")));
        equipos.addEquipo(new Equipo("03","FC Soplido", new Entrenador("Esteban Fuentes")));
        equipos.addEquipo(new Equipo("04","Bayern Puno", new Entrenador("Sebastián Nuñez")));
        equipos.addEquipo(new Equipo("05","Los Gordos", new Entrenador("Pedro Castillo")));
        equipos.addEquipo(new Equipo("06","Los Peves", new Entrenador("El Turry")));
        equipos.addEquipo(new Equipo("07","Cerrón FC", new Entrenador("Guido Bellido")));
        equipos.addEquipo(new Equipo("08","Los Bikas", new Entrenador("Patricio Parodi")));
        equipos.addEquipo(new Equipo("09","FC PP", new Entrenador("Luigi Gutierrez")));
        equipos.addEquipo(new Equipo("10","ChocoSport", new Entrenador("Diego Maradona")));
        equipos.addEquipo(new Equipo("11","Real Aurich", new Entrenador("Josi Martinez")));
        equipos.addEquipo(new Equipo("12","Huancayo Saint-German", new Entrenador("Augusto Cortez")));
*/
        /*equipos.addJugador(1, new Jugador("Manuel Gonzales", 7,"48576849"));
        equipos.addJugador("E01", new Jugador("Choquote", 10,"42795273"));
        equipos.addJugador("E01", new Jugador("Esteban Fuentes", 1,"42180542"));
        equipos.addJugador("E01", new Jugador("Parcemon Peves", 20,"47602658"));
        equipos.addJugador("E01", new Jugador("Marco Rojo", 2,"40379002"));
        equipos.addJugador("E01", new Jugador("Gilberto Salinas", 3,"40622482"));
        equipos.addJugador("E01", new Jugador("Jean Deza", 4,"46270195"));
        equipos.addJugador("E01", new Jugador("Choquote", 5,"49352590"));
        equipos.addJugador("E01", new Jugador("Sebastian Nuñez", 6,"48088399"));
        equipos.addJugador("E01", new Jugador("Jesús De Nazareth", 8,"47154154"));
        equipos.addJugador("E01", new Jugador("Sigrid Bazán", 9,"43814304"));
        equipos.addJugador("E01", new Jugador("Jair Solano", 11,"41897783"));
        equipos.addJugador("E01", new Jugador("Lionel Messi", 12,"44172163"));
        equipos.addJugador("01", new Jugador("Cristiano Ronaldo", 13,"46015576"));
        
        equipos.addJugador("01", new Jugador("Gianluca Lapadula", 14,"44986027"));
        
        equipos.addJugador("02", new Jugador("Pedro Gallese", 7,"48576849"));
        equipos.addJugador("02", new Jugador("Claudio Pizarro", 10,"42795273"));
        equipos.addJugador("02", new Jugador("Augusto Cortez", 1,"42180542"));
        equipos.addJugador("02", new Jugador("Miguel Flores", 20,"47602658"));
        equipos.addJugador("02", new Jugador("Antonio Lopez", 2,"40379002"));
        equipos.addJugador("02", new Jugador("Fabio Agostini", 3,"40622482"));
        equipos.addJugador("02", new Jugador("Sideral Cortez", 4,"46270195"));
        equipos.addJugador("02", new Jugador("Tyler Creator", 5,"49352590"));
        equipos.addJugador("02", new Jugador("Benito Martinez", 6,"48088399"));
        equipos.addJugador("02", new Jugador("Andree Salazar", 8,"47154154"));
        equipos.addJugador("02", new Jugador("Reimond Manco", 9,"43814304"));
        equipos.addJugador("02", new Jugador("Zinedine Zidane", 11,"41897783"));
        equipos.addJugador("02", new Jugador("Ronaldinho Gaúcho", 12,"44172163"));
        equipos.addJugador("02", new Jugador("Sergio Ramos", 13,"46015576"));
        equipos.addJugador("02", new Jugador("Carlos Cabrera", 14,"44986027"));
        
        equipos.addJugador("03", new Jugador("Manuel Gonzales", 7,"48576849"));
        equipos.addJugador("03", new Jugador("Choquote", 10,"42795273"));
        equipos.addJugador("03", new Jugador("Esteban Fuentes", 1,"42180542"));
        equipos.addJugador("03", new Jugador("Parcemon Peves", 20,"47602658"));
        equipos.addJugador("03", new Jugador("Marco Rojo", 2,"40379002"));
        equipos.addJugador("03", new Jugador("Gilberto Salinas", 3,"40622482"));
        equipos.addJugador("03", new Jugador("Jean Deza", 4,"46270195"));
        equipos.addJugador("03", new Jugador("Choquote", 5,"49352590"));
        equipos.addJugador("03", new Jugador("Sebastian Nuñez", 6,"48088399"));
        equipos.addJugador("03", new Jugador("Jesús De Nazareth", 8,"47154154"));
        equipos.addJugador("03", new Jugador("Sigrid Bazán", 9,"43814304"));
        equipos.addJugador("03", new Jugador("Jair Solano", 11,"41897783"));
        equipos.addJugador("03", new Jugador("Lionel Messi", 12,"44172163"));
        equipos.addJugador("03", new Jugador("Cristiano Ronaldo", 13,"46015576"));
        equipos.addJugador("03", new Jugador("Gianluca Lapadula", 14,"44986027"));
       
        equipos.addJugador("04", new Jugador("Pedro Gallese", 7,"48576849"));
        equipos.addJugador("04", new Jugador("Claudio Pizarro", 10,"42795273"));
        equipos.addJugador("04", new Jugador("Augusto Cortez", 1,"42180542"));
        equipos.addJugador("04", new Jugador("Miguel Flores", 20,"47602658"));
        equipos.addJugador("04", new Jugador("Antonio Lopez", 2,"40379002"));
        equipos.addJugador("04", new Jugador("Fabio Agostini", 3,"40622482"));
        equipos.addJugador("04", new Jugador("Sideral Cortez", 4,"46270195"));
        equipos.addJugador("04", new Jugador("Tyler Creator", 5,"49352590"));
        equipos.addJugador("04", new Jugador("Benito Martinez", 6,"48088399"));
        equipos.addJugador("04", new Jugador("Andree Salazar", 8,"47154154"));
        equipos.addJugador("04", new Jugador("Reimond Manco", 9,"43814304"));
        equipos.addJugador("04", new Jugador("Zinedine Zidane", 11,"41897783"));
        equipos.addJugador("04", new Jugador("Ronaldinho Gaúcho", 12,"44172163"));
        equipos.addJugador("04", new Jugador("Sergio Ramos", 13,"46015576"));
        equipos.addJugador("04", new Jugador("Carlos Cabrera", 14,"44986027"));
        
        equipos.addJugador("05", new Jugador("Manuel Gonzales", 7,"48576849"));
        equipos.addJugador("05", new Jugador("Choquote", 10,"42795273"));
        equipos.addJugador("05", new Jugador("Esteban Fuentes", 1,"42180542"));
        equipos.addJugador("05", new Jugador("Parcemon Peves", 20,"47602658"));
        equipos.addJugador("05", new Jugador("Marco Rojo", 2,"40379002"));
        equipos.addJugador("05", new Jugador("Gilberto Salinas", 3,"40622482"));
        equipos.addJugador("05", new Jugador("Jean Deza", 4,"46270195"));
        equipos.addJugador("05", new Jugador("Choquote", 5,"49352590"));
        equipos.addJugador("05", new Jugador("Sebastian Nuñez", 6,"48088399"));
        equipos.addJugador("05", new Jugador("Jesús De Nazareth", 8,"47154154"));
        equipos.addJugador("05", new Jugador("Sigrid Bazán", 9,"43814304"));
        equipos.addJugador("05", new Jugador("Jair Solano", 11,"41897783"));
        equipos.addJugador("05", new Jugador("Lionel Messi", 12,"44172163"));
        equipos.addJugador("05", new Jugador("Cristiano Ronaldo", 13,"46015576"));
        equipos.addJugador("05", new Jugador("Gianluca Lapadula", 14,"44986027"));
        
        equipos.addJugador("06", new Jugador("Pedro Gallese", 7,"48576849"));
        equipos.addJugador("06", new Jugador("Claudio Pizarro", 10,"42795273"));
        equipos.addJugador("06", new Jugador("Augusto Cortez", 1,"42180542"));
        equipos.addJugador("06", new Jugador("Miguel Flores", 20,"47602658"));
        equipos.addJugador("06", new Jugador("Antonio Lopez", 2,"40379002"));
        equipos.addJugador("06", new Jugador("Fabio Agostini", 3,"40622482"));
        equipos.addJugador("06", new Jugador("Sideral Cortez", 4,"46270195"));
        equipos.addJugador("06", new Jugador("Tyler Creator", 5,"49352590"));
        equipos.addJugador("06", new Jugador("Benito Martinez", 6,"48088399"));
        equipos.addJugador("06", new Jugador("Andree Salazar", 8,"47154154"));
        equipos.addJugador("06", new Jugador("Reimond Manco", 9,"43814304"));
        equipos.addJugador("06", new Jugador("Zinedine Zidane", 11,"41897783"));
        equipos.addJugador("06", new Jugador("Ronaldinho Gaúcho", 12,"44172163"));
        equipos.addJugador("06", new Jugador("Sergio Ramos", 13,"46015576"));
        equipos.addJugador("06", new Jugador("Carlos Cabrera", 14,"44986027"));
        
        equipos.addJugador("07", new Jugador("Manuel Gonzales", 7,"48576849"));
        equipos.addJugador("07", new Jugador("Choquote", 10,"42795273"));
        equipos.addJugador("07", new Jugador("Esteban Fuentes", 1,"42180542"));
        equipos.addJugador("07", new Jugador("Parcemon Peves", 20,"47602658"));
        equipos.addJugador("07", new Jugador("Marco Rojo", 2,"40379002"));
        equipos.addJugador("07", new Jugador("Gilberto Salinas", 3,"40622482"));
        equipos.addJugador("07", new Jugador("Jean Deza", 4,"46270195"));
        equipos.addJugador("07", new Jugador("Choquote", 5,"49352590"));
        equipos.addJugador("07", new Jugador("Sebastian Nuñez", 6,"48088399"));
        equipos.addJugador("07", new Jugador("Jesús De Nazareth", 8,"47154154"));
        equipos.addJugador("07", new Jugador("Sigrid Bazán", 9,"43814304"));
        equipos.addJugador("07", new Jugador("Jair Solano", 11,"41897783"));
        equipos.addJugador("07", new Jugador("Lionel Messi", 12,"44172163"));
        equipos.addJugador("07", new Jugador("Cristiano Ronaldo", 13,"46015576"));
        equipos.addJugador("07", new Jugador("Gianluca Lapadula", 14,"44986027"));
       
        equipos.addJugador("08", new Jugador("Pedro Gallese", 7,"48576849"));
        equipos.addJugador("08", new Jugador("Claudio Pizarro", 10,"42795273"));
        equipos.addJugador("08", new Jugador("Augusto Cortez", 1,"42180542"));
        equipos.addJugador("08", new Jugador("Miguel Flores", 20,"47602658"));
        equipos.addJugador("08", new Jugador("Antonio Lopez", 2,"40379002"));
        equipos.addJugador("08", new Jugador("Fabio Agostini", 3,"40622482"));
        equipos.addJugador("08", new Jugador("Sideral Cortez", 4,"46270195"));
        equipos.addJugador("08", new Jugador("Tyler Creator", 5,"49352590"));
        equipos.addJugador("08", new Jugador("Benito Martinez", 6,"48088399"));
        equipos.addJugador("08", new Jugador("Andree Salazar", 8,"47154154"));
        equipos.addJugador("08", new Jugador("Reimond Manco", 9,"43814304"));
        equipos.addJugador("08", new Jugador("Zinedine Zidane", 11,"41897783"));
        equipos.addJugador("08", new Jugador("Ronaldinho Gaúcho", 12,"44172163"));
        equipos.addJugador("08", new Jugador("Sergio Ramos", 13,"46015576"));
        equipos.addJugador("08", new Jugador("Carlos Cabrera", 14,"44986027"));
        
        equipos.addJugador("09", new Jugador("Manuel Gonzales", 7,"48576849"));
        equipos.addJugador("09", new Jugador("Choquote", 10,"42795273"));
        equipos.addJugador("09", new Jugador("Esteban Fuentes", 1,"42180542"));
        equipos.addJugador("09", new Jugador("Parcemon Peves", 20,"47602658"));
        equipos.addJugador("09", new Jugador("Marco Rojo", 2,"40379002"));
        equipos.addJugador("09", new Jugador("Gilberto Salinas", 3,"40622482"));
        equipos.addJugador("09", new Jugador("Jean Deza", 4,"46270195"));
        equipos.addJugador("09", new Jugador("Choquote", 5,"49352590"));
        equipos.addJugador("09", new Jugador("Sebastian Nuñez", 6,"48088399"));
        equipos.addJugador("09", new Jugador("Jesús De Nazareth", 8,"47154154"));
        equipos.addJugador("09", new Jugador("Sigrid Bazán", 9,"43814304"));
        equipos.addJugador("09", new Jugador("Jair Solano", 11,"41897783"));
        equipos.addJugador("09", new Jugador("Lionel Messi", 12,"44172163"));
        equipos.addJugador("09", new Jugador("Cristiano Ronaldo", 13,"46015576"));
        equipos.addJugador("09", new Jugador("Gianluca Lapadula", 14,"44986027"));
        
        equipos.addJugador("10", new Jugador("Pedro Gallese", 7,"48576849"));
        equipos.addJugador("10", new Jugador("Claudio Pizarro", 10,"42795273"));
        equipos.addJugador("10", new Jugador("Augusto Cortez", 1,"42180542"));
        equipos.addJugador("10", new Jugador("Miguel Flores", 20,"47602658"));
        equipos.addJugador("10", new Jugador("Antonio Lopez", 2,"40379002"));
        equipos.addJugador("10", new Jugador("Fabio Agostini", 3,"40622482"));
        equipos.addJugador("10", new Jugador("Sideral Cortez", 4,"46270195"));
        equipos.addJugador("10", new Jugador("Tyler Creator", 5,"49352590"));
        equipos.addJugador("10", new Jugador("Benito Martinez", 6,"48088399"));
        equipos.addJugador("10", new Jugador("Andree Salazar", 8,"47154154"));
        equipos.addJugador("10", new Jugador("Reimond Manco", 9,"43814304"));
        equipos.addJugador("10", new Jugador("Zinedine Zidane", 11,"41897783"));
        equipos.addJugador("10", new Jugador("Ronaldinho Gaúcho", 12,"44172163"));
        equipos.addJugador("10", new Jugador("Sergio Ramos", 13,"46015576"));
        equipos.addJugador("10", new Jugador("Carlos Cabrera", 14,"44986027"));
        
        equipos.addJugador("11", new Jugador("Manuel Gonzales", 7,"48576849"));
        equipos.addJugador("11", new Jugador("Choquote", 10,"42795273"));
        equipos.addJugador("11", new Jugador("Esteban Fuentes", 1,"42180542"));
        equipos.addJugador("11", new Jugador("Parcemon Peves", 20,"47602658"));
        equipos.addJugador("11", new Jugador("Marco Rojo", 2,"40379002"));
        equipos.addJugador("11", new Jugador("Gilberto Salinas", 3,"40622482"));
        equipos.addJugador("11", new Jugador("Jean Deza", 4,"46270195"));
        equipos.addJugador("11", new Jugador("Choquote", 5,"49352590"));
        equipos.addJugador("11", new Jugador("Sebastian Nuñez", 6,"48088399"));
        equipos.addJugador("11", new Jugador("Jesús De Nazareth", 8,"47154154"));
        equipos.addJugador("11", new Jugador("Sigrid Bazán", 9,"43814304"));
        equipos.addJugador("11", new Jugador("Jair Solano", 11,"41897783"));
        equipos.addJugador("11", new Jugador("Lionel Messi", 12,"44172163"));
        equipos.addJugador("11", new Jugador("Cristiano Ronaldo", 13,"46015576"));
        equipos.addJugador("11", new Jugador("Gianluca Lapadula", 14,"44986027"));
       
        equipos.addJugador("12", new Jugador("Pedro Gallese", 7,"48576849"));
        equipos.addJugador("12", new Jugador("Claudio Pizarro", 10,"42795273"));
        equipos.addJugador("12", new Jugador("Augusto Cortez", 1,"42180542"));
        equipos.addJugador("12", new Jugador("Miguel Flores", 20,"47602658"));
        equipos.addJugador("12", new Jugador("Antonio Lopez", 2,"40379002"));
        equipos.addJugador("12", new Jugador("Fabio Agostini", 3,"40622482"));
        equipos.addJugador("12", new Jugador("Sideral Cortez", 4,"46270195"));
        equipos.addJugador("12", new Jugador("Tyler Creator", 5,"49352590"));
        equipos.addJugador("12", new Jugador("Benito Martinez", 6,"48088399"));
        equipos.addJugador("12", new Jugador("Andree Salazar", 8,"47154154"));
        equipos.addJugador("12", new Jugador("Reimond Manco", 9,"43814304"));
        equipos.addJugador("12", new Jugador("Zinedine Zidane", 11,"41897783"));
        equipos.addJugador("12", new Jugador("Ronaldinho Gaúcho", 12,"44172163"));
        equipos.addJugador("12", new Jugador("Sergio Ramos", 13,"46015576"));
        equipos.addJugador("12", new Jugador("Carlos Cabrera", 14,"44986027"));
       
        
        equipos.realizarPartido(1, equipos.getEquipos()[0],equipos.getEquipos()[1] );
        equipos.realizarPartido(2, equipos.getEquipos()[2],equipos.getEquipos()[3] );
        equipos.realizarPartido(1, equipos.getEquipos()[4],equipos.getEquipos()[5] );
        equipos.realizarPartido(3, equipos.getEquipos()[6],equipos.getEquipos()[7] );
        equipos.realizarPartido(1, equipos.getEquipos()[8],equipos.getEquipos()[9] );
        equipos.realizarPartido(2, equipos.getEquipos()[10],equipos.getEquipos()[11] );
        
        System.out.println(equipos.getDatosJugadores(0));*/
}


}


