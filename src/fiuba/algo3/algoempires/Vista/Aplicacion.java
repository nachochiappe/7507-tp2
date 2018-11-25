package fiuba.algo3.algoempires.Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Dimension;
import java.awt.Toolkit;


public class Aplicacion extends Application {
	
	private static int width;
	private static int height;
	
    public static void main(String[] args) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.width;
		height = screenSize.height;
        launch(args);
    }
    
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Algo Empires");
        ContenedorPantallaPrincipal contenedorPantallaPrincipal = new ContenedorPantallaPrincipal(stage, null);
        Scene escenaPrincipal = new Scene(contenedorPantallaPrincipal, 1024, 768);
 
        stage.setScene(escenaPrincipal);
       stage.setFullScreen(true);

        stage.show();
	}

}
