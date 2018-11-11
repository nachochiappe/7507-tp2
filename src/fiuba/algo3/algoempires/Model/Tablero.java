package fiuba.algo3.algoempires.Model;

public class Tablero {
	
	private int [][] matriz =  new int[ANCHO][ALTO];;
	static final int ANCHO = 20;
	static final int ALTO = 20;
	
	public void inicializarTablero() {
		for (int i=0; i<ANCHO; i++) {
			for(int j=0; j<ALTO; j++) {
				matriz[i][j] = 0;
			}
		}
	}

	public boolean estasVacio() {
		for (int i=0; i<ANCHO; i++) {
			for(int j=0; j<ALTO; j++) {
				if(matriz[i][j] != 0) return false;
			}
		}
		return true;
	}

	public void construir(Construible construible, int cordX, int cordY) {
		construible.construiteEn(cordX,cordY);
		
	}
	
	public int getAncho() {
		return ANCHO;
	}
	
	public int getAlto() {
		return ALTO;
	}

	public static int ancho() {
		return ANCHO;
	}

	public static int alto() {
		return ANCHO;
	}
}