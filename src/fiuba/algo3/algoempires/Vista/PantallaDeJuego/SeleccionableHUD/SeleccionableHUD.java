package fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SeleccionableHUD extends VBox {

    public SeleccionableHUD() {
        this.setPadding(new Insets(20));
        this.setMinWidth(100);
        this.setMaxWidth(100);
    }

    public SeleccionableHUD(ContenedorPantallaDeJuego contenedor, Posicionable posicionable, Jugador jugador) {
        VBox botoneraAcciones = new VBox();
        this.setPadding(new Insets(20, 0, 20 , 0));
        Image sprite = posicionable.getSprite();
        ImageView imageView = new ImageView();
        imageView.setImage(sprite);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        Label nombre = new Label(posicionable.getNombre());
        Label vida = new Label("HP: " + posicionable.getHp() + "/" + posicionable.getMaxHp());
        if (jugador.equals(posicionable.getJugador())) {
            botoneraAcciones= new BotoneraAcciones().generarBotonera(contenedor, posicionable);
        }

        this.getChildren().addAll(imageView, nombre, vida, botoneraAcciones);
        this.setMinWidth(100);
        this.setMaxWidth(100);
    }

}
