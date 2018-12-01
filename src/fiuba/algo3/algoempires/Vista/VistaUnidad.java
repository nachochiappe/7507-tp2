package fiuba.algo3.algoempires.Vista;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class VistaUnidad extends StackPane{
    protected Unidad unidad;
    protected VBox unitVBox;
    protected Image imagenUnidad;
	protected BorderPane borderPane;
	
	protected abstract void mostrarMenuUnidad();
	
    public int getPosX() {
    	return unidad.getPosicion().getPosicionX();
    }
    
    public int getPosY() {
    	return unidad.getPosicion().getPosicionY();
    }
    
    protected void mostrarMenu(ImageView imageView, String _nombre, Button...buttons) {
    	this.unitVBox = new VBox(20);
    	this.unitVBox.setAlignment(Pos.TOP_CENTER);
    	this.unitVBox.setPadding(new Insets(20));
		imageView.setFitWidth(50);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		imageView.setCache(true);
		this.unitVBox.getChildren().add(imageView);
		
		Label nombre = new Label(_nombre);
		Label vida = new Label("Vida: ");
		this.unitVBox.getChildren().addAll(nombre, vida);
		
		VBox accionesVBox = new VBox(20);
    	accionesVBox.setPadding(new Insets(20));
    	accionesVBox.setAlignment(Pos.TOP_CENTER);
    	for (Button button : buttons) {
    		accionesVBox.getChildren().add(button);
		}
    	this.unitVBox.getChildren().add(accionesVBox);
    	this.borderPane.setCenter(this.unitVBox);
    }
    
    public void inicializarUnidad() {
    	Image pisoVacio = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
		ImageView imageViewPiso = new ImageView();
		imageViewPiso.setImage(pisoVacio);
		imageViewPiso.setFitWidth(40);
		imageViewPiso.setPreserveRatio(true);
		imageViewPiso.setSmooth(true);
		imageViewPiso.setCache(true);
		ImageView imageViewUnidad = new ImageView();
		imageViewUnidad.setImage(imagenUnidad);
		imageViewUnidad.setFitWidth(40);
		imageViewUnidad.setPreserveRatio(true);
		imageViewUnidad.setSmooth(true);
		imageViewUnidad.setCache(true);
		this.getChildren().addAll(imageViewPiso, imageViewUnidad);
		imageViewUnidad.setOnMouseClicked(e -> mostrarMenuUnidad());
    }
}
