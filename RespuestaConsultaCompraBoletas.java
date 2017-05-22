package vos;


import org.codehaus.jackson.annotate.JsonProperty;

public class RespuestaConsultaCompraBoletas {

	@JsonProperty(value="idFuncion")
	private int idFuncion;
	
	@JsonProperty(value="espectaculo")
	private String espectaculo;
	
	@JsonProperty(value="fecha")
	private String fecha;
	
	@JsonProperty(value="sitio")
	private String sitio;
	
	@JsonProperty(value="boletasVendidas")
	private int boletasVendidas;
	
	@JsonProperty(value="usuariosRegistrados")
	private int usuariosRegistrados;

	public RespuestaConsultaCompraBoletas(@JsonProperty(value="idFuncion") int idFuncion, @JsonProperty(value="Espectaculo")String espectaculo,@JsonProperty(value="Fecha") String fecha,@JsonProperty(value="Sitio") String sitio,@JsonProperty(value="Boletas vendidas") int boletasVendidas,
			@JsonProperty(value="usuarios registrados")int usuariosRegistrados) {
		super();
		this.idFuncion = idFuncion;
		this.espectaculo = espectaculo;
		this.fecha = fecha;
		this.sitio = sitio;
		this.boletasVendidas = boletasVendidas;
		this.usuariosRegistrados = usuariosRegistrados;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public String getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(String espectaculo) {
		this.espectaculo = espectaculo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSitio() {
		return sitio;
	}

	public void setSitio(String sitio) {
		this.sitio = sitio;
	}

	public int getBoletasVendidas() {
		return boletasVendidas;
	}

	public void setBoletasVendidas(int boletasVendidas) {
		this.boletasVendidas = boletasVendidas;
	}

	public int getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void setUsuariosRegistrados(int usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}
	
}
