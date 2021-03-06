public class Enemigo_Vertical extends Enemigo_Lineal {

    public Enemigo_Vertical(char tipo, int maxmov, int pasos, char direccion, int x, int y, char nombre) {
        super(tipo, maxmov, pasos, direccion, y, x, nombre);
    }
    
    @Override
    public char siguiente_movimiento(char[][] map, int largo, int ancho)
    {
        int x = this.getX();
        int y = this.getY();
        
        if(this.getMaxmov() != this.getPasos())
        {
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
                        return '1';
                }

                else if(map[y-1][x] == '*')
                {
                    return '0'; 
                }

                else 
                {       
                    if(map[y+1][x] == '*')
                    {
                        return '0'; 
                    }

                    this.setDireccion('D');
                    map[y+1][x] = this.getNombre();
                    map[y][x] = '0';
                    this.setY(y+1);
                    this.setPasos(0);
                    this.setPasos(this.getPasos()+1);
                    return '1';
                }
            }

            else if(this.getDireccion() == 'U' && y-1 < 0)
            {
                
                
                if(map[y+1][x] == '*')
                {
                    return '0'; 
                }
                
                this.setDireccion('D');
                
                map[y][x] = '0';    
                map[y+1][x] = this.getNombre();
                this.setY(y+1);
                this.setPasos(0);
                this.setPasos(this.getPasos()+1);
                return '1';
            }
            
            else if(y+1 == largo && this.getDireccion() == 'D')
            {
                if(map[y-1][x] == '*' )
                {
                    return '0'; 
                }
                
                this.setDireccion('U');
                
                if(map[y][x] != '*')
                {
                    map[y][x] = '0';    
                }
                
                map[y-1][x] = this.getNombre();
                this.setY(y-1);
                this.setPasos(0);
                this.setPasos(this.getPasos()+1);
                return '1';
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
                    return '1';
                }

                else if(map[y+1][x] == '*')
                {
                    return '0'; 
                }

                else
                {
                    if(map[y-1][x] == '*')
                    {
                        return '0'; 
                    }

                    this.setDireccion('U');

                    if(map[y][x] != '*')
                    {
                        map[y][x] = '0';    
                    }
                    map[y-1][x] = this.getNombre();
                    this.setY(y-1);
                    this.setPasos(0);
                    this.setPasos(this.getPasos()+1);
                    return '1';
                }   
            }
        }
        
        else
        {
            if(this.getDireccion() == 'U')
            {
                if(map[y+1][x] == '*')
                {
                    return '0'; 
                }
                
                this.setDireccion('D');
                
                map[y][x] = '0';    
                map[y+1][x] = this.getNombre();
                this.setY(y+1);
                this.setPasos(0);
                this.setPasos(this.getPasos()+1);
                return '1';
            }
            
            else if(this.getDireccion() == 'D')
            {
                this.setDireccion('U');
                if(map[y][x] != '*')
                {
                    map[y][x] = '0';    
                }
                map[y-1][x] = this.getNombre();
                this.setY(y-1);
                this.setPasos(0);
                this.setPasos(this.getPasos()+1);
                return '1';
            }
        }
        
        
        
    return '1';
    }
    
    
    
    
    
    
    
    
    
    
}
