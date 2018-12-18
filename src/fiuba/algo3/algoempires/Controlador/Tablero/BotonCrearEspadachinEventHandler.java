package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Espadachin;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearEspadachinEventHandler  implements EventHandler<ActionEvent>  {

	private Cuartel cuartel;
	private ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	private Unidad unidad;
	
	public BotonCrearEspadachinEventHandler(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Cuartel cuartel) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.cuartel = cuartel;
		this.unidad = new Espadachin(cuartel.getJugador(), null);
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.contenedorPantallaDeJuego.getVistaTablero().iniciarCreacionUnidad(cuartel, unidad, contenedorPantallaDeJuego);
	}
}