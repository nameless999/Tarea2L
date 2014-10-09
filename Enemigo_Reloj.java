public class Enemigo_Reloj extends Enemigo_Circular {

    public Enemigo_Reloj(char tipo, int maxmov, int pasos, char direccion, int y, int x, char nombre) {
        super(tipo, maxmov, pasos, direccion, x, y, nombre);
    }

    
    @Override
    public char siguiente_movimiento(char[][] map, int largo, int ancho) {
        int x = this.getX();
        int y = this.getY();

        if(this.getMaxmov() != this.getPasos())
        {
            if(this.getDireccion() == 'R' &&  x+2 < ancho)
            {
                if (map[y][x+2] == '0')
                {
                    if(map[y][x] != '*')
                    {
                        map[y][x] = '0';    
                    }
                    map[y][x+2] = this.getNombre();
                    this.setX(x+2); 
                    this.setPasos(this.getPasos()+1);
                       
                    if(this.getPasos() == 2)
                    {
                        this.setPasos(0);
                        this.setDireccion('D');
                    }
                       
                    return '1';
                }

                else if(map[y][x+2] == '*')
                {
                    return '0';
                }    
            }
            
            else if(this.getDireccion() == 'D' && y+1 < largo)
            {        
                if(map[y+1][x] == '0')
                {
                    if(map[y][x] != '*')
                    {
                        map[y][x] = '0';    
                    }
                    map[y+1][x] = this.getNombre();
                    this.setY(y+1);
                    this.setPasos(this.getPasos()+1);
                    if(this.getPasos() == 2)
                    {
                        this.setPasos(0);
                        this.setDireccion('L');
                    }
                    return '1';
                }

                else if(map[y+1][x] == '*')
                {
                    return '0'; 
                }
                
                
            }
            
            else if(this.getDireccion() == 'L' && x-2 >= 0)
            {              
                if(map[y][x-2] == '0')
                {
                    if(map[y][x] != '*')
                    {
                        map[y][x] = '0';    
                    }
                    map[y][x-2] = this.getNombre();
                    this.setX(x-2);
                    this.setPasos(this.getPasos()+1);
                    if(this.getPasos() == 2)
                    {
                        this.setPasos(0);
                        this.setDireccion('U');
                    }
                    return '1';
                }

                else if(map[y][x-2] == '*')
                {
                    return '0'; 
                }
                
                
            }
            
            if(this.getDireccion() == 'U' && y-1 >= 0)
            {
                if(map[y-1][x] == '0')
                {
                        if(map[y][x] != '*')
                        {
                            map[y][x] = '0';    
                        }

                        map[y-1][x] = this.getNombre();
                        this.setY(y-1); 
                        this.setPasos(this.getPasos()+1);
                        if(this.getPasos() == 2)
                        {
                            this.setPasos(0);
                            this.setDireccion('R');
                        }
                        return '1';
                }

                else if(map[y-1][x] == '*')
                {
                    return '0'; 
                }
            }              
        }
        return 0;
    }
}
        

  
