package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;

public interface Ofensiva{
	
	public void atacar(Posicionable posicionable)throws ObjetivoFueraDeRangoException;	
	public int cuantoDanioAUnidad();
	public int cuantoDanioAEdificio();
}
