package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class NotaDebitoJM {

	@JsonProperty(value="cliente")
	private Cliente cliente;
	
	@JsonProperty(value="dinero")
	private double dinero;
	
	@JsonProperty(value="funcion")
	private Funcion funcion;
	
	@JsonProperty(value="boleta")
	private BoletaJM boleta;
	
	

	public NotaDebitoJM(@JsonProperty(value="cliente") Cliente cliente, @JsonProperty(value="dinero") double dinero, @JsonProperty(value="funcion") Funcion funcion, @JsonProperty(value="boleta") BoletaJM boleta) {
		super();
		this.cliente = cliente;
		this.dinero = dinero;
		this.funcion = funcion;
		this.boleta = boleta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public BoletaJM getBoleta() {
		return boleta;
	}

	public void setBoleta(BoletaJM boleta) {
		this.boleta = boleta;
	}
	
	
}
