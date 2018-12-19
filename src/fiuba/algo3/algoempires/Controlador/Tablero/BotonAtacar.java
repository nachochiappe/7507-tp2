package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacar  implements EventHandler<ActionEvent>  {

	private ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	private Ofensiva ofensiva;
	
	public BotonAtacar(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Ofensiva ofensiva) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.ofensiva = ofensiva;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		this.contenedorPantallaDeJuego.getVistaTablero().iniciarAtaque(ofensiva, contenedorPantallaDeJuego);
	}

}
