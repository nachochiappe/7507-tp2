package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaUnidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ClickPosicionableEventHandler implements EventHandler<MouseEvent> {

    private VistaUnidad vistaUnidad;

    public ClickPosicionableEventHandler(VistaUnidad vistaUnidad) {
        this.vistaUnidad = vistaUnidad;
    }


    @Override
    public void handle(MouseEvent event) {
        vistaUnidad.contenedor.vistaTablero.iniciarTablero(vistaUnidad.contenedor, vistaUnidad.contenedor.algoEmpires.getJugadorActual());
        SeleccionableHUD seleccionableHUD = new SeleccionableHUD(vistaUnidad.contenedor, vistaUnidad.unidad, vistaUnidad.jugadorActual);
        vistaUnidad.borderPane.setCenter(seleccionableHUD);
        Image seleccionado = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/selec.png");
        ImageView imageViewSeleccionado = new ImageView();
        imageViewSeleccionado.setImage(seleccionado);
        imageViewSeleccionado.setFitWidth(40);
        imageViewSeleccionado.setPreserveRatio(true);
        imageViewSeleccionado.setSmooth(true);
        imageViewSeleccionado.setCache(true);
        vistaUnidad.getChildren().add(imageViewSeleccionado);
    }
}
