package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;

public abstract class Ofensiva extends Unidad{

    public void atacar (Unidad unidad) {
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
