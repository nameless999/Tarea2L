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
public class Switch extends Elemento {
    
    private List<Puerta> Puertas;

    public Switch(char nombre, List<Puerta> Puertas) 
    {
        super('S', nombre);
        this.Puertas = Puertas;
    }
    
    /******** Función: crearListaPuertas ********
    Descripción: crea una lista enlazada con las puertas que estén enlazadas a un swtich-
    Parámetros: un arreglo de chars que es la matriz con el mapa, largo y ancho del mapa, label para saber el nombre del switch al que está enlazado.
    Retorno: lista enlazada con nodos de tipo tPuerta.
    ****************************************/
    static List<Puerta> crearListaPuertas(char[][] map, int largo, int ancho, char label)
    {

        List<Puerta> ListaPuertas = new ArrayList<>();

        for(int y = 0; y < largo; y++)
        {
            for (int x = 0; x < ancho; x++)
            {
               if(map[y][x] == Character.toUpperCase(label))
                    {
                                       
                        ListaPuertas.add(new Puerta(Character.toUpperCase(label),x,y,'P'));
                    }
            }
        }
        return ListaPuertas;
    }
    
    public void activar_switch(char[][] map)
    {
	int x,y;
	List<Puerta> puertas = this.getPuertas();
        for (Puerta puerta : puertas) {
            x = puerta.getX();
            y = puerta.getY();
            if(puerta.getEstado() == '1') //'cerrado'
            {
                map[y][x] = '0' ;
                puerta.setEstado('0');
            }

            else
            {
                puerta.setEstado('1');
                map[y][x] = puerta.getNombre();
            }
        }
    }   

    public List<Puerta> getPuertas() {
        return Puertas;
    }
    
    public void setPuertas(List<Puerta> Puertas) {
        this.Puertas = Puertas;
    }
    
}    

