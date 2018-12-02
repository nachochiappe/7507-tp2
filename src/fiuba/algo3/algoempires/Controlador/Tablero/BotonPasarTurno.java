package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Vista.ContenedorPantallaDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BotonPasarTurno implements EventHandler<ActionEvent> {

    ContenedorPantallaDeJuego contenedorPantallaDeJuego;

    public BotonPasarTurno (ContenedorPantallaDeJuego contenedorPantallaDeJuego) {
        this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        this.contenedorPantallaDeJuego.algoEmpires.pasarTurno();
        this.contenedorPantallaDeJuego.statsJugador = new VBox();
        this.contenedorPantallaDeJuego.statsJugador.setSpacing(20);
        this.contenedorPantallaDeJuego.statsJugador.setPadding(new Insets(20));
        Label nombreJugador = new Label();
        nombreJugador.setText(this.contenedorPantallaDeJuego.algoEmpires.getJugadorActual().getNombre());
        Label oroJugador = new Label();
        oroJugador.setText(String.valueOf(this.contenedorPantallaDeJuego.algoEmpires.getJugadorActual().getOro()));
        this.contenedorPantallaDeJuego.statsJugador.getChildren().addAll(nombreJugador, oroJugador);
        this.contenedorPantallaDeJuego.setRight(this.contenedorPantallaDeJuego.statsJugador);

    }
}
