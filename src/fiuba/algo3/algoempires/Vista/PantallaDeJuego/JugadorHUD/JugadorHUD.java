package fiuba.algo3.algoempires.Vista.PantallaDeJuego.JugadorHUD;

import fiuba.algo3.algoempires.Controlador.Tablero.BotonPasarTurno;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class JugadorHUD extends VBox {

    public JugadorHUD(ContenedorPantallaDeJuego root) {
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        Label nombreJugador = new Label();
        nombreJugador.setText(root.algoEmpires.getJugadorActual().getNombre());
        Label oroJugador = new Label();
        oroJugador.setText(String.valueOf(root.algoEmpires.getJugadorActual().getOro()));

        Button button = new Button();
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setPadding(new Insets(20));
        button.setText("Terminar Turno");
        button.setOnAction(new BotonPasarTurno(root));

        this.setMaxWidth(200);
        this.setMinWidth(200);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().addAll(nombreJugador, oroJugador, button);
    }
}
