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
import java.util.List;
import java.util.ArrayList;

class Puerta extends Elemento
{	
	private char estado;
	private char nombre;
	private int x;
	private int y;  	

     
	/******** Función: crearPuerta  ********
	Descripción: crea una estructura de tipo tPuerta
	Parámetros:  nombre de la puerta, x e y que son la posición de donde se encuentra-
	Retorno: estructura de tipo tPuerta.
	****************************************/
	public Puerta(char nombre2, int x2,int y2)
	{
		this.nombre = nombre2;
		this.x = x2;
		this.y = y2;
		this.estado = '1';
	}

		/******** Función: crearListaPuertas ********
	Descripción: crea una lista enlazada con las puertas que estén enlazadas a un swtich-
	Parámetros: un arreglo de chars que es la matriz con el mapa, largo y ancho del mapa, label para saber el nombre del switch al que está enlazado.
	Retorno: lista enlazada con nodos de tipo tPuerta.
	****************************************/	

	public char getNombre()
	{
		return this.nombre;
	}

	public void setNombre(char nombre)
	{
		this.nombre = nombre;
	}

	public int getX()
	{
		return this.x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public char getEstado()
	{
		return estado;
	}

	public void setEstado(char estado)
	{
		this.estado = estado;
	}
}

	