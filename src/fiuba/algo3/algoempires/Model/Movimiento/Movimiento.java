package fiuba.algo3.algoempires.Model.Movimiento;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.PosicionOcupadaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;

public interface Movimiento {
    void mover(Desplazamiento desplazamiento, Unidad unidad) throws UnidadYaSeMovioException, DestinoFueraDelMapaException, PosicionOcupadaException;
}
