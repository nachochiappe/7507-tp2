package fiuba.algo3.algoempires.Vista;

import java.util.ArrayList;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaPlazaCentral extends VistaEdificio {

	public VistaPlazaCentral(Edificio plazaCentral, VBox unitVBox, BorderPane borderPane) {
    	this.edificio = plazaCentral;
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