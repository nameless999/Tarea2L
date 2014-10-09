
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Game {
    

    public static char movEnemigos(List<Elemento> lista, char[][] map, int largo,int ancho)
    {
        char a;
        for (Elemento objeto : lista) {
            if (objeto.getLabel() == 'E') {
                
                Enemigo enemigo = (Enemigo) objeto;
                a = enemigo.siguiente_movimiento(map, largo, ancho);
                if(a == '0')
                {
                    return '0';
                }
            }
        }
    return '1';
    }

    static List<Elemento> lista;

    public static void main(String[] args) {
        char[][] MapaActual = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        char accion = 0;
     
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("entrada.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            Usuario user = new Usuario();
            lista = new ArrayList<Elemento>();
            // Lectura del fichero
            int ancho = Integer.parseInt(br.readLine())*2;
            int largo = Integer.parseInt(br.readLine());
            Mapa mapa = new Mapa(ancho,largo);
            MapaActual = mapa.Map(ancho,largo,br,user);
            lista = Elemento.crearListaEnemigosSwitch(MapaActual, largo, ancho);
       
            System.out.println(MapaActual[4][5]);
            
            System.out.print("\033[2J\033[1;1H");
            System.out.print("▄︻̷̿┻̿═━一  Bienvenido a Death Dungeon V.1.0\n\n");
            System.out.print("Instrucciones del juego: \n\n");
            System.out.print("    1. Su misión es llegar desde el punto inicial I, a el punto final F.\n" );
            System.out.print("    2. Para moverse utilizar: A (Izquierda), S (Abajo), D (Derecha), W (Arriba).\n" );
            System.out.print("    3. El número '0' en el mapa significa que usted puede moverse a esa\n       posición.\n" );
            System.out.print("    4. El número '1' en el mapa significa que hay una muralla, es decir, no se\n       puede pasar.\n" );
            System.out.print("    5. Los enemigos están listados del 2 al 9.\n\n" );
           
            char tecla = 0;
            while((int)tecla != 10)
            {
                System.out.print("(☞ﾟヮﾟ)☞ ¡Presiona Enter dos veces para comenzar el juego! ☜(ﾟヮﾟ☜)");
                tecla = (char)System.in.read();
            }

            System.out.print("\033[2J\033[1;1H");  
            System.out.print("El juego ha comenzado...no mueras ♪└|∵|┐♪└|∵|┘♪┌|∵|┘♪ ♪└|∵┌|└| ∵ |┘|┐∵|┘\n\n\n\n");

            mapa.PrintMap(ancho,largo);
            System.out.print("Es su turno, por favor haga un movimiento.\n");
            
            while(true)
            {
                accion = user.movUsuario(MapaActual, largo, ancho, lista); 

                if(accion == '1')
                {
                   accion = movEnemigos(lista, MapaActual, largo, ancho);
                }
                if(accion == '5')
                {
                    mapa.PrintMap(ancho,largo); 
                    System.out.print("Es su turno, por favor haga un movimiento.\n"); 
                    continue;  
                }

                switch(accion)
                {
                    case '0':
                       System.out.print ("\033[2J\033[1;1H");  
                       System.out.print("Juego terminado, más suerte para la próxima.\n");
                       System.exit(0);
                       break;

                    case '1':

                       mapa.PrintMap(ancho, largo);
                       System.out.print("Es su turno, por favor haga un movimiento.\n");
                       break;

                    case '2':
                        System.out.print ("\033[2J\033[1;1H");  
                       System.out.print("Has ganado, felicitaciones.\n");
                       System.exit(0);
                       break;
                    default:
                       break;
                    }  
            }
       }
            catch(Exception e){
             e.printStackTrace();
            }finally{
             // En el finally cerramos el fichero, para asegurarnos
             // que se cierra tanto si todo va bien como si salta 
             // una excepcion.
             try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
             }catch (Exception e2){ 
                e2.printStackTrace();
             }
            }
    }     
}
    

