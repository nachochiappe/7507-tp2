package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public abstract class VistaPosicionable extends StackPane {
	public abstract void inicializar();

	public void agregarATablero(VistaTablero vistaTablero, Posicionable posicionable, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public abstract Posicion getPosicion();


	public abstract void setearClickListener(EventHandler<MouseEvent> eventEventHandler);

	public abstract void esperarConstruccion(ContenedorPantallaDeJuego contenedor, Aldeano aldeano, Edificio edificio, Posicion posicion);
	
	public abstract void esperarCreacionUnidad(ContenedorPantallaDeJuego contenedor, Edificio edificio, Unidad unidad, Posicion posicion);

}
