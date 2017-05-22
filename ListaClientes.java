package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaClientes 
{
	@JsonProperty(value="clientes")
	private List<Cliente> clientes;
	
	public ListaClientes(@JsonProperty(value="clientes") List<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
