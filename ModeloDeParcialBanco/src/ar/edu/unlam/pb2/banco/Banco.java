package ar.edu.unlam.pb2.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	public List<Cliente> listaDeClientes = new ArrayList<Cliente>();
	public List<Cliente> listaDeClientesVip = new ArrayList<Cliente>();

	public Boolean listaDeClientes() {
		Boolean seCreoLaLista = false;
		if (this.listaDeClientes != null) {
			seCreoLaLista = true;
		}
		return seCreoLaLista;
	}

	public void agregarCliente(Cliente cliente) {
		listaDeClientes.add(cliente);

	}

	public List<Cliente> obtenerListaDeClientesVip() {

		for (int i = 0; i < this.listaDeClientes.size(); i++) {
			if (this.listaDeClientes.get(i) != null && this.listaDeClientes.get(i).esVip()) {
				Cliente clienteVip = this.listaDeClientes.get(i);
				this.listaDeClientesVip.add(clienteVip);
			}
		}

		return this.listaDeClientesVip;
	}

}
