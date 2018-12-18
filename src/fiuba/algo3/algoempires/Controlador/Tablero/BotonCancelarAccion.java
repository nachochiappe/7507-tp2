package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCancelarAccion implements EventHandler<ActionEvent>  {

	private ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	private Posicionable posicionable;

	public BotonCancelarAccion(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Posicionable posicionable) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.posicionable = posicionable;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.contenedorPantallaDeJuego.leftBorderPane.setCenter(new SeleccionableHUD(contenedorPantallaDeJuego, posicionable));
		this.contenedorPantallaDeJuego.vistaTablero.iniciarTablero(contenedorPantallaDeJuego, contenedorPantallaDeJuego.algoEmpires.getJugadorActual());
	}
	
}
