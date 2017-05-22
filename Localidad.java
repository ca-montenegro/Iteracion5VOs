package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Localidad {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	@JsonProperty(value="numerada")
	private int numerada;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="boletas")
	private ListaBoletas boletas;
	
	@JsonProperty(value="sitio")
	private Sitio sitio;

	public Localidad(@JsonProperty(value="id") int id, @JsonProperty(value="capacidad")int capacidad, @JsonProperty(value="numerada")int numerada, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="boletas")ListaBoletas boletas, @JsonProperty(value="sitio")Sitio sitio) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.numerada = numerada;
		this.nombre = nombre;
		this.boletas = boletas;
		this.sitio = sitio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNumerada() {
		return numerada;
	}

	public void setNumerada(int numerada) {
		this.numerada = numerada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sitio getSitio() {
		return sitio;
	}

	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}

	public ListaBoletas getBoletas() {
		return boletas;
	}

	public void setBoletas(ListaBoletas boletas) {
		this.boletas = boletas;
	}
}
