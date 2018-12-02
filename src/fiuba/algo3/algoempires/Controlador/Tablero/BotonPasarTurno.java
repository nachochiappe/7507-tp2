package fiuba.algo3.algoempires.Controlador.Tablero;

import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.JugadorHUD.JugadorHUD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPasarTurno implements EventHandler<ActionEvent> {

    private ContenedorPantallaDeJuego contenedorPantallaDeJuego;

    public BotonPasarTurno (ContenedorPantallaDeJuego contenedorPantallaDeJuego) {
        this.contenedorPantallaDeJuego = contenedorPantallaDeJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        this.contenedorPantallaDeJuego.algoEmpires.pasarTurno();
        this.contenedorPantallaDeJuego.jugadorHUD = new JugadorHUD(this.contenedorPantallaDeJuego);
        this.contenedorPantallaDeJuego.setRight(this.contenedorPantallaDeJuego.jugadorHUD);

    }
}
