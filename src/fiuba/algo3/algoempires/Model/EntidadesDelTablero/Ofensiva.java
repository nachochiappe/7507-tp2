package fiuba.algo3.algoempires.Model.EntidadesDelTablero;

import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.AtaqueAliadoException;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;

public interface Ofensiva{
	
	public void atacar(Posicionable posicionable) throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException, AtaqueAliadoException;
	public int cuantoDanioAUnidad() throws ArmaDeAsedioNoAtacaUnidadesException;
	public int cuantoDanioAEdificio();
}
