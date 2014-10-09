public abstract class Enemigo extends Elemento
{
    private char tipo;
    private int maxmov;
    private int pasos;
    private char direccion;
    private int y;
    private int x;
    private char nombre;

    public Enemigo(char tipo, int maxmov, int pasos, char direccion, int y, int x, char nombre)
    {
        super('E',nombre);
    	this.tipo = tipo;
    	this.maxmov = maxmov;
    	this.pasos = pasos;
    	this.direccion = direccion;
    	this.y = y;
    	this.x= x;
    	this.nombre = nombre;
    }

    public abstract char siguiente_movimiento(char[][] map, int largo, int ancho);
    
        
        public char getTipo() {
            return tipo;
        }

        public void setTipo(char tipo) {
            this.tipo = tipo;
        }

        public int getMaxmov() {
            return maxmov;
        }

        public void setMaxmov(int maxmov) {
            this.maxmov = maxmov;
        }

        public int getPasos() {
            return pasos;
        }

        public void setPasos(int pasos) {
            this.pasos = pasos;
        }

        public char getDireccion() {
            return direccion;
        }

        public void setDireccion(char direccion) {
            this.direccion = direccion;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public char getNombre() {
            return nombre;
        }

        public void setNombre(char nombre) {
            this.nombre = nombre;
        }
}


