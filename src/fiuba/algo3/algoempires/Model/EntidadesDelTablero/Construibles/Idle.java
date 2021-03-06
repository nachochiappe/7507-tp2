package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioNoNecesitaRepararse;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class Idle implements EstadoEdilicio {

    private Edificio edificio;


    Idle(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public void edificar(Aldeano aldeano) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException {
        edificio.aldeanoValido(aldeano);
        if(this.edificio.isFullHp()){
            throw new EdificioNoNecesitaRepararse();
        }
        this.edificio._reparar(aldeano);
    }

    @Override
    public void crearUnidad(Unidad unidad) {
    }

    @Override
    public VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedorPantallaDeJuego, BotoneraAcciones botoneraAcciones) {
        return this.edificio._getBotoneraAcciones(contenedorPantallaDeJuego, botoneraAcciones);
    }

    @Override
    public Image getSprite() {
        return this.edificio.getSpriteConstruido();
    }

    @Override
    public String getSpritePath() {
        return this.edificio.getSpriteConstruidoPath();
    }
}
