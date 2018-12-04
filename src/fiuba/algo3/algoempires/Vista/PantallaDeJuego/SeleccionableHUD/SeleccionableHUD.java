package fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
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

    public SeleccionableHUD(Posicionable posicionable) {
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

        BotoneraAcciones botoneraAcciones = new BotoneraAcciones();

        this.getChildren().addAll(imageView, nombre, vida, botoneraAcciones.generarBotonera(posicionable));
        this.setMinWidth(100);
        this.setMaxWidth(100);
    }

}
