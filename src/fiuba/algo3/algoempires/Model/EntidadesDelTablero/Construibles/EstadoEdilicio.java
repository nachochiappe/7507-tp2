package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioEnConstruccionException;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioNoNecesitaRepararse;
import fiuba.algo3.algoempires.Model.Excepciones.EdificioYaConstruidoException;
import fiuba.algo3.algoempires.Model.Excepciones.SoloSePermiteUnAldeanoException;
import javafx.scene.image.Image;

public interface EstadoEdilicio {

    void edificar(Aldeano aldeano) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException;

    void crearUnidad(Unidad unidad) throws EdificioEnConstruccionException;

    Image getSprite();
}
