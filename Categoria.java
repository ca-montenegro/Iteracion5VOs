package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Categoria {

	@JsonProperty(value="categoria")
	private String categoria;
	
	@JsonProperty(value="espectaculos")
	private ListaEspectaculos espectaculos;
	
	public Categoria(@JsonProperty(value="categoria")String categoria, @JsonProperty(value="espectaculos")ListaEspectaculos espectaculos) {
		super();
		this.categoria = categoria;
		this.espectaculos = espectaculos;
	}

	public ListaEspectaculos getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(ListaEspectaculos espectaculos) {
		this.espectaculos = espectaculos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
