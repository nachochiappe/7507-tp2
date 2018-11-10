package fiuba.algo3.algoempires.Model;

import java.util.LinkedList;

public class AlgoEmpires {
	
	private LinkedList jugadores;
	private Tablero tablero;
	
	public void inicializarTablero() {
		tablero = new Tablero();
		tablero.inicializarTablero();
	}

	public boolean elMapaEstaVacio() {
		return tablero.estasVacio();
	}

	public void agregarPlazaCentralInicial() {
		Construible plazaCentral = new PlazaCentral();
		tablero.construir(plazaCentral,0,0);
	}

}
