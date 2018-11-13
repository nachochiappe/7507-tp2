package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.ConstruccionFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class PlazaCentral extends Edificio implements Construible, Posicionable{

	private static final int MAX_VIDA = 450;
	public int vida = MAX_VIDA;
	static final int COSTO=100;
	static final int TURNOSCONTRUCCION=3;
	static final int OCUPA_ANCHO = 2;
	static final int OCUPA_ALTO = 2;
	
	public PlazaCentral(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public void construiteEn(Posicion posicionDeInicio) throws ConstruccionFueraDelMapaException {
		posicionInicial = posicionDeInicio;
		Posicion posicionDeFin = posicionInicial.mismosValores(posicionInicial);
		posicionDeFin.aumentarAncho(OCUPA_ANCHO-1);
		posicionDeFin.aumentarAlto(OCUPA_ALTO-1);
		posicionFinal = posicionDeFin;
		try {
			this.tablero.poner(this, posicionDeInicio, posicionDeFin);
		}
		catch (ArrayIndexOutOfBoundsException e){
			throw new ConstruccionFueraDelMapaException("La construcción está fuera del mapa");
		};
	}
		
	public void reparate(Aldeano aldeano) {
		if (this.vida < MAX_VIDA) {
			this.vida += 25;
		}
		else {
			aldeano.deshabilitarReparacion();
		}
	}
	
	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}
	public int getVida() {
		return vida;
	}
	
}
