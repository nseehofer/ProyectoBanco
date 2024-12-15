package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaCorrienteTest {

	// DESCUBIERTO MAXIMO $ 150,00

	@Test
	public void queAlDepositar1000EnUnaCuentaCorrienteConSaldoIgualACeroSuSaldoFinalSea1000() {
		CuentaCorriente cuentaCorriente = new CuentaCorriente();
		cuentaCorriente.depositarDinero(1000.0);
		Double resultadoEsperado = 1000.0;
		Double resultadoObtenido = cuentaCorriente.saldoEnCuenta();
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queSeCobre5PorCientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldoEnUnaCuentaCorriente() {

		CuentaCorriente cuentaCorriente = new CuentaCorriente();
		cuentaCorriente.depositarDinero(100.0);
		cuentaCorriente.extraerDinero(200.0);
		cuentaCorriente.depositarDinero(200.0);
		Double resultadoEsperado = 95.0;
		Double resultadoObtenido = cuentaCorriente.saldoEnCuenta();
		assertEquals(resultadoEsperado, resultadoObtenido);

	}

	@Test
	public void queUnaExtraccionCuandoYaSeTieneDeudaIncrementeLaDeuda() {
		CuentaCorriente cuentaCorriente = new CuentaCorriente();
		cuentaCorriente.depositarDinero(100.0);
		cuentaCorriente.extraerDinero(200.0);
			cuentaCorriente.extraerDinero(50.0);
		Double resultadoEsperado = 7.5;
		Double resultadoObtenido = cuentaCorriente.saldoDeudor();
		assertEquals(resultadoEsperado, resultadoObtenido);

	}
	
	@Test
	public void queVariasOperacionesDeDepositoYExtraccionGenerenElSaldoYLaDeudaCorrecto() {
		

		/*
		 * 1Depósito $ 100,00 SALDO $100,00 DESC $ 0,00 DEUDA $ 0,00 2Extracción $
		 * 200,00 SALDO $0,00 DESC $ 100,00 DEUDA $ 5,00 3Extracción $ 50,00 SALDO $0,00
		 * DESC $ 150,00 DEUDA $ 7,50 4Depósito $ 50,00 SALDO $0,00 DESC $ 107,50 DEUDA
		 * $ 0,00 5Extracción $ 40,00 SALDO $0,00 DESC $ 147,50 DEUDA $ 2,00 6Depósito $
		 * 150,00 SALDO $0,50 DESC $ 0,00 DEUDA $ 0,00
		 * 
		 */
		Double resultadoEsperado = 0.0;
		Double resultadoObtenido = 0.0;
		CuentaCorriente cuentaCorriente = new CuentaCorriente();
		
		// OP 1
		cuentaCorriente.depositarDinero(100.0);
		resultadoObtenido = cuentaCorriente.saldoEnCuenta();
		resultadoEsperado = 100.0;
		assertEquals(resultadoEsperado, resultadoObtenido);

		// OP 2
		cuentaCorriente.extraerDinero(200.0);
		resultadoEsperado = 5.0;
		resultadoObtenido = cuentaCorriente.saldoDeudor();
		assertEquals(resultadoEsperado, resultadoObtenido);

		// OP 3
		cuentaCorriente.extraerDinero(50.0);
		resultadoEsperado = 7.50;
		resultadoObtenido = cuentaCorriente.saldoDeudor();
		assertEquals(resultadoEsperado, resultadoObtenido);

		// OP 4
		cuentaCorriente.depositarDinero(50.0);
		resultadoEsperado = 0.00;
		resultadoObtenido = cuentaCorriente.saldoDeudor();
		assertEquals(resultadoEsperado, resultadoObtenido);

		// OP 5
		cuentaCorriente.extraerDinero(40.0);
		resultadoEsperado = 2.00;
		resultadoObtenido = cuentaCorriente.saldoDeudor();
		assertEquals(resultadoEsperado, resultadoObtenido);

		// OP 6
		cuentaCorriente.depositarDinero(150.0);
		resultadoEsperado = 0.0;
		resultadoObtenido = cuentaCorriente.saldoDeudor();
		assertEquals(resultadoEsperado, resultadoObtenido);
		resultadoEsperado = 0.50;
		resultadoObtenido = cuentaCorriente.saldoEnCuenta();
		assertEquals(resultadoEsperado, resultadoObtenido);

	}

}
