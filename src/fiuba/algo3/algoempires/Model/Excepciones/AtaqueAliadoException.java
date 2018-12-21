package fiuba.algo3.algoempires.Model.Excepciones;

public class AtaqueAliadoException extends Exception {

	public AtaqueAliadoException() {
		// TODO Auto-generated constructor stub
	}

	public AtaqueAliadoException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AtaqueAliadoException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AtaqueAliadoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AtaqueAliadoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "No se puede atacar a un aliado";
	}
}
