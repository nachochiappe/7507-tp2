package fiuba.algo3.algoempires.Controlador;

import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Vista.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.ContenedorPantallaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;


public class Aplicacion extends Application {
	
	private static int width;
	private static int height;

	private AlgoEmpires algoEmpires;
	
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
      
        ContenedorPantallaPrincipal contenedorPantallaPrincipal = new ContenedorPantallaPrincipal(stage);
        Scene escenaPrincipal = new Scene(contenedorPantallaPrincipal, 1024, 768);
        escenaPrincipal.getStylesheets().add("file:src/fiuba/algo3/algoempires/Vista/MenuPrincipal.css");
        stage.setScene(escenaPrincipal);
        stage.setFullScreen(true);
        stage.setResizable(true);
        stage.setAlwaysOnTop(true);
        stage.show();
	}
}
