package fiuba.algo3.algoempires.Model.Excepciones;

public class JugadorYaExisteException extends Exception {

	public JugadorYaExisteException() {
		// TODO Auto-generated constructor stub
	}

	public JugadorYaExisteException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JugadorYaExisteException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JugadorYaExisteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public JugadorYaExisteException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		return "Jugador ya existe";
	}
}
