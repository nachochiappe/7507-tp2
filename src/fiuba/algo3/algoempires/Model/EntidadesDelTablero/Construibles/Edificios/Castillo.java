package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;

public class Castillo extends Edificio implements Posicionable {

    private static final int MAX_VIDA = 1000;
    private static final int HP_REGEN = 15;
    private static final int OCUPA_ANCHO = 4;
    private static final int OCUPA_ALTO = 4;

    public Castillo() {
        this.vida = MAX_VIDA;
    }

    public int getVida() {
        return vida;
    }


    public void construir(Aldeano aldeano) {
        //TODO: EXCEPTION CASTILLO NO PUEDE CONSTRUIR
    }

    @Override
    public int getHpRegen() {
        return HP_REGEN;
    }

    @Override
    public int getMaxHp() {
        return MAX_VIDA;
    }

    @Override
    public int getTurnosConstruccion() {
        return 0;
    }

    @Override
    public int getAlto() {
        return OCUPA_ALTO;
    }

    @Override
    public int getAncho() {
        return OCUPA_ANCHO;
    }

    public boolean estaVacio() {
        return false;
    }

    public ArmaDeAsedio crearArmaDeAsedio(Jugador jugador, Posicion posicion) throws OroInsuficienteException, ExcedeTopePoblacionalException {
        if (jugador.getOro()<200) throw new OroInsuficienteException();
        jugador.modificarOro(-200);
        ArmaDeAsedio arma = new ArmaDeAsedio( jugador, posicion);
        jugador.agregarUnidad(arma);
        return arma;
    }
	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
		this.recibeDanioDe(ofensivo);
	}
}