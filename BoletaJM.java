package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class BoletaJM {
	
	public final static int DISPONIBLE = 0;
	public final static int NO_DISPONIBLE= 1;
	public final static int ABONADA = 2;
	public final static int DEVUELTA = 3;
	
	@JsonProperty(value="ubicacion")
	private int ubicacion;
	
	@JsonProperty(value="estado")
	private int estado;
	
	@JsonProperty(value="costo")
	private double costo;
	
	@JsonProperty(value="localidad")
	private Localidad localidad;
	
	@JsonProperty(value="funcion")
	private Funcion funcion;
	
	@JsonProperty(value="cliente")
	private Cliente cliente;
	
	public BoletaJM(@JsonProperty(value="ubicacion") int ubicacion, @JsonProperty(value="estado") int estado,
			@JsonProperty(value="costo") double costo, @JsonProperty(value="localidad") Localidad localidad, @JsonProperty(value="funcion")Funcion funcion,
			@JsonProperty(value="cliente") Cliente cliente) {
		
		super();
		this.ubicacion = ubicacion;
		this.estado = estado;
		this.costo = costo;
		this.localidad = localidad;
		this.funcion = funcion;
		this.cliente = cliente;
		
	}

	public int getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
