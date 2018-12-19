package fiuba.algo3.algoempires.Model.Excepciones;

public class PosicionOcupadaException extends Exception {

	public PosicionOcupadaException() {
		// TODO Auto-generated constructor stub
	}

	public PosicionOcupadaException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PosicionOcupadaException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PosicionOcupadaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PosicionOcupadaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Posición ocupada";
	}
}
