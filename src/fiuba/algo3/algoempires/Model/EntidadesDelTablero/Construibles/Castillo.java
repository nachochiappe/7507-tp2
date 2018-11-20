package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles;

import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Excepciones.FueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;

public class Castillo extends Edificio {

    private static final int MAX_VIDA = 1000;
    public int vida = MAX_VIDA;
    static final int OCUPA_ANCHO = 4;
    static final int OCUPA_ALTO = 4;

    public Castillo() {
        this.vida = MAX_VIDA;
    }
    public void construiteEn(Posicion posicionDeInicio) throws FueraDelMapaException {
        this.posiciones.addFirst(posicionDeInicio);
        for(int i = posicionDeInicio.getPosicionX(); i < posicionDeInicio.getPosicionX() + OCUPA_ALTO; i++) {
            for(int j = posicionDeInicio.getPosicionY(); j < posicionDeInicio.getPosicionY() + OCUPA_ANCHO; j++) {
                Posicion posicionActual = new Posicion(i,j);
                posiciones.add(posicionActual);
            }
        }
        try {
            //Tablero.getInstance().poner(this , posiciones.getFirst(), posiciones.getLast());
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new FueraDelMapaException("La construcción está fuera del mapa");
        };
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
        //if (jugador.getOro()<25) throw new OroInsuficienteException();
        ArmaDeAsedio arma = new ArmaDeAsedio( jugador, posicion);
        jugador.agregarUnidad(arma);
        return arma;
    }
}