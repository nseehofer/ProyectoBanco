package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class CajaDeAhorroTest {

	@Test
	public void queAlRealizar5ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe5000SuSaldoFinalSea0() {
		CajaDeAhorro cajaDeAhorro = new CajaDeAhorro();
		cajaDeAhorro.depositarDinero(5000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		Double resultadoEsperado = 0.0;
		Double resultadoObtenido = cajaDeAhorro.saldoEnCuenta();
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queAlRealizar6ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe10000SuSaldoFinalSea3900() {
		CajaDeAhorro cajaDeAhorro = new CajaDeAhorro();
		cajaDeAhorro.depositarDinero(10000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		cajaDeAhorro.extraerDinero(1000.0);
		Double resultadoEsperado = 3900.0;
		Double resultadoObtenido = cajaDeAhorro.saldoEnCuenta();
		assertEquals(resultadoEsperado, resultadoObtenido);

	}

}
