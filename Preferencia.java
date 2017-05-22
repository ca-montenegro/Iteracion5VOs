package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Preferencia {

	@JsonProperty(value="tipo")
	private String tipo;
	
	@JsonProperty(value="preferencia")
	private String preferencia;
	
	@JsonProperty(value="id")
	private int id;
	
	

	public Preferencia(@JsonProperty(value="tipo")String tipo, @JsonProperty(value="preferencia")String preferencia, @JsonProperty(value="id")int id) {
		super();
		this.tipo = tipo;
		this.preferencia = preferencia;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}
	
	
}
