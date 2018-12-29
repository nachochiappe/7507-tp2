package fiuba.algo3.algoempires.Model.Excepciones;

public class ArmaDeAsedioNoAtacaUnidadesException extends Exception {

    @Override
    public String getMessage() {
        return "El arma de asedio solo puede atacar edificios";
    }
}
