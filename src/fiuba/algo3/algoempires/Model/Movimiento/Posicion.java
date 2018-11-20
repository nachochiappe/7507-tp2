package fiuba.algo3.algoempires.Model.Movimiento;

public class Posicion {

    private int x;
    private int y;


	public Posicion(int posicionX, int posicionY) {
		this.x = posicionX;
		this.y = posicionY;
	}

    public Posicion mismosValores(Posicion posicionInicial) {
    	int inicio = posicionInicial.getPosicionX();
    	int fin = posicionInicial.getPosicionY();
    	Posicion retorno = new Posicion(inicio,fin);
    	return retorno;
    }

    public boolean dentroDe(int ancho, int alto) {
        if (this.x > ancho || this.x < 0 || this.y > alto || this.y < 0) {
            return false;
        }
        return true;
    }


    public int getPosicionX() {
        return this.x;
    }

    public int getPosicionY() {
        return this.y;
    }

	public void aumentarAncho(int ancho) {
		this.x = x+ancho;
	}

	public void aumentarAlto(int alto) {
		this.y = y + alto;
	}

	public boolean mismaPosicion(Posicion posicion) {
		if( this.x == posicion.getPosicionX() && this.y == posicion.getPosicionY()) 
			return true;
		return false;
	}
	
	public boolean estaEnRango(Posicion posicion, int rango) {
		
		for(int i = this.x - rango; i <= this.x + rango ; i++) {
			for(int j = this.y - rango; j <= this.y + rango; j++) {
				Posicion posicionEnBusqueda = new Posicion(i,j);
				if(posicion.mismaPosicion(posicionEnBusqueda))
					return true;
			}
		}
		return false;
		
	}
	
}
