package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.layout.VBox;

public interface EstadoAldeano {
    void comenzarTurno() throws EdificioNoNecesitaRepararse, EdificioYaConstruidoException, SoloSePermiteUnAldeanoException;

    String getNombre();

    void terminarAccion();

    VBox getBotonearaAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones);

    void empezarConstruccion(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException, FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException;
    
	void empezarReparacion(Edificio edificio) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException, AldeanoOcupadoException;
}
