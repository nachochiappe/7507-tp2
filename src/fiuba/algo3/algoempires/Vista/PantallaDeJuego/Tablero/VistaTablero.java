package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoempires.Controlador.Tablero.Celdas.CeldaCrearEdificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import javafx.scene.layout.GridPane;

public class VistaTablero extends GridPane{

	List<Posicionable> posicionablesDibujados;
	List<VistaPosicionable> posicionables;

	public VistaTablero() {
	}

	
	public void agregar(VistaUnidad vistaUnidad) {

		this.add(vistaUnidad,vistaUnidad.getPosY(),vistaUnidad.getPosX());
	}

	public void iniciarTablero(ContenedorPantallaDeJuego contenedor, Jugador jugadorActual) {
    	Tablero tablero = Tablero.getInstance();
    	posicionables = new ArrayList<>();
		posicionablesDibujados = new ArrayList<>();
    	for (int i = 0; i < tablero.getAncho(); i++) {
    		for (int j = 0; j < tablero.getAlto(); j++) {
    			Posicionable posicionable = tablero.obtenerPosicionable(i, j);
    			if (!(posicionablesDibujados.contains(posicionable))) {
    				VistaPosicionable vistaPosicionable = posicionable.getView(contenedor, jugadorActual);
        			vistaPosicionable.agregarATablero(this, posicionable, i, j);
        			posicionablesDibujados.add(posicionable);
        			posicionables.add(vistaPosicionable);
    			}
    		}
    	}		
	}

	public void iniciarConstruccion(Edificio e, Aldeano aldeano, ContenedorPantallaDeJuego contenedorPantallaDeJuego) {
		for (VistaPosicionable vistaPosicionable: posicionables) {
			vistaPosicionable.esperarConstruccion(contenedorPantallaDeJuego, aldeano, e, vistaPosicionable.getPosicion());
		}
	}
}
