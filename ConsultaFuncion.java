package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConsultaFuncion {
	
	@JsonProperty(value="idFuncion")
	private int idFuncion;
	
	@JsonProperty(value="nombreEspectaculo")
	private String nombreEspectaculo;
	
	@JsonProperty(value="fechaHora")
	private String fechaHora;
	
	@JsonProperty(value="estado")
	private String estado;
	
	@JsonProperty(value="boletaDevuelta")
	private String boletaDevuelta;

	public ConsultaFuncion(@JsonProperty(value="idFuncion")int idFuncion, @JsonProperty(value="nombreEspectaculo") String nombreEspectaculo, @JsonProperty(value="fechaHora")String fechaHora, @JsonProperty(value="estado")String estado,
			@JsonProperty(value="boletaDevuelta") String boletaDevuelta) {
		super();
		this.idFuncion = idFuncion;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fechaHora = fechaHora;
		this.estado = estado;
		this.boletaDevuelta = boletaDevuelta;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public String getNombreEspectaculo() {
		return nombreEspectaculo;
	}

	public void setNombreEspectaculo(String nombreEspectaculo) {
		this.nombreEspectaculo = nombreEspectaculo;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBoletaDevuelta() {
		return boletaDevuelta;
	}

	public void setBoletaDevuelta(String boletaDevuelta) {
		this.boletaDevuelta = boletaDevuelta;
	}

	
}
