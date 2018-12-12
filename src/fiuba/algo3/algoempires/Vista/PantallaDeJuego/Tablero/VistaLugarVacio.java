package fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero;

import fiuba.algo3.algoempires.Controlador.Tablero.LugarVacioEventHandler;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class VistaLugarVacio extends VistaPosicionable{
	
	private Image pisoVacio;
	BorderPane borderPane;
	
	public VistaLugarVacio(BorderPane borderPane) {
		pisoVacio  = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/PedazoDePiso.png");
		this.borderPane = borderPane;
		inicializar();
	}


	@Override
	public void inicializar() {
		ImageView imageViewPiso = new ImageView();
		imageViewPiso.setImage(pisoVacio);
		imageViewPiso.setFitWidth(40);
		imageViewPiso.setPreserveRatio(true);
		imageViewPiso.setSmooth(true);
		imageViewPiso.setCache(true);
		this.getChildren().add(imageViewPiso);
		imageViewPiso.setOnMouseClicked(new LugarVacioEventHandler(this.borderPane));
/*
		imageViewPiso.setOnMouseClicked(e -> {
			this.borderPane.setCenter(new SeleccionableHUD());
		});*/
	}

	@Override
    public void agregarATablero(VistaTablero vistaTablero, Posicionable posicionable, int i, int j) {
    	vistaTablero.add(this, i, j);
    }
}
