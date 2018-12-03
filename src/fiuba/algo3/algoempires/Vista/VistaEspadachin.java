package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VistaEspadachin  extends VistaUnidad{

	
    public VistaEspadachin(Unidad espadachin, VBox unitVBox, BorderPane borderPane) {
    	this.unidad = espadachin;
    	this.borderPane = borderPane;
    	this.unitVBox = unitVBox;
    	this.imagenUnidad = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Unidades/Espadachin/EspadachinS.png");
    	inicializar();
    }
	@Override
	protected void mostrarMenuUnidad() {
		// acá debería chequear si la unidad pertenece al equipo del jugador
    	// si no es suya, tiene que mostrar solo la vida y no el menú de opciones
 
    	ImageView imageView = new ImageView();
		imageView.setImage(this.imagenUnidad);
		Button botonMoverUnidad = new Button("Mover Unidad");
    	Button botonAtacar = new Button("Atacar");
		mostrarMenu(imageView, "Espadachin", botonMoverUnidad, botonAtacar);
	}

}
