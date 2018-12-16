package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearPlazaCentral implements EventHandler<ActionEvent>  {

	Aldeano aldeano;
	ContenedorPantallaDeJuego contenedorPantallaDeJuego;

	public BotonCrearPlazaCentral(ContenedorPantallaDeJuego contenedorPantallaDeJuego, Aldeano aldeano) {
		this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
		this.aldeano = aldeano;
	}

	@Override
	public void handle(ActionEvent event) {
		this.contenedorPantallaDeJuego.vistaTablero.iniciarConstruccion(new PlazaCentral(), aldeano, contenedorPantallaDeJuego);
	}

	

}
