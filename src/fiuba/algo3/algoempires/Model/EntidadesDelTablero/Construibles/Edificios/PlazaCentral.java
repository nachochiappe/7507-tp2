package fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construible;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.LugarVacio;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.Excepciones.ArmaDeAsedioNoAtacaUnidadesException;
import fiuba.algo3.algoempires.Model.Excepciones.ExcedeTopePoblacionalException;
import fiuba.algo3.algoempires.Model.Excepciones.OroInsuficienteException;
import fiuba.algo3.algoempires.Model.Jugador.Jugador;
import fiuba.algo3.algoempires.Model.Movimiento.Posicion;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.BotoneraAcciones;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;


public class PlazaCentral extends Edificio {

	private static final int MAX_VIDA = 450;
	private static final int HP_REGEN = 25;
	private static final int COSTO=100;
	private static final int TURNOSCONTRUCCION=3;
	private static final int OCUPA_ANCHO = 2;
	private static final int OCUPA_ALTO = 2;

	public PlazaCentral() {
		this.vida = MAX_VIDA;
	}


	//Constructor llamado únicamente al principio del juego
	public PlazaCentral(Posicion posicion) {
		this.vida = MAX_VIDA;
		for (int i = 0; i < OCUPA_ANCHO; i++) {
        	for (int j = 0; j < OCUPA_ALTO; j++) {
        		this.posiciones.add(new Posicion(posicion.getPosicionX() + i, posicion.getPosicionY() + j));
        	}
        }
		Tablero.getInstance().poner(this, this.posiciones);
	}

	@Override
	public Image getSpriteConstruido() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralConstruida.png");
	}

	@Override
	public Image getSpriteConstruyendo() {
		return new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Edificios/PlazaCentral/PlazaCentralEnConstruccion.png");
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
	public VBox getBotoneraAcciones(BotoneraAcciones botoneraAcciones) {
		return botoneraAcciones.generarBotonera(this);
	}

	@Override
	public String getNombre() {
		return "Plaza Central";
	}

	@Override
	public int getTurnosConstruccion() {
		return TURNOSCONTRUCCION;
	}

	@Override
	public int getAlto() {
		return OCUPA_ALTO;
	}

	@Override
	public int getAncho() {
		return OCUPA_ANCHO;
	}

	public void mori() {
		LugarVacio lugar = LugarVacio.class.cast(this);
	}

	//estos get son para las pruebas...despues los saco
	public int getCosto() {
		return COSTO;
	}



	private void estoyDestruido() {
		if(vida <= 0) {
			this.mori();
		}

	}

	public Aldeano crearAldeano(Jugador jugador,Posicion posicion)  throws OroInsuficienteException, ExcedeTopePoblacionalException {
		if (jugador.getOro()<25) throw new OroInsuficienteException();
		jugador.modificarOro(-25);
		Aldeano aldeano = new Aldeano(jugador,posicion);
		jugador.agregarUnidad(aldeano);
		return aldeano;
	}

	@Override
	public void atacadoPor(Ofensiva ofensivo) throws ArmaDeAsedioNoAtacaUnidadesException {
		this.recibeDanioDe(ofensivo);
		
	}



}
