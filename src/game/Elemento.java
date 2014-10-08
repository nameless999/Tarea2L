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
public abstract class Elemento {
    
    private char label;
    private char nombre;

    public Elemento(char label, char nombre) {
        this.label = label;
        this.nombre = nombre;
    }
        
    static List<Elemento> crearListaEnemigosSwitch(char[][] map, int largo, int ancho) 
    {
        List<Elemento> lista = new ArrayList<>();
        int y,x;
        for (y = 0; y < largo; y++)
        {   
            for (x = 0; x < ancho; ++x)
            {
                if(map[y][x] == '2')
                {			        
                    lista.add(new Enemigo_Horizontal('H',2,0,'R',x,y,'2'));
                }
                else if (map[y][x] == '3')
                { 
                    lista.add(new Enemigo_Vertical('V',2,0,'U',x,y,'3'));
                }

                else if (map[y][x] == '4')
                {
                    lista.add(new Enemigo_Horizontal('H',3,0,'L',x,y,'4'));
                }

                else if (map[y][x] == '5')
                {   
                    lista.add(new Enemigo_Vertical('V',3,0,'D',x,y,'5'));
                }   

                else if (map[y][x] == '6')
                {
                    lista.add(new Enemigo_Horizontal('H',4,0,'R',x,y,'6'));
                }

                else if (map[y][x] == '7')
                {
                    lista.add(new Enemigo_Vertical('V',4,0,'U',x,y,'7'));
                }

                else if (map[y][x] == '8')
                {
                    lista.add(new Enemigo_Horizontal('H',5,0,'L',x,y,'8'));
                }

                else if (map[y][x] == '9')
                {
                    lista.add(new Enemigo_Vertical('V',5,0,'D',x,y,'9'));
                }

                else if (map[y][x] == 'a')
                {
                    lista.add(new Switch('a',  Switch.crearListaPuertas(map, largo, ancho, 'a' )));
                }

                else if (map[y][x] == 'b')
                       
                {
                     lista.add(new Switch('b', Switch.crearListaPuertas(map, largo, ancho, 'b') ));
                }

                else if (map[y][x] == 'c')
                {
                     lista.add(new Switch('c', Switch.crearListaPuertas(map, largo, ancho, 'c')));
                }
            }
        }
    return lista;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }
    
    
}
