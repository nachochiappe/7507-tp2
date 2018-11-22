package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.AldeanoOcupadoException;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public interface EstadoAldeano {
    void comenzarTurno();

    void reparar(Edificio edificio) throws AldeanoOcupadoException;

    void construir(Edificio edificio) throws AldeanoOcupadoException;

    void terminarAccion();

    void empezarConstruccion(Edificio edificio, Posicion posicion) throws AldeanoOcupadoException, FueraDelMapaException;
}
