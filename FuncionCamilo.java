package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class FuncionCamilo {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="fecha")
	private String fecha;
	
	@JsonProperty(value="idSitio")
	private Long idSitio;
	
	@JsonProperty(value="idEspectaculo")
	private Long idEspectaculo;
	
	private Sitio sitio;
	
	private Espectaculo espectaculo;
	
	@JsonProperty(value="realizada")
	private char realizada;
	
	@JsonProperty(value="hora")
	private int hora;

	public FuncionCamilo(@JsonProperty(value="id") Long id, 
			@JsonProperty(value="fecha") String fecha, 
			@JsonProperty(value="idSitio")  Long idSitio, 
			@JsonProperty(value="idEspectaculo") Long idEspectaculo, 
			@JsonProperty(value="hora") int hora,
			@JsonProperty(value="realizada") char realizada) 
	{
		this.id = id;
		this.fecha = fecha;
		this.idSitio = idSitio;
		this.idEspectaculo = idEspectaculo;
		this.hora = hora;
		this.realizada = realizada;
	}

	
	
	public char getRealizada() {
		return realizada;
	}



	public void setRealizada(char realizada) {
		this.realizada = realizada;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Long getIdSitio() {
		return idSitio;
	}

	public void setIdSitio(Long idSitio) {
		this.idSitio = idSitio;
	}

	public Long getIdEspectaculo() {
		return idEspectaculo;
	}

	public void setIdEspectaculo(Long idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}

	public int getHora() {
		return (hora);
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public Sitio getSitio() {
		return sitio;
	}

	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}
	
}
