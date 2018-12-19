package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAldeanoCancelarAccion implements EventHandler<ActionEvent>  {

	Aldeano aldeano;
	ContenedorPantallaDeJuego contenedorPantallaDeJuego;

	public BotonAldeanoCancelarAccion(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Aldeano aldeano) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.aldeano = aldeano;
	}

	@Override
	public void handle(ActionEvent event) {
		this.aldeano.terminarAccion();
		this.contenedorPantallaDeJuego.leftBorderPane.setCenter(new SeleccionableHUD(contenedorPantallaDeJuego, aldeano));
	}

	

}
