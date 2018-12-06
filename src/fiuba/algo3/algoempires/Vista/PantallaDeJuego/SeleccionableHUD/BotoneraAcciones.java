package fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD;

import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Controlador.Tablero.BotonMoverUnidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.Aldeano;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedioDesmontada;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedioMontada;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotoneraAcciones {


    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, Posicionable posicionable) {
        return posicionable.getBotoneraAcciones(contenedor, this);
    }

    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, Aldeano aldeano) {
        VBox botonera = new VBox(20);

        Button botonMoverUnidad = new Button("Mover Unidad");
        botonMoverUnidad.setOnAction(new BotonMoverUnidad(contenedor, aldeano));
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

    public VBox generarBotonera(ArmaDeAsedioMontada armaDeAsedioMontada) {
        VBox botonera = new VBox(20);

        Button botonAtacar = new Button("Atacar");
        Button botonDesmontar = new Button("Desmontar");


        botonera.getChildren().addAll(botonAtacar, botonDesmontar);
        return botonera;
    }

    public VBox generarBotonera(ArmaDeAsedioDesmontada armaDeAsedioDesmontada) {
        VBox botonera = new VBox(20);

        Button botonMover = new Button("Mover");
        Button botonMontar = new Button("Montar");
        botonera.getChildren().addAll(botonMover, botonMontar);
        return botonera;
    }


}
