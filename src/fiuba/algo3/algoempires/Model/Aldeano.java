package fiuba.algo3.algoempires.Model;

public class Aldeano implements Unidad {

	int costo;
	int vida;
	Tablero tablero;
	Posicion posicion;
	Movimiento movimientoArriba = new MovimientoArriba();
	Movimiento movimientoAbajo = new MovimientoAbajo();
	Movimiento movimientoIzquierda = new MovimientoIzquierda();
	Movimiento movimientoDerecha = new MovimientoDerecha();
	boolean yaMovio;
	
	public Aldeano(Tablero _tablero, Posicion _posicion) {
		this.costo = 25;
        this.vida = 50;
		this.tablero = _tablero;
		this.posicion = _posicion;
		this.yaMovio = false;
	}
	
	@Override
	public void moverArriba() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		if (!yaMovio) {
			this.posicion = this.movimientoArriba.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.yaMovio = true;
		}
		else {
			throw new UnidadYaSeMovioException();
		}
	}
	
	@Override
	public void moverAbajo() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		if (!yaMovio) {
			this.posicion = this.movimientoAbajo.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.yaMovio = true;
		}
		else {
			throw new UnidadYaSeMovioException();
		}
	}
	
	@Override
	public void moverIzquierda() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		if (!yaMovio) {
			this.posicion = this.movimientoIzquierda.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.yaMovio = true;
		}
		else {
			throw new UnidadYaSeMovioException();
		}
	}
	
	@Override
	public void moverDerecha() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		if (!yaMovio) {
			this.posicion = this.movimientoDerecha.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.yaMovio = true;
		}
		else {
			throw new UnidadYaSeMovioException();
		}
	}
	
	@Override
	public void moverArribaIzquierda() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		if (!yaMovio) {
			this.posicion = this.movimientoArriba.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.posicion = this.movimientoIzquierda.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.yaMovio = true;
		}
		else {
			throw new UnidadYaSeMovioException();
		}
	}
	
	@Override
	public void moverArribaDerecha() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		if (!yaMovio) {
			this.posicion = this.movimientoArriba.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.posicion = this.movimientoDerecha.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.yaMovio = true;
		}
		else {
			throw new UnidadYaSeMovioException();
		}
	}
	
	@Override
	public void moverAbajoIzquierda() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		if (!yaMovio) {
			this.posicion = this.movimientoAbajo.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.posicion = this.movimientoIzquierda.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.yaMovio = true;
		}
		else {
			throw new UnidadYaSeMovioException();
		}
	}
	
	@Override
	public void moverAbajoDerecha() throws DestinoFueraDelMapaException, UnidadYaSeMovioException {
		if (!yaMovio) {
			this.posicion = this.movimientoAbajo.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.posicion = this.movimientoDerecha.calcularPosicionSiguiente(this.posicion, this.tablero.getAncho(), this.tablero.getAlto());
			this.yaMovio = true;
		}
		else {
			throw new UnidadYaSeMovioException();
		}
	}
}