package fiuba.algo3.algoempires.Model.Entidades.Movimiento;

import fiuba.algo3.algoempires.Model.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.UnidadYaSeMovioException;

public interface Movimiento {
    Posicion mover(Desplazamiento desplazamiento, Posicion posicion) throws UnidadYaSeMovioException, DestinoFueraDelMapaException;
}
