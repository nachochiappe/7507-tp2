package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;



public class Cuartel extends Edificio implements Construible {

	private static final int MAX_VIDA = 250;
	static final int COSTO=50;
	public int vida;
	private static final int HP_REGEN = 50;
	private static final int TURNOSCONTRUCCION=3;
	private static final int OCUPA_ANCHO = 2;
	private static final int OCUPA_ALTO = 2;

	public Cuartel() {
		this.vida = MAX_VIDA;
	}


	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}
	public int getVida() {
		return vida;
	}

	@Override
	public int getHpRegen() {
		return HP_REGEN;
	}

	@Override
	public int getMaxHp() {
		return MAX_VIDA;
	}

	@Override
	public int getTurnosConstruccion() {
		return TURNOSCONTRUCCION;
	}

	@Override
	public int getAlto() {
		return OCUPA_ALTO;
	}

	@Override
	public int getAncho() {
		return OCUPA_ANCHO;
	}


	public Arquero crearArquero(Jugador jugador,Posicion posicion) throws OroInsuficienteException, ExcedeTopePoblacionalException {
		if (jugador.getOro()<75) throw new OroInsuficienteException();
		jugador.modificarOro(-75);
		Arquero arquero = new Arquero(jugador,posicion);
		jugador.agregarUnidad(arquero);
		return arquero;
	}



	public Espadachin crearEspadachin(Jugador jugador,Posicion posicion) throws OroInsuficienteException, ExcedeTopePoblacionalException {
		if (jugador.getOro()<100) throw new OroInsuficienteException();
		jugador.modificarOro(-100);
		Espadachin espadachin = new Espadachin(jugador,posicion);
		jugador.agregarUnidad(espadachin);
		return espadachin;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) {
		this.recibeDanioDe(ofensivo);
	}

}

