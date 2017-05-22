package vos;

import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class FiltroConsultaCompraBoletas {
	
	@JsonProperty(value="Fecha inicio")
	private String fechaInicio;
	
	@JsonProperty(value="Fecha fin")
	private String fechaFin;
	
	@JsonProperty(value="Requerimiento escenario")
	private String requerimientoEscenario;
	
	@JsonProperty(value="Tipo localidad")
	private String tipoLocalidad;

	@JsonProperty(value="Hora inicio")
	private int horaInicio;
	
	@JsonProperty(value="Hora fin")
	private int horaFin;
	
	@JsonProperty(value="Dia")
	private String dia;

	public FiltroConsultaCompraBoletas(@JsonProperty(value="Fecha inicio")String fechaInicio,@JsonProperty(value="Fecha fin") String fechaFin,@JsonProperty(value="Requerimiento escenario") String requerimientoEscenario,
			@JsonProperty(value="Tipo localidad") String tipoLocalidad, @JsonProperty(value="Dia")String dia,@JsonProperty(value="Hora inicio")int horaInicio ,@JsonProperty(value="Hora fin")int horaFin ) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.requerimientoEscenario = requerimientoEscenario;
		this.tipoLocalidad = tipoLocalidad;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin= horaFin;	
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getRequerimiento() {
		return requerimientoEscenario;
	}

	public void setRequerimiento(String listaRequerimientos) {
		this.requerimientoEscenario = listaRequerimientos;
	}

	public String getTipoLocalidad() {
		return tipoLocalidad;
	}

	public void setTipoLocalidad(String tipoLocalidad) {
		this.tipoLocalidad = tipoLocalidad;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}
	
}
