package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.Arquero;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearArquero implements EventHandler<ActionEvent>  {

	private Cuartel cuartel;
	private ContenedorPantallaDeJuego contenedorPantallaDeJuego;
	private Unidad unidad;
	
	public BotonCrearArquero(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Cuartel cuartel) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.cuartel = cuartel;
		this.unidad = new Arquero(cuartel.getJugador(), null);
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.contenedorPantallaDeJuego.getVistaTablero().iniciarCreacionUnidad(cuartel, unidad, contenedorPantallaDeJuego);
		this.contenedorPantallaDeJuego.leftBorderPane.setCenter(new SeleccionableHUD(contenedorPantallaDeJuego, cuartel, "Crear Aldeano"));
	}
}
