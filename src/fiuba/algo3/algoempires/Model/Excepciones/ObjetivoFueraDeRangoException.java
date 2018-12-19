package fiuba.algo3.algoempires.Model.Excepciones;

public class ObjetivoFueraDeRangoException extends Exception {

    @Override
    public String getMessage() {
        return "Objetivo fuera de rango";
    }
}
