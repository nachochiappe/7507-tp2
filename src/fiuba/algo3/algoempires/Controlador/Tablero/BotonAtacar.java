package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

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
