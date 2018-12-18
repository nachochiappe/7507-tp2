package fiuba.algo3.algoempires.Vista.PantallaDeJuego;

import fiuba.algo3.algoempires.Model.AlgoEmpires;
import fiuba.algo3.algoempires.Model.Tablero;
import fiuba.algo3.algoempires.Vista.*;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.JugadorHUD.JugadorHUD;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD.SeleccionableHUD;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.Tablero.VistaTablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class ContenedorPantallaDeJuego extends BorderPane {

	public BarraDeMenu menuBar;

    public AlgoEmpires algoEmpires;
	public VistaTablero vistaTablero;
	public BorderPane leftBorderPane;
	public VBox unitVBox;
	public JugadorHUD jugadorHUD;
	public SeleccionableHUD seleccionableHUD;
	public Stage rootStage;

    public ContenedorPantallaDeJuego(Stage stage, AlgoEmpires algoEmpires) {
        this.rootStage = stage;
        this.algoEmpires = algoEmpires;
        this.vistaTablero = new VistaTablero();
        vistaTablero.setAlignment(Pos.CENTER);
        this.leftBorderPane = new BorderPane();
        leftBorderPane.setPadding(new Insets(20));
        this.setMenu(stage);
        this.setCentro();
        this.seleccionableHUD = new SeleccionableHUD();
		this.leftBorderPane.setCenter(seleccionableHUD);
        this.setLeft(leftBorderPane);
        this.actualizarJugadorHUD();
    }


    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    public void setCentro() {
    	
    	this.vistaTablero.iniciarTablero(this, algoEmpires.getJugadorActual());
    	this.setCenter(vistaTablero);
    }

    public void actualizarJugadorHUD() {
        this.jugadorHUD = new JugadorHUD(this);
        this.setRight(jugadorHUD);
    }

    public VistaTablero getVistaTablero() {
    	return this.vistaTablero;
    }

    
	public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}