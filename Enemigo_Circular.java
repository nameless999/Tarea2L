public abstract class Enemigo_Circular extends Enemigo {
  
    public Enemigo_Circular(char tipo, int maxmov, int pasos, char direccion, int y, int x, char nombre) {
        super(tipo, maxmov, pasos, direccion, y, x, nombre);
    }
    
    @Override
    public abstract char siguiente_movimiento(char[][] map, int largo, int ancho);    
    
}

