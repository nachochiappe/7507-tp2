package fiuba.algo3.algoempires.Model.Movimiento;


import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.LugarVacio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.PosicionOcupadaException;
import fiuba.algo3.algoempires.Model.Tablero;


public class Movible implements Movimiento {


    @Override
    public void mover(Desplazamiento desplazamiento, Unidad unidad) throws DestinoFueraDelMapaException, PosicionOcupadaException {
        Posicion posicionActual = unidad.getPosicion();
        Posicion nuevaPosicion = new Posicion(unidad.getPosicion().getPosicionX() + desplazamiento.getX(), unidad.getPosicion().getPosicionY() + desplazamiento.getY());
        Tablero.getInstance().poner(posicionActual, nuevaPosicion, unidad);
        //Tablero.getInstance().poner(new LugarVacio(), posicionActual);
        unidad.setPosicion(nuevaPosicion);
    }
}
