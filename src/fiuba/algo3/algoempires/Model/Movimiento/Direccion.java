package fiuba.algo3.algoempires.Model.Movimiento;

public class Direccion {
    public static Desplazamiento arriba() {
       return new Desplazamiento(0, 1);
    }

    public static Desplazamiento abajo() {
        return new Desplazamiento(0, -1);
    }
    public static Desplazamiento derecha() {
        return new Desplazamiento(1, 0);
    }
    public static Desplazamiento izquierda() {
        return new Desplazamiento(-1, 0);
    }
    public static Desplazamiento arribaDerecha() {
        return new Desplazamiento(1, 1);
    }
    public static Desplazamiento arribaIzquierda() {
        return new Desplazamiento(-1, 1);
    }
    public static Desplazamiento abajoDerecha() {
        return new Desplazamiento(1, -1);
    }
    public static Desplazamiento abajoIzquierda() {
        return new Desplazamiento(-1 , -1);
    }
}
