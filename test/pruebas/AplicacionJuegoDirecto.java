package pruebas;

import fiuba.algo3.algoempires.Vista.ContenedorPantallaDeJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AplicacionJuegoDirecto  extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Algo Empires");
		ContenedorPantallaDeJuego pantallaDeJuego = new ContenedorPantallaDeJuego(stage);
		Scene escena = new Scene(pantallaDeJuego, 1024,768);
		stage.setScene(escena);
        stage.show();	
	}

	
}
