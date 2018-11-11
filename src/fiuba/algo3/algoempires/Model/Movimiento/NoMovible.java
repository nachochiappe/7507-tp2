package fiuba.algo3.algoempires.Model.Movimiento;

import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;

public class NoMovible implements Movimiento {
    @Override
    public Posicion mover(Desplazamiento desplazamiento, Posicion posicion) throws UnidadYaSeMovioException {
        throw new UnidadYaSeMovioException();
    }
}
