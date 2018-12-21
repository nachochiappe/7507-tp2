package fiuba.algo3.algoempires.Model.Excepciones;

public class FueraDelMapaException extends Exception{

	public FueraDelMapaException() {
		// TODO Auto-generated constructor stub
	}

	public FueraDelMapaException(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Fuera del mapa";
	}

}
