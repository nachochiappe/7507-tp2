package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.List;

public abstract class VistaPosicionable extends StackPane {
	public abstract void inicializar();

	public abstract void agregarATablero(VistaTablero vistaTablero, Posicionable posicionable, int i, int j);


	public abstract Posicion getPosicion();


	public void setearClickListener(EventHandler<MouseEvent> eventEventHandler) {
		this.setOnMouseClicked(eventEventHandler);
	}

	public abstract void esperarConstruccion(ContenedorPantallaDeJuego contenedor, Aldeano aldeano, Edificio edificio, Posicion posicion, List<VistaPosicionable> vistaPosicionables);
	public abstract Posicionable getPosicionable();
	public abstract void esperarCreacionUnidad(ContenedorPantallaDeJuego contenedor, Edificio edificio, Unidad unidad, Posicion posicion);
	public abstract void mostrarSeleccionable();
	public abstract void ocultarSeleccionable();

	public abstract void esperarAtaque(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Ofensiva ofensiva, Posicion posicion);
	public abstract void esperarConstruccionReparacion(Aldeano aldeano, ContenedorPantallaDeJuego contenedorPantallaDeJuego);
}
