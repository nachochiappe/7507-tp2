package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConstruirReparar implements EventHandler<ActionEvent>  {

	private ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	private Aldeano aldeano;

	public BotonConstruirReparar(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Aldeano aldeano) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.aldeano = aldeano;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		this.contenedorPantallaDeJuego.vistaTablero.iniciarConstruccionReparacion(aldeano, contenedorPantallaDeJuego);
		this.contenedorPantallaDeJuego.leftBorderPane.setCenter(new SeleccionableHUD(contenedorPantallaDeJuego, aldeano, "Construir/Reparar"));
	}

}
