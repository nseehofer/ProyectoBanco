package ar.edu.unlam.pb2.banco;

public class CuentaCorriente extends CuentaBancaria {

	private final Double COMISION = 0.05;
	private final Double MONTO_EN_DESCUBIERTO = 150.0;
	private Double dinero;
	private Double descubiertoActual = 150.0;
	private Double deuda = 0.0;
	
	@Override
	public void depositarDinero(Double dinero) {

		// USO TODO EL DESCUBIERTO
		if (this.descubiertoActual < 150.0 && dinero <= this.MONTO_EN_DESCUBIERTO && dinero >= this.deuda) {

			dinero = dinero - this.deuda;
			this.descubiertoActual = this.descubiertoActual + dinero;
			this.deuda = 0.0;
			this.dinero = this.descubiertoActual > this.MONTO_EN_DESCUBIERTO
					? this.descubiertoActual - this.MONTO_EN_DESCUBIERTO
					: 0.0;

		} else if (this.descubiertoActual < 150.0 && dinero > this.MONTO_EN_DESCUBIERTO) {
			Double descubiertoACobrar = this.MONTO_EN_DESCUBIERTO - this.descubiertoActual;
			this.dinero = +dinero - (descubiertoACobrar + this.deuda);
			this.deuda = 0.0;
		} else {
			this.dinero = +dinero;
		}

	}

	@Override
	public boolean extraerDinero(Double dinero) {

		if (tieneDineroSuficiente(dinero)) {
			this.dinero -= dinero;
			return true;
		} else if ((this.dinero + this.descubiertoActual) >= dinero) {
			Double diferenciaARestarEnDescubierto = this.dinero - dinero;
			this.deuda += ((diferenciaARestarEnDescubierto * (-1)) * this.COMISION);
			this.dinero = 0.0; // RETIRA TODO EL SALDO PORQUE YA NO LE ALCANZABA
			this.descubiertoActual += diferenciaARestarEnDescubierto;// EL RESTO LO SACO DEL DESCUBIERTO
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

	public Double saldoDeudor() {

		return this.deuda;
	}

}
