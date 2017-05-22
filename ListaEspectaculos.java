package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaEspectaculos {

	@JsonProperty(value="espectaculos")
	private List<Espectaculo> espectaculos;

	public ListaEspectaculos(@JsonProperty(value="espectaculos")List<Espectaculo> espectaculos) {
		super();
		this.espectaculos = espectaculos;
	}

	public List<Espectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(List<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
}
