package fiuba.algo3.algoempires.Model.Movimiento;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;

public interface Movimiento {
    Posicion mover(Desplazamiento desplazamiento, Posicion posicion) throws UnidadYaSeMovioException, DestinoFueraDelMapaException;
}
