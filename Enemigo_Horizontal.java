public class Enemigo_Horizontal extends Enemigo_Lineal {

    public Enemigo_Horizontal(char tipo, int maxmov, int pasos, char direccion, int x, int y, char nombre) {
        super(tipo, maxmov, pasos, direccion, y, x, nombre);
    }
    
    
    
    @Override
    public char siguiente_movimiento(char[][] map, int largo, int ancho){
        int x = this.getX();
        int y = this.getY();

        if(this.getMaxmov() != this.getPasos())
        {
            if(this.getDireccion() == 'R' && x+2 < ancho)
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
                    return '1';
                }
                

                else if(map[y][x+2] == '*')
                {
                                        System.out.println("Hola1");
                    return '0';
                    
                }

                else
                {
                    if(map[y][x-2] == '*')
                    {
                        return '0';
                    }

                    this.setDireccion('L');
                    if(map[y][x] != '*')
                    {
                        map[y][x] = '0';    
                    }
                    map[y][x-2] = this.getNombre();
                    this.setX(x-2);
                    this.setPasos(0);
                    this.setPasos(this.getPasos()+1);
                    return '1';
                }
            }

            else if(this.getDireccion() == 'R' && x+2 >= ancho)
            {
                this.setDireccion('L');
                if(map[y][x] != '*')
                {
                    map[y][x] = '0';    
                }
                map[y][x-2] = this.getNombre();
                this.setX(x-2);
                this.setPasos(0);
                this.setPasos(this.getPasos()+1);
                return '1';    
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
                    return '1';
                }

                else if(map[y][x-2] == '*')
                {
                    return '0'; 
                } 

                else 
                {
                    if(map[y][x+2] == '*')
                    {
                        return '0'; 
                    }

                    this.setDireccion('R'); 
                    if(map[y][x] != '*')
                    {
                        map[y][x] = '0';    
                    }
                    map[y][x+2] = this.getNombre();
                    this.setX(x+2);
                    this.setPasos(0);
                    this.setPasos(this.getPasos()+1);
                    return '1';
                }   
            }


            else if(this.getDireccion() == 'L' && x-2 < 0)
            {
                this.setDireccion('R');
                if(map[y][x] != '*')
                {
                    map[y][x] = '0';    
                }
                map[y][x+2] = this.getNombre();
                this.setX(x+2);
                this.setPasos(0);
                this.setPasos(this.getPasos()+1);
                return '1';    
            } 
        }
        
        else
        {
            if(this.getDireccion() == 'L')
            {
                this.setDireccion('R');
                if(map[y][x] != '*')
                {
                    map[y][x] = '0';    
                }
                map[y][x+2] = this.getNombre();
                this.setX(x+2);
                this.setPasos(0);
                this.setPasos(this.getPasos()+1);
                return '1';    
            }
            
            else if(this.getDireccion() == 'R')
            {
                this.setDireccion('L');
                if(map[y][x] != '*')
                {
                    map[y][x] = '0';    
                }
                map[y][x-2] = this.getNombre();
                this.setX(x-2);
                this.setPasos(0);
                this.setPasos(this.getPasos()+1);
                return '1'; 
            }
        }
        
              
        return '1';
    }


}
