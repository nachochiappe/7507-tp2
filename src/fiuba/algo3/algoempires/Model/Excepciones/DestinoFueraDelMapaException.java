package fiuba.algo3.algoempires.Model.Excepciones;

public class DestinoFueraDelMapaException extends Exception {

	public DestinoFueraDelMapaException() {
		// TODO Auto-generated constructor stub
	}

	public DestinoFueraDelMapaException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DestinoFueraDelMapaException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DestinoFueraDelMapaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DestinoFueraDelMapaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Destino fuera del mapa";
	}
}
