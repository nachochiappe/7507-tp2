package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;

public class Castillo extends Edificio implements Posicionable {

    private static final int MAX_VIDA = 1000;
    public int vida = MAX_VIDA;

    public Castillo() {

    }

    public int getVida() {
        return vida;
    }

    public void reparate(Aldeano aldeano) {
        if (this.vida < MAX_VIDA) {
            this.vida += 15;
        } else {
            aldeano.deshabilitarReparacion();
        }
    }

    public boolean estaVacio() {
        return false;
    }


    public ArmaDeAsedio crearArmaDeAsedio(Jugador jugador, Posicion posicion) {
        //falta crear la excepcion
        //if (jugador.getOro()<25) throw new OroInsuficienteException();
        ArmaDeAsedio arma = new ArmaDeAsedio(jugador, posicion);
        jugador.agregarUnidad(arma);
        return arma;
    }
}