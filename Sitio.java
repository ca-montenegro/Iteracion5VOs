package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sun.jmx.snmp.Timestamp;

public class Sitio 
{
	
	@JsonProperty(value="id")
	private int id;


	@JsonProperty(value="direccion")
	private String direccion;
	
	
	@JsonProperty(value="abierto")
	private int abierto;
	
	@JsonProperty(value="capacidad")
	private int capacidad;


	@JsonProperty(value="aptoIncapacitados")
	private int aptoIncapacitados;

	@JsonProperty(value="inicioHorario")
	private java.sql.Timestamp inicioHorario;
	
	@JsonProperty(value="finHorario")
	private java.sql.Timestamp finHorario;
	
	@JsonProperty(value="proteccionLluvia")
	private int proteccionLluvia;
	
	@JsonProperty(value="efectosAtmosfericos")
	private int efectosAtmosfericos;

	public Sitio(@JsonProperty(value="id") int id, @JsonProperty(value="direccion") String direccion,@JsonProperty(value="abierto") int abierto,@JsonProperty(value="capacidad") int capacidad,@JsonProperty(value="aptoIncapacitados") int aptoIncapacitados,
			@JsonProperty(value="inicioHorario") java.sql.Timestamp iniHora,@JsonProperty(value="finHorario") java.sql.Timestamp finHora,@JsonProperty(value="proteccionLluvia") int proteccionLluvia, @JsonProperty(value="efectosAtmosfericos") int efectosAtmosfericos) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.abierto = abierto;
		this.capacidad = capacidad;
		this.aptoIncapacitados = aptoIncapacitados;
		this.inicioHorario = iniHora;
		this.finHorario = finHora;
		this.proteccionLluvia = proteccionLluvia;
		this.efectosAtmosfericos = efectosAtmosfericos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getAbierto() {
		return abierto;
	}

	public void setAbierto(int abierto) {
		this.abierto = abierto;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getAptoIncapacitados() {
		return aptoIncapacitados;
	}

	public void setAptoIncapacitados(int aptoIncapacitados) {
		this.aptoIncapacitados = aptoIncapacitados;
	}
//
//	public Timestamp getInicioHorario() {
//		return inicioHorario;
//	}
//
//	public void setInicioHorario(Timestamp inicioHorario) {
//		this.inicioHorario = inicioHorario;
//	}
//
//	public Timestamp getFinHorario() {
//		return finHorario;
//	}
//
//	public void setFinHorario(Timestamp finHorario) {
//		this.finHorario = finHorario;
//	}

	public int getProteccionLluvia() {
		return proteccionLluvia;
	}

	public void setProteccionLluvia(int proteccionLluvia) {
		this.proteccionLluvia = proteccionLluvia;
	}

	public int getEfectosAtmosfericos() {
		return efectosAtmosfericos;
	}

	public void setEfectosAtmosfericos(int efectosAtmosfericos) {
		this.efectosAtmosfericos = efectosAtmosfericos;
	}
	
	
	
}
