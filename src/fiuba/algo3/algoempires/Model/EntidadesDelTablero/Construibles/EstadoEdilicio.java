package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioEnConstruccionException;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioNoNecesitaRepararse;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioYaConstruidoException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import fiuba.algo3.algoempires.Vista.MenuPrincipal.ContenedorPantallaPrincipal;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public interface EstadoEdilicio {

    void edificar(Aldeano aldeano) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException;

    void crearUnidad(Unidad unidad) throws EdificioEnConstruccionException;

    VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedorPantallaPrincipal, BotoneraAcciones botoneraAcciones);

    Image getSprite();

    String getSpritePath();
}
