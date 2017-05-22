package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC1 {
	
	@JsonProperty(value="fechaInicio")
	private Date fechaInicio;
	
	@JsonProperty(value="fechaFin")
	private Date fechaFin;
	
	@JsonProperty(value="criterio")
	private String criterio;
	
	@JsonProperty(value="compania")
	private int compania;
	
	@JsonProperty(value="agrupamiento")
	private String agrupamiento;
	
	@JsonProperty(value="categoria")
	private String categoria;
	
	@JsonProperty(value="idioma")
	private String idioma;
	
	@JsonProperty(value="traduccion")
	private int traduccion;

	public RFC1(@JsonProperty(value="fechaInicio") Date fechaInicio, @JsonProperty(value="fechaFin") Date fechaFin, @JsonProperty(value="criterio")String criterio,@JsonProperty(value="compania") int compania, @JsonProperty(value="agrupamiento") String agrupamiento, @JsonProperty(value="idioma")String idioma,@JsonProperty(value="traduccion")int traduccion,
			@JsonProperty(value="categoria") String categoria) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.criterio = criterio;
		this.agrupamiento = agrupamiento;
		this.compania = compania;
		this.idioma = idioma;
		this.traduccion = traduccion;
		this.categoria = categoria;
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

	public String getCriterio() {
		return criterio;
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}

	public String getAgrupamiento() {
		return agrupamiento;
	}

	public void setAgrupamiento(String agrupamiento) {
		this.agrupamiento = agrupamiento;
	}

	public int getCompania() {
		return compania;
	}

	public void setCompania(int compania) {
		this.compania = compania;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(int traduccion) {
		this.traduccion = traduccion;
	}
	
	
	
}
