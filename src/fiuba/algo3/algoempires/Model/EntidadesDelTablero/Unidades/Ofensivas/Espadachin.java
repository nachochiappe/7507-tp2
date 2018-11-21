package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas;

import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;

public class Espadachin extends Unidad implements Ofensiva {
    private final int MAX_HP = 100;
    private final int COSTO = 50;
    private final int MAX_RANGO = 1;
    private int rango;
    public Espadachin (Jugador jugador, Posicion posicion) {
        this.costo = COSTO;
        this.hp = MAX_HP;
        this.posicion = posicion;
        this.rango = MAX_RANGO;
    }
/*
	public void atacar(Posicionable posicionable)throws ObjetivoFueraDeRangoException {
		posicionable.atacadoPor(this);
	}
*/
    public void atacar (Unidad unidad) throws ObjetivoFueraDeRangoException {
    	if(!unidad.estasEnRango(this.getPosicion(), rango)) throw new ObjetivoFueraDeRangoException();
        unidad.recibeDanioDe(this);
    }
	public void atacar(Edificio edificio) throws ObjetivoFueraDeRangoException {
    	if(!edificio.estasEnRango(this.getPosicion(), rango)) throw new ObjetivoFueraDeRangoException();
		edificio.recibeDanioDe(this);	
	}	
    
    @Override
	public boolean estaVacio() {
		return false;
	}
	public int cuantoDanioAUnidad() {
		return 25;
	}
	
	public int cuantoDanioAEdificio() {
		return 15;
	}
}
