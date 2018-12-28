package fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD;

import fiuba.algo3.algoempires.Controlador.Tablero.BotonCancelarAccion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SeleccionableHUD extends VBox {

    VBox botoneraAcciones;

    public SeleccionableHUD() {
        this.setPadding(new Insets(20));
        //this.setMaxWidth(200);
        this.setPrefWidth(150);
        //this.setMinWidth(150);
    }


    public SeleccionableHUD(ContenedorPantallaDeJuego contenedor, Posicionable posicionable) {
        botoneraAcciones = new VBox();
        this.setPadding(new Insets(20, 0, 20 , 0));
        Image sprite = posicionable.getSprite();
        ImageView imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setFitWidth(35);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        Label nombre = new Label(posicionable.getNombre());
        Label vida = new Label("HP: " + posicionable.getHp() + "/" + posicionable.getMaxHp());
        if (contenedor.algoEmpires.getJugadorActual().equals(posicionable.getJugador())) {
            botoneraAcciones= new BotoneraAcciones().generarBotonera(contenedor, posicionable);
        }
        this.getChildren().addAll(imageView, nombre, vida, botoneraAcciones);
        //this.setMaxWidth(200);
        this.setPrefWidth(150);
        //this.setMinWidth(150);
    }

    public SeleccionableHUD(ContenedorPantallaDeJuego contenedor, Posicionable posicionable, String action) {
        botoneraAcciones = new VBox();
        this.setPadding(new Insets(20, 0, 20 , 0));
        Image sprite = posicionable.getSprite();
        ImageView imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setFitWidth(35);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        Label nombre = new Label(posicionable.getNombre());
        Label vida = new Label("HP: " + posicionable.getHp() + "/" + posicionable.getMaxHp());

        Button button = new Button("Cancelar");
        button.setOnAction(new BotonCancelarAccion(contenedor, posicionable));
        Label label = new Label(action);
        botoneraAcciones.getChildren().addAll(label, button);

        this.getChildren().addAll(imageView, nombre, vida, botoneraAcciones);
        this.setPrefWidth(150);
    }
}
