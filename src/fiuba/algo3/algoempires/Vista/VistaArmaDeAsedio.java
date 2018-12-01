package fiuba.algo3.algoempires.Vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VistaArmaDeAsedio extends VistaUnidad{

    public VistaArmaDeAsedio(VBox unitVBox, BorderPane borderPane) {
    	this.borderPane = borderPane;
    	this.unitVBox = unitVBox;
    	this.imagenUnidad = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/ArmaDeAsedio/ArmaDeAsedioS.png");
    	inicializarUnidad();
    }
	
	@Override
	protected void mostrarMenuUnidad() {
		
    	ImageView imageView = new ImageView();
		imageView.setImage(this.imagenUnidad);
		Button botonMoverUnidad = new Button("Mover Unidad");
    	Button botonAtacar = new Button("Atacar");
    	Button botonToggleFijar = new Button("Toggle Fijar");
		mostrarMenu(imageView, "Arma de asedio", botonMoverUnidad, botonAtacar, botonToggleFijar);
		
	}

}
