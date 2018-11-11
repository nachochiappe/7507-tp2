package fiuba.algo3.algoempires.Model.Entidades.Movimiento;

import fiuba.algo3.algoempires.Model.UnidadYaSeMovioException;

public class NoMovible implements Movimiento {
    @Override
    public Posicion mover(Desplazamiento desplazamiento, Posicion posicion) throws UnidadYaSeMovioException {
        throw new UnidadYaSeMovioException();
    }
}
