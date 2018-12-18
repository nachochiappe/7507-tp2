package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.*;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public interface EstadoAldeano {
    void comenzarTurno() throws EdificioNoNecesitaRepararse, EdificioYaConstruidoException, SoloSePermiteUnAldeanoException;

    void terminarAccion();

    void empezarConstruccion(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException, FueraDelMapaException, SoloSePermiteUnAldeanoException, OroInsuficienteException;
    
	void empezarReparacion(Edificio edificio) throws EdificioNoNecesitaRepararse, SoloSePermiteUnAldeanoException, AldeanoOcupadoException;
}
