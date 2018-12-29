package fiuba.algo3.algoempires.Vista.PantallaDeJuego.SeleccionableHUD;

import fiuba.algo3.algoempires.Controlador.Tablero.*;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Castillo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.Cuartel;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Construibles.Edificios.PlazaCentral;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Ofensiva;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Posicionable;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidad;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.AldeanoConstruyendo;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Aldeano.AldeanoIdle;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedioDesmontada;
import fiuba.algo3.algoempires.Model.EntidadesDelTablero.Unidades.Ofensivas.ArmaDeAsedio.ArmaDeAsedioMontada;
import fiuba.algo3.algoempires.Model.Movimiento.Direccion;
import fiuba.algo3.algoempires.Vista.PantallaDeJuego.ContenedorPantallaDeJuego;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BotoneraAcciones {


    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, Posicionable posicionable) {
        return posicionable.getBotoneraAcciones(contenedor, this);
    }

    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, AldeanoConstruyendo aldeanoConstruyendo) {
        VBox botonera = new VBox(20);
        Button button = new Button("Cancelar Acción");
        button.setOnAction(new BotonAldeanoCancelarAccion(contenedor, aldeanoConstruyendo.getAldeano()));
        botonera.getChildren().addAll(button);
        return botonera;
    }

    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, AldeanoIdle aldeanoIdle) {
        VBox botonera = new VBox(20);
        GridPane botonesMovimiento = generarBotoneraDireccional(contenedor, aldeanoIdle.getAldeano());
        Button botonConstruirPlazaCentral = new Button("Construir Plaza Central");
        botonConstruirPlazaCentral.setOnAction(new BotonCrearPlazaCentral(contenedor, aldeanoIdle.getAldeano()));
        Button botonConstruirCuartel = new Button("Construir Cuartel");
        botonConstruirCuartel.setOnAction(new BotonCrearCuartel(contenedor, aldeanoIdle.getAldeano()));
        Button botonReparar = new Button("Construir/Reparar");
        botonReparar.setOnAction(new BotonConstruirReparar(contenedor, aldeanoIdle.getAldeano()));
        botonera.getChildren().addAll(botonesMovimiento, botonConstruirCuartel, botonConstruirPlazaCentral, botonReparar);
        return botonera;
    }
    
    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, Unidad ofensivo) {
        VBox botonera = new VBox(20);
        GridPane botonesMovimiento = generarBotoneraDireccional(contenedor, ofensivo);
        Button botonAtacar = new Button("Atacar");
        botonAtacar.setOnAction(new BotonAtacar(contenedor, (Ofensiva) ofensivo));
        botonera.getChildren().addAll(botonesMovimiento, botonAtacar);
        return botonera;
    }

    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, Cuartel cuartel) {
        VBox botonera = new VBox(20);

        Button botonCrearArquero = new Button("Crear Arquero");
        botonCrearArquero.setOnAction(new BotonCrearArquero(contenedor, cuartel));
        Button botonCrearEspadachin = new Button("Crear Espadachín");
        botonCrearEspadachin.setOnAction(new BotonCrearEspadachin(contenedor, cuartel));

        botonera.getChildren().addAll(botonCrearArquero, botonCrearEspadachin);
        return botonera;
    }

    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, PlazaCentral plazaCentral) {
        VBox botonera = new VBox(20);

        Button botonCrearAldeano = new Button("Crear Aldeano");
        botonCrearAldeano.setOnAction(new BotonCrearAldeano(contenedor, plazaCentral));

        botonera.getChildren().addAll(botonCrearAldeano);
        return botonera;
    }

    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, Castillo castillo) {
        VBox botonera = new VBox(20);

        Button botonCrearArmaDeAsedio = new Button("Crear Arma De Asedio");
        botonCrearArmaDeAsedio.setOnAction(new BotonCrearArmaDeAsedio(contenedor, castillo));
        botonera.getChildren().addAll(botonCrearArmaDeAsedio);
        return botonera;
    }

    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, ArmaDeAsedioMontada armaDeAsedioMontada) {
        VBox botonera = new VBox(20);

        Button botonAtacar = new Button("Atacar");
        botonAtacar.setOnAction(new BotonAtacar(contenedor, armaDeAsedioMontada.getArmaDeAsedio()));
        Button botonDesmontar = new Button("Desmontar");
        botonDesmontar.setOnAction(e-> {
            armaDeAsedioMontada.getArmaDeAsedio().toggleMontar();
            contenedor.leftBorderPane.setCenter(new SeleccionableHUD(contenedor, armaDeAsedioMontada.getArmaDeAsedio()));
        });

        botonera.getChildren().addAll(botonAtacar, botonDesmontar);
        return botonera;
    }

    public VBox generarBotonera(ContenedorPantallaDeJuego contenedor, ArmaDeAsedioDesmontada armaDeAsedioDesmontada) {
        VBox botonera = new VBox(20);

        GridPane botonesMovimiento = generarBotoneraDireccional(contenedor, armaDeAsedioDesmontada.getArmaDeAsedio());
        Button botonMontar = new Button("Montar");
        botonMontar.setOnAction(e-> {
            armaDeAsedioDesmontada.getArmaDeAsedio().toggleMontar();
            contenedor.leftBorderPane.setCenter(new SeleccionableHUD(contenedor, armaDeAsedioDesmontada.getArmaDeAsedio()));
        });

        botonera.getChildren().addAll(botonesMovimiento, botonMontar);
        return botonera;
    }

    public GridPane generarBotoneraDireccional (ContenedorPantallaDeJuego contenedor, Unidad unidad) {
        Button botonMoverArriba = new Button();
        Image imgArriba = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Flechas/up-arrow.png");
        ImageView ivArriba = new ImageView(imgArriba);
        ivArriba.setFitWidth(10);
        ivArriba.setFitHeight(10);
        botonMoverArriba.setGraphic(ivArriba);
        botonMoverArriba.setOnAction(new BotonMoverUnidad(contenedor, unidad, Direccion.arriba()));
        Button botonMoverArribaIzquierda = new Button();
        Image imgArribaIzquierda = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Flechas/up-left-arrow.png");
        ImageView ivArribaIzquierda = new ImageView(imgArribaIzquierda);
        ivArribaIzquierda.setFitWidth(10);
        ivArribaIzquierda.setFitHeight(10);
        botonMoverArribaIzquierda.setGraphic(ivArribaIzquierda);
        botonMoverArribaIzquierda.setOnAction(new BotonMoverUnidad(contenedor, unidad, Direccion.arribaIzquierda()));
        Button botonMoverArribaDerecha = new Button();
        Image imgArribaDerecha = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Flechas/up-right-arrow.png");
        ImageView ivArribaDerecha = new ImageView(imgArribaDerecha);
        ivArribaDerecha.setFitWidth(10);
        ivArribaDerecha.setFitHeight(10);
        botonMoverArribaDerecha.setGraphic(ivArribaDerecha);
        botonMoverArribaDerecha.setOnAction(new BotonMoverUnidad(contenedor, unidad, Direccion.arribaDerecha()));
        Button botonMoverAbajo = new Button();
        Image imgAbajo = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Flechas/down-arrow.png");
        ImageView ivAbajo = new ImageView(imgAbajo);
        ivAbajo.setFitWidth(10);
        ivAbajo.setFitHeight(10);
        botonMoverAbajo.setGraphic(ivAbajo);
        botonMoverAbajo.setOnAction(new BotonMoverUnidad(contenedor, unidad, Direccion.abajo()));
        Button botonMoverAbajoIzquierda = new Button();
        Image imgAbajoIzquierda = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Flechas/down-left-arrow.png");
        ImageView ivAbajoIzquierda = new ImageView(imgAbajoIzquierda);
        ivAbajoIzquierda.setFitWidth(10);
        ivAbajoIzquierda.setFitHeight(10);
        botonMoverAbajoIzquierda.setGraphic(ivAbajoIzquierda);
        botonMoverAbajoIzquierda.setOnAction(new BotonMoverUnidad(contenedor, unidad, Direccion.abajoIzquierda()));
        Button botonMoverAbajoDerecha = new Button();
        Image imgAbajoDerecha = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Flechas/down-right-arrow.png");
        ImageView ivAbajoDerecha = new ImageView(imgAbajoDerecha);
        ivAbajoDerecha.setFitWidth(10);
        ivAbajoDerecha.setFitHeight(10);
        botonMoverAbajoDerecha.setGraphic(ivAbajoDerecha);
        botonMoverAbajoDerecha.setOnAction(new BotonMoverUnidad(contenedor, unidad, Direccion.abajoDerecha()));
        Button botonMoverIzquierda = new Button();
        Image imgIzquierda = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Flechas/left-arrow.png");
        ImageView ivIzquierda = new ImageView(imgIzquierda);
        ivIzquierda.setFitWidth(10);
        ivIzquierda.setFitHeight(10);
        botonMoverIzquierda.setGraphic(ivIzquierda);
        botonMoverIzquierda.setOnAction(new BotonMoverUnidad(contenedor, unidad, Direccion.izquierda()));
        Button botonMoverDerecha = new Button();
        Image imgDerecha = new Image("file:src/fiuba/algo3/algoempires/Vista/Imagenes/Flechas/right-arrow.png");
        ImageView ivDerecha = new ImageView(imgDerecha);
        ivDerecha.setFitWidth(10);
        ivDerecha.setFitHeight(10);
        botonMoverDerecha.setGraphic(ivDerecha);
        botonMoverDerecha.setOnAction(new BotonMoverUnidad(contenedor, unidad, Direccion.derecha()));

        botonMoverArribaIzquierda.setDisable(!unidad.puedeAccionar());
        botonMoverArriba.setDisable(!unidad.puedeAccionar());
        botonMoverArribaDerecha.setDisable(!unidad.puedeAccionar());
        botonMoverDerecha.setDisable(!unidad.puedeAccionar());
        botonMoverAbajoIzquierda.setDisable(!unidad.puedeAccionar());
        botonMoverAbajo.setDisable(!unidad.puedeAccionar());
        botonMoverAbajoDerecha.setDisable(!unidad.puedeAccionar());
        botonMoverIzquierda.setDisable(!unidad.puedeAccionar());

        GridPane botones = new GridPane();
        botones.add(botonMoverArribaIzquierda, 0, 0);
        botones.add(botonMoverArriba, 1, 0);
        botones.add(botonMoverArribaDerecha, 2, 0);
        botones.add(botonMoverIzquierda, 0, 1);
        botones.add(botonMoverDerecha, 2, 1);
        botones.add(botonMoverAbajoIzquierda, 0, 2);
        botones.add(botonMoverAbajo, 1, 2);
        botones.add(botonMoverAbajoDerecha, 2, 2);
        return botones;
    }

}
