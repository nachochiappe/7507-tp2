package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.DestinoFueraDelMapaException;
import fiuba.algo3.algoempires.Model.Excepciones.PosicionOcupadaException;
import fiuba.algo3.algoempires.Model.Excepciones.UnidadYaSeMovioException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.*;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaPosicionable;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaUnidad;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public abstract class Unidad implements Posicionable {

    //Todas las unidades tienen hp y costo
    protected int hp;
    protected int costo;
    //TODO: Determinar si cada unidad va a tener una referencia a su  o solamente el nombre
    protected Jugador jugador;
    protected Posicion posicion;
    protected Movible movible = new Movible();
    protected NoMovible noMovible = new NoMovible();
    protected Movimiento movimiento = movible;



    //TODO: Ver cómo integro esto del movimiento con el arma de asedio
    public void mover(Desplazamiento desplazamiento) throws UnidadYaSeMovioException, DestinoFueraDelMapaException, PosicionOcupadaException {
        this.movimiento.mover(desplazamiento, this);
        this.deshabilitarMovimiento();
    }

    public void habilitarMovimiento() {
        this.movimiento = movible;
    }

    public void comenzarTurno() {
        this.habilitarMovimiento();
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

    public Jugador getJugador() {
        return jugador;
    }

	public void recibeDanioDe(Ofensiva ofensiva) throws ArmaDeAsedioNoAtacaUnidadesException {
		int danio = ofensiva.cuantoDanioAUnidad();
		this.hp = this.hp - danio;
		if (this.hp < 1) {
		    jugador.getUnidades().remove(this);
		    this.posicion = null;
        }
	}

	public boolean estasEnRango(Posicion posicionAtacante, int rango){
		return posicionAtacante.estaEnRango(this.getPosicion(), rango);
	}

    @Override
    public VistaPosicionable getView(VBox unitVBox, BorderPane leftBorderPane, Jugador jugadorActual) {
        VistaUnidad vistaUnidad = new VistaUnidad(this, unitVBox, leftBorderPane, jugadorActual);
        return vistaUnidad;
    }

}
