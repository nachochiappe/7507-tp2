package fiuba.algo3.algoempires.Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }
    
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Algo Empires");
        ContenedorPantallaPrincipal contenedorPantallaPrincipal = new ContenedorPantallaPrincipal(stage, null);
        Scene escenaPrincipal = new Scene(contenedorPantallaPrincipal, 640, 480);
        stage.setScene(escenaPrincipal);
        stage.setFullScreen(true);

        stage.show();
	}

}
