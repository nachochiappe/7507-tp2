package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.ArrayList;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VistaCuartel extends VistaEdificio {

	public VistaCuartel(ContenedorPantallaDeJuego contenedor, Edificio cuartel, Jugador jugadorActual) {
		super(contenedor, cuartel, jugadorActual);
    	this.imagenEdificio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralConstruida.png");
    	inicializar();
    }
	
	@Override
	protected void mostrarMenuEdificio() {
		// TODO Auto-generated method stub
		
	}
}
