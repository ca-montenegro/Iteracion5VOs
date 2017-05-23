package vos;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class Abonamiento {

	@JsonProperty(value="idsFunciones")
	private ArrayList<Long> idsFunciones;
	
	@JsonProperty(value="idsLocalidades")
	private ArrayList<String> localidades;
	
	@JsonProperty(value="fechaConsulta")
	private String fechaConsulta;
	
	@JsonProperty(value="fechaFinal")
	private String fechaFinal;
	
	@JsonProperty(value="idUsuario")
	private Long idUsuario;
	
	


	private ArrayList<Boleta> abonamientoList;



	public Abonamiento(@JsonProperty(value="idsFunciones") ArrayList<Long> idsFunciones,
			@JsonProperty(value="idsLocalidades") ArrayList<String> localidades, 
			@JsonProperty(value="fechaConsulta") String fechaConsulta) {
		this.idsFunciones = idsFunciones;
		this.localidades = localidades;
		this.fechaConsulta = fechaConsulta;
		
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public ArrayList<Long> getIdsFunciones() {
		return idsFunciones;
	}

	public void setIdsFunciones(ArrayList<Long> idsFunciones) {
		this.idsFunciones = idsFunciones;
	}

	public ArrayList<String> getIdsLocalidades() {
		return localidades;
	}

	public void setIdsLocalidades(ArrayList<String> localidades) {
		this.localidades = localidades;
	}


	public String getFechaConsulta() {
		return fechaConsulta;
	}


	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	
	public ArrayList<Boleta> getAbonamientoList() {
		return abonamientoList;
	}


	public void setAbonamientoList(ArrayList<Boleta> abonamientoList) {
		this.abonamientoList = abonamientoList;
	}
	
	
	
	public ArrayList<String> getLocalidades() {
		return localidades;
	}


	public void setLocalidades(ArrayList<String> localidades) {
		this.localidades = localidades;
	}


	public String getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public String toString(){
		
		return "";
	}
	
}
