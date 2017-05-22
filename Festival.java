package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Festival {
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="año")
	private int año;
	
	@JsonProperty(value="pais")
	private String pais;
	
	@JsonProperty(value="fechaInicio")
	private Date fechaInicio;
	
	@JsonProperty(value="fechaFin")
	private Date fechaFin;
	
	@JsonProperty(value="compañias")
	private ListaCompañias compañias;	
	
	@JsonProperty(value="organizadores")
	private ListaOrganizadores organizadores;
	
	@JsonProperty(value="clientes")
	private ListaClientes clientes;	
		
	public Festival(@JsonProperty(value="id")int id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="año")int año, @JsonProperty(value="pais")String pais, @JsonProperty(value="fechaInicio")Date fechaInicio, @JsonProperty(value="fechaFin")Date fechaFin,
			@JsonProperty(value="compañias")ListaCompañias compañias, @JsonProperty(value="organizadores")ListaOrganizadores organizadores, @JsonProperty(value="clientes")ListaClientes clientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.año = año;
		this.pais = pais;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.compañias = compañias;
		this.organizadores = organizadores;
		this.clientes = clientes;
	}

	public ListaClientes getClientes() {
		return clientes;
	}

	public void setClientes(ListaClientes clientes) {
		this.clientes = clientes;
	}

	public ListaOrganizadores getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(ListaOrganizadores organizadores) {
		this.organizadores = organizadores;
	}

	public ListaCompañias getCompañias() {
		return compañias;
	}

	public void setCompañias(ListaCompañias compañias) {
		this.compañias = compañias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
}
