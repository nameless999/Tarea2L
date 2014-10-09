class Puerta extends Elemento
{
	private char estado;
	private int x;
	private int y;  	

     
	/******** Función: crearPuerta  ********
	Descripción: crea una estructura de tipo tPuerta
	Parámetros:  nombre de la puerta, x e y que son la posición de donde se encuentra-
	Retorno: estructura de tipo tPuerta.
	****************************************/
	public Puerta(char nombre, int x,int y, char label)
	{
            super(label,nombre);
            this.x = x;
            this.y = y;
            this.estado = '1';
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

	
