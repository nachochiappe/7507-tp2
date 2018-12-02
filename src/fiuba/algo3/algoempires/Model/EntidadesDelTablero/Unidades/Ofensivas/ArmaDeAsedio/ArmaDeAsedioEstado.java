package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio;

import fiuba.algo3.algoempires.Model.Movimiento.Desplazamiento;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.layout.VBox;

public interface ArmaDeAsedioEstado {

    void mover(Desplazamiento posicion) throws ArmaDeAsedioMontadaException;
    void atacar(Posicionable edificio) throws ArmaDeAsedioNoMontadaException, ArmaDeAsedioNoAtacaUnidadesException;
    //Montar/Desmontar
    void toggleMontar();

    String getNombre();
    VBox getBotoneraAcciones(BotoneraAcciones botoneraAcciones);
}
