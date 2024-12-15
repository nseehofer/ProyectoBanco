package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BancoTest {

	@Test
	public void queTengaUnaListaDeClientes() {
		Banco b1 = new Banco();
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();
		Cliente c3 = new Cliente();
		Cliente c4 = new Cliente();

		b1.agregarCliente(c1);
		b1.agregarCliente(c2);
		b1.agregarCliente(c3);
		b1.agregarCliente(c4);

		assertTrue(b1.listaDeClientes());
	}

	@Test
	public void queSeObtengaDeManeraCorrectaElListadoDeClientesVip() {

		Banco b1 = new Banco();
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();
		Cliente c3 = new Cliente();
		Cliente c4 = new Cliente();

		b1.agregarCliente(c1);
		b1.agregarCliente(c2);
		b1.agregarCliente(c3);
		b1.agregarCliente(c4);

		CuentaBancaria cuentaCorriente1 = new CuentaCorriente();
		CuentaBancaria cuentaCorriente2 = new CuentaCorriente();
		CuentaBancaria cuentaCorriente3 = new CuentaCorriente();
		CuentaBancaria cuentaCorriente4 = new CajaDeAhorro();

		CuentaBancaria cuentaSueldo1 = new CuentaSueldo();
		CuentaBancaria cuentaSueldo2 = new CuentaSueldo();
		CuentaBancaria cuentaSueldo3 = new CuentaSueldo();
		CuentaBancaria cuentaSueldo4 = new CajaDeAhorro();

		CuentaBancaria cajaDeAhorro1 = new CajaDeAhorro();
		CuentaBancaria cajaDeAhorro2 = new CajaDeAhorro();
		CuentaBancaria cajaDeAhorro3 = new CajaDeAhorro();
		CuentaBancaria cajaDeAhorro4 = new CajaDeAhorro();

		cuentaCorriente1.depositarDinero(1000000.0);
		cuentaSueldo2.depositarDinero(1000000.0);
		cajaDeAhorro3.depositarDinero(1000000.0);
		cuentaSueldo4.depositarDinero(500000.0);

		c1.listaDeCuentas().add(cuentaCorriente1);
		c1.listaDeCuentas().add(cajaDeAhorro1);
		c1.listaDeCuentas().add(cuentaSueldo1);

		c2.listaDeCuentas().add(cuentaCorriente2);
		c2.listaDeCuentas().add(cajaDeAhorro2);
		c2.listaDeCuentas().add(cuentaSueldo2);

		c3.listaDeCuentas().add(cuentaCorriente3);
		c3.listaDeCuentas().add(cuentaSueldo3);
		c3.listaDeCuentas().add(cajaDeAhorro3);

		c4.listaDeCuentas().add(cuentaCorriente4);
		c4.listaDeCuentas().add(cuentaSueldo4);
		c4.listaDeCuentas().add(cajaDeAhorro4);

		// MANIFESTAR EL RESULTADO ESPERADO PORQUE EL ASSERT QUE GENERE NO ES EL
		// CORRECTO

		// List <Cliente> resultadoEsperado =
		List<Cliente> listaClientesVip = new ArrayList<Cliente>();
		listaClientesVip.add(c1);
		listaClientesVip.add(c2);
		listaClientesVip.add(c3);

		List<Cliente> resultadoEsperado = listaClientesVip;
		List<Cliente> resultadoObtenido = b1.obtenerListaDeClientesVip();
		assertEquals(resultadoEsperado, resultadoObtenido);

	}

}
