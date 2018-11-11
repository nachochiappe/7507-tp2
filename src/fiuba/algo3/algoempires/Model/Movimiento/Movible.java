package fiuba.algo3.algoempires.Model.Movimiento;


import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Tablero;


public class Movible implements Movimiento {


    @Override
    public Posicion mover(Desplazamiento desplazamiento, Posicion posicion) throws DestinoFueraDelMapaException {
        Posicion posicion_nueva = new Posicion(posicion.getPosicionX() + desplazamiento.getX(), posicion.getPosicionY() + desplazamiento.getY());
        if (!posicion_nueva.dentroDe(Tablero.ancho(), Tablero.alto())) {
            throw new DestinoFueraDelMapaException("La unidad no puede moverse fuera de los límites del mapa");
        }
        return posicion_nueva;
    }
}
