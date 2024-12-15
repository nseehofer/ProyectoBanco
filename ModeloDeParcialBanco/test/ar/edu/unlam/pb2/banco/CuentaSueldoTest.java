package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaSueldoTest {

	@Test
	public void queSePuedaExtraer1000PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		CuentaSueldo cuentaSueldo1 = new CuentaSueldo();
		cuentaSueldo1.depositarDinero(2000.0);
		assertTrue(cuentaSueldo1.extraerDinero(1000.0));

	}

	@Test
	public void queNoSePuedaExtraer2500PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		CuentaSueldo cuentaSueldo1 = new CuentaSueldo();
		cuentaSueldo1.depositarDinero(2000.0);
		assertFalse(cuentaSueldo1.extraerDinero(2500.0));
	}

}
