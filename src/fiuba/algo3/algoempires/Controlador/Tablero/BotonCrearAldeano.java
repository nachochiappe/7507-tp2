package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonCrearAldeano implements EventHandler<ActionEvent>  {

	private PlazaCentral plazaCentral;
	private ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	private Unidad unidad;
	
	public BotonCrearAldeano(ContenedorPantallaDeJuego contenedorPantallaDeJuego, PlazaCentral plazaCentral) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.plazaCentral = plazaCentral;
		this.unidad = new Aldeano(plazaCentral.getJugador(), null);
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.contenedorPantallaDeJuego.getVistaTablero().iniciarCreacionUnidad(plazaCentral, unidad, contenedorPantallaDeJuego);
		this.contenedorPantallaDeJuego.leftBorderPane.setCenter(new SeleccionableHUD(contenedorPantallaDeJuego, plazaCentral, "Crear Aldeano"));
	}
	
}
