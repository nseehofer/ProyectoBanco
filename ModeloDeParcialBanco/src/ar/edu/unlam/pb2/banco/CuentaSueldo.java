package ar.edu.unlam.pb2.banco;

public class CuentaSueldo extends CuentaBancaria {

	private Double dinero;
	
	@Override
	public void depositarDinero(Double dinero) {
		this.dinero = +dinero;

	}

	@Override
	public boolean extraerDinero(Double dinero) {

		if (tieneDineroSuficiente(dinero)) {
			this.dinero -= dinero;
			return true;
		}

		return false;
	}

	protected boolean tieneDineroSuficiente(Double dinero) {
		return this.dinero >= dinero;
	}

	protected Double saldoEnCuenta() {
		return this.dinero;
	}

}
