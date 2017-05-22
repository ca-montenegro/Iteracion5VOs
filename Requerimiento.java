package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Requerimiento {
	
	@JsonProperty(value="requerimiento")
	private String requerimiento;
	
	@JsonProperty(value="espectaculos")
	private ListaEspectaculos espectaculos;
	
	public Requerimiento(@JsonProperty(value="requerimiento")String requerimiento, @JsonProperty(value="espectaculos")ListaEspectaculos espectaculos) {
		super();
		this.requerimiento = requerimiento;
		this.espectaculos = espectaculos;
	}

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public ListaEspectaculos getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(ListaEspectaculos espectaculos) {
		this.espectaculos = espectaculos;
	}
}
