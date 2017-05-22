package vos;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConsultaCompania 
{
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="asistencia")
	private ArrayList<String> asistencia;
	
	@JsonProperty(value="dineroTaquilla")
	private String dineroTaquilla;
	
	@JsonProperty(value="porcentajeOcupacion")
	private ArrayList<String> porcentajeOcupacion;
	
	public ConsultaCompania(@JsonProperty(value="nombre") String nombre, @JsonProperty(value="asistencia") ArrayList<String> asistencia,@JsonProperty(value="dineroTaquilla") String dineroTaquilla,@JsonProperty(value="porcentajeOcupacion") ArrayList<String> porcentajeOcupacion) {
		super();
		this.nombre = nombre;
		this.asistencia = asistencia;
		this.dineroTaquilla = dineroTaquilla;
		this.porcentajeOcupacion = porcentajeOcupacion;
	}

	public ArrayList<String> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(ArrayList<String> asistencia) {
		this.asistencia = asistencia;
	}

	public String getDineroTaquilla() {
		return dineroTaquilla;
	}

	public void setDineroTaquilla(String dineroTaquilla) {
		this.dineroTaquilla = dineroTaquilla;
	}

	public ArrayList<String> getPorcentajeOcupacion() {
		return porcentajeOcupacion;
	}

	public void setPorcentajeOcupacion(ArrayList<String> porcentajeOcupacion) {
		this.porcentajeOcupacion = porcentajeOcupacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
