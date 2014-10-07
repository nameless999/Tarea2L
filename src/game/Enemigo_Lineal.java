/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

/**
 *
 * @author nameless999
 */
public abstract class Enemigo_Lineal extends Enemigo {

    public Enemigo_Lineal(char tipo, int maxmov, int pasos, char direccion, int y, int x, char nombre) {
        super(tipo, maxmov, pasos, direccion, y, x, nombre);
    }
    
    @Override
    public abstract char siguiente_movimiento(char[][] map, int largo, int ancho);
    
}
