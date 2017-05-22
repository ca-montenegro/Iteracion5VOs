package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class CompañiaTeatro {
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="fechaLlegada")
	private Date fechaLlegada;
	
	@JsonProperty(value="fechaSalida")
	private Date fechaSalida;

	@JsonProperty(value="festivales")
	private ListaFestivales festivales;
	
	@JsonProperty(value="representante")
	private Representante representante;
	
	@JsonProperty(value="espectaculos")
	private ListaEspectaculos espectaculos;

	public CompañiaTeatro(@JsonProperty(value="id")int id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="fechaLlegada")Date fechaLlegada, @JsonProperty(value="fechaSalida")Date fechaSalida,@JsonProperty(value="festivales") ListaFestivales festivales,
			@JsonProperty(value="representante") Representante representante, @JsonProperty(value="espectaculos") ListaEspectaculos espectaculos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.festivales = festivales;
		this.representante = representante;
		this.espectaculos = espectaculos;		
	}

	public ListaEspectaculos getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(ListaEspectaculos espectaculos) {
		this.espectaculos = espectaculos;
	}

	public ListaFestivales getFestivales() {
		return festivales;
	}

	public void setFestivales(ListaFestivales festivales) {
		this.festivales = festivales;
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

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
	
	

}
