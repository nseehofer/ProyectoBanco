package ar.edu.unlam.pb2.banco;

public class CajaDeAhorro extends CuentaBancaria {
	private Double dinero;
	private Integer cantidadDeExtracciones = 0;

	@Override
	public void depositarDinero(Double dinero) {
		this.dinero = +dinero;

	}

	@Override
	public boolean extraerDinero(Double dinero) {

		Boolean extraccionRealizada = false;

		if (tieneDineroSuficiente(dinero)) {
			this.dinero -= dinero;
			++this.cantidadDeExtracciones;
			extraccionRealizada = true;
		}

		if (this.cantidadDeExtracciones > 5) {
			this.dinero -= 100;
		}

		return extraccionRealizada;
	}

	protected boolean tieneDineroSuficiente(Double dinero) {
		return this.dinero >= dinero;
	}

	protected Double saldoEnCuenta() {
		return this.dinero;
	}
}
