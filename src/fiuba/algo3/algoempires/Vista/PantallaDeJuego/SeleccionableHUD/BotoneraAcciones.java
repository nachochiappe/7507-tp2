package fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotoneraAcciones {

    public BotoneraAcciones(Unidad unidad) {

    }
    /*
    public VBox generarBotonera(Unidad unidad) {
        return unidad.generarBotonera(this);
    }*/

    public VBox generarBotonera(Aldeano aldeano) {
        VBox botonera = new VBox(20);

        Button botonMoverUnidad = new Button("Mover Unidad");
        Button botonConstruirPlazaCentral = new Button("Construir Plaza Central");
        Button botonConstruirCuartel = new Button("Construir Cuartel");
        Button botonReparar = new Button("Reparar");
        botonera.getChildren().addAll(botonMoverUnidad, botonConstruirCuartel, botonConstruirPlazaCentral, botonReparar);
        return botonera;
    }

    public VBox generarBotonera(Cuartel cuartel) {
        VBox botonera = new VBox(20);

        Button botonCrearArquero = new Button("Crear Arquero");
        Button botonCrearEspadachin = new Button("Crear Espadachín");

        botonera.getChildren().addAll(botonCrearArquero, botonCrearEspadachin);
        return botonera;
    }

    public VBox generarBotonera(PlazaCentral plazaCentral) {
        VBox botonera = new VBox(20);

        Button botonCrearAldeano = new Button("Crear Aldeano");

        botonera.getChildren().addAll(botonCrearAldeano);
        return botonera;
    }

    public VBox generarBotonera(Castillo castillo) {
        VBox botonera = new VBox(20);

        Button botonCrearArmaDeAsedio = new Button("Crear Arma De Asedio");

        botonera.getChildren().addAll(botonCrearArmaDeAsedio);
        return botonera;
    }



}
