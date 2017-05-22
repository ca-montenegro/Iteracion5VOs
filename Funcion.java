package vos;

import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Funcion {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="fechaHora")
	private Timestamp fechaHora;
	
	@JsonProperty(value="costo")
	private double costo;
	
	@JsonProperty(value="sillasOcupadas")
	private int sillasOcupadas;
	
	@JsonProperty(value="realizada")
	private int realizada;
	
	@JsonProperty(value="espectaculo")
	private Espectaculo espectaculo;
	
	@JsonProperty(value="sitio")
	private Sitio sitio;
	
	

	public Funcion(@JsonProperty(value="id")int id, @JsonProperty(value="fechaHora")Timestamp fechaHora, @JsonProperty(value="costo")double costo, @JsonProperty(value="sillasOcupadas")int sillasOcupadas, @JsonProperty(value="realizada")int realizada,
			@JsonProperty(value="espectaculo")Espectaculo espectaculo,@JsonProperty(value="sitio") Sitio sitio ) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.costo = costo;
		this.sillasOcupadas = sillasOcupadas;
		this.realizada = realizada;
		this.espectaculo = espectaculo;
		this.sitio = sitio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getSillasOcupadas() {
		return sillasOcupadas;
	}

	public void setSillasOcupadas(int SillasOcupadas) {
		this.sillasOcupadas = SillasOcupadas;
	}

	public int isRealizada() {
		return realizada;
	}

	public void setRealizada(int realizada) {
		this.realizada = realizada;
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	public Sitio getSitio() {
		return sitio;
	}

	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}
	
}
