package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import java.util.ArrayList;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VistaCuartel extends VistaEdificio {

	public VistaCuartel(Edificio cuartel, VBox unitVBox, BorderPane borderPane, Jugador jugadorActual) {
    	this.edificio = cuartel;
    	this.jugadorActual = jugadorActual;
    	this.anchoEdificio = this.edificio.getAncho();
    	this.altoEdificio = this.edificio.getAlto();
    	this.borderPane = borderPane;
    	this.unitVBox = unitVBox;
    	this.imagenEdificio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralConstruida.png");
    	this.stackPanes = new ArrayList<>();
    	this.writableImages = new ArrayList<>();
    	inicializar();
    }
	
	@Override
	protected void mostrarMenuEdificio() {
		// TODO Auto-generated method stub
		
	}
}
