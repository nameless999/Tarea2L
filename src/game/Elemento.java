/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.util.List;

/**
 *
 * @author nameless999
 */
public abstract class Elemento {
    
    private char label;
    
    /*
	//public void agregarEnemigo(List<E> lista, void* info ,char label)
	//{
	    if(label == 'E')
	    {
	        tEnemigo* enemigo;
	        enemigo = (tEnemigo*)info;
	        if(lista->listSize == 0)
	        {
	            lista->head = lista->curr =  lista->tail = (tNodo*)malloc(sizeof(tNodo));
	            lista->head->info  = enemigo;
	            lista->head->label = 'E';
	            lista->listSize++;
	        }

	        else
	        {
	            lista->tail->siguiente = (tNodo*)malloc(sizeof(tNodo));
	            lista->tail = lista->tail->siguiente;
	            lista->tail->info = enemigo;
	            lista->tail->label = 'E';
	            lista->listSize++;
	        }
	    }
	    else if(label == 'S')
	    {
	        tSwitch* Switch;
	        Switch = (tSwitch*) info;
	        if(lista->listSize == 0)
	        {
	            lista->head = lista->curr =  lista->tail = (tNodo*)malloc(sizeof(tNodo));
	            lista->head->info  = Switch;
	            lista->head->label = 'S';
	            lista->listSize++;
	        }

	        else
	        {
	            lista->tail->siguiente = (tNodo*)malloc(sizeof(tNodo));
	            lista->tail = lista->tail->siguiente;
	            lista->tail->info = Switch;
	            lista->tail->label = 'S';
	            lista->listSize++;
	        
	        }
	    }

	    else if(label == 'P')
	    {
	        tPuerta* puerta;
	        puerta = (tPuerta*) info;
	        if(lista->listSize == 0)
	        {
	            lista->head = lista->curr =  lista->tail = (tNodo*)malloc(sizeof(tNodo));
	            lista->head->info  = puerta;
	            lista->head->label = 'P';
	            lista->listSize++;
	        }

	        else
	        {
	            lista->tail->siguiente = (tNodo*)malloc(sizeof(tNodo));
	            lista->tail = lista->tail->siguiente;
	            lista->tail->info = puerta;
	            lista->tail->label = 'P';
	            lista->listSize++;
	        
	        }
	    }
	//}	

	//public void agregarSwitch(List<E> lista, void* info ,char label)
	//{
	//}
	
	*/
	
	
	public crearListaEnemigosSwitch(List<Elemento> lista ,char[][] map, int largo, int ancho) 
	{
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
			        listaPuertas = crearListaPuertas(map,largo,ancho,'a');
			        general = crearSwitch('a',listaPuertas);
			        agregarElemento(lista,general,'S');

			    }

			    else if (map[y][x] == 'b')
			    {
			        listaPuertas = crearListaPuertas(map,largo,ancho,'b');
			        general = crearSwitch('b',listaPuertas);
			        agregarElemento(lista,general,'S');

			    }

			    else if (map[y][x] == 'c')
			    {
			        listaPuertas = crearListaPuertas(map,largo,ancho,'c');
			        general = crearSwitch('c',listaPuertas);
			        agregarElemento(lista,general,'S');

			    }
			}
	    }

		return lista;
	//}
*/

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }
}
