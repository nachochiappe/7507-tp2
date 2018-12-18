package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;

import java.util.Iterator;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedio;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoMontadaException;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaCastillo;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaPosicionable;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Castillo extends Edificio implements Ofensiva {

    private static final int MAX_VIDA = 1000;
    private static final int HP_REGEN = 15;
    private static final int OCUPA_ANCHO = 4;
    private static final int OCUPA_ALTO = 4;
    private static final int MAX_RANGO = 3;
    private final int COSTO = 50;
    private int rango;

    public Castillo() {
        this.vida = MAX_VIDA;
        this.rango = MAX_RANGO;
    }


    //Constructor llamado únicamente al principio del juego
    public Castillo(Posicion posicion, Jugador jugador) {
        this.vida = MAX_VIDA;
        this.jugador = jugador;
        this.rango = MAX_RANGO;
        for (int i = 0; i < OCUPA_ANCHO; i++) {
        	for (int j = 0; j < OCUPA_ALTO; j++) {
        		this.posiciones.add(new Posicion(posicion.getPosicionX() + i, posicion.getPosicionY() + j));
        	}
        }
        Tablero.getInstance().poner(this, this.posiciones);
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
    public int getHp() {
        return this.vida;
    }

    @Override
    public VBox getBotoneraAcciones(ContenedorPantallaDeJuego contenedor, BotoneraAcciones botoneraAcciones) {
        return botoneraAcciones.generarBotonera(this);
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

    @Override
    public int getCosto() {
        return COSTO;
    }

    @Override
    public String getNombre() {
        return "Castillo";
    }


    public boolean estaVacio() {
        return false;
    }

    @Override
    public Image getSpriteConstruido() {
        return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/Castillo/CastilloConstruido.png");
    }

    @Override
    public Image getSpriteConstruyendo() {
        return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/Castillo/CastilloEnConstruccion.png");
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

    @Override
	public void atacar(Posicionable posicionable) throws ObjetivoFueraDeRangoException, ArmaDeAsedioNoAtacaUnidadesException, ArmaDeAsedioNoMontadaException {
		Iterator<Posicion> iterator = posiciones.iterator();
		while (iterator.hasNext()) {
			if(posicionable.estasEnRango(iterator.next(), rango)) {
				posicionable.atacadoPor(this);
				return;
			}
		}

	}


	@Override
	public int cuantoDanioAUnidad() throws ArmaDeAsedioNoAtacaUnidadesException {
		return 20;
	}

	@Override
	public int cuantoDanioAEdificio() {
		return 20;
	}


	@Override
	public VistaPosicionable getView(ContenedorPantallaDeJuego contenedor, Jugador jugadorActual) {
		VistaCastillo vistaCastillo = new VistaCastillo(contenedor, this, jugadorActual);
		return vistaCastillo;
	}


	@Override
	public Unidad crearUnidad(Unidad unidad) throws OroInsuficienteException, ExcedeTopePoblacionalException {
		// TODO Auto-generated method stub
		return null;
	}
}