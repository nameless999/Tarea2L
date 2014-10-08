package game;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author nameless999
 */
public class Mapa {
    private char[][] Map;

    public Mapa(int ancho, int largo)
    {
            Map = new char[largo][ancho]; 	
    }

    public char[][] Map(int ancho, int largo, BufferedReader br, Usuario user)
    {
        // Apertura del fichero y creacion de BufferedReader para poder
        // hacer una lectura comoda (disponer del metodo readLine()).
        try{
            for (int i = 0; i< largo ; i++){
                for (int j = 0; j < ancho; j++ ){
                    char read = (char)br.read(); 
                    Map[i][j] = read;
                }
            }

            for (int i = 0; i< largo ; i++){
                for (int j = 0; j < ancho; j++ ){
                    if(Map[i][j] == 'I')
                    {
                        System.out.println(i);
                        System.out.println(j);
                        user.setPos(i,j,j/2);

                    }
                }
            }
        
        }catch(IOException ie)
        {
            ie.printStackTrace();
        }
            return Map;
    }

    public void PrintMap(int ancho,int largo)
    {
        for (int i = 0; i< largo ; i++){
            System.out.print("\033[30C");
            for (int j = 0; j < ancho; j++ ){
                System.out.print(Map[i][j]);
            }
        }

        System.out.print("\n\n\n\n");
    }
    
}
