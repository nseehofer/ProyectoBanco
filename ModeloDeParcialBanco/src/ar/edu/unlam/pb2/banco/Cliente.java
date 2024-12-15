package ar.edu.unlam.pb2.banco;

import java.util.ArrayList;

import java.util.List;

public class Cliente {
	public List<CuentaBancaria> listaDeCuentas = new ArrayList<CuentaBancaria>();

	public List<CuentaBancaria> listaDeCuentas() {

		return this.listaDeCuentas;
	}

	public boolean esVip() {

		Boolean esVip = false;
		Double saldoParcial = 0.0;
		Double saldoTotal = 0.0;

		int i = 0;

		while (i < this.listaDeCuentas().size() && !esVip) {
			if (this.listaDeCuentas().get(i) != null && this.listaDeCuentas().get(i).saldoEnCuenta() != null
					&& this.listaDeCuentas().get(i).saldoEnCuenta() > 0) {
				saldoParcial = this.listaDeCuentas().get(i).saldoEnCuenta();
				saldoTotal += saldoParcial;

			}

			if (saldoTotal >= 1000000.0) {
				esVip = true;
			}

			i++;

		}

		return esVip;
	}
}
