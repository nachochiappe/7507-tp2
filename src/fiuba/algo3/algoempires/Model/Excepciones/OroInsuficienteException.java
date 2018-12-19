package fiuba.algo3.algoempires.Model.Excepciones;

public class OroInsuficienteException extends Exception {

	public OroInsuficienteException() {
		// TODO Auto-generated constructor stub
	}

	public OroInsuficienteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OroInsuficienteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public OroInsuficienteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OroInsuficienteException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Oro insuficiente";
	}
}
