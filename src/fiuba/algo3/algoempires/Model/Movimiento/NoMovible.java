package fiuba.algo3.algoempires.Model.Movimiento;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;

public class NoMovible implements Movimiento {
    @Override
    public void mover(Desplazamiento desplazamiento, Unidad unidad) throws UnidadYaSeMovioException {
        throw new UnidadYaSeMovioException();
    }
}
