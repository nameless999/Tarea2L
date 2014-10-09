
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nameless999
 */
public class Usuario {
    private int[] pos;

    public Usuario()
    {
            pos = new int[3];
            pos[0] = 0;
            pos[1] = 0;
            pos[2] = 0;
    }
    
    public void ActSwitch(char[][] map, List<Elemento> lista, char label)
    {
 
        for (Elemento objeto : lista) {
            if(objeto.getLabel() == 'S')
            {
                Switch interruptor = (Switch) objeto;
                if(interruptor.getNombre() == label)
                {
                    interruptor.activar_switch(map);
                }
            }
        }
    }
    

    public  char dontMove(char[][] Map, List<Elemento> lista )
    {
        if(Map[pos[0]][pos[1]] == 'a') //Si la casilla actual es == a (Switch)...
        {
           System.out.print("\033[2J\033[1;1H"); 
           System.out.print("Te has quedado quieto en la posición("+ pos[0] + ',' + pos[2] +")y has activado el Switch 'a' <('o'<).\n\n\n\n");
           this.ActSwitch(Map,lista,'a');
           return '1';
        }

        else if(Map[pos[0]][pos[1]] == 'b') //Si la casilla de la derecha es == a (Switch)...
        {
           System.out.print("\033[2J\033[1;1H"); 
           System.out.print("Te has quedado quieto en la posición("+ pos[0] + ',' + pos[2] +")y has activado el Switch 'b' <('o'<).\n\n\n\n");
           this.ActSwitch(Map,lista,'b');
           return '1';
        }

        else if(Map[pos[0]][pos[1]] == 'c') //Si la casilla de la derecha es == a (Switch)...
        {
           System.out.print ("\033[2J\033[1;1H"); 
           System.out.print("Te has quedado quieto en la posición("+ pos[0] + ',' + pos[2] +")y has activado el Switch 'c' <('o'<).\n\n\n\n");
           this.ActSwitch(Map,lista,'c');
           return '1';
        }

        else
        {
           System.out.print ("\033[2J\033[1;1H"); 
           System.out.print("Te has quedado quieto en la posición("+ pos[0] + ',' + pos[2] +") <('o'<).\n\n\n\n");
           return '1';
        }
    }

    /******** Función: movDown ********
    Descripción: jugador ejecuta movimiento hacia abajo desde su posición actual
    Parámetros: string literal (entrada), posición actual
    Retorno: entero característico de la función (label)
    ****************************************/
    public  char movDown(char[][] Map, List<Elemento> lista) 
    {
       //char nombreEnemigo;
       if(Map[pos[0]+1][pos[1]] == '0') //Si la casilla de abajo es == 0 (válida)...
       {
          System.out.print ("\033[2J\033[1;1H");
          if(Map[pos[0]][pos[1]] == '*' || Map[pos[0]][pos[1]] == 'I' )
          {
             Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.
          }  
          Map[pos[0]+1][pos[1]] = '*'; //Nos movemos a la casilla de abjao
          pos[0] += 1; //Dejamos nuestra fila como 0
          pos[1] = pos[1]; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
          System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +").\n\n\n\n");
          return '1';
       }

       else if(Map[pos[0]+1][pos[1]] == 'F')
       {
          return '2';
       }   

       else if(Map[pos[0]+1][pos[1]] == '1')
       {
          System.out.print ("\033[2J\033[1;1H");
          System.out.print("┬┴┬┴┤(･_├┬┴┬┴ UPS! Hay una gran muralla delante tuyo, debes buscar otro camino.\n\n\n\n");
          return '5';
       }

       else if(Map[pos[0]+1][pos[1]] == 'A')
       {
          System.out.print ("\033[2J\033[1;1H");   
          System.out.print("La puerta está cerrada, busca el switch 'a' para abrirla. ¯_(ツ)_/¯ \n\n\n\n");
          return '5';
       }


       else if(Map[pos[0]+1][pos[1]] == 'a') //Si la casilla de la derecha es == a (Switch)...
       {
          System.out.print ("\033[2J\033[1;1H");  
          Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.  
          pos[0] += 1; //Dejamos nuestra fila como 0
          pos[1] = pos[1]; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
          System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch a y has abierto la puerta A.\n\n\n\n");
          this.ActSwitch(Map, lista, 'a');
          return '1';
       }

       else if(Map[pos[0]+1][pos[1]] == 'B')
       {
          System.out.print ("\033[2J\033[1;1H");   
          System.out.print("La puerta está cerrada, busca el switch 'b' para abrirla.\n");
          return '5';
       }

       else if(Map[pos[0]+1][pos[1]] == 'b') //Si la casilla de la derecha es == a (Switch)...
       {  
          System.out.print ("\033[2J\033[1;1H");
          Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.  
          pos[0] += 1; //Dejamos nuestra fila como 0
          pos[1] = pos[1]; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
          System.out.print("Te has movido a la posición("+ pos[0] + ',' + pos[2] +") sobre el Switch b y has abierto la puerta B.\n\n\n\n");
          this.ActSwitch(Map, lista, 'b');
          return '1';
       }

       else if(Map[pos[0]+1][pos[1]] == 'C')
       {
          System.out.print ("\033[2J\033[1;1H");   
          System.out.print("La puerta está cerrada, busca el switch 'c' para abrirla.\n");
          return '5';
       }


       else if(Map[pos[0]+1][pos[1]] == 'c') //Si la casilla de la derecha es == a (Switch)...
       {
          System.out.print ("\033[2J\033[1;1H");
          Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.  
          pos[0] += 1; //Dejamos nuestra fila como 0
          pos[1] = pos[1]; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
          System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch c y has abierto la puerta C.\n\n\n\n");
          this.ActSwitch(Map, lista, 'c');
          return '1';
       }

       else
       {
          return '0';
       }
    }

    /******** Función: movUp ********
    Descripción: jugador ejecuta movimiento hacia arriba desde su posición actual
    Parámetros: string literal (entrada), posición actual
    Retorno: entero característico de la función (label)
    ****************************************/
    public  char movUp(char[][] Map, List<Elemento> lista) // S
    {
       if(Map[pos[0]-1][pos[1]] == '0') //Si la casilla de abajo es == 0 (válida)...
       {
          System.out.print ("\033[2J\033[1;1H");
          if(Map[pos[0]][pos[1]] == '*' || Map[pos[0]][pos[1]] == 'I' )
          {
             Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.
          }  
          Map[pos[0]-1][pos[1]] = '*'; //Nos movemos a la casilla de abjao
          pos[0] -= 1; //Dejamos nuestra fila como 0
          pos[1] = pos[1]; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
          System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +").\n\n\n\n");
          return '1';
       }

       else if(Map[pos[0]-1][pos[1]] == 'F')
       {
          return '2';
       }

       else if(Map[pos[0]-1][pos[1]] == '1')
       {
          System.out.print ("\033[2J\033[1;1H");
          System.out.print("┬┴┬┴┤(･_├┬┴┬┴ UPS! Hay una gran muralla delante tuyo, debes buscar otro camino.\n\n\n\n");
          return '5';
       }

       else if(Map[pos[0]-1][pos[1]] == 'A')
       {
          System.out.print ("\033[2J\033[1;1H");   
          System.out.print("La puerta está cerrada, busca el switch 'a' para abrirla. ¯_(ツ)_/¯ \n\n\n\n");
          return '5';
       }


       else if(Map[pos[0]-1][pos[1]] == 'a') //Si la casilla de la derecha es == a (Switch)...
       {  
          System.out.print ("\033[2J\033[1;1H");
          Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.  
          pos[0] -= 1; //Dejamos nuestra fila como 0
          pos[1] = pos[1]; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
          System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch a y has abierto la puerta A.\n\n\n\n");
          this.ActSwitch(Map, lista, 'a');
          return '1';
       }

       else if(Map[pos[0]-1][pos[1]] == 'B')
       {
          System.out.print ("\033[2J\033[1;1H");   
          System.out.print("La puerta está cerrada, busca el switch 'b' para abrirla.\n\n\n\n");
          return '5';
       }

       else if(Map[pos[0]-1][pos[1]] == 'b') //Si la casilla de la derecha es == a (Switch)...
       {
          System.out.print ("\033[2J\033[1;1H");
          Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.  
          pos[0] -= 1; //Dejamos nuestra fila como 0
          pos[1] = pos[1]; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
          System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch b y has abierto la puerta B.\n\n\n\n");
          this.ActSwitch(Map, lista, 'b');
          return '1';
       }

       else if(Map[pos[0]-1][pos[1]] == 'C')
       {
          System.out.print ("\033[2J\033[1;1H");   
          System.out.print("La puerta está cerrada, busca el switch 'c' para abrirla.\n\n\n\n");
          return '5';
       }


       else if(Map[pos[0]-1][pos[1]] == 'c') //Si la casilla de la derecha es == a (Switch)...
       {
          System.out.print ("\033[2J\033[1;1H");
          Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.  
          pos[0] -= 1; //Dejamos nuestra fila como 0
          pos[1] = pos[1]; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
          System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch c y has abierto la puerta C.\n\n\n\n");
          this.ActSwitch(Map, lista, 'c');
          return '1';
       }
       else
       {
          return '0';
       }
    }

    /******** Función: movLeft ********
    Descripción: jugador ejecuta movimiento hacia la izquierda desde su posición actual
    Parámetros: string literal (entrada), posición actual
    Retorno: entero característico de la función (label)
    ****************************************/
    public  char movLeft(char[][] Map, List<Elemento> lista)
    {
          if(Map[pos[0]][pos[1]-2] == '0') //Si la casilla que está a la derecha es == 0 (válida)...
          {
             System.out.print ("\033[2J\033[1;1H"); 
             if(Map[pos[0]][pos[1]] == '*' || Map[pos[0]][pos[1]] == 'I' )
             {
                Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.
             }    
             Map[pos[0]][pos[1]-2] = '*'; //Nos movemos a la casilla de la derecha Map[pos[0][pos[1]-2] == (0,2).
             pos[0] = pos[0]; //Dejamos nuestra fila como 0
             pos[1] -= 2; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
             pos[2] -= 1;
             System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +").\n\n\n\n");
             return '1';
          }

          else if(Map[pos[0]][pos[1]-2] == 'F')
          {
             return '2';
          }

          else if(Map[pos[0]][pos[1]-2] == '1') //Si la casilla de la derecha es == 1 (muralla)...
          {
             System.out.print ("\033[2J\033[1;1H");               
             System.out.print("┬┴┬┴┤(･_├┬┴┬┴ UPS! Hay una gran muralla delante tuyo, debes buscar otro camino.\n\n\n\n");
             return '5';
          }

          else if(Map[pos[0]][pos[1]-2] == 'A') //Si la casilla de la derecha es == A (Puerta)...  
          {
             System.out.print ("\033[2J\033[1;1H");
             System.out.print("La puerta está cerrada, busca el switch 'a' para abrirla. ¯_(ツ)_/¯ \n\n\n\n");
             return '5';
          }

          else if(Map[pos[0]][pos[1]-2] == 'a') //Si la casilla de la derecha es == a (Switch)...
          {
             System.out.print ("\033[2J\033[1;1H"); 
             Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.   
             pos[0] = pos[0]; //Dejamos nuestra fila como 0
             pos[1] -= 2; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
             pos[2] -= 1;
             System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch a y has abierto la puerta A.\n\n\n\n");
             this.ActSwitch(Map, lista, 'a');
             return '1';
          }

          else if(Map[pos[0]][pos[1]-2] == 'B')
          {
             System.out.print ("\033[2J\033[1;1H");   
             System.out.print("La puerta está cerrada, busca el switch 'b' para abrirla.\n\n\n\n");
             return '5';
          }


          else if(Map[pos[0]][pos[1]-2] == 'b') //Si la casilla de la derecha es == a (Switch)...
          {
             System.out.print ("\033[2J\033[1;1H"); 
             Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.   
             pos[0] = pos[0]; //Dejamos nuestra fila como 0
             pos[1] -= 2; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
             pos[2] -= 1;
             System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch a y has abierto la puerta A.\n\n\n\n");
             this.ActSwitch(Map, lista, 'b');
             return '1';
          }

          else if(Map[pos[0]][pos[1]-2] == 'C')
          {
             System.out.print ("\033[2J\033[1;1H");   
             System.out.print("La puerta está cerrada, busca el switch 'c' para abrirla.\n\n\n\n");
             return '5';
          }

          else if(Map[pos[0]][pos[1]-2] == 'c') //Si la casilla de la derecha es == a (Switch)...
          {
             System.out.print ("\033[2J\033[1;1H"); 
             Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.   
             pos[0] = pos[0]; //Dejamos nuestra fila como 0
             pos[1] -= 2; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
             pos[2] -= 1;
             System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch a y has abierto la puerta A.\n\n\n\n");
             this.ActSwitch(Map, lista, 'c');
             return '1';
          }

          else
          {
             return '0';
          }
    }


    /******** Función: movRight ********
    Descripción: jugador ejecuta movimiento hacia la derecha desde su posición actual
    Parámetros: string literal (entrada), posición actual
    Retorno: entero característico de la función (label)
    ****************************************/
    public  char movRight(char[][] Map, List<Elemento> lista)
    {
       if(Map[pos[0]][pos[1]+2] == '0') //Si la casilla que está a la derecha es == 0 (válida)...
          {
             System.out.print("\033[2J\033[1;1H"); 
             if(Map[pos[0]][pos[1]] == '*' || Map[pos[0]][pos[1]] == 'I' )
             {
                Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.
             }     
             Map[pos[0]][pos[1]+2] = '*'; //Nos movemos a la casilla de la derecha Map[pos[0][pos[1]+2] == (0,2).
             pos[0] = pos[0]; //Dejamos nuestra fila como 0
             pos[1] += 2; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
             pos[2] += 1;
             System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +").\n\n\n\n");
             return '1';
          }

          else if(Map[pos[0]][pos[1]+2] == 'F')
          {
             return '2';
          }          

          else if(Map[pos[0]][pos[1]+2] == '1') //Si la casilla de la derecha es == 1 (muralla)...
          {
             System.out.print ("\033[2J\033[1;1H");               
             System.out.print("┬┴┬┴┤(･_├┬┴┬┴ UPS! Hay una gran muralla delante tuyo, debes buscar otro camino.\n\n\n\n");
             return '5';
          }

          else if(Map[pos[0]][pos[1]+2] == 'A') //Si la casilla de la derecha es == A (Puerta)...  
          {
             System.out.print ("\033[2J\033[1;1H");
             System.out.print("La puerta está cerrada, busca el switch 'a' para abrirla. ¯_(ツ)_/¯ \n\n\n\n");
             return '5';
          }

          else if(Map[pos[0]][pos[1]+2] == 'a') //Si la casilla de la derecha es == a (Switch)...
          {
             System.out.print ("\033[2J\033[1;1H"); 
             Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.   
             pos[0] = pos[0]; //Dejamos nuestra fila como 0
             pos[1] += 2; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
             pos[2] += 1;
             System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch a y has abierto la puerta A.\n\n\n\n");
             this.ActSwitch(Map, lista, 'a');
             return '1';
          }

          else if(Map[pos[0]][pos[1]+2] == 'B')
          {
             System.out.print ("\033[2J\033[1;1H");   
             System.out.print("La puerta está cerrada, busca el switch 'b' para abrirla.\n\n\n\n");
             return '5';
          }


          else if(Map[pos[0]][pos[1]+2] == 'b') //Si la casilla de la derecha es == a (Switch)...
          {
             System.out.print ("\033[2J\033[1;1H"); 
             Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.   
             pos[0] = pos[0]; //Dejamos nuestra fila como 0
             pos[1] += 2; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
             pos[2] += 1;
             System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch b y has abierto la puerta B.\n\n\n\n");
             this.ActSwitch(Map, lista, 'b');
             return '1';
          }

          else if(Map[pos[0]][pos[1]+2] == 'C')
          {
             System.out.print ("\033[2J\033[1;1H");   
             System.out.print("La puerta está cerrada, busca el switch 'c' para abrirla.\n\n\n\n");
             return '5';
          }


          else if(Map[pos[0]][pos[1]+2] == 'c') //Si la casilla de la derecha es == a (Switch)...
          {
             System.out.print ("\033[2J\033[1;1H"); 
             Map[pos[0]][pos[1]] = '0'; //Dejamos la posición I como 0 para que sea válida otra vez.   
             pos[0] = pos[0]; //Dejamos nuestra fila como 0
             pos[1] += 2; //Dejamos nuestra columna como 2, es decir, una casilla a la derecha de la pos actual
             pos[2] += 1;
             System.out.print("Te has movido a la posición ("+ pos[0] + ',' + pos[2] +") sobre el Switch c y has abierto la puerta C.\n\n\n\n");
             this.ActSwitch(Map, lista, 'c');
             return '1';
          }

          else
          {
             return '0';
          }
    }

    /******** Función: movUsuario ********
    Descripción: ejecuta función según la tecla ingresada por el jugador (movimiento) 
    Parámetros: string literal (entrada), posición actual, largo y ancho del mapa
    Retorno:  
    ****************************************/
    public char movUsuario(char[][] Map, int largo, int ancho, List<Elemento> lista)
    {
        //int x,y;
            Scanner in = new Scanner ( System.in );
            char tecla = in.next().charAt(0);

            //Pedimos un movimiento al usuario (ASWD)   

            if (pos[0] == largo-1 && pos[1] == ancho-2) // Esquina inferior derecha
            {
              if (tecla == 'x' || tecla == 'X') //Es decir, me quedo quieto.
              {
                 return dontMove(Map, lista);
              }

              else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
              {
                 System.out.print("\033[2J\033[1;1H"); 
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';   
              }

              else if (tecla == 'w' || tecla == 'W')
              {
                 return movUp(Map, lista); 
              }

              else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
              {
                 System.out.print ("\033[2J\033[1;1H"); 
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';   
              }

              else if (tecla == 'a' || tecla =='A')
              {
                return movLeft(Map,lista);
              }
            } 

            else if (pos[0] == 0 && pos[1] == 0) //Esquina superior izquierda
            {
                 if (tecla == 'x' || tecla == 'X')
                 {
                    return dontMove(Map,lista);
                 }

                 else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
                 {
                    return movRight(Map,lista);
                 }

                 else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
                 {
                    return movDown(Map,lista);
                 }
            
                 else if(tecla == 'w' || tecla == 'W')
                 {
                    System.out.print ("\033[2J\033[1;1H"); 
                    System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                    return '5';   
                 }

                 else if (tecla == 'a' || tecla == 'A')
                 {
                    System.out.print ("\033[2J\033[1;1H"); 
                    System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                    return '5';
                 }     
            }
            
            else if(pos[0] == 0 && pos[1] == ancho-2 ) // Esquina superior derecha
            {
              if (tecla == 'x' || tecla == 'X') //Es decir, me quedo quieto.
              {
                 return dontMove(Map, lista);
              }

              else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
              {
                 System.out.print ("\033[2J\033[1;1H"); 
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';   
              }

              else if (tecla == 'w' || tecla == 'W')
              {
                 System.out.print ("\033[2J\033[1;1H"); 
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';  
              }

              else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
              {
                 return movDown(Map, lista);   
              }

              else if (tecla == 'a' || tecla =='A')
              {
                return movLeft(Map, lista);
              }  
            }
            else if(pos[0] == largo-1 && pos[1] == 0) // Esquina inferior izquierda
            {
              if (tecla == 'x' || tecla == 'X') //Es decir, me quedo quieto.
              {
                 return dontMove(Map, lista);
              }

              else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
              {
                 return movRight(Map, lista);   
              }  

              else if (tecla == 'w' || tecla == 'W')
              {
                 return movUp(Map, lista); 
              }

              else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
              {
                 System.out.print ("\033[2J\033[1;1H"); 
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';      
              }

              else if (tecla == 'a' || tecla =='A')
              {
                 System.out.print ("\033[2J\033[1;1H"); 
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';   
              }  
            }
            else if (pos[0] != 0 && pos[1] == 0) //Cuando estoy en el (x,0)
            {
              
              if (tecla == 'x' || tecla == 'X') //Es decir, me quedo quieto.
              {
                 return dontMove(Map, lista);
              }

              else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
              {
                 return movRight(Map, lista);
              }
              
              else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
              {
                 return movDown(Map, lista);
              }   

              else if (tecla == 'w' || tecla == 'W') //Si presion la tecla W, es decir arriba....
              {
                 return movUp(Map, lista);
              }   

              else if (tecla == 'a' || tecla == 'A')
              {
                    System.out.print ("\033[2J\033[1;1H");   
                    System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                    return '5';
              } 
            }
            else if (pos[0] == largo-1 && pos[1] != 0) //Cuando estoy en el (9,x)
            {
              
              if (tecla == 'x' || tecla == 'X') //Es decir, me quedo quieto.
              {
                 return dontMove(Map, lista);
              }

              else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
              {
                 return movRight(Map, lista);
              }
              
              else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
              {
                 System.out.print ("\033[2J\033[1;1H");   
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';
              }   

              else if (tecla == 'w' || tecla == 'W') //Si presion la tecla W, es decir arriba....
              {
                 return movUp(Map, lista);
              }   

              else if (tecla == 'a' || tecla == 'A')
              {
                 return movLeft(Map, lista);
              } 
            }
            else if (pos[0] != 0 && pos[1] == ancho-2) //Cuando estoy en el (x, 18)
            {
              
              if (tecla == 'x' || tecla == 'X') //Es decir, me quedo quieto.
              {
                 return dontMove(Map, lista);
              }

              else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
              {
                 System.out.print ("\033[2J\033[1;1H");   
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';
              }
              
              else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
              {
                 return movDown(Map, lista);
              }   

              else if (tecla == 'w' || tecla == 'W') //Si presion la tecla W, es decir arriba....
              {
                 return movUp(Map, lista);
              }   

              else if (tecla == 'a' || tecla == 'A')
              {
                 return movLeft(Map, lista);
              } 
            }
            else if (pos[0] == 0 && pos[1] != 0) //En el caso cuando I está en el (0,x) x = cualquier número.
            {

              if (tecla == 'x' || tecla == 'X') //Es decir, me quedo quieto.
              {
                 return dontMove(Map, lista);
              }

              else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
              {

                 return movRight(Map, lista);
              }

              else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
              {
                 return movDown(Map, lista);
              }

              else if (tecla == 'w' || tecla == 'W')
              {
                 System.out.print ("\033[2J\033[1;1H"); 
                 System.out.print("Aquí no hay nada de nada, vuelva a intentarlo. (ﾉ◕ ヮ◕ )ﾉ*:･ﾟ✧\n\n\n\n");
                 return '5';   
              }

              else if (tecla == 'a' || tecla =='A')
              {
                return movLeft(Map, lista);
              }
            }   
            else if (pos[0] != 0 && pos[1] != 0 ) //Cuando estoy en el (x,y)
            {
              
              if (tecla == 'x' || tecla == 'X') //Es decir, me quedo quieto.
              {
                 return dontMove(Map, lista);
              }

              else if (tecla == 'd' || tecla == 'D') //Si presionamos la tecla D, es decir a la derecha...
              {
                 return movRight(Map, lista);
              }
                 
              else if (tecla == 's' || tecla == 'S') //Si presion la tecla S, es decir abajo....
              {
                 return movDown(Map, lista);
              }   

              else if (tecla == 'w' || tecla == 'W') //Si presion la tecla W, es decir arriba....
              {
                 return movUp(Map, lista);
              }   

              else if (tecla == 'a' || tecla =='A')
              {
                 return movLeft(Map, lista);
              }
            }
 
        return '1';
    }

    public int[] getPos()
    {
    	return pos;
    }

    public void setPos(int i, int j, int j2)
    {
    	pos[0] = i;
    	pos[1] = j;
    	pos[2] = j2;
    }
}
