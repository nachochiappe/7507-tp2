package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearArmaDeAsedio implements EventHandler<ActionEvent>  {

	private Castillo castillo;
	private ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	private Unidad unidad;

	public BotonCrearArmaDeAsedio(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Castillo castillo) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.castillo = castillo;
		this.unidad = new ArmaDeAsedio(castillo.getJugador(), null);
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.contenedorPantallaDeJuego.getVistaTablero().iniciarCreacionUnidad(castillo, unidad, contenedorPantallaDeJuego);
	}
}