package fiuba.algo3.algoempires.Model;

public class Posicion {

	private int x;
	private int y;
	
	public Posicion(int posicionX, int posicionY) {
		this.x = posicionX;
		this.y = posicionY;
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
}
