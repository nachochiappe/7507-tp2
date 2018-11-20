package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Ofensiva;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.TableroS;

public abstract class Edificio {
	//vida
	public int vida;
	Posicion posicionInicial;
	Posicion posicionFinal;
	
	public boolean estaVacio() {
		return false;
	}
	
	public void reparate(Aldeano aldeano) {
	   
    }
	
	public void crearUnidad(Unidad unidad) throws FueraDelMapaException {
		TableroS.getInstance().poner(unidad, unidad.getPosicion(), unidad.getPosicion());
	}
	
	public Posicion obtenerPosicionInicial() {
		return posicionInicial;
	}
	public Posicion obtenerPosicionFinal() {
		return posicionFinal;
	}

	public int obtenerVida() {
		return this.vida;
	}
	
	public void recibeDanioDe(Ofensiva ofensivo) {
		int danio = ofensivo.cuantoDanioAEdificio();
		this.vida = this.vida - danio;
	}
}