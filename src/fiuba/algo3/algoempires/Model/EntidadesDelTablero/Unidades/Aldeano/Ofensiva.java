package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;

public abstract class Ofensiva extends Unidad{
	protected int rango;
	
    public void atacar (Unidad unidad) throws ObjetivoFueraDeRangoException {
    	if(!unidad.estasEnRango(this.getPosicion(), rango)) throw new ObjetivoFueraDeRangoException();
        unidad.recibeDanioDe(this);
    }
	public void atacar(Edificio edificio) {
		edificio.recibeDanioDe(this);
		
	}
	public int cuantoDanioAUnidad() {
		return 0;
	}
	public int cuantoDanioAEdificio() {
		return 0;
	}
}
