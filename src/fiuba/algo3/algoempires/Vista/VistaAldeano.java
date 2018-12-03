package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;



public class VistaAldeano extends VistaUnidad{


    public VistaAldeano(Unidad aldeano, VBox unitVBox, BorderPane borderPane) {
    	this.unidad = aldeano;
    	this.borderPane = borderPane;
    	this.unitVBox = unitVBox;
    	this.imagenUnidad = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Aldeano/AldeanoI.png");
    	inicializar();
    }
    
    @Override
    protected void mostrarMenuUnidad() {
		// acá debería chequear si la unidad pertenece al equipo del jugador
    	// si no es suya, tiene que mostrar solo la vida y no el menú de opciones
    	
    	Image imagenUnidad = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Aldeano/AldeanoI.png");
		ImageView imageView = new ImageView();
		imageView.setImage(imagenUnidad);
		Button botonMoverUnidad = new Button("Mover Unidad");
    	Button botonConstruirPlazaCentral = new Button("Construir Plaza Central");
    	Button botonConstruirCuartel = new Button("Construir Cuartel");
    	Button botonReparar = new Button("Reparar");
    	mostrarMenu(imageView, "Aldeano", botonMoverUnidad, botonConstruirPlazaCentral, botonConstruirCuartel, botonReparar);
    	botonMoverUnidad.setOnMouseClicked(e -> MostrarMenuDeMovimiento());
	} 

}
