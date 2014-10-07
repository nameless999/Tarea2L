/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nameless999
 */
public class Switch {
    
    private char label;
    private List<Puerta> puertas;
    
    public List<Puerta> crearListaPuertas(char[][] map, int largo, int ancho, char label)
    {
        List<Puerta> ListaPuertas = new ArrayList<Puerta>();
        for(int y = 0; y < largo; y++)
        {
            for (int x = 0; x < ancho; x++)
            {
               if(map[y][x] == Character.toUpperCase(label))
                    {
                            ListaPuertas.add(new Puerta(Character.toUpperCase(label),x,y));
                    }
            }
        }

        return ListaPuertas;
    }
}
