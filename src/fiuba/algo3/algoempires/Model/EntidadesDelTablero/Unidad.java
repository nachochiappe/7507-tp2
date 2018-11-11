package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;

import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Movimiento.*;

public abstract class Unidad {

    //Todas las unidades tienen hp y costo
    protected int hp;
    protected int costo;
    //TODO: Determinar si cada unidad va a tener una referencia a su Jugador o solamente el nombre
    protected String jugador;
    protected Posicion posicion;
    protected Movible movible = new Movible();
    protected NoMovible noMovible = new NoMovible();
    protected Movimiento movimiento = movible;



    //TODO: Ver cómo integro esto del movimiento con el arma de asedio
    public void mover(Desplazamiento desplazamiento) throws UnidadYaSeMovioException, DestinoFueraDelMapaException {
        this.posicion = this.movimiento.mover(desplazamiento, this.posicion);
        this.deshabilitarMovimiento();
        return;
    }

    public void habilitarMovimiento() {
        this.movimiento = movible;
    }

    public void deshabilitarMovimiento() {
        this.movimiento = noMovible;
    }

    public void _mover(int posicion){}

    public int getCosto() {
        return costo;
    }

    public int getHp() {
        return hp;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public String getJugador() {
        return jugador;
    }
}
