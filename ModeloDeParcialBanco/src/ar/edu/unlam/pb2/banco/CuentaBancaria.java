package ar.edu.unlam.pb2.banco;

public abstract class CuentaBancaria {
	private Double dinero;

	protected abstract void depositarDinero(Double dinero);

	protected abstract boolean extraerDinero(Double dinero);

	protected boolean tieneDineroSuficiente(Double dinero) {
		return this.dinero >= dinero;
	}

	protected  Double saldoEnCuenta() {
		return this.dinero;
	}


}
